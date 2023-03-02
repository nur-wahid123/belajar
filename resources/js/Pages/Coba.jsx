import { useForm } from '@inertiajs/react';
import { useRef, useState } from 'react';

export default function alo() {

    const { data, setData, post, processing, errors, reset } = useForm({
        nama: '',
        kelas: '',
    });

    const input = useRef()
    // console.log(errors[Object.keys(errors)[0]]);
    const handleSubmit = (e) => {
        e.preventDefault()
        reset()
        post(route('cobat.store'))
        // .then(data=>console.log(data))
    }

    const handleSubmit2 = (e)=>{
        console.log("halo");
        e.preventDefault()
        reset()
        post(route('coba.Login'))
    }
    const [WhatSubmit, setWhatSubmit] = useState(true)
    console.log(WhatSubmit)
    const handleClick = (e)=>{
        e.preventDefault()
        setWhatSubmit(!WhatSubmit)
    }

    // console.log(input);
    const inputClassName = 'rounded-lg focus:ring-1 focus:ring-blue-300 mb-3'
    return (
        <div className={'bg-slate-200 flex justify-center items-center h-[100vh]'}>
            <form onSubmit={WhatSubmit ? handleSubmit : handleSubmit2} className='card w-96 bg-base-100 shadow-xl p-8'>
                <h1 className='text-center text-lg'>Pemilihan Kelompok Mapel<p className='text-2xl font-bold'>SMAN 1 Srengat</p></h1>
                {errors[Object.keys(errors)[0]] == undefined ? "" : (
                    <div className="alert m-2 alert-error shadow-lg">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                            <span>{errors[Object.keys(errors)[0]]}</span>
                        </div>
                    </div>
                )}
                <label htmlFor="">Nama</label>
                <input
                    className={inputClassName}
                    value={data.nama}
                    ref={input}
                    onChange={(e) => setData('nama', e.target.value)}
                    type="text" />
                <label htmlFor="">kelas</label>
                <input
                    className={inputClassName}
                    value={data.kelas}
                    onChange={(e) => setData('kelas', e.target.value)}
                    type="text" />
                <button className='bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded' type="submit">Submit</button>
            </form>
                <button className='bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded' onClick={handleClick}>Ganti Submit</button>
        </div>
    )
}