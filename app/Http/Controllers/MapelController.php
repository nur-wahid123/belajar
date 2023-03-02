<?php

namespace App\Http\Controllers;

use App\Models\Info;
use App\Models\Mapel;
use Illuminate\Http\Request;

class MapelController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return response()->json("Halobro");
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $request->validate([
            'kelompok' => 'required|unique:App\Models\Mapel,kelompok',
            'kode' => 'required|unique:App\Models\Mapel,kode',
            'mapel1' => 'required',
            'mapel2' => 'required',
            'mapel3' => 'required',
            'mapel4' => 'required',
            'mapel5' => 'required',
            'mapel6' => 'required',
        ]);
        Mapel::create($request->all());
        return redirect()->back()->withErrors("Kelompok Mapel ".$request->kelompok." berhasil dibuat!!");
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $mapel)
    {
        // dd($request->all());
        $request->validate([
            'kelompok' => 'required',
            'kode' => 'required',
            'mapel1' => 'required',
            'mapel2' => 'required',
            'mapel3' => 'required',
            'mapel4' => 'required',
            'mapel5' => 'required',
            'mapel6' => 'required',
        ]);
        $data= $request->all();
        Mapel::where('no',$mapel)->update($data);
        return redirect()->back()->withErrors("Kelompok Mapel Berhasil Diupdate");
    }

    /**
     * Remove the specified resource from storage.
     *
     * @return \Illuminate\Http\Response
     */
    public function destroy($mapel)
    {
        $data = Mapel::where('kelompok',$mapel)->get('kelompok');
        foreach ($data as $key => $value) {
            $data = "Kelompok Mapel ".$value->kelompok." Berhasil di Hapus!!";
        }
        Mapel::where('kelompok',$mapel)->delete();
        return redirect()->back()->withErrors($data);
    }
}
