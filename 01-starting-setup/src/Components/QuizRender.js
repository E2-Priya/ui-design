import { useState } from "react";
import { quiz } from "./Questions";
import "./QuizRender.css";
import Result from "./Result";
const selectedAns = [];

function QuizRender() {
  const [activeQuestion, setActiveQuestion] = useState(0);
  const [selectedAnswer, setSelectedAnswer] = useState();
  const [selectedAnswerIndex, setSelectedAnswerIndex] = useState(null);
  const [selectedAnswerValue, setSelectedAnswerValue] = useState(null);
  const { questions } = quiz;
  const [showResult, setShowResult] = useState(false);
  const { question, choices, correctAnswer } = questions[activeQuestion];
  const [result, setResult] = useState({
    score: 0,
    correctAnswers: 0,
    wrongAnswers: 0,
  });

  function onClickNext() {
    selectedAns.push(selectedAnswerValue);
    localStorage.setItem("selectedAnsIndex", JSON.stringify(selectedAns));

    setSelectedAnswerIndex(null);
    if (activeQuestion !== questions.length - 1) {
      setActiveQuestion((prev) => prev + 1);
    } else {
      setActiveQuestion(0);
      setShowResult(true);
      questions[0].selectedAnswer1 = selectedAns[0];
      questions[1].selectedAnswer1 = selectedAns[1];
      questions[2].selectedAnswer1 = selectedAns[2];
      questions[3].selectedAnswer1 = selectedAns[3];
    }
    setResult((prev) =>
      selectedAnswer
        ? {
            ...prev,
            score: prev.score + 1,
            correctAnswers: prev.correctAnswers + 1,
          }
        : { ...prev, wrongAnswers: prev.wrongAnswers + 1 }
    );
  }

  function onAnswerSelected(answer, index) {
    setSelectedAnswerValue(answer);
    setSelectedAnswerIndex(index);

    if (answer === correctAnswer) {
      setSelectedAnswer(true);
    } else {
      setSelectedAnswer(false);
    }
  }

  return (
    <div className="finalContainer">
      {!showResult && (
        <div className="Questioncontainer">
          <div className="qnCont">
            <span class="qNo">{activeQuestion + 1}</span>
            <h2>{questions[activeQuestion].question}</h2>
          </div>
          <div className="choiceClass">
            <ul>
              {choices.map((item, index) => (
                <div
                  onClick={() => onAnswerSelected(item, index)}
                  className={
                    selectedAnswerIndex === index
                      ? "selected-answer eachChoice"
                      : "eachChoice"
                  }
                >
                  <li key={activeQuestion + index}>{item}</li>
                </div>
              ))}
            </ul>
          </div>
          <div className="nxtBtnClass">
            {" "}
            <button
              onClick={onClickNext}
              disabled={selectedAnswerIndex === null}
            >
              {" "}
              {activeQuestion === questions.length - 1 ? "Finish" : "Next"}
            </button>
          </div>
        </div>
      )}
      {showResult && (
        <div className="resultDiv">
          <Result score={result}> SHOW RESULT PAGE </Result>
        </div>
      )}
    </div>
  );
}

export default QuizRender;
