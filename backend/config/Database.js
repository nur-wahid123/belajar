import { Sequelize } from "sequelize";  
const db = new Sequelize('indra','root','',{
    host:'localhost',
    dialect:'mysql'
})

export default db