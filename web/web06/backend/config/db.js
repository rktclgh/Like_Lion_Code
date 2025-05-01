
const mysql = require('mysql2');

const pool = mysql.createPool({
  host: 'localhost',
  user: 'root',
  password: 'password', // 실제 비밀번호로 변경
  database: 'travel_db'
});

module.exports = pool.promise();
