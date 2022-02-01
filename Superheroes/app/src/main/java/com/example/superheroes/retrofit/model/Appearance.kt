package com.example.superheroes.retrofit.model

class Appearance(response: String, id: String, name: String,
    var gender: String,
    var race: String,
    var height: List<String>,
    var weight: List<String>,
    var eyeColor: String,
    var hairColor: String) : Response(response, id, name) {


}
