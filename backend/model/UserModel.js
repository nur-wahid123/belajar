import { Sequelize } from "sequelize";
import db from "../config/Database.js";

const {DataTypes} = Sequelize

export const seluruh = db.define('daat',{
    urut:{
        type : DataTypes.STRING,
        primaryKey:true,
        autoIncrement:true,
        field:'urut'
    },
    NO:{
        type : DataTypes.STRING
    },
    NISN:{
        type : DataTypes.STRING
    },
    nama:{
        type : DataTypes.STRING
    },
},{
    timestamps:false,
    tableName:'datakeseluruhan',
    initialAutoIncrement:'urut'
})
export const siswa = db.define('siswa',{
    nama:{
        type : DataTypes.STRING
    },
    nis:{
        type : DataTypes.STRING
    },
    nisn:{
        type : DataTypes.STRING
    },
    nisn:{
        type : DataTypes.STRING
    },
},{
    timestamps:false,
    tableName:'siswa'
})

const users = db.define('siswak',{
    name:{
        type : DataTypes.STRING
    },
    email:{
        type : DataTypes.STRING
    },
    password:{
        type : DataTypes.STRING
    },
    refresh_token:{
        type : DataTypes.TEXT
    },
    gender:{
        type : DataTypes.STRING
    },
},{
    freezeTableName:true
})

export default users