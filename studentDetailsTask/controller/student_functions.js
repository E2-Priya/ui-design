const { where } = require("sequelize");
var model = require("../model/model");
const { error } = require("console");
const postStudent = (req, res) => {
  let createStudent = {
    firstName: req.body.firstName,
    lastName: req.body.lastName,
    dob: req.body.dob,
    studentId: req.body.studentId,
  };
  let createMark = {
    mark: req.body.mark,
    studentStudentId: req.body.studentId,
  };
  if(createMark.mark <= 100 && createMark.mark >=80 ){
      createStudent["gradeId"] = 1
  }else if(createMark.mark <= 79 && createMark.mark >= 50){
      createStudent["gradeId"] = 2
  }else{
      createStudent["gradeId"] = 3
  }
  if (req.body.firstName !== null && req.body.firstName !== undefined) {
    model.student.create(createStudent);
    model.mark
      .create(createMark)
      .then(() => {
         res.send({
          message: "student record created",
        });
      })
      .catch((error) => {
        console.log(error);
        return res.json({
          message: "Unable to create a student record!",
        });
      });
  } else {
    return res.send({
      message: "Please provide first name",
    });
  }
};
const updateStudent = (req, res) => {
  let post = req.body;
  var condition = {
    where: {
      firstName: req.body.firstName,
    },
  };
  model.student
    .findOne({
      where: {
        firstName: req.body.firstName,
      },
    })
    .then((data) => {
      var condition = {
        where: { studentStudentId: data.studentId },
      };
      model.mark.update(post, condition);
    })
    .catch((error) => {
      console.log(error);
      return res.json({
        message: "Unable to update a record!",
      });
    });
  model.student
    .update(post, condition)
    .then(() => res.json({ message: "Student record updated" }))
    .catch((error) => {
      console.log(error);
      return res.json({
        message: "Unable to update a record!",
      });
    });
};

const deleteStudent = (req, res) => {
  model.mark.destroy({
    where: {
      studentStudentId: req.body.id,
    },
  });
  model.student
    .destroy({
      where: {
        studentId: req.body.id,
      },
    })
    .then(() => res.json({ message: "Student record deleted" }))
    .catch((error) => {
      console.log(error);
      return res.json({
        message: "Unable to delete a record!",
      });
    });
};
const getStudent = (req, res) => {
  model.student
    .findAll({
      where: {
        studentId: req.body.id,
      },
      include: [
        {
          model: model.mark,
          attributes: ["mark"],
        },
      ],
    })
    .then((data) => res.json(data))
    .catch((error) => {
      console.log("erorr", error);
      return res.json({
        message: "Unable to get capital records!",
      });
    });
};
const getCategory = (req, res) => {
  model.grade
  .findAll({
    attributes : ["grade"],
    include: [
      {
        model: model.student,
        attributes: ["studentId" , "firstName" , "lastName"],
      },
    ],
  })
  .then((data) => res.json(data))
  .catch((error) => {
    console.log("erorr", error);
    return res.json({
      message: "Unable to get student records!",
    });
  });
}
const postGrade = (req, res) => {
  let createGrade = {
    grade: req.body.grade,
  };
  model.grade.create(createGrade).then(() => {
    res.send({
     message: "student record created",
   });
 })
  .catch((error) => {
    console.log("erorr", error);
    return res.json({
      message: "Unable to get capital records!",
    });
  });
}
module.exports = {
  getStudent,
  postStudent,
  updateStudent,
  deleteStudent,
  getCategory,
  postGrade
};
