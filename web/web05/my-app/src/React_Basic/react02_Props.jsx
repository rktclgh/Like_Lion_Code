import React, { useState } from 'react';


function Welcome(props) {
  return <h2>Welcome, {props.name}!</h2>;
}
function App() {
  return <Welcome name="홍길동 " />;
}


//Calc 컴포넌트를 만들어 사칙연산을 구현해보자

function Calc(props){

  const{num1, num2} = props;

  return (
    <div>
      <h2> 사칙연산 </h2>
      <p>{num1} +{num2} = {num1+num2}</p>
      <p>{num1} -{num2} = {num1-num2}</p>
      <p>{num1} *{num2} = {num1*num2}</p>
      <p>{num1} /{num2} = {num2!==0? (num1/num2): "0으로 나눌수 없어!"}</p>
    
    
    

      </div>
  );
}

//MyCalc를 만들어서 버튼을 클릭하면 사칙연산을 구현해보자
function MyCalc(props){
  const {num1, num2} = props;

  //계산 결과를 보여주는 상태, 화면을 보여줄지 말지
const[showResult, setShowResult] = useState(false);


//버튼을 클릭했을때 계산결과 보여주는 이벤트
const  handleCalc = () => {
  setShowResult(true);
};


return(
  <div>
      <h2> 사칙연산 </h2>
      <button onClick={handleCalc}>계산하기</button>
      
      {showResult && (<div>
      <p>{num1} +{num2} = {num1+num2}</p>
      <p>{num1} -{num2} = {num1-num2}</p>
      <p>{num1} *{num2} = {num1*num2}</p>
      <p>{num1} /{num2} = {num2!==0? (num1/num2): "0으로 나눌수 없어!"}</p>
      </div>)
      }
      </div>

    );

  }

//내보내기

export default Welcome;
export {MyCalc};
  
