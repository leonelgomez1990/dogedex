package com.leonelg.dogedex.dog.data

import com.leonelg.dogedex.dog.domain.Dog

interface IDogDataSource {
    suspend fun getAllDogs(): List<Dog>
}