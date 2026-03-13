const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'example.txt');
const savePath = path.join(__dirname, 'text-1.txt');

const data = fs.readFileSync(filePath, 'utf-8');

// file 존재 시
if (fs.existsSync(savePath)) {
  console.log('파일이 존재합니다.');
} else {
  // file 없으면 생성
  fs.writeFileSync(savePath, data);
}
