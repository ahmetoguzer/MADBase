package com.ahmet.madbase.data.service

import com.ahmet.madbase.data.responses.PokemonList
import com.ahmet.madbase.data.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Resource<PokemonList>

}