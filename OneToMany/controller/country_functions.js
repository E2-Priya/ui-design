var model = require('../model/capital')
const postCountry = (req, res) => {
  let post = {
    countryName: req.body.countryName,
    population: req.body.population
  }
  model.country.create(post).then((data) => {
    res.send(data)
  }).catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to create a country record!",
  });
  });
}
const updateCountry = (req, res) => {
  model.country.update({
    where: {
      countryName: req.body.countryName,
    },
  }).then((result) => {
        return res.json({
        message: "Record updated successfully!",
      });
      })
      .catch((error) => {
        console.log(error);
        return res.json({
        message: "Unable to updated a record!",
      });
      });
}
const deleteCountry = (req, res) => {
  model.country.destroy({
    where: { countryName: req.body.countryName }
  }).then((result) => {
    return res.json({
    message: "Record deleted successfully!",
  });
  })
  .catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to delete a record!",
  });
  });
}
const getCountry = (req, res) => {
  model.country.findAll({ include: model.city }).then((result) => res.json(result)) .catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to get country records!",
  });
  });
}
module.exports = {
  getCountry,
  postCountry,
  updateCountry,
  deleteCountry,
}
