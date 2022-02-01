package com.example.superheroes.retrofit.model

class Image(
    response: String, id: String, name: String,
    var url: String
) : Response(response, id, name) {

}
