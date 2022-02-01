package com.example.superheroes.retrofit.model

class PowerStats(
    response: String, id: String, name: String,
    var intelligence: String,
    var strength: String,
    var speed: String,
    var durability: String,
    var Power: String,
    var combat: String
) : Response(response, id, name) {

}