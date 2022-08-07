package com.leonelg.dogedex.dog.usecases

import com.leonelg.dogedex.dog.domain.Dog
import com.leonelg.dogedex.dog.interfaces.IDogRepository
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(
    private val dogRepository: IDogRepository
) {
    suspend operator fun invoke(): List<Dog> =
        dogRepository.getDogCollection()
}