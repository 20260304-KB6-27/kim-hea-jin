// .sort(): 정렬
// 객체{} 안에 정렬 기준 필드(컬럼) 작성 (1: 오름차순. -1: 내림차순)
db.members.find().sort({age: -1})

// office 기준 오름차순 정렬 -> 동일 값은 나이 내림차순 정렬
db.members.find().sort({office: 1, age: -1})

// .limit(n): 문서(행) n개 출력
db.members.find().sort({office: 1, age: -1}).limit(5)

/*
조건연산자
$or: 여러 조건 중 하나라도 만족하는 문서 조회
$and: 모든 조건을 만족하는 문서 조회
$in: 특정 필드의 값(들)을 하나라도 만족하는 문서 조회
 */

// office: seoul이거나 age: 1인 문서 출력
db.members.find({
    $or: [
        {office: 'seoul'},
        {age: 1}
    ]
})

// office: busan이고 age: 1인 문서 출력
db.members.find({
    $and: [
        {office: 'busan'},
        {age: 1}
    ]
})

// office가 busan 또는 seoul인 문서 출력
db.members.find({
    office: {$in: ['busan', 'seoul']}
})

/*
비교 연산

$gt (greater than, 초과)
$lt (less than, 미만)
$gte (greater than or equal, 이상)
$lte (less than ot equal, 이하)
 */

// age가 50 초과인 문서 출력
db.members.find({
    age: {$gt: 50}
})

// age: 20이상 30이하
db.members.find({
    age: {$gte: 20, $lte: 30}
})

/*
$ne: not equal (같지 않음)
 */

// office: busan 제외 모든 문서 출력
db.members.find({
    office: {$ne: 'busan'}
})

/*
$exists: 해당 필드(컬럼)가 존재하는 문서만 조회
- true: 필드가 있으면 조회
- false: 필드가 없으면 조회
 */

db.members.updateMany(
    {age: {$gte: 1, $lte: 10}},  // 조건: age 1~10
    {$unset: {phone: ''}}  // 수정: phone 필드 삭제
)

// phone 필드값 있는 문서만 조회
db.members.find({
    phone: {$exists: true}
})

// 출력 동일
db.members.find({
    // $not: 부정 연산자
    phone: {$not: {$exists: false}}
})

/*
$regex
- 정규표현식을 이용한 검색
 */
db.members.find({
    // name이 G로 시작하는 문서 조회
    name: {$regex: /^G/}
})