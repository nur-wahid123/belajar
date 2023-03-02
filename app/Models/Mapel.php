<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Mapel extends Model
{
    protected $fillable = [
        'kelompok',
        'kode',
        'mapel1',
        'mapel2',
        'mapel3',
        'mapel4',
        'mapel5',
        'mapel6',
    ];
    protected $table = 'mapel';
    protected $primaryKey = 'no';
    public $timestamps = false;
    use HasFactory;
}
