/*
insertOne
insertMany: 처리시간 짧음
 */

for (let i=0; i < 20000; i++) {
    db.numbers.insertOne({
        num: i
    })
}

const docs = []
for (let i=0; i < 20000; i++) {
    docs.push({
        num: i
    })
}
db.numbers_2.insertMany(docs)

// 컬렉션(테이블)의 문서(행) 개수 조회
db.numbers.countDocuments()
db.numbers_2.countDocuments()