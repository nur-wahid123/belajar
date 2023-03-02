<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Kelas extends Model
{
    protected $fillable = [
        'nama',
        'KELAS',
        'NISN',
        'NO',
        'JK',
    ];
    protected $primaryKey = 'urut';
    protected $table = 'datakeseluruhan';
    public $timestamps = false;
    use HasFactory;
}
