package com.lihan.dogproject.core.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.Properties

object HttpClientFactory {
    fun build(): HttpClient {
        return HttpClient(OkHttp.create()){
            install(ContentNegotiation){
                json(
                    json = Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Logging){
                logger = object: Logger {
                    override fun log(message: String) {
                        Log.d("Ktor", "log: ${message}")
                    }

                }
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                val key = "live_AZuHUn5WyHtd3kRdlsVy1PRCx9GM0DqozcGaGNVGC7ojSgjeTvqHf94aV6u4ZZDw"
                header("x-api-key" , key)
            }
        }
    }
}