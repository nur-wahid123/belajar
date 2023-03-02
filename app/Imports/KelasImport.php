<?php

namespace App\Imports;

use App\Models\Kelas;
use Maatwebsite\Excel\Concerns\ToModel;
use Maatwebsite\Excel\Concerns\WithHeadingRow;

class KelasImport implements ToModel, WithHeadingRow
{
    /**
     * @param array $row
     *
     * @return \Illuminate\Database\Eloquent\Model|null
     */
    public function model(array $row)
    {
        if ($row['id'] != null){
            $row['id'] = null;
        }
        // dd($row);
        if ($row['nisn'] == null || $row['nis'] == null || $row['nama'] == null || $row['kelas'] == null || $row['jk'] == null) {
            return;
        }
        return new Kelas([
            "urut" => $row['id'],
            "NO" => $row['nis'],
            "NISN" => $row['nisn'],
            "nama" => $row['nama'],
            "KELAS" => $row['kelas'], // User Type User
            "JK" => $row['jk'],
            "pilihan" => 0,
        ]);
    }
}
