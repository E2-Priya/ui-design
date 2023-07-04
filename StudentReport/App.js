
const express = require("express");

const app = express();

const port = 3000;
const StudentModal = require("./StudentModal");
const bodyParser = require('body-parser');
const cors = require('cors');
const db = require("./database");

const initApp = async () => {
    console.log("Testing the database connection..");
    try {
        await db.authenticate();
        console.log("Connection has been established successfully.");

        StudentModal.sync({
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
            StudentModal.create({
                name: req.body.name,
                subject: req.body.subject,
                mark: req.body.mark,
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
        app.get("/get-all-student", (req, res, next) => {
            StudentModal.findAll({
                attributes: ["id", "name","subject","mark"],
            })
            .then((result) => {
                  return res.json(result);
            })
            .catch((error) => {
                console.log(error);
                return res.json({
                    message: 'Unable to fetch records!'
                });
            });
        });
        //update
        app.post("/update-student", (req, res, next) => {
            StudentModal.update(
                {
                    name: req.body.name,
                    subject: req.body.subject,
                    mark: req.body.mark,
                },
                {
                    where: {
                        id: req.body.id,
                    },
                }
            )
            .then((result) => {
                return res.json(result);
            })
            .catch((error) => {
                console.log(error);
                return res.json({
                    message: 'Unable to update the record!'
                });
            });
        });

    } catch (error) {
        console.error("Unable to connect to the database:", error.original);
    }
};


initApp();
