
const express = require("express");

const app = express();

const port = 3000;
const Tutorial = require("./StudentModal");
const bodyParser = require('body-parser');
const cors = require('cors');
const db = require("./database");

const initApp = async () => {
    console.log("Testing the database connection..");
    try {
        await db.authenticate();
        console.log("Connection has been established successfully.");

        Tutorial.sync({
            alter: true,
        });

        app.listen(port, () => {
            console.log(`Server is up and running at: http://localhost:${port}`);
        });

        app.use(bodyParser.urlencoded())
        app.use(bodyParser.urlencoded({
            extended: true
          }));

        //post
        app.post("/create-student", (req, res, next) => {
            Tutorial.create({
                        title: "Tut#1",
                        description: "Tut#1 Description",
                      })
            .then((result) => {
                return res.json({
                      message: "Record created successfully!",
                      addedValue: req.body
                });
            })
            .catch((error) => {
                console.log(error);
                return res.json({
                      message: "Unable to create a record!",
                });
            });
        });
        //read all
        // app.get("/get-all-student", (req, res, next) => {
        //     console.log("*************")
        //     StudentModal.findAll({
        //         attributes: ["id", "name","subject","mark"],
        //     })
        //     .then((result) => {
        //           return res.json(result);
        //     })
        //     .catch((error) => {
        //         console.log(error);
        //         return res.json({
        //             message: 'Unable to fetch records!'
        //         });
        //     });
        // });
        //  //read single student
        //  app.get("/get-student", (req, res) => {
        //     console.log("---------------------------",req)
        //     StudentModal.findOne({
        //         where: {
        //             id : 13
        //         }
        //     })
        //     .then((result) => {
        //           return res.json(result);
        //     })
        //     .catch((error) => {
        //         console.log(error);
        //         return res.json({
        //             message: 'Unable to fetch record!'
        //         });
        //     });
        // });
        // //update
        // app.put("/update-student", (req, res, next) => {
        //     console.log("check--------------------")
        //     StudentModal.update(
        //         {
        //             name: req.body.name,
        //             subject: req.body.subject,
        //             mark: req.body.mark,
        //         },
        //         {
        //             where:{
        //                 id: req.body.id
        //             }
        //         }
        //     )
        //     .then((result) => {
        //         return res.json(result);
        //     })
        //     .catch((error) => {
        //         console.log(error);
        //         return res.json({
        //             message: 'Unable to update the record!'
        //         });
        //     });
        // });

    } catch (error) {
        console.error("Unable to connect to the database:", error.original);
    }
};


initApp();
