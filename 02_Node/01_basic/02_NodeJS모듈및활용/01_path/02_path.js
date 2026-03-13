// const path = require('path')
import path from 'path'; // esm 방식

// __filename -> 사용불가
/* 
path module
 - 파일 경로나 디렉토리 경로를 다루는 오듈
 - 운영체제 간의 경로를 구분하는 구분자가 다르나 통일가능
*/
import { fileURLToPath } from 'url';
const dir = fileURLToPath(import.meta.url);
console.log(dir);
