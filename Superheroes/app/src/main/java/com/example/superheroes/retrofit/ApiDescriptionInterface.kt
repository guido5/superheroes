package com.example.superheroes.retrofit

import com.example.superheroes.retrofit.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDescriptionInterface {

    @GET("{id}")
    fun getId(@Path("id") id:Int) : Call<IdResponse>

    @GET("{id}/powerstats")
    fun getPowerstats(@Path("id") id:Int) : Call<PowerStats>

    @GET("{id}/biography")
    fun getBibliography(@Path("id") id:Int) : Call<Biography>

    @GET("{id}/appearance")
    fun getAppearance(@Path("id") id:Int) : Call<Appearance>

    @GET("{id}/work")
    fun getWork(@Path("id") id:Int) : Call<Work>

    @GET("{id}/connections")
    fun getConnections(@Path("id") id:Int) : Call<Connections>

    @GET("{id}/image")
    fun getImage(@Path("id") id:Int) : Call<Image>

}