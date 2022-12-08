//pets is an array of pet objects
let pets = 
[
    {catName:"Panther",sex:"male",breed:"tabby",color:"black",age:3,description: "Panther is a shy boy who will need lots of patience to break him out of his shell."},
    {catName:"Mittens",sex:"female",breed:"tabby",color:"orange",age:1,description: "Mittens is a very outgoing and friendly girl. She will fit in with kids of any age."},
    {catName:"Jax",sex:"male",breed :"tabby",color:"orange and white",age:4,description: "Jax is a talkative boy who loves to play with laser pointers."},
    {catName:"Sally",sex:"female",breed :"tabby",color:"white and black",age:2,description: "Sally is a shy but vocal girl."},
    {catName:"Jalapeno",sex:"male",breed:"Main Coon",color:"gray",age:16,description:"Jalapeno is a senior cat that loves to relax and likes quiet environments. For this reason, a home with young kids will not be ideal."}
    //{catName:"",sex:"",breed:"",color:"",age:,description:""},
]


// -get/view all adoptable cats 
const getAllAdoptableCats = (req,res) =>
{
    res.send(pets)
}

// -submit a new cat profile 
const createCatProfile = (req,res) =>
{
    let newPet = req.body;
    pets.push(newPet);
    console.log(newPet);
    res.send(req.body);   
}

// -get/view details about a specific cat
const getSpecificCat = (req,res) =>
{
    const {catName} = req.params;
    const pet = pets.find((pet) => pet.catName === catName);
    if(pet) res.send(pet);
    else res.send('Not Found');  
}

// -update a cat profile
const updateSpecificCat = (req,res) =>
{
    const {catName} = req.params;
    const pet = pets.find((pet) => pet.catName === catName);
    if(pet) req.json(pet);
    else res.send('Not Found');
}

// -delete a cat profile
const deleteSpecificCat = (req,res) =>
{
    const {catName} = req.params;
    const pet = pets.find((pet) => pet.catName === catName);
    if(pet) 
        {
            pets = pets.filter(pet => pet.catName != catName);
            res.send("cat profile successfully deleted.")        
        }
    else res.send('Not Found');
}


//module.exports allows node to use a certain function
module.exports = 
{
    getAllAdoptableCats, 
    createCatProfile, 
    getSpecificCat, 
    updateSpecificCat, 
    deleteSpecificCat
}