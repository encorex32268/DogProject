package com.lihan.dogproject.home_list.data.network

import com.lihan.dogproject.core.domain.util.DataError
import com.lihan.dogproject.core.domain.util.Result
import com.lihan.dogproject.home_list.data.model.DogDto
import com.lihan.dogproject.home_list.data.model.DogResponse

interface RemoteDogDataSource {
    suspend fun getDogs(): Result<List<DogDto>, DataError.Remote>
}