import { useEffect, useState } from "react";
export default function UserList() {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(data => setUsers(data.slice(0, 5)));
  }, []);
  return (
    <ul>
      {users.map(user => <li key={user.id}>{user.name}</li>)}
    </ul>
  );
}



export function TodosOne() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/todos/1")
      .then(res => res.json())
      .then(data => setUser(data));
  }, []);

  // user가 아직 null이면 로딩 문구 표시
  if (!user) return <div>Loading...</div>;

  return (
    <div>
      {user.userId}, {user.id}, {user.title}, {user.completed.toString()}
    </div>
  );
}


export function MyNode()
{
  const [message, setMessage] = useState('Loading...'); 
  useEffect(() => {
    fetch("http://localhost:7777/api/data")
      .then(response => response.json())
      .then(data => setMessage(data.message));
  }, []);


  return(
    <div className = "App"> 
    <header className = "App-header">
      <p>{message}</p>
    </header>
    </div>

  );
}


export function MyText() {
  const [message, setMessage] = useState('Loading...');

  useEffect(() => {
    fetch('http://localhost:7777/api/text',
      {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text: "hello server!!!" })
      }
    )
    .then(response => response.json())
    .then(data => setMessage(data.msg))
  }, []);

  return (
    <div>
      <h2>{message}</h2>
    </div>
  );
}


export function MyUser() {
  const [message, setMessage] = useState('Loading...');

  useEffect(() => {
    fetch('http://localhost:7777/api/user', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        username: '야옹이',
        email: 'a@a.com',
        addr  : '서울시 ...'
      })
    })
      .then(response => response.json())
      .then(data => setMessage(  `${data.user.username}, ${data.user.email}, ${data.user.addr}`))
      .catch(err => {
        console.error(err);
        setMessage('요청실패');
      });
  }, []);

  return (
    <div>
      <h2>{message}</h2>
    </div>
  );

  
}

export function MyTime() {
  const [message, setMessage] = useState('Loading...');

  useEffect(() => {
    fetch('http://localhost:7777/api/time', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' }
    })
      .then(response => response.json())
      .then(data => setMessage(`서버로 받은 시간 : ${data.serverTime}`))
      .catch(err => {
        console.error(err);
        setMessage('요청실패');
      });
  }, []);

  return (
    <div>
      <h2>{message}</h2>
    </div>
  );
}







