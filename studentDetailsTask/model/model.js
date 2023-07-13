const Sequelize = require("sequelize");
var sequelize = require("../database/connection");

const student = sequelize.define(
  "student",
  {
    firstName: { type: Sequelize.STRING, field: "firstName" },
    lastName: { type: Sequelize.STRING, field: "lastName" },
    dob: { type: Sequelize.STRING, field: "dob" },
    studentId: {
      allowNull: false,
      autoIncrement: false,
      primaryKey: true,
      type: Sequelize.INTEGER
    }
  },
  { tableName: "student" }
);

const mark = sequelize.define('marks', {
  mark: { type: Sequelize.INTEGER, field: 'mark' }
},{ tableName:  'mark'})

const grade = sequelize.define('grade', {
  grade: { type: Sequelize.STRING, field: 'grade' }
},{ tableName:  'grade'})



student.hasOne(mark)
grade.hasMany(student)


grade.sync({ alter : true})
student.sync({ alter: true });
mark.sync({ alter: true });

   
module.exports = {
  student,
  mark,
  grade
};
