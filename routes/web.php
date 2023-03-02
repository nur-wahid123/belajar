<?php

use App\Http\Controllers\AdminController;
use App\Http\Controllers\MapelController;
use App\Http\Controllers\ProfileController;
use App\Imports\KelasImport;
use App\Models\Kelas;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Route;
use Inertia\Inertia;
use PhpOffice\PhpSpreadsheet\IOFactory;
use PhpOffice\PhpSpreadsheet\Spreadsheet;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

//mau buat dari controller males
Route::get('/dashboard', function () {
    $counto = array();
    $data = DB::table('mapel')->get();
    foreach ($data as $key => $value) {
        $counto[$key] = ($value->jumlah) - Kelas::where('pilihan', $value->kode)->count();
    }
    $jml = DB::table('mapel')->get('jumlah');
    $jmlh = array();
    foreach ($jml as $key => $value) {
        $jmlh[$key] = $value->jumlah;
    }
    $sdh = array();
    foreach ($data as $key => $value) {
        $sdh[$key] = Kelas::where('pilihan', $value->kode)->count();
    }
    $file = Auth::guard('web')->user();
    $file = Kelas::where("NO", $file->email)->get();
    return Inertia::render('Dashboard', [
        'data' => $data,
        'autha' => $file[0],
        'count' => $counto,
        'jumlah' => $jmlh,
        'sudah' => $sdh,
    ]);
})->middleware(['auth', 'verified'])->name('dashboard');

//saat siswa klik submit kelompok mapel
Route::middleware('auth')->group(function () {
    Route::get('/submit/pilihan/{any}/{id}', [ProfileController::class, 'submit']);
    Route::get('/result', [ProfileController::class, 'result'])->name('result');
});

//langsung login
Route::get('/', function () {
    return redirect()->route('login');
});


/*Start admin route*/


Route::get('/download', function () {

    // Retrieve the data from the database
    $data = DB::table('datakeseluruhan')->get();

    // Create a new Excel file
    $spreadsheet = new Spreadsheet();
    $sheet = $spreadsheet->getActiveSheet();

    // Add the data to the sheet
    $sheetData = [];
    foreach ($data as $row) {
        $rowData = [];
        foreach ($row as $column) {
            $rowData[] = (string)$column;
        }
        $sheetData[] = $rowData;
    }
    $sheet->fromArray($sheetData);

    // Set the response headers
    header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
    header('Content-Disposition: attachment;filename="data.xlsx"');
    header('Cache-Control: max-age=0');

    // Write the data to the response
    $writer = IOFactory::createWriter($spreadsheet, 'Xlsx');
    $writer->save('php://output');
    return;
})->middleware('admin')->name('admin.download');

Route::get('/template', function () {

    // Retrieve the data from the database
    $data = DB::table('template')->get();

    // Create a new Excel file
    $spreadsheet = new Spreadsheet();
    $sheet = $spreadsheet->getActiveSheet();

    // Add the data to the sheet
    $sheetData = [];
    foreach ($data as $row) {
        $rowData = [];
        foreach ($row as $column) {
            $rowData[] = (string)$column;
        }
        $sheetData[] = $rowData;
    }
    $sheet->fromArray($sheetData);

    // Set the response headers
    header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
    header('Content-Disposition: attachment;filename="template.xlsx"');
    header('Cache-Control: max-age=0');

    // Write the data to the response
    $writer = IOFactory::createWriter($spreadsheet, 'Xlsx');
    $writer->save('php://output');
    return;
})->middleware('admin')->name('admin.template');

//route get logo
Route::get('/logo', [AdminController::class, 'logo'])->name('logo');

//route admin
Route::prefix('admin')->group(function () {
    //route login admin
    Route::get('/login', [AdminController::class, 'index'])->name('login_form');

    //route request login admin
    Route::post('/login/owner', [AdminController::class, 'login'])->name('admin.login');

    //route register admin
    Route::get('/register', [AdminController::class, 'register'])->name('admin.register')->middleware('admin');

    //route request register admin
    Route::post('/register/admin', [AdminController::class, 'registerAdmin'])->name('admin.registerAdmin')->middleware('admin');

    //route request logout admin
    Route::post('/logout', [AdminController::class, 'logout'])->name('admin.logout')->middleware('admin');

    //route request logout admin
    Route::get('/dashboard', [AdminController::class, 'dashboard'])->name('admin.dashboard')->middleware('admin');

    //route pengaturan mapel admin
    Route::get('/dashboard/mapel', [AdminController::class, 'mapel'])->name('admin.mapel')->middleware('admin');

    //route pembuatan siswa baru
    Route::post('/tambahSiswa', [AdminController::class, 'tambahSiswa'])->name('admin.tambahSiswa')->middleware('admin');

    //route pembuatan siswa baru
    Route::get('/Siswa', [AdminController::class, 'Siswa'])->name('admin.Siswa')->middleware('admin');

    //route cari siswa dari admin
    Route::post('/cari', [AdminController::class, 'cari'])->name('admin.cari')->middleware('admin');

    //route request hapus pilihan dari admin
    Route::get('/hapusPilihan/{id}', [AdminController::class, 'hapusPilihan'])->name('admin.hapusPilihan')->middleware('admin');

    //route request hapus Siswa dari admin
    Route::get('/hapusSiswa/{id}', [AdminController::class, 'hapusSiswa'])->name('admin.hapusSiswa')->middleware('admin');

    //route request Halaman Pengaturan
    Route::get('/atur', [AdminController::class, 'atur'])->name('admin.atur')->middleware('admin');

    //route request Halaman Pengaturan
    Route::post('/upload', [AdminController::class, 'upload'])->name('admin.upload')->middleware('admin');

    //route Import database from excel
    Route::post('/import', [AdminController::class, 'import'])->name('admin.import')->middleware('admin');
});


/*End admin route*/

//route untuk mapel yang ada untuk siswa
Route::group(['prefix' => 'mapel'], function () {
    Route::apiResource('mapel', MapelController::class)->middleware('admin');
});

require __DIR__ . '/auth.php';
