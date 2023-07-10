var model = require('../model/capital')
const postCapital= (req, res) => {
  let post = {
    name: req.body.name,
    countryId : req.body.countryId
  }
  model.capital.create(post).then((data) => {
    res.send(data)
  }).catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to create a capital record!",
  });
  });
}
const updateCapital = (req, res) => {
  model.capital.update({
    where: {
      name: req.body.name,
    },
  }).then((result) => res.json(result))
    .catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to update a record!",
    });
  });
}
const deleteCapital = (req, res) => {
  model.capital.destroy({
    where: {
      name: req.body.name,
    },
  }).then((result) => res.json(result))
    .catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to delete a record!",
    });
  });
}
const getCapital = (req, res) => {
  model.capital.findAll({ include: model.country }).then((result) => res.json(result))
    .catch((error) => {
      console.log("erorr----------------", error);
      return res.json({
      message: "Unable to get capital records!",
    });
  });
}
module.exports = {
  getCapital,
  postCapital,
  updateCapital,
  deleteCapital,
}
