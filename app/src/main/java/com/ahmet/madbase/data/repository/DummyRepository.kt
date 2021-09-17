package com.ahmet.madbase.data.repository

import com.ahmet.madbase.app.base.BaseRepository
import com.ahmet.madbase.data.remote.DummyRemoteDataSource
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val dummyRemoteDataSource: DummyRemoteDataSource
) : BaseRepository() {

    fun getPokemonList(
        limit: Int,
        offset: Int
    )= responseFlowWrapper {
            dummyRemoteDataSource
                .getPokemonList(
                    limit = limit, offset = offset
                )
    }
}