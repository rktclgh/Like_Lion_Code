import { useState } from "react";
export default function FormSubmit() {
  const [name, setName] = useState("");
  const handleSubmit = e => {
    e.preventDefault();
    alert("제출된 이름: " + name);
  };
  return (
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={e => setName(e.target.value)} />
      <button type="submit">제출</button>
    </form>
  );
}


export function ServerFormSubmit() {
  const [name, setName] = useState("");
  const [responseMsg, setResponseMsg] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch("http://localhost:7777/api/name", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ text: name }) 
      });
      const data = await res.json();
      setResponseMsg(data.msg);
    } catch (err) {
      console.error(err);
      setResponseMsg("요청 실패");
    }
    setName("");
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input value={name} onChange={(e) => setName(e.target.value)} />
        <button type="submit">제출</button>
      </form>
      <p>{responseMsg}</p>
    </div>
  );
}