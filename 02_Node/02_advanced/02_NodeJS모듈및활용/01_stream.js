const fs = require('fs');
const path = require('path');
const filePath = path.join(__dirname, 'readMe.txt');

// stream
// : 데이터를 작은 단위로 나누어 처리하는 방식
// readable -> 읽는 스트림 (단방향)
// writeable -> 쓰는 스트림 (단방향)
// duplex -> 읽고 씀 (양방향)

/*
stream 이벤트 (on method 필요)
 - data: 데이터를 읽을 때 동작
 - end: 데이터를 다 읽었을 때
 - error: 에러가 발생했을 때
 */

const rs = fs.createReadStream(filePath, 'utf-8');
rs.on('data', (chunk) => {
  console.log('새로운 청크 도착');
  console.log('청크 길이: ', chunk.length);
  console.log('청크 내용: ', chunk);
})
  .on('end', () => {
    console.log('data 읽기가 완료되었습니다.');
  })
  .on('error', (err) => {
    console.log(`error가 발생했습니다 ${err}`);
  });
