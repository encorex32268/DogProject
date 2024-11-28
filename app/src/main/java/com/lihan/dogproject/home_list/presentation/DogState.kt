package com.lihan.dogproject.home_list.presentation

import com.lihan.dogproject.core.presentation.UiText
import com.lihan.dogproject.home_list.domain.model.Dog

data class DogState(
    val items: List<Dog> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: UiText?=null
)
