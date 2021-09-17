package com.ahmet.madbase.data.remote

import com.ahmet.madbase.data.util.Resource
import com.ahmet.madbase.data.responses.PokemonList
import com.ahmet.madbase.data.service.DummyService
import javax.inject.Inject

class DummyRemoteDataSource @Inject constructor(
    private val dummyService: DummyService
) {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList> = dummyService.getPokemonList(limit = limit, offset = offset)
}