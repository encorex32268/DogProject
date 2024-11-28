package com.lihan.dogproject.home_list.data.mapper

import com.lihan.dogproject.home_list.data.model.BreedDto
import com.lihan.dogproject.home_list.data.model.DetailDto
import com.lihan.dogproject.home_list.data.model.DogDto
import com.lihan.dogproject.home_list.domain.model.Breed
import com.lihan.dogproject.home_list.domain.model.Detail
import com.lihan.dogproject.home_list.domain.model.Dog

fun DetailDto.toDetail(): Detail{
    return Detail(
        imperial = imperial,
        metric = metric
    )
}

fun BreedDto.toBreed(): Breed {
    return Breed(
        weight = weight.toDetail(),
        height = height.toDetail(),
        id = id,
        name =name,
        bredFor = bred_for?:"",
        breedGroup = breed_group,
        lifeSpan = life_span,
        temperament = temperament,
        referenceImageId = reference_image_id
    )
}

fun DogDto.toDog(): Dog {
    return Dog(
        breeds = breeds.map { it.toBreed()},
        id = id,
        imageUrl = url
    )
}