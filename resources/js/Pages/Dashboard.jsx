import AuthenticatedLayout from '@/Layouts/AuthenticatedLayout';
import { Head, Link } from '@inertiajs/react';
import { useEffect, useState } from 'react';
import Card from './Auth/Card';
import { router } from '@inertiajs/react';
import date from './tanggal'

export default function Dashboard(props) {
    const [data, setData] = useState();
    async function fetchDataAsync() {
        const result = await axios.get("/deadline");
        setData(result.data.value);
    }
    const sekarang = new Date(date)
    const deadline = new Date(data)
    const disab = sekarang > deadline ? true : false

    const [pilihan, setPilihan] = useState('Belum Memilih Kelompok Mapel')
    useEffect(() => {
        fetchDataAsync()
        if (props.auth.user.pilihan != null) {
            setPilihan(props.autha.pilihan)
        }
    }, [])
    // console.log(date)
    const cardHandle = (e) => {
        setPilihan(e.no)
    }
    return (
        <AuthenticatedLayout
            auth={props.auth}
            errors={props.errors}
            header={<h2 className="font-semibold text-xl text-gray-800 leading-tight">{props.auth.user.name} Dashboard</h2>}
        >
            <Head title="Dashboard" />

            <div className="py-12">
                <div className="flex flex-col max-w-7xl mx-auto sm:px-6 lg:px-8">
                    <div className="bg-white my-9 self-center p-6 flex flex-col items-center justify-center max-w-lg overflow-hidden shadow-sm sm:rounded-lg">
                        <p className='mt-2 font-bold text-lg'>Nama</p>
                        <p>{props.autha.nama}</p>
                        <p className='mt-2 font-bold text-lg'>Kelas</p>
                        <p>{props.autha.KELAS}</p>
                        <p className='mt-2 font-bold text-lg'>NIS</p>
                        <p>{props.autha.NO}</p>
                        <p className='mt-2 font-bold text-lg'>Kelompok Mapel</p>
                        <p>
                            {pilihan == 0 && "Belum Memilih Mapel"}
                            {pilihan == 1 && "Kesehatan"}
                            {pilihan == 2 && "Teknik"}
                            {pilihan == 3 && "Informatika"}
                            {pilihan == 4 && "Ekonomi & Bisnis"}
                            {pilihan == 5 && "Humaniora"}
                        </p>
                        <div className='m-3'>
                            <Link disabled={disab} href={'/submit/pilihan/' + pilihan + '/' + props.auth.user.email} className='btn btn-success mx-3 font-bold btn-outline'>{disab ? 'Maaf Sudah Telat' : 'Submit'}</Link>
                            <button onClick={() => { router.post('logout') }} className='btn btn-error font-bold btn-outline'>Logout</button>
                        </div>
                    </div>
                    <div className="bg-white overflow-hidden shadow-sm sm:rounded-lg">
                        {props.data.map((data, i) => {
                            return (
                                <Card key={i} props={data} jumlah={props.jumlah[i]} sudah={props.sudah[i]} count={props.count} num={i} card={cardHandle} />
                            )
                        })}
                    </div>
                </div>
            </div>
        </AuthenticatedLayout>
    );
}
