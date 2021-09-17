package com.ahmet.madbase.app.base

import com.ahmet.madbase.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

open class BaseRepository {
    protected fun <T> responseFlowWrapper(remoteCall: suspend () -> Resource<T>): Flow<Resource<T>> =
        flow {
            emit(Resource.loading())
            emit(Resource.success(remoteCall.invoke().data as T))
        }.catch {
            emit(Resource.error(Throwable("An error occured.")))
        }
}