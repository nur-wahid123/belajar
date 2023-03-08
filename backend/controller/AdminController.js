import users, { seluruh, siswa } from "../model/UserModel.js";
import bcrypt from 'bcrypt'
import jwt from 'jsonwebtoken'

export const LoginAdmin = async (req, res) => {
    try {
        const user = await users.findAll({
            where: {
                email: req.body.email
            }
        })
        const match = await bcrypt.compare(req.body.password, user[0].password)
        if (!match) return res.status(404).json({ msg: "Wrong Password" })
        const userId = user[0].id
        const name = user[0].name
        const email = user[0].email
        const accessToken = jwt.sign({ userId, name, email }, process.env.COBA_BRO_OKE, {
            expiresIn: '20s'
        })
        const refreshToken = jwt.sign({ userId, name, email }, process.env.ALHAMDULILLAH_BRO, {
            expiresIn: '1d'
        })
        // return res.json(process.env)
        await users.update({ refresh_token: refreshToken }, {
            where: {
                id: userId
            }
        })
        res.cookie('refreshToken', refreshToken, {
            httpOnly: true,
            maxAge: 24 * 60 * 60 * 1000
        })
        res.json({ accessToken })
    } catch (error) {
        res.status(404).json({ msg: "email tidak ditemukan" })
    }

}

export const ambilData = async(req,res)=>{
    const c = await seluruh.count()
    await users.sync({force:true})
    for (let index = 1; index < c+1; index++) {
        const a = await seluruh.findAll({
            where:{
                urut:index
            }
        })
        const salt = await bcrypt.genSalt()
        const hashPw = await bcrypt.hash(a[0].NISN,salt)
        await users.create({
            id:a[0].urut,
            name:a[0].nama,
            email:a[0].NO,
            password:hashPw,
        })
    }
    const siswao = await seluruh.findAll()
    return res.json(siswao)
}

export const LogoutAdmin = async (req, res) => {
    const resfreToken = req.cookies.refreshToken
    if (!resfreToken) return res.sendStatus(204)
    const user = await users.findAll({
        where: {
            refresh_token: resfreToken
        }
    })
    if (!user[0]) return res.sendStatus(204)
    const userId = user[0].id
    await users.update({ refresh_token: null }, {
        where: {
            id: userId
        }
    })
    res.clearCookie('refreshToken')
    return res.sendStatus(200)
}

export const hapusData = async (req,res)=>{

    await siswa.sync({
        force:true
    })
    return res.json({msg:'Data Sudah dihapus'})
}