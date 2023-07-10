var model = require('../model/model')
const postUser = (req, res) => {
  let post = {
    userName: req.body.userName,
  }
  model.user.create(post).then((data) => {
    res.send(data)
  }).catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to create a User record!",
  });
  });
}
const updateUser = (req, res) => {
    let post = {
        userName: req.body.updateuserName,
    }
    var condition = {
        where: {
          userName: req.body.userName
        }
      }
  model.user.update(post,condition).then((result) => {
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
const deleteUser = (req, res) => {
  model.user.destroy({
    where: { userName: req.body.userName }
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
const getAllUser = (req, res) => {
  model.user.findAll().then((result) => res.json(result)) .catch((error) => {
    console.log(error);
    return res.json({
    message: "Unable to get country records!",
  });
  });
}
const postUserRole = (req, res) => {
    let post = {
      userId: req.body.userId,
      roleId : req.body.roleId
    }
    model.user_role.create(post).then((data) => {
      res.send(data)
    }).catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to create a User record!",
    });
    });
  }
const getAllUserRole = (req, res) => {
    model.user.findAll({
        include: [
          {
            model: model.role,
             
            attributes: ["roleName"],
            through: {
              attributes: ["userId", "roleId"],
            }
          },
        ],
      }).then((result) => res.json(result)) .catch((error) => {
      console.log(error);
      return res.json({
      message: "Unable to get country records!",
    });
    });
}

module.exports = {
  getAllUser,
  postUser,
  updateUser,
  deleteUser,
  postUserRole,
  getAllUserRole
}
