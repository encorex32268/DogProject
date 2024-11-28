package com.lihan.dogproject.home_list.domain

import com.lihan.dogproject.core.domain.util.DataError
import com.lihan.dogproject.core.domain.util.Result
import com.lihan.dogproject.home_list.domain.model.Dog

interface DogRepository {
    suspend fun getDogs(): Result<List<Dog>,DataError.Remote>
}