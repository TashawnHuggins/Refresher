//this sets up server
const { localsName } = require("ejs");
const express = require("express");
const app = express()

//Static files
app.use(express.static("public"))
//app.use(express.urlencoded({extended: false}))
app.use(express.json())
app.use('/css', express.static(__dirname + 'public/css'))
app.use('/js', express.static(__dirname + 'public/js'))
app.use('/img', express.static(__dirname + 'public/img'))

//set views
app.set('views', './views')
app.set('view engine', 'ejs') 

const adoptRouter = require('./routes/adopt') //this imports the router from adopt(routes)

//Below two lines allows to not repeat path names
app.use('/api/v1/adopt', adoptRouter) //this links up routes to main app(server)..all routes are defined here
app.use('/api/v1/adopt/:catName', adoptRouter)


app.get('/', (req,res) => {
    res.render('homePage', { text: 'Home Page'})
})

app.post('/:catName', (req,res) => {
    res.render('new', { text: 'Add a cat profile'})
})


app.get('/:catName', (req,res) => {
    let catName = req.params
    res.render('search', { text: catName})
})




app.listen(3000) //this helps our app to run