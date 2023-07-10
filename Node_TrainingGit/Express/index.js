var express = require('express');
var app = express();

var things = require('./router.js');

//both index.js and things.js should be in same directory
app.use('/things', things);

app.listen(3000);
