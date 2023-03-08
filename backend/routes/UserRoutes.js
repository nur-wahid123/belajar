import express from 'express'
import { Logout, getUsers, Register, Login } from './../controller/UserController.js'
import { LoginAdmin, ambilData, LogoutAdmin, hapusData } from '../controller/AdminController.js'
import { VerifyToken, VerifyTokenAdmin } from '../middleware/VerifyToken.js'
import { refreshToken, refreshTokenAdmin } from '../controller/RefreshToken.js'


const router = express.Router()

router.get('/LoginAdmin', LoginAdmin)
router.post('/data',VerifyTokenAdmin, ambilData)
router.post('/data2', ambilData)
router.get('/users', VerifyToken, getUsers)
router.post('/users', Register)
router.post('/login', Login)
router.get('/token', refreshToken)
router.get('/tokenAdmin', refreshTokenAdmin)
router.delete('/logout', Logout)
router.delete('/logout', LogoutAdmin)
router.post('/hapusData', hapusData)


export default router