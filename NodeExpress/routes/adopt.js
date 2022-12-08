//This is the setup for an express server
// npm i --save-dev nodemon   (this is used to automatically save changes
//npm run devStart  (this runs all code in this page, adopt.js, and it automatically reruns server)
//cls clears the terminal


const { application } = require("express");
const express = require("express")
const router = express.Router()

// //middleware
router.use(express.json()); //allows data to be present in the console
router.use(express.urlencoded({extended: false}))

module.exports = router //exports router to be used elsewhere (imported in server)


const {
    getAllAdoptableCats,
    createCatProfile,
    getSpecificCat,
    updateSpecificCat,
    deleteSpecificCat,
} = require('../controllers/adopt');

router.route('/').get(getAllAdoptableCats).post(createCatProfile);

router.route('/:catName').get(getSpecificCat).patch(updateSpecificCat).delete(deleteSpecificCat);







