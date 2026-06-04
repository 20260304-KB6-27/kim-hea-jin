// 1.
// use tutorial

db.users.insertOne({username: "smith"});

db.users.insertOne({username: "jones"});

db.users.find();

db.users.findOne();

// 2.
db.users.find({username: "jones"});

db.users.find({ $or: [
        {username: "smith"},
        {username: "jones"}
    ]});

// 3.
db.users.updateOne({username: "smith"}, {$set: {country: "Canada"}});

db.users.find({username: "smith"});

// 4.
db.users.replaceOne(
    {username: 'smith'},
    {country: 'Canada'}
);
db.users.find();

db.users.replaceOne(
    {country: 'Canada'},
    {username: 'smith', country: 'Canada'}
);
db.users.find();

// 5.
db.users.updateOne(
    {username: 'smith'},
    {$unset: {country: ''}}
);
db.users.find();

// 6.
// show dbs

// show collections

db.stats();

db.users.stats();

// 7.
db.users.deleteOne({username: 'smith'});
db.users.find();

db.users.deleteMany({});
db.users.find();

db.users.drop();