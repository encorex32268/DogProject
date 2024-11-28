package com.lihan.dogproject.home_list.domain.model

data class Dog(
    val breeds: List<Breed>,
    val id: String,
    val imageUrl: String
)
