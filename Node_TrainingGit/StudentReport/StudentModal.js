const  DataTypes  = require("sequelize");

const sequelize = require("./database");

// const studentMarks = sequelize.define(
//     "studentMarks",
//     {
//         id: {
//             type: DataTypes.INTEGER,
//             autoIncrement: true,
//             allowNull: false,
//             primaryKey: true,
//         },
//         name: {
//             type: DataTypes.STRING,
//             allowNull: true,
//         },
//         subject: {
//             type: DataTypes.STRING,
//             allowNull: true,
//         },
//         mark: {
//             type: DataTypes.INTEGER,
//             allowNull: true,
//         },
//     },
//     {
//         /**
//          * Other model options go here
//          */
//     }
// );
const Tutorial = sequelize.define(
    "Tutorial",
    {
        id: {
            type: DataTypes.INTEGER,
            autoIncrement: true,
            allowNull: false,
            primaryKey: true,
        },
        title: {
            type: DataTypes.STRING,
            allowNull: true,
        },
        description: {
            type: DataTypes.STRING,
            allowNull: true,
        }
    },
);
// const Comment = sequelize.define(
//     "Comment",
//     {
//         id: {
//             type: DataTypes.INTEGER,
//             autoIncrement: true,
//             allowNull: false,
//             primaryKey: true,
//         },
//         name: {
//             type: DataTypes.STRING,
//             allowNull: true,
//         },
//         Text: {
//             type: DataTypes.STRING,
//             allowNull: true,
//         }

//     },
// );
// Tutorial.hasMany(Comment, { as: "comments" });
// Comment.belongsTo(Tutorial, {
//   foreignKey: "tutorialId",
//   as: "tutorial",
// });
module.exports = Tutorial;
// module.exports = Comment;
// module.exports = studentMarks;
