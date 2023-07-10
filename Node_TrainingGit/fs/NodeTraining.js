const fs = require("fs")

const first = fs.readFileSync("./ContentText/first.txt","utf8")

const second = fs.readFileSync("./ContentText/second.txt","utf8")

fs.writeFileSync("./ContentText/writing.txt" , `Here is the result ${first}, ${second}` , { flag : 'a'})
