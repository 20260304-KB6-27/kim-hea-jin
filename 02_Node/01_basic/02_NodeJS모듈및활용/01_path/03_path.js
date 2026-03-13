const path = require('path');

// file 확장자
const ext = path.extname(__filename);
console.log('확장자: ', ext);

// file 정보 
const parsedPath = path.parse(__filename);
console.log("parsePath: ", parsedPath);