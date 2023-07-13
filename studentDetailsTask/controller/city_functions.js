var model = require('../model/capital')
const postCity= (req, res) => {
  let post = {
    cityName: req.body.cityName,
    countryId : req.body.countryId
  }
  model.city.create(post).then((data) => {
    res.send(data)
  }).catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to create a capital record!",
  });
  });
}
const updateCity = (req, res) => {
  model.city.update({
    where: {
      cityName: req.body.cityName,
    },
  }).then((result) => res.json(result))
    .catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to update a record!",
    });
  });
}
const deleteCity = (req, res) => {
  model.city.destroy({
    where: {
      cityName: req.body.cityName,
    },
  }).then((result) => res.json(result))
    .catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to delete a record!",
    });
  });
}
const getCity = (req, res) => {
  model.city.findAll({ include: model.country }).then((result) => res.json(result))
    .catch((error) => {
      console.log("erorr----------------", error);
      return res.json({
      message: "Unable to get capital records!",
    });
  });
}
module.exports = {
  getCity,
  postCity,
  updateCity,
  deleteCity,
}
