import { Head } from '@inertiajs/react';
import { useState } from 'react';
import { Link } from '@inertiajs/react';
import Paginator from './Auth/Paginator';
import AdminAuthNav from '@/Layouts/AdminAuthNav';
import axios from 'axios';

export default function Dashboard(props) {
    //deklarasi useState
    const [suggestions, setSuggestions] = useState([]);
    const [formData, setFormData] = useState({
        cari: "",
    })
    const [loading, setLoading] = useState(false);
    const [loadingData, setLoadingData] = useState(false);
    const [kata, setKata] = useState('')

    //fungsi cari data siswa
    const handleClick = async (e) => {
        e.preventDefault()
        setLoadingData(true);
        const response = await axios.post('/admin/cari', formData)
        setSuggestions(response.data)
        setKata(formData.cari)
        setLoadingData(false);
    };

    //fungsi untuk input
    const handleChange = (event) => {
        setFormData({ ...formData, [event.target.name]: event.target.value });
    }

    //fungsi agar nama tidak terlalu panjang
    function limitStringLength(str, limit) {
        var words = str.split(" ");
        var limitedString = "";
        for (var i = 0; i < words.length; i++) {
            if (limitedString.length + words[i].length >= limit) {
                limitedString += words[i][0] + '. '
            } else {
                limitedString += words[i] + " "
            }
        }
        return limitedString;
    }


    //fungsi download data
    const handleDownload = async () => {
        setLoading(true);

        // Make the API call to download the file
        const response = await fetch('/download');
        const blob = await response.blob();

        // Create a link element and trigger a download
        const link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        link.download = 'data.xlsx';
        document.body.appendChild(link);
        link.click();
        link.remove();

        setLoading(false);
    };
    return (
        <div className="min-h-screen bg-gray-100">
            <AdminAuthNav props={props} />
            <Head title="Admin Dashboard" />
            <main>
                <div className="py-12">
                    {props.errors[0] == '' || props.errors[0] == undefined || props.errors[0] == null ? "" : (
                        <div className="max-w-7xl mx-auto my-8 sm:px-6 lg:px-8">
                            <div className="alert alert-success shadow-lg">
                                <div>
                                    <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                                    <span>{props.errors[0]}</span>
                                </div>
                            </div>
                        </div>
                    )}
                    <div className="w-full mx-auto flex place-content-center sm:px-6 lg:px-8">
                        <div className="bg-white flex flex-col items-center justify-center overflow-x-auto max-w-4xl shadow-sm p-5 sm:rounded-lg">
                            <h1 className='text-4xl font-bold uppercase font-serif my-8'>Data Kelompok Mapel</h1>
                            <button className='btn btn-success my-6' onClick={handleDownload} disabled={loading}>
                                {loading ? 'Downloading...' : 'Download Data'}
                            </button>
                            <div className='self-start my-5 mx-12'>
                                <label className="label">
                                    <span className="label-text">Cari Nama / NIS / NISN</span>
                                </label>
                                <input autoComplete='off' value={formData.cari} onChange={handleChange} placeholder='Masukkan Nama / NIS /NISN' className='input input-bordered input-info w-full max-w-xs' type="text" name="cari" id="cari" />
                                <div className='flex gap-6 items-center'>
                                    <button onClick={handleClick} className='btn block mb-6 mt-3 btn-primary'>Cari</button>
                                    <p className={'font-serif font-bold ' + (loadingData ? 'opacity-50' : 'opacity-0')}>Loading...</p>
                                </div>
                            </div>
                            {kata == '' ? (
                                props.data.data.length < 1 ? (
                                    <div className='font-bold font-serif text-3xl opacity-70 text-red-400'>Maaf Data Tidak Ditemukan</div>
                                ) : (
                                    <div className={'flex flex-col w-full ' + (loadingData && 'opacity-50')}>
                                        <Paginator data={props.data} />
                                        <table className='table table-compact w-full'>
                                            <thead className='text-center'>
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Nama</th>
                                                    <th>NIS</th>
                                                    <th>NISN</th>
                                                    <th>Jenis Kelamin</th>
                                                    <th>Kelas</th>
                                                    <th>Pilihan</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {props.data.data.map((datak) => {
                                                    return (
                                                        <tr key={datak.urut}>
                                                            <td>{datak.urut}</td>
                                                            <td>{limitStringLength(datak.nama, 15)}</td>
                                                            <td>{datak.NO}</td>
                                                            <td>{datak.NISN}</td>
                                                            <td className='text-center'>{datak.JK}</td>
                                                            <td className='text-center'>{datak.KELAS}</td>
                                                            <td className='text-center'>
                                                                {datak.pilihan == 0 && "Belum Memilih Mapel"}
                                                                {datak.pilihan == 1 && "Kesehatan"}
                                                                {datak.pilihan == 2 && "Teknik"}
                                                                {datak.pilihan == 3 && "Informatika"}
                                                                {datak.pilihan == 4 && "Ekonomi & Bisnis"}
                                                                {datak.pilihan == 5 && "Humaniora"}
                                                            </td>
                                                            <td className='flex flex-col gap-2'>
                                                                <Link className='btn btn-sm text-xsm btn-outline btn-error' href={'/admin/hapusPilihan/' + datak.urut}>
                                                                    Hapus Pilihan
                                                                </Link>
                                                                <Link className='btn btn-sm text-xsm btn-outline btn-error' href={'/admin/hapusSiswa/' + datak.urut}>
                                                                    Hapus Siswa
                                                                </Link>
                                                            </td>
                                                        </tr>
                                                    )
                                                })}
                                            </tbody>
                                        </table>
                                        <Paginator data={props.data} />
                                    </div>
                                )
                            ) : (
                                suggestions.length < 1 ? (
                                    <div className='font-bold font-serif text-3xl opacity-70 text-red-400'>Maaf Data Tidak Ditemukan</div>
                                ) : (
                                    <div className={'flex flex-col w-full place-content-center ' + (loadingData && 'opacity-50')}>
                                        <table className='table table-compact w-full'>
                                            <thead className='text-center'>
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Nama</th>
                                                    <th>NIS</th>
                                                    <th>NISN</th>
                                                    <th>Jenis Kelamin</th>
                                                    <th>Kelas</th>
                                                    <th>Pilihan</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {suggestions.map((datak) => {
                                                    return (
                                                        <tr key={datak.urut}>
                                                            <td>{datak.urut}</td>
                                                            <td>{limitStringLength(datak.nama, 15)}</td>
                                                            <td>{datak.NO}</td>
                                                            <td>{datak.NISN}</td>
                                                            <td className='text-center'>{datak.JK}</td>
                                                            <td className='text-center'>{datak.KELAS}</td>
                                                            <td className='text-center'>
                                                                {datak.pilihan == 0 && "Belum Memilih Mapel"}
                                                                {datak.pilihan == 1 && "Kesehatan"}
                                                                {datak.pilihan == 2 && "Teknik"}
                                                                {datak.pilihan == 3 && "Informatika"}
                                                                {datak.pilihan == 4 && "Ekonomi & Bisnis"}
                                                                {datak.pilihan == 5 && "Humaniora"}
                                                            </td>
                                                            <td>
                                                                <Link className='btn btn-sm text-xsm btn-outline btn-error' href={'/admin/hapusPilihan/' + datak.urut}>
                                                                    Hapus Pilihan
                                                                </Link>
                                                                <Link className='btn btn-sm text-xsm btn-outline btn-error' href={'/admin/hapusSiswa/' + datak.urut}>
                                                                    Hapus Siswa
                                                                </Link>
                                                            </td>
                                                        </tr>
                                                    )
                                                })}
                                            </tbody>
                                        </table>
                                    </div>
                                )

                            )}
                        </div>
                    </div>
                </div>
            </main>
        </div>
    );
}
