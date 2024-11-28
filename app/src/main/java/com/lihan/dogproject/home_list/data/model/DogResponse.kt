package com.lihan.dogproject.home_list.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class DogResponse(
    val dogs: List<DogDto>
)

@Serializable
data class DogDto(
    val breeds: List<BreedDto> = emptyList(),
    val id: String,
    val url: String
)

@Serializable
data class BreedDto(
    val weight: DetailDto,
    val height: DetailDto,
    val id: Int,
    val name: String,
    val bred_for: String? = "",
    val breed_group: String,
    val life_span: String,
    val temperament: String,
    val reference_image_id: String
)

@Serializable
data class DetailDto(
    val imperial: String,
    val metric: String
)
