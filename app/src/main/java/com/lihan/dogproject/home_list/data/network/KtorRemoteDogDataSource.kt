package com.lihan.dogproject.home_list.data.network

import com.lihan.dogproject.core.data.safeCall
import com.lihan.dogproject.core.domain.util.DataError
import com.lihan.dogproject.core.domain.util.Result
import com.lihan.dogproject.home_list.data.model.DogDto
import com.lihan.dogproject.home_list.data.model.DogResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.parametersOf

private const val BASE_URL = "https://api.thedogapi.com/v1/images/search"

class KtorRemoteDogDataSource(
    private val httpClient: HttpClient
): RemoteDogDataSource {
    override suspend fun getDogs(): Result<List<DogDto>, DataError.Remote> {
        return safeCall<List<DogDto>>{
            httpClient.get(
                urlString = BASE_URL
            ){
                parameter("limit" , 30)
            }
        }
    }
}