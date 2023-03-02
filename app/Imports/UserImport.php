<?php

namespace App\Imports;

use App\Models\User;
use Illuminate\Support\Facades\Hash;
use Maatwebsite\Excel\Concerns\ToModel;
use Illuminate\Support\Str;
use Maatwebsite\Excel\Concerns\WithHeadingRow;



class UserImport implements ToModel, WithHeadingRow
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
        if ($row['nisn'] == null || $row['nis'] == null || $row['nama'] == null || $row['kelas'] == null || $row['jk'] == null) {
            return;
        }
        $pw = Hash::make($row['nisn']);
        $rand = Str::random(20);
        return new User([
            "id" => $row['id'],
            "email" => $row['nis'],
            "password" => $pw,
            "name" => $row['nama'],
            "kelas" => $row['kelas'], // User Type User
            "jk" => $row['jk'],
            "pilihan" => 0,
            "remember_token" => $rand,
        ]);
    }
}
