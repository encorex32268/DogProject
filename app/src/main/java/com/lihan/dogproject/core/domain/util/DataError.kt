package com.lihan.dogproject.core.domain.util

sealed interface DataError: Error {

    enum class Remote: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN,
        NO_AUTH
    }

    enum class Local: DataError {
        DISK_FULL,
        UNKNOWN
    }
}