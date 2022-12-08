//***********************TO START ****************** */

// npm init -y  
//the above sets up a basic package json in package.json

//npm i express
//this downloads an express library

//port
// const http = require('http')
// const fs = require('fs') //file handling
// const port = 3000

// //server
// //Note: server needs to be restarted (ctrl + C) after any change
const server = http.createServer(function(req,res)
{
    //this will tell function to send html instead of just plain text "Hello Node"
    res.writeHead(200, {'Content-Type': 'text/html'}) 
    fs.readFile('AdoptPage.ejs', function(error, data)
    {
        if (error)
        {
            res.writeHead(404)
            res.write('Error: File Not Found')
        }
        else 
        {
            res.write(data)
        }   
        res.end()     
    })
})

server.listen(port, function(error)
{
    if(error)
    {
        console.log('Something went wrong', error)
    }
    else
    {
        console.log('Server is listening on port ' + port)
    }
})
const express = require('express');
const app = express();
const adopt = require('./routes/adopt');


//middleware
app.use(express.json());

// routes 
app.get('/hello', (req, res)=>{
    res.send('Adopt a Cat');
})

app.use('/api/v1/adopt', adopt);


//requests
app.get('/api/v1/adopt')  //-get/view all adoptable cats
app.post('/api/v1/adopt') //-submit a new cat profile
app.get('/api/v1/adopt/:catName') //-get/view details about a specific cat
app.patch('/api/v1/adopt/:catName')  //--update a cat profile
app.delete('/api/v1/adopt/:catName')  //-delete a cat profile



