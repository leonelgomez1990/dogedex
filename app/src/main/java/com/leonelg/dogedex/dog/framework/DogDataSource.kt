package com.leonelg.dogedex.dog.framework

import android.util.Log
import com.leonelg.dogedex.dog.data.IDogDataSource
import com.leonelg.dogedex.dog.domain.Dog
import com.leonelg.dogedex.dog.framework.responses.toDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class DogDataSource @Inject constructor(
    private val dogApiService: DogApiService,
    private val dispatcher: CoroutineDispatcher
) : IDogDataSource {

    override suspend fun getAllDogs(): List<Dog> {
        return withContext(dispatcher) {
            try {
                val dogListApiResponse = dogApiService.getAllDogs()
                val response = dogListApiResponse.data.dogs
                response.map { it.toDomain() }
            }
            catch (e: Exception) {
                Log.e("server", e.message.toString())
                emptyList()
            }
        }
    }

}