package com.leonelg.dogedex.dog.framework

import com.leonelg.dogedex.dog.framework.responses.DogListApiResponse
import retrofit2.http.GET

interface DogApiService {

    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse
}