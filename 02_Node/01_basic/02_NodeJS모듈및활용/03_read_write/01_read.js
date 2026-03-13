const fs = require('fs');

// 현재 디렉토리(03_read_write) file 주소
const path = require('path');
const filePath = path.join(__dirname, 'example.txt');

const data = fs.readFileSync(filePath);

console.log(data);
