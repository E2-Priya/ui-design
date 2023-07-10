import React from 'react';
import { useState } from "react";
import './App.css'
import QuizRender from './Components/QuizRender';

function App() {


const [startQuiz,setStartQuiz] = useState(false)

function startQuizClicked(){
  console.log('start Quiz')
  setStartQuiz(true)
}

  return (
    <div className='containerDiv'>
       <div className='headerDiv'><h1 className='headerClass'>QUIZ APP</h1></div> 
        
        {startQuiz === false && <div className='startBtnDiv'><button onClick={startQuizClicked}>START</button></div>}
        {startQuiz === true && <QuizRender/>}
    </div>
  );
}

export default App;
