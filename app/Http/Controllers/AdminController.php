<?php

namespace App\Http\Controllers;

use App\Http\Resources\KelasCollection;
use App\Imports\KelasImport;
use App\Imports\UserImport;
use App\Models\Admin;
use App\Models\Info;
use Illuminate\Support\Str;
use App\Models\Kelas;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\File;
use Illuminate\Support\Facades\Hash;
use Inertia\Inertia;
use Maatwebsite\Excel\Facades\Excel as FacadesExcel;

class AdminController extends Controller
{
    //fungsi logout admin
    public function logout()
    {
        Auth::guard('admin')->logout();
        return redirect()->route('login_form')->withErrors('Admin Logout Successfully');
    }

    //End Function


    //fungsi jaga agar admin aman
    public function index()
    {
        if (Auth::guard('admin')->check()) {
            return redirect()->route('admin.Dashboard');
        }
        $info = Info::where('id', 1)->get();
        $a = Auth::guard('admin')->check();
        return Inertia::render('LoginAdmin', [
            'info' => $info,
            'a' => $a,
        ]);
    }

    //End Function

    //fungsi data dashboard
    public function dashboard(Request $req)
    {
        $ses = Auth::guard('admin')->user();
        $data = new KelasCollection(Kelas::paginate(20));
        // Auth::guard('admin')->logout();
        $a = Auth::guard('admin')->check();
        return Inertia::render('AdminDashboard', [
            'ses' => $ses,
            'data' => $data,
            'a' => $a,
        ]);
        //keamanan lagi
    }


    //End Function


    //fungsi untuk cari siswa spesifik
    public function cari(Request $req)
    {
        $data = '%' . strtolower($req->cari) . '%';
        $datak = DB::table('datakeseluruhan')
            ->whereRaw('LOWER(nama) like ?', $data)
            ->orWhereRaw('LOWER(NO) like ?', $data)
            ->orWhereRaw('LOWER(NISN) like ?', $data)
            ->get();

        return response()->json($datak, 200);
    }


    //End Function


    //fungsi untuk login
    public function login(Request $request)
    {
        $check = $request->all();
        if (Auth::guard('admin')->attempt(['email' => $check['email'], 'password' => $check['password']])) {
            $user = Admin::where('email', $check['email'])->get();
            return redirect()->route('admin.dashboard')->with('error', $user);
        } else {
            return redirect()->back()->with('error', 'Invalid Email Or Password')->withErrors('Invalid Email Or Password');
        }
    }


    //End Function


    //fungsi untuk buat admin baru
    public function registerAdmin(Request $req)
    {
        $ree = $req->validate([
            'name' => 'required',
            'email' => 'required|unique:admins',
            'password' => 'required|confirmed',
        ]);

        Admin::create([
            'name' => $req->name,
            'email' => $req->email,
            'password' => Hash::make($req->password),
        ]);

        return redirect()->route('login_form')->withErrors('Your Account Is Crreated');
    }


    //End Function


    //fungsi halaman register admin
    public function register()
    {
        $ses = Auth::guard('admin')->user();
        return Inertia::render('RegisterAdmin', [
            'ses' => $ses,
        ]);
    }

    //End function


    //fungsi untuk menghapus pilihan siswa
    public function hapusPilihan($id)
    {
        // dd($id);
        DB::table('datakeseluruhan')->where('urut', $id)->update(['pilihan' => 0]);
        return redirect()->back()->withErrors('Pilihan telah diupdate');
    }


    //End Function


    //fungsi untuk menghapus siswa
    public function hapusSiswa($id)
    {
        $nama = User::find($id);
        $nama = $nama->name;
        Kelas::find($id)->delete();
        User::find($id)->delete();
        return redirect()->back()->withErrors('Siswa ' . $nama . ' telah dihapus');
    }


    //End Function


    // fungsi untuk pengaturan mapel
    public function mapel()
    {
        $ses = Auth::guard('admin')->user();
        $data = DB::table('mapel')->get();
        return Inertia::render('PengaturanMapel', [
            'mapel' => $data,
            'ses' => $ses,
        ]);
    }


    //End Function


    //fungsi untuk menambah siswa baru
    public function tambahSiswa(Request $req)
    {
        $req->validate([
            'nama' => 'required|unique:datakeseluruhan,nama',
            'nis' => 'required|max_digits:6|numeric|unique:datakeseluruhan,NO',
            'nisn' => 'required|max_digits:10|numeric|unique:datakeseluruhan,NISN',
            'kelas' => 'required|max:5',
            'jk' => 'required|max:1',
        ]);
        Kelas::create([
            'nama' => $req->nama,
            'KELAS' => $req->kelas,
            'NO' => $req->nis,
            'NISN' => $req->nisn,
            'JK' => $req->jk,
        ]);
        User::create([
            'name' => $req->nama,
            'kelas' => $req->kelas,
            'email' => $req->nis,
            'password' => Hash::make($req->nisn),
            'jk' => $req->jk,
            'remember_token' => Str::random(10),
        ]);
        return response()->json([
            'message' => 'Request was successful.',
        ], 200);
    }


    //End Function


    //fungsi display siswa baru
    public function Siswa()
    {
        $ses = Auth::guard('admin')->user();
        return Inertia::render('TambahSiswa', [
            'ses' => $ses
        ]);
    }


    //End Function

    //fungsi inmport database
    public function import(Request $req)
    {
        $file = $req->file('selectedFile');
        if ($file == null) {
            return redirect()->back()->withErrors(1);
        } else if ($file->getClientOriginalExtension() != "xlsx" && $file->getClientOriginalExtension() != "xls") {
            return redirect()->back()->withErrors(2);
        }
        $olo = DB::table('template')->get();
        $ola = FacadesExcel::toArray(new KelasImport, $file);
        $olo = $olo[0];
        $ola = array_keys($ola[0][0]);
        $i = 0;
        foreach ($olo as $key => $value) {
            if ($ola[$i] != $value) {
                return redirect()->back()->withErrors(3);
            }
            $i++;
        }
        $ola = FacadesExcel::toArray(new KelasImport, $file);
        foreach ($ola as $key => $value) {
            if ($value[0]["id"] != null) {
                return redirect()->back()->withErrors(4);
            }
        }
        Kelas::truncate();
        User::truncate();
        FacadesExcel::import(new KelasImport, $file);
        FacadesExcel::import(new UserImport, $file);
        return redirect()->route('admin.dashboard')->withErrors("Jika ada Nama siswa yang belum masuk, mohon dilengkapi untuk setiap tabel nya, terimakasih");
    }

    //end function


    //function for settings
    public function atur()
    {
        dd(Auth::guard('admin')->check());
        $ses = Auth::guard('admin')->user();
        return Inertia::render('Atur', [
            'ses' => $ses,
        ]);
    }


    //end function


    //function for upload
    public function upload(Request $req)
    {
        $text = $req->text;
        if ($text != null) {
            Info::where('id', 1)->update(['value' => $text]);
        }
        $file = $req->file('selectedFile');
        if ($file == null) {
            return redirect()->back()->withErrors(1);
        } else if ($file->getSize() > 2500000) {

            return redirect()->back()->withErrors(3);
        }
        $ext = $file->getClientOriginalExtension();
        if ($ext != "jpg" && $ext != "png" && $ext != "avif" && $ext != "jpeg") {
            return redirect()->back()->withErrors(2);
        }
        $gambar = Info::where('id', 2)->get();
        File::delete(public_path('asetkubro/' . $gambar[0]->value));
        Info::where('id', 2)->update(['value' => $file->getClientOriginalName()]);
        $file->move(public_path('asetkubro'), $file->getClientOriginalName());
    }


    //end function


    //fungsi ambil logo
    public function logo()
    {
        $info = Info::where('id', 2)->get();
        return response()->json($info[0]);
    }
}
