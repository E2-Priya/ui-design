const express = require("express");
const app = express();
const port = 3000;
const {Tutorial,Comment} = require("./modal");
const db = require("./database");

const initApp = async () => {
    console.log("Testing the database connection..");
    try {
        await db.authenticate();
        console.log("Connection has been established successfully.");

        Tutorial.sync({
            alter: true,
        });
        // Comment.sync({
        //     alter: true,
        // });
        app.listen(port, () => {
            console.log(`Server is up and running at: http://localhost:${port}`);
        });

        // //post
        app.post("/create-student", (req, res, next) => {
            Tutorial.create({
                title: "Tut#1",
                description: "Tut#1 Description",
              })
              
            Comment.create({
                name: "E2info",
                text: "good job",
                tutorialId: 1,
            },{
                name: "Amara",
                text: "good work",
                tutorialId: 1,
            },{
                name: "Amara",
                text: "good work",
                tutorialId: 1,
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
        // //read all
        // app.get("/get-all", (req, res, next) => {
        //     console.log("*************")
        //    // Tutorial.findByPk(tutorialId, { include: ["comments"] })
        //     Tutorial.findAll({ include: ["comments"] })
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
        
    } catch (error) {
        console.error("Unable to connect to the database:", error.original);
    }
};
initApp();
