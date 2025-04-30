import React from "react";
import { useState } from "react";
// import Hello from "./react01_Hello";
// import MyAddress from "./myaddress";
import Hello, { Bye, Connect } from "./React_Basic/react01_Hello";
import Welcome, {MyCalc} from "./React_Basic/react02_Props";

import NameInput, {DateInput} from "./React_Basic/react04_InputBinding";
import LoginStatus from "./React_Basic/react05_ConditionalRender";
import Counter from "./React_Basic/react03_UseState";
import SkillList from "./React_Basic/react06_ListRender";
import Clock from "./React_Basic/react07_UseEffect";
import {MyTime, MyUser} from "./React_Basic/react08_FetchData";
import {ServerFormSubmit} from "./React_Basic/react09_FormSubmit";
function App()
{

  const [CurrentComponent, setCurrentComponent] = React.useState("React01");
  const listComponent = () =>
  {
switch(CurrentComponent)
{
    case "React01": return <React01 />;  
    case "React02": return <React02 />;  
    case "React03": return <React03 />;  
    case "React04": return <React04 />;  
    case "React05": return <React05 />;  
    case "React06": return <React06 />;  
    case "React07": return <React07 />; 
    case "React08": return <React08 />;   
    case "React08": return <React08 />;   
    case "React09": return <React09 />;

}


  }
  return (
    <>
    <div>
     <button onClick={() => setCurrentComponent("React01")}>React01</button>
     <button onClick={() => setCurrentComponent("React02")}>React02</button>
     <button onClick={() => setCurrentComponent("React03")}>React03</button>
     <button onClick={() => setCurrentComponent("React04")}>React04</button>
     <button onClick={() => setCurrentComponent("React05")}>React05</button>
     <button onClick={() => setCurrentComponent("React06")}>React06</button>
     <button onClick={() => setCurrentComponent("React07")}>React07</button>
     <button onClick={() => setCurrentComponent("React08")}>React08</button>
     <button onClick={() => setCurrentComponent("React09")}>React09</button>

     </div>

     <div>
      {listComponent()} 
     </div>
    </>
  );

}

function React09()
{
  return(
    // <FormSubmit />
  <ServerFormSubmit />
  )
}

function React08()
{
  return (
    <>
    <MyUser />
    <MyTime />
    </>
  )
}

function React07()
{
  return (
    <>
    <Clock />
    </>
  )
}


function React06()
{
  return (
    <>
    <SkillList />
    </>
  );
}


function React05()
{

  const [isLoggedIn, setIsLoggedIn] = useState(false);

const handleLogin = () => {
   setIsLoggedIn(true)
  };

  const handleLogout = () => {
    setIsLoggedIn(false)
  };



  return (
    <div>
      <LoginStatus isLoggedIn={isLoggedIn}/>
      {isLoggedIn ? (<button onClick={handleLogout}> 로그아웃</button>) : (<button onClick={handleLogin}> 로그인</button>)}
    </div>
  )
}

function React03()
{
  return <Counter />
}


function React04()
{
  return (
    <div>

      <NameInput />
      <DateInput />
    </div>
  )
}

function React02()
{
  return (<>
  <Welcome name = "홍길동"/>
  
  <MyCalc num1 = {10} num2 = {20}/>
  
  
  
  
  </>)
}





function React01(){
  return ( 
  <>
<Hello/>
<Bye/>
<Connect />
</>
  );
  // <div>
  //   {/*주석이야 */ }
  //   <h1> Hello React! 처음 만드는 웹페이지 !!!</h1>
  //   <Hello name="치호" nic_name = "rktclgh" />
  //   <MyAddress  name = "송치호" addr = "좆시골" phone = "010-5008-1701" />
  // </div>)
}

export default App;