var express = require('express')
var app = express()
app.use(express.json())
const user = require('./routers/user_routes')
const role= require('./routers/role_routes')

app.use('/user', user)
app.use('/role', role)

app.listen(3000)
