package com.leonelg.dogedex.dog.framework.responses

import com.leonelg.dogedex.dog.domain.Dog
import com.squareup.moshi.Json

class DogResponse(
    //Clase DTO: Data transfer object
    val id: Long,
    val index: Int,
    @field:Json(name = "name_es")
    val name: String,
    @field:Json(name = "dog_type")
    val type: String,
    @field:Json(name = "height_female")
    val heightFemale: String,
    @field:Json(name = "height_male")
    val heightMale: String,
    @field:Json(name = "image_url")
    val imageUrl: String,
    @field:Json(name = "life_expectancy")
    val lifeExpectancy: String,
    @field:Json(name = "temperament")
    val temperament: String,
    @field:Json(name = "weight_female")
    val weightFemale: String,
    @field:Json(name = "weight_male")
    val weightMale: String
)

fun DogResponse.toDomain(): Dog = Dog(
    id, index, name, type, heightFemale, heightMale,
    imageUrl, lifeExpectancy, temperament, weightFemale, weightMale
)
