package com.lihan.dogproject.home_list.data

import com.lihan.dogproject.core.domain.util.DataError
import com.lihan.dogproject.core.domain.util.Result
import com.lihan.dogproject.core.domain.util.map
import com.lihan.dogproject.home_list.data.mapper.toDog
import com.lihan.dogproject.home_list.data.network.RemoteDogDataSource
import com.lihan.dogproject.home_list.domain.DogRepository
import com.lihan.dogproject.home_list.domain.model.Dog

class DogRepositoryImpl(
    private val remoteDogDataSource: RemoteDogDataSource
): DogRepository {
    override suspend fun getDogs(): Result<List<Dog>, DataError.Remote> {
        return remoteDogDataSource
            .getDogs()
            .map {
                it.map {
                    it.toDog()
                }
            }
    }
}
