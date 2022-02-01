package com.example.superheroes.retrofit.model

class IdResponse(
    response: String, id: String, name: String,
    var powerStats: PowerStats,
    var biography: Biography,
    var appearance: Appearance,
    var work: Work,
    var connections: Connections,
    var image: Image) : Response(response, id, name) {
}