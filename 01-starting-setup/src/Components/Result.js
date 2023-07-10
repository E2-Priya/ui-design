import { quiz } from "./Questions";
import { qu } from "./QuizRender";
import "./Result.css";
import { useState } from "react";
const { questions } = quiz;

function Result(props) {
  const selectAns = localStorage.getItem("selectedAnsIndex");
  const [first, second, third, fourth] = JSON.parse(selectAns);
  console.log(
    `first : ${first} second : ${second} third : ${third} , fourth : ${fourth}`
  );

  const { questions } = quiz;
  const listItems = questions.map((element) => {
    const crr = element.correctAnswer;
    const sAns = element.selectedAnswer1;

    console.log(`crr : ${crr} sAns : ${sAns}`);
    return (
      <div className="container">
        <ul>
          <li className="qnContainer" key={Math.random()}>
            <div className="qnContainer2">{element.question}</div>
          </li>
          <li className="choiceContainer2" key={Math.random()}>
            <div className="choiceContainer">
              <ul>
                {element.choices.map((el, index) => {
                  if (el === crr) {
                    return (
                      <li
                        key={index}
                        className={
                          crr === sAns
                            ? "scoredCrt choiceList"
                            : "crtAns choiceList"
                        }
                      >
                        {el}
                      </li>
                    );
                  } else {
                    if (el == sAns) {
                      return (
                        <li
                          key={index}
                          className={
                            crr === sAns
                              ? "scoredCrt choiceList"
                              : "wrongAns choiceList"
                          }
                        >
                          {el}
                        </li>
                      );
                    } else {
                      return (
                        <li key={index} className="choiceList">
                          {el}
                        </li>
                      );
                    }
                  }
                })}
              </ul>
            </div>
          </li>
        </ul>
      </div>
    );
  });

  console.log(questions);
  return (
    <div className="divv">
      <div className="mainContainer">{listItems}</div>
     <div className="scoreDiv"><p className="scoreClass">YOUR SCORE : {props.score.correctAnswers}</p></div> 
    </div>
  );
}
export default Result;
