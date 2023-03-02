import { useState } from "react"
import { router } from '@inertiajs/react';


export default function EditMapel({ props, num, clicked }) {

    const [formData1, setFormData1] = useState({
        kelompok: props.kelompok,
        kode: props.kode,
        mapel1: props.mapel1,
        mapel2: props.mapel2,
        mapel3: props.mapel3,
        mapel4: props.mapel4,
        mapel5: props.mapel5,
        mapel6: props.mapel6,
        url: props.url,
        jumlah: props.jumlah,
    })

    const namaPelma = props.kelompok

    const [content, setContent] = useState(false)

    const submit = (e) => {
        e.preventDefault();
        router.patch('/mapel/mapel/' + props.no, formData1)
    };

    const clocked = (e) => {
        e.preventDefault()
        clicked(props.kelompok)
    }

    const classname = 'input input-bordered w-full max-w-xs'
    const handleCheck = (e) => {
        e.preventDefault()
        setContent(!content)
    }
    const handleChange = (event) => {
        setFormData1({ ...formData1, [event.target.name]: event.target.value });
    }
    const klsn = !content ? 'collapse-close' : "collapse-open"
    const focus = !content ? ' btn-outline' : ''
    return (
        <div className={"collapse collapse-arrow w-full bg-white " + klsn}>
            <div onClick={handleCheck} className={"w-full cursor-pointer collapse-title text-xl font-medium " + (content && "bg-gray-100")} >
                <p>{namaPelma}</p>
            </div>
            <div className="w-full collapse-content">
                <form onSubmit={submit} className="w-full flex flex-col">
                    <div className="form-control w-[100%] md:mx-10 md:w-72 lg:w-80 xl:w-96 gap-4 md:self-center">
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
                                <span className="label-text">Jumlah</span>
                            </label>
                            <input onChange={handleChange} className={classname} type="text" name="jumlah" value={formData1.jumlah} />
                        </div>
                        <button onClick={clocked} className={"btn bg-red-500 border-none shadow-md text-white"}>Hapus</button>
                        <button type="submit" className="btn shadow-md btn-primary">Simpan</button>
                    </div>
                </form>
            </div>
        </div>
    );
}
