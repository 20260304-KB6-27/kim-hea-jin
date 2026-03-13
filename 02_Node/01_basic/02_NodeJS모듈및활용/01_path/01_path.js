const path = require('path');

/* 
path module
 - 파일 경로나 디렉토리 경로를 다루는 오듈
 - 운영체제 간의 경로를 구분하는 구분자가 다르나 통일가능
*/

// const fullPath = path.join('some', 'work', 'ex.text');
// console.log(fullPath);

console.log(`파일 절대 경로: ${__filename}`);
/*
 - 절대경로: 루트 디렉토리 부터 시작하는 경로
 - 상대경로: 현재 작업 디렉토리 기준 경로
*/
const dir = path.dirname(__filename);
console.log(`폴더까지만: ${dir}`);

// 현재 작업 디렉토리
console.log(`working directory: ${process.cwd()}`);
