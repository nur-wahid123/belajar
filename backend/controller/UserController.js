import users from "../model/UserModel.js";
import bcrypt from 'bcrypt'
import jwt from 'jsonwebtoken'


export const getUsers = async (req, res) => {
    try {
        const user = await users.findAll({
            attributes: ['id', 'name', 'email']
        })
        res.json(user)
    } catch (err) {
        console.log(err)
    }
}
export const Register = async (req, res) => {
    try {
        const { name, email, password, confPassword } = req.body
        if (password !== confPassword) return res.status(400).json({ msg: "Password dan confirm password tidak cocok" })
        const salt = await bcrypt.genSalt()
        const hashPassword = await bcrypt.hash(password, salt)
        try {
            await users.create({
                name: name,
                password: hashPassword,
                email: email,
            })
            res.json({ msg: "Register Berhasil" })
        } catch (error) {
            console.log(error)
        }
    } catch (err) {
        console.log(err)
    }
}

export const Login = async (req, res) => {
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
        const accessToken = jwt.sign({ userId, name, email }, process.env.ACCESS_TOKEN_SECRET, {
            expiresIn: '20s'
        })
        const refreshToken = jwt.sign({ userId, name, email }, process.env.REFRESH_TOKEN_SECRET, {
            expiresIn: '1d'
        })
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

export const Logout = async (req, res) => {
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

