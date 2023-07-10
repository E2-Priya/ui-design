const Sequelize = require('sequelize')
var sequelize = require('../database/connection')

const country = sequelize.define('country', {
  countryName: { type: Sequelize.STRING, field: 'countryName' },
  population: { type: Sequelize.INTEGER, field: 'population' },
 
},{ tableName:  'country'})

// country.associate = models => {
//     country.hasOne(models.capital, {
// 			foreignKey: 'id',
// 			targetKey: 'id',
// 			as: 'capitalId'
// 		});
//   }
country.sync({ alter: true })
module.exports = country
