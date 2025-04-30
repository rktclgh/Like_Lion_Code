import { useState } from "react";
export default function NameInput() {
  const [name, setName] = useState("");
  return (
    <div>
      <input value={name} onChange={e => setName(e.target.value)} />
      <p>입력한 이름: {name}</p>
    </div>
  );
}

//오늘 날짜로 초기화
const getToday = () => {
  const today  = new Date();
  const year = today.getFullYear();
  const month = today.getMonth()+1;
  const day = today.getDate();

  return `${year}-${month}-${day}`;

}


export function DateInput(){
const [mydate, setMyDate] = useState(getToday());
  return (
    <div style ={{marginTop: "20px"}}>
      <h2>날짜 선택</h2>
      <input type="date" value = {mydate} 
      onChange={e => setMyDate(e.target.value)}/>

      <p>입력한 날짜: {mydate}</p>
    </div>
  )

}

