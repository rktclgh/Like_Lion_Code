const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();//express.js 
const port = 7777; // 원하는 포트 번호

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

//1.  미들웨어 등록 
app.use(cors());
app.use(bodyParser.json());

// 간단한 데이터 (나중에 데이터베이스 연동 등을 할 수 있습니다.)
const data = { message: 'Hello from Node.js server!' };

//2.  라우팅 설정   = http 메소드  + 경로  
// GET 요청 처리 (예시)
app.get('/api/data', (req, res) => {
  res.json(data);
});

// POST 요청 처리 (예시)
app.post('/api/data', (req, res) => {
  console.log('Received data:', req.body);
  res.json({ received: req.body });
});

// POST 요청 처리 (예시2  _  텍스트 전송  )
app.post('/api/text', (req, res) => {
  const { text } = req.body;
  console.log('Received received:', text);
  res.json({ msg: `서버가 받은 텍스트: ${text}` });
});


// POST 요청 처리 (예시3  _ 유저정보 )이름 , email,  주소  
app.post('/api/user', (req, res) => {
  const { username, email, addr } = req.body;   
  console.log(`Received Text :, ${ username} ${email}  ${addr}`);
  res.json({ status : 'success' , user : req.body });
});


// POST 요청 처리 (예시4 _ 서버시간 리턴)
app.post('/api/time', (req, res) => {
  const now = new Date();
  res.json({ serverTime: now.toISOString() });
});




app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})




//3. 서버시작  
app.listen(port, () => {
  console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`);
});

//4. 템플릿 엔진 설정  app.set()  



//5. Error 핸들러 정의
//선언
function errorHandle(err, req, res, next) {
  // log it
  console.error(err.stack);

  // respond with 500 "Internal Server Error".
  res.status(500).send("Internal Server Error");
}


//라우터
app.get('/', function () {
  // Caught and passed down to the errorHandler middleware
  throw new Error('something broke!');
});

//등록
app.use(errorHandle);

//app.locals 앱 전체 영역, res.locals 요청과 응답 사이클에 한정
//템플릿 변수, 전역설정, 앱 공통 데이터 등의 속성



