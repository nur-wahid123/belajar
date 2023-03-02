import AdminAuthNav from '@/Layouts/AdminAuthNav'
import { Head, router } from '@inertiajs/react'
import React, { useEffect, useState } from 'react'
import hrini from './tanggal'

const Atur = (props) => {
    const [file, setFile] = useState({
        selectedFile: null,
        text: null,
        tanggal: null,
    })
    const importFile = (e) => {
        e.preventDefault()
        router.post("upload", file)
    }

    //fungsi import
    const input = (e) => {
        setFile({ ...file, selectedFile: e.target.files[0] })
    }
    const inputText = (e) => {
        setFile({ ...file, text: e.target.value })
    }
    const inputDate = (e) => {
        setFile({ ...file, tanggal: e.target.value })
    }
    useEffect(() => {
        setFile({ ...file, tanggal: props.b })
    }, []);
    return (
        <div>
            <AdminAuthNav props={props} />
            <Head title="Pengaturan" />
            <div className='flex min-h-screen items-center flex-col justify-center'>
                {props.errors[0] != null && (
                    <div className="alert w-fit sm:w-1/2 md:w-2/3 flex-grow-0 self-center m-5 alert-error shadow-lg">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                            <span>
                                {props.errors[0] == 1 && "Maaf Data Tidak Boleh Kosong"}
                                {props.errors[0] == 2 && "Maaf Data hanya diperbolehkan file .jpg, .png, .avif dan .jpeg"}
                                {props.errors[0] == 3 && "Ukuran file maksimal adalah 2.5 Mb"}
                                {props.errors[0] == 4 && "Mohon maaf, kosongkan kolom id"}
                            </span>
                        </div>
                    </div>
                )}
                <form className='form-control m-12 w-full max-w-xs gap-2'>
                    <label className='label'>
                        <span className='label-text'>Upload Logo SMA</span>
                    </label>
                    <input onChange={input} className='file-input input-bordered w-full max-w-xs' type="file" name="file" id="file" />
                    <label className='label'>
                        <span className='label-text'>Edit Nama SMA</span>
                    </label>
                    <input onChange={inputText} className='input input-bordered w-full max-w-xs' type="text" name="file" id="file" />
                    <label className='label'>
                        <span className='label-text'>Atur Deadline Tugas</span>
                    </label>
                    <input onChange={inputDate} className='input input-bordered w-full max-w-xs' type="date" min={hrini} max={props.a} value={file.tanggal == null ? "2023-01-01" : file.tanggal} name="file" id="file" />
                    <button className='btn btn-success' onClick={importFile}>Submit</button>
                </form>
            </div>
        </div>
    )
}

export default Atur
