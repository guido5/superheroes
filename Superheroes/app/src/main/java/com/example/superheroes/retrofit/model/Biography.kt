package com.example.superheroes.retrofit.model

class Biography(response: String, id: String, name: String,
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String) : Response(response, id, name) {

}
