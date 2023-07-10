const Sequelize = require('sequelize')
const sequelize = new Sequelize('manyTomany', 'root', 'root@123', {
  dialect: 'mariadb',
  host: 'localhost',
  port: "3305"
})
;(async () => {
  sequelize.authenticate()
  console.log('Connection successfull.')
})
module.exports = sequelize
