import AdminAuthNav from '@/Layouts/AdminAuthNav';
import EditMapel from './Profile/Partials/EditMapel';
import { useState } from 'react';
import { Head, router } from '@inertiajs/react';


const PengaturanMapel = (props) => {
    const [yakin, setYakin] = useState('')
    const [content, setContent] = useState(false)
    const [formData1, setFormData1] = useState({
        kelompok: props.kelompok,
        kode: props.kode,
        mapel1: props.mapel1,
        mapel2: props.mapel2,
        mapel3: props.mapel3,
        mapel4: props.mapel4,
        mapel5: props.mapel5,
        mapel6: props.mapel6,
    })

    const hapusKel = (e) => {
        e.preventDefault()
        router.delete('/mapel/mapel/' + yakin)
        setYakin('')
    }

    const classname = 'input input-bordered w-full max-w-xs md:w-full'


    const submit = (e) => {
        e.preventDefault()
        router.post('/mapel/mapel', formData1)
        if (props.errors[Object.keys(props.errors)[1]] == undefined) {
            setFormData1({
                kelompok: "",
                kode: "",
                mapel1: "",
                mapel2: "",
                mapel3: "",
                mapel4: "",
                mapel5: "",
                mapel6: "",
                url: "",
                jumlah: "",
            })
        }
    }

    const handleChange = (event) => {
        setFormData1({ ...formData1, [event.target.name]: event.target.value });
    }


    const clicked = (e) => {
        setYakin(e)
    }

    const handleCheck = (e) => {
        e.preventDefault()
        setContent(!content)
    }
    const klsn = !content ? 'collapse-close' : "collapse-open"

    return (
        <div className='min-h-screen flex flex-col bg-gray-100'>
            <Head title='Pengaturan Mapel' />
            <AdminAuthNav props={props} />
            <div className='flex flex-col md:p-8'>
                {props.errors[Object.keys(props.errors)[0]] != undefined && (
                    <div className="alert w-fit sm:w-1/2 md:w-2/3 flex-grow-0 self-center m-5 alert-success shadow-lg">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                            <span>{props.errors[Object.keys(props.errors)[0]]}</span>
                        </div>
                    </div>
                )}
                {yakin == '' ? "" : (
                    <div className="alert shadow-lg self-center my-6 max-w-3xl">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="stroke-info flex-shrink-0 w-6 h-6"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
                            <span>Anda Yakin ingin menghapus {yakin} dari kelompok mapel? ?</span>
                        </div>
                        <div className="flex-none">
                            <button onClick={() => setYakin('')} className="btn btn-sm btn-ghost">Batal</button>
                            <button onClick={hapusKel} className="btn btn-sm btn-error">Yakin</button>
                        </div>
                    </div>
                )}
                {props.mapel.map((data, i) => {
                    return (
                        <div key={i} className='flex flex-col items-center justify-center gap-4'>
                            <EditMapel props={data} num={i} clicked={clicked} />
                        </div>
                    )
                })}


                <div className={"collapse collapse-plus w-full my-6 bg-white " + klsn}>
                    <div onClick={handleCheck} className={"w-full collapse-title text-xl font-medium cursor-pointer " + (content && 'bg-green-100')}>
                        <p className='' >Tambah Kelompok</p>
                    </div>
                    <div className="w-full collapse-content">
                        <form onSubmit={submit} className="w-full flex flex-col">
                            <div className="form-control w-[100%] md:mx-10 sm:w-72 md:w-80 lg:w-96 gap-4 md:self-center">
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Kelompok Mapel</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="kelompok" value={formData1.kelompok} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Kode Mapel</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="kode" value={formData1.kode} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 1</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel1" value={formData1.mapel1} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 2</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel2" value={formData1.mapel2} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 3</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel3" value={formData1.mapel3} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 4</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel4" value={formData1.mapel4} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 5</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel5" value={formData1.mapel5} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text">Mapel - 6</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="mapel6" value={formData1.mapel6} />
                                </div>
                                <div className="flex flex-col">
                                    <img className="max-w-xs rounded-lg" src={formData1.url} alt={'Gambar Kelompok Mapel ' + formData1.kelompok} />
                                    <label className='label'>
                                        <span className="label-text">URL Gambar</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="url" value={formData1.url} />
                                </div>
                                <div className="flex flex-col">
                                    <label className='label'>
                                        <span className="label-text ">Jumlah</span>
                                    </label>
                                    <input onChange={handleChange} className={classname} type="text" name="jumlah" value={formData1.jumlah} />
                                </div>
                                <button type="submit" className="btn btn-success">Tambah Kelompok Mapel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default PengaturanMapel