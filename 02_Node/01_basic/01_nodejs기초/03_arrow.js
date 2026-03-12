// 화살표 함수
// let function = (매개변수) => {} 
// 함수 한 줄 -> 중괄호 생략가능

let getTriangle = (base, height) => (base * height) / 2;

console.log('삼각형의 면적: ' + getTriangle(5, 2));

const person = {
  name: 'khj',

  // 일반함수
  // this -> 상위 객체 person
  hello1: function () {
    console.log('일반함수: ', this);
  },

  // 화살표함수
  // this -> 빈 객체 {}
  hello2: () => {
    console.log('화살표함수: ', this);
  },
};

person.hello1();
person.hello2();
