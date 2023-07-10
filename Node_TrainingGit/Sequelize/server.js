const {Sequelize, DataTypes} = require("sequelize");
const sequelize = new Sequelize(
   'students',
   'root',
   'root@123',
    {
      host: 'localhost',
      dialect: 'mariadb',
      port: '3305',
    }
  );

sequelize.authenticate().then(() => {
   console.log('Connection has been established successfully.');
}).catch((error) => {
   console.error('Unable to connect to the database: ', error);
});

const student = sequelize.define("studentDetail", {
    name: {
      type: DataTypes.STRING,
      allowNull: false
    },
    class: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    mark: {
      type: DataTypes.INTEGER,
    }
 });
 
 sequelize.sync().then(() => {
    console.log('student detail table created successfully!');
    student.create({
        name: "Mohana Priya",
        class: "8",
        mark: 85
    }).then(res => {
        console.log(res)
    }).catch((error) => {
        console.error('Failed to create a new record : ', error);
    });
 }).catch((error) => {
    console.error('Unable to create table : ', error);
 });
