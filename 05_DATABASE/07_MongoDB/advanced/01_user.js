/*
insertOne()
- 하나의 문서(행)을 컬렉션(테이블)에 추가
- 형식: db.컬렉션명.insertOne({키: 값, ...})

insertMany()
- 여러개의 문서(행)을 컬렉션(테이블)에 추가
- 형식: db.컬렉션명.insertMany([{키: 값, ...}, {키: 값, ...}, ...])
 */

db.users.insertOne({username: "smith"})
db.users.insertOne({username: "jones"})

db.users.find()

/*
updateOne() / updateMany()
- 조건에 맞는 첫번째/모든 문서 수정
- 형식: db.컬렉션명.updateOne({조건}, {$set: {수정내용}})
 */
db.users.updateOne({username: "smith"},
    {
        $set : {
            favorites: {
                cities: ['Chicago', 'Seoul'],
                movies: ['Casablanca', 'For a few Dollars More', 'The Sting']
            }
        }
    })

db.users.updateOne({username: "jones"},
    {
        $set : {
            favorites: {
                movies: ['Casablanca', 'rocky']
            }
        }
    })

/*
find() / findOne()
- 컬렉션(테이블)에서 모든/첫번째 문서 조회
- 형식: db.컬렉션명.find({조건}, {프로젝션})
 */
db.users.find()  // 모든 문서 조회

// 카사블랑카 영화를 좋아하는 사람들
db.users.find({"favorites.movies": "Casablanca"})

// 조건에 맞는 첫 번째 문서 출력
db.users.findOne({"favorites.movies": "Casablanca"})

// 원하는 필드(컬럼)만 조회
// 1: True(해당 필드값만 조회)
// 0: False(해당 필드 제외 모든 문서 조회)
db.users.findOne({"favorites.movies": "Casablanca"}, {username: 1})


db.users.updateMany({"favorites.movies": "Casablanca"},
    {
        // addToSet: 중복 방지용 문법, 있으면 무시 없으면 추가
        $addToSet: {"favorites.movies": "rocky"}
    })


/*
replaceOne()
- 조건에 맞는 문서를 새 문서로 교체
- 기존 문서의 필드(컬럼) 모두 삭제, 새 필드로 대체
 */
db.users.replaceOne({username: 'smith'},
    {
        country: 'Canada'
    })

db.users.updateOne({country: 'Canada'}, {
    $set: {username: 'smith'}
})

db.users.find()

db.users.updateOne({username: 'smith'}, {

    // unset: 해당 필드 제거
    $unset: {country: ''}
})

db.users.find()

/*
deleteOne() / deleteMany()
- 조건에 맞는 첫번째/모든 문서 삭제
 */
db.users.deleteOne({username: 'smith'})
db.users.find()

// 모든 문서 삭제
db.users.deleteMany({})
db.users.find()

/*
drop()
- 컬렉션(테이블) 삭제
 */
db.users.drop();