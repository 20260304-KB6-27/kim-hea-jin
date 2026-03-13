// fs module 가져오기
const fs = require('fs');

// 동기방식
// ./ 현재위치 기준의 working directory(작업 디렉토리)
// let files = fs.readdirSync('./');
// console.log(files);

// 비동기(콜백)방식
// let files = fs.readdir('./', (err, files) => {
//   if (err) {
//     console.error(err);
//     return;
//   }
//   console.log(files);
// });

// Promise 방식
fs.promises
  .readdir('./')
  .then((files) => {
    console.log(files);
  })
  .catch((err) => {
    console.error(err);
  });
