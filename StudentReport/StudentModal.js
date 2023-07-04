const { Sequelize, DataTypes } = require("sequelize");

const sequelize = require("./database");

const studentMarks = sequelize.define(
    "studentMarks",
    {
        id: {
            type: DataTypes.INTEGER,
            autoIncrement: true,
            allowNull: false,
            primaryKey: true,
        },
        name: {
            type: DataTypes.STRING,
            allowNull: true,
        },
        subject: {
            type: DataTypes.STRING,
            allowNull: true,
        },
        mark: {
            type: DataTypes.INTEGER,
            allowNull: true,
        },
    },
    {
        /**
         * Other model options go here
         */
    }
);

module.exports = studentMarks;
