package com.leonelg.dogedex.dog.interfaces

import com.leonelg.dogedex.dog.domain.Dog

interface IDogRepository {
    suspend fun getDogCollection(): List<Dog>
}