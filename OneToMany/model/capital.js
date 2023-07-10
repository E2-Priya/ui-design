const Sequelize = require("sequelize");
var sequelize = require("../database/connection");

const capital = sequelize.define(
  "capital",
  {
    name: { type: Sequelize.STRING, field: "name" },
    //countryId: { type: Sequelize.INTEGER, field: "countryId" },
  },
  { tableName: "capital" }
);

const country = sequelize.define('country', {
  countryName: { type: Sequelize.STRING, field: 'countryName' },
  population: { type: Sequelize.INTEGER, field: 'population' },
 
},{ tableName:  'country'})

const city = sequelize.define('city', {
  cityName: { type: Sequelize.STRING, field: 'cityName' }
},{ tableName:  'city'})


// capital.associate = (models) => {
//   console.log("error-------------", models);
//   capital.belongsTo(models.country, {
//     foreignKey: "countryId",
//     targetKey: "id",
//     as: "relation",
//   });
// };

capital.belongsTo(country)
country.hasOne(capital)

city.belongsTo(country)
country.hasMany(city)

country.sync({ alter: true });
capital.sync({ alter: true });
city.sync({ alter: true})
module.exports = {
  capital,
  country,
  city
};
