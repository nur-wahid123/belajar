import { useState } from 'react';
import { useEffect } from 'react';
const tampilCard = ({ props, card, count, num, jumlah, sudah }) => {
    const url = 'url(' + props.url + ')'
    const styles = {
        container: {
            backgroundImage: url,
            height: 'auto',
            width: 'auto',
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            backgroundPosition: 'center',
        },
    }

    const styl = {
        container: {
            color: '#fff',
            background: 'rgba(0,0,0,0.7)',
        },
    }
    const [habis, setHabis] = useState(true)
    const sisa = count[num]
    useEffect(() => {
        if (sisa == 0) {
            setHabis(false)
        } else {
            setHabis(true)
        }
    }, [habis])

    return (
        <div style={styles.container} className="my-5 mx-3 w-full md:w-1/2 lg:my-4 lg:w-1/3 rounded-lg">
            <article style={styl.container} className="flex w-full flex-col md:justify-center md:items-center px-5 overflow-hidden rounded-lg shadow-lg">
                <div className="m-4">
                    <h1 className="font-bold font-serif text-2xl mb-4 text-center">{props.kelompok}</h1>
                    <ul className="text-center md:flex md:gap-32 md:justify-center md:items-center md:w-full">
                        <div>
                            <li className='font-bold'>P{num + 1}</li>
                            <li className='mt-2'>Jumlah Kuota : <span className='font-extrabold'>{jumlah}</span> orang</li>
                            <li className='mt-2'>Jumlah Pendaftar : <span className='font-extrabold'>{sudah}</span> orang</li>
                            <li className='mt-2'>Kuota tersisa : <span className='font-extrabold'>{sisa}</span> orang</li>
                        </div>
                        <div className='m-4'>
                            <li className='text-xl font-bold'>{props.mapel1}</li>
                            <li className='text-xl font-bold'>{props.mapel2}</li>
                            <li className='text-xl font-bold'>{props.mapel3}</li>
                            <li className='text-xl font-bold'>{props.mapel4}</li>
                            <li className='text-xl font-bold'>{props.mapel5}</li>
                            <li className='text-xl font-bold'>{props.mapel6}</li>
                        </div>
                    </ul>
                </div>
                {/* <footer className="flex items-center justify-betweeen md:justify-center leading-none p-2 md:p-4">
                    <p className="flex items-center md:flex-col no-underline hover:underline text-black" href="#">
                        <h1 className="ml-2 text-xl text-center font-bold xl:text-xl md:text-base md:w-auto">
                            {props.kelas[num].mapel}
                        </h1>
                    </p>
                </footer> */}
                <div className="flex justify-center m-4">
                    <button disabled={!habis} onClick={() => card(props)} className="btn disabled:bg-blue-100 bg-blue-500 hover:bg-purple-600 hover:-translate-y-1 hover:scale-110 transition ease-in-out delay-150 duration-300 text-center text-white w-32 border-none">{'Pilih'}</button>
                </div>

            </article>
        </div>
    )
}


const Card = (props) => {
    return (

        tampilCard(props)
    )
}

export default Card