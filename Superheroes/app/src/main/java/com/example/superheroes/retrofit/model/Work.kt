package com.example.superheroes.retrofit.model

class Work(
    response: String, id: String, name: String,
    var occupation: String,
    var base: String) : Response(response, id, name) {

}
