var model = require('../model/model')
const postRole = (req, res) => {
  let post = {
    roleName: req.body.roleName,
  }
  model.role.create(post).then((data) => {
    res.send(data)
  }).catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to create a Role record!",
  });
  });
}
const updateRole = (req, res) => {
    let post = {
        roleName: req.body.updateroleName,
    }
    var condition = {
        where: {
          roleName: req.body.roleName
        }
      }
  model.role.update(post,condition).then((result) => {
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
const deleteRole = (req, res) => {
  model.role.destroy({
    where: { roleName: req.body.roleName }
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
const getAllRole = (req, res) => {
  model.role.findAll().then((result) => res.json(result)) .catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to get country records!",
  });
  });
}

module.exports = {
  getAllRole,
  postRole,
  updateRole,
  deleteRole,
}
