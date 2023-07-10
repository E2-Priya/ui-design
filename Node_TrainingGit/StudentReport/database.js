const Sequelize = require("sequelize");


const sequelize = new Sequelize(
    'studentReport',
    'root',
    'root@123',
     {
       host: 'localhost',
       dialect: 'mariadb',
       port: '3305',
     }
   );

module.exports = sequelize;
