import { useState } from 'react';
import { useEffect } from 'react';
import { router, Head } from '@inertiajs/react';
const Result = (props) => {
    const [pilih, setPilih] = useState('Belum ada Kelompok Mapel')
    const handleSubmit = () => {
        router.post('logout')
    }
    useEffect(() => {
        if (props.data[0].pilihan != null) {
            setPilih(props.data[0].pilihan)
            // a++
        }

    }, [pilih])

    const styl = {
        width: '100vh'
    }
    return (
        <div className={'flex flex-col items-center justify-center h-[100vh]'}>
            <Head title='Result' />
            <div className="flex flex-col items-center justify-center shadow-lg border-gray-300 border rounded-lg mx-12 w-80 sm:w-96 p-3 my-4">
                <div className="text-center">
                    <p className="font-bold mt-3  text-lg">NIS</p>
                    <p>{props.data[0].NO}</p>
                    <p className="font-bold mt-3  text-lg">NISN</p>
                    <p>{props.data[0].NISN}</p>
                    <p className="font-bold mt-3  text-lg">Nama</p>
                    <p>{props.data[0].nama}</p>
                    <p className="font-bold mt-3  text-lg">Kelas</p>
                    <p>{props.data[0].KELAS}</p>
                    <p className="font-bold mt-3  text-lg">Pilihan Kelompok Mapel</p>
                    <p>
                        {pilih == 0 && "Belum Memilih Mapel"}
                        {pilih == 1 && "Kesehatan"}
                        {pilih == 2 && "Teknik"}
                        {pilih == 3 && "Informatika"}
                        {pilih == 4 && "Ekonomi & Bisnis"}
                        {pilih == 5 && "Humaniora"}
                    </p>                </div>
                <button onClick={() => handleSubmit()} className="btn mt-6 font-bold bg-green-400 hover:bg-blue-500 border-none text-white transition ease-in-out delay-150 duration-300 hover:scale-110">Kembali</button>
            </div>
        </div>
    )
}

export default Result