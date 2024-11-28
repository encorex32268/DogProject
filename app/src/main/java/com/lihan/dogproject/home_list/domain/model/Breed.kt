package com.lihan.dogproject.home_list.domain.model


data class Breed(
    val weight: Detail,
    val height: Detail,
    val id: Int,
    val name: String,
    val bredFor: String,
    val breedGroup: String,
    val lifeSpan: String,
    val temperament: String,
    val referenceImageId: String
)
