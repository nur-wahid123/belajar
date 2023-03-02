import AdminAuthNav from '@/Layouts/AdminAuthNav';
import { useState, useRef } from 'react';
import { Head, router } from '@inertiajs/react';
import axios from 'axios';


const TambahSiswa = (props) => {
    const [yeas, setYeas] = useState({
        content1: false,
        content2: false,
    })
    const [loading, setLoading] = useState(false);
    const [content, setContent] = useState(null)
    const [_errors, setErrors] = useState(null)
    const [formData1, setFormData1] = useState({
        nama: "",
        kode: "",
        nis: "",
        nisn: "",
        jk: "",
    })

    const classname = 'input input-bordered w-full max-w-xs md:w-full'

    const submitt = (e) => {
        e.preventDefault()
        axios.post('tambahSiswa', formData1)
            .then(response => setContent(response.data.message))
            .catch(error => setErrors(error.response.data.message))
    }

    if (content != null) {
        router.get('dashboard')
    }

    const handleChange = (event) => {
        setFormData1({ ...formData1, [event.target.name]: event.target.value.toUpperCase() });
    }

    // const klsn = yeas.content1 ? "collapse-open" : "collapse-close"
    const klsn = {
        klsn1: yeas.content1 ? "collapse-open" : "collapse-close",
        klsn2: yeas.content2 ? "collapse-open" : "collapse-close",
    }

    //fungsi import
    const [file, setFile] = useState()
    const input = (e) => {
        setFile({ selectedFile: e.target.files[0] })
    }
    const importFile = (e) => {
        e.preventDefault()
        router.post("import", file)
    }

    //fungsi download data
    const handleDownload = async () => {
        setLoading(true);

        // Make the API call to download the file
        const response = await fetch('/template');
        const blob = await response.blob();

        // Create a link element and trigger a download
        const link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        link.download = 'template.xlsx';
        document.body.appendChild(link);
        link.click();
        link.remove();

        setLoading(false);
    };


    return (
        <div className='min-h-screen flex flex-col'>
            <Head title='Tambah Siswa' />
            <AdminAuthNav props={props} />
            <div className='flex flex-col md:p-8'>
                {props.errors[0] != null && (
                    <div className="alert w-fit sm:w-1/2 md:w-2/3 flex-grow-0 self-center m-5 alert-error shadow-lg">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                            <span>
                            {props.errors[0] == 1 && "Maaf Data Tidak Boleh Kosong"}
                            {props.errors[0] == 2 && "Maaf Data hanya diperbolehkan file .xls dan .xlsx"}
                            {props.errors[0] == 3 && "Maaf Masukkan File Sama seperti template yang sudah ada"}
                            {props.errors[0] == 4 && "Mohon maaf, kosongkan kolom id"}
                            </span>
                        </div>
                    </div>
                )}
                {_errors != null && (
                    <div className="alert w-fit sm:w-1/2 md:w-2/3 flex-grow-0 self-center m-5 alert-error shadow-lg">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                            <span>{_errors}</span>
                        </div>
                    </div>
                )}
                <div className={"collapse collapse-plus w-full shadow my-6 " + klsn.klsn1}>
                    <div onClick={(e) => {
                        e.preventDefault()
                        setYeas({ ...yeas, content1: !yeas.content1 })
                    }}
                        className={"w-full collapse-title text-2xl font-serif text-center font-normal cursor-pointer border border-gray-300 " + (yeas.content1 && "bg-slate-50")}>
                        <p className='' >Tambah Siswa Baru Via excel</p>
                    </div>
                    <div className="w-full flex justify-center items-center collapse-content">
                        <form onSubmit={importFile} className='form-control m-12 w-full max-w-xs gap-2'>
                            <label className='label'>
                                <span className='label-text'>Import Database</span>
                            </label>
                            <input onChange={input} className='file-input input-bordered w-full max-w-xs' type="file" name="file" id="file" />
                            <input type="submit" className='btn btn-success' />
                            <button className='btn btn-success my-6' onClick={handleDownload} disabled={loading}>
                                {loading ? 'Downloading...' : 'Download Template'}
                            </button>
                        </form>
                    </div>
                </div>
                <div className={"collapse collapse-plus w-full shadow my-6 " + klsn.klsn2}>
                    <div onClick={(e) => {
                        e.preventDefault()
                        console.log(yeas)
                        console.log(klsn)
                        setYeas({ ...yeas, content2: !yeas.content2 })
                    }}
                        className={"w-full collapse-title text-2xl font-serif text-center font-normal cursor-pointer border border-gray-300 " + (yeas.content2 && "bg-slate-50")}>
                        <p className='' >Tambah Siswa Baru Manual</p>
                    </div>
                    <div className="w-full collapse-content">
                        <form onSubmit={submitt} className="w-full flex flex-col">
                            <div className="form-control w-[100%] md:mx-10 sm:w-72 md:w-80 lg:w-96 gap-4 md:self-center">
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Nama</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="nama" value={formData1.nama} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">NIS</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} min="0" type="number" name="nis" value={formData1.nis} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">NISN</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} min="0" type="number" name="nisn" value={formData1.nisn} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Kelas</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="kelas" value={formData1.kelas} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Jenis Kelamin</span>
                                    </label>
                                    <select name="jk" id="jk" value={formData1.jk} onChange={handleChange} className="select select-bordered">
                                        <option value="">Pilih Salah Satu</option>
                                        <option value="L">L</option>
                                        <option value="P">P</option>
                                    </select>
                                    {/* <input  className={classname} type="text"  value={formData1.jk} /> */}
                                </div>
                                <button type="submit" className="btn btn-success">Tambah Siswa Baru</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default TambahSiswa