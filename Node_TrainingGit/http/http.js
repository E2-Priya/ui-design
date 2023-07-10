const http = require('http')

const server = http.createServer((req,res) =>{
    if(req.url === ('/')){
        res.end("Welcome to home page")
    }
    if(req.url === ('/dashboard')){
        res.write('welcome to dashboard')
        res.end()
    }
})
server.listen(8000)
