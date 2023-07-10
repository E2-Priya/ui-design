const Sequelize = require("sequelize");
var sequelize = require("../database/connection");

const user = sequelize.define(
  "user",{

    userName: { type: Sequelize.STRING, field: "userName" },
  },
  { tableName: "user" }
);

const role = sequelize.define('role', {
    roleName: { type: Sequelize.STRING, field: 'roleName' },
},{ tableName:  'role'})

const user_role = sequelize.define("Employee_project", {
   
    userId: {
       type: Sequelize.INTEGER,
       references: {
         model: user, 
         key: 'id'
       }
     },
    roleId: {
       type: Sequelize.INTEGER,
       references: {
         model: role, 
         key: 'id'
       }
    }})
     
user.belongsToMany(role , { through: user_role })
role.belongsToMany(user , { through: user_role })

user.sync({ alter: true });
role.sync({ alter: true });
user_role.sync({alter: true})
module.exports = {
    user,
    role,
    user_role
};
