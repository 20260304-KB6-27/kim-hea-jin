// 1.
// use test

const docs = [];

for(let i = 0; i < 20000; i++) {
    docs.push({
        num: i,
        name: '스마트폰' + i
    })
}

db.product.insertMany(docs);

db.product.countDocuments();

// 2.
db.product.find().sort({num: -1});

db.product.find().sort({num: -1}).limit(10);

db.product.find().sort({num: -1}).skip(50).limit(10);

// 3.
db.product.find({ $or: [
        {num: {$lt: 15}},
        {num: {$gt: 19995}}
    ]});

db.product.find({
    name: {$in: ['스마트폰10', '스마트폰100', '스마트폰1000']}
});

// 4.
db.product.find(
    {num: {$lt: 5}},
    {name: 1, _id: 0}
)