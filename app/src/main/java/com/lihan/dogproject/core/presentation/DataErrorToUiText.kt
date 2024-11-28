package com.lihan.dogproject.core.presentation

import com.lihan.dogproject.R
import com.lihan.dogproject.core.domain.util.DataError


fun DataError.toUiText(): UiText {
    val stringRes = when(this){
        DataError.Local.DISK_FULL          -> R.string.error_disk_full
        DataError.Local.UNKNOWN            -> R.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT   -> R.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> R.string.error_too_many_request
        DataError.Remote.NO_INTERNET       -> R.string.error_no_internet
        DataError.Remote.SERVER_ERROR      -> R.string.error_server_error
        DataError.Remote.SERIALIZATION     -> R.string.error_serialization_error
        DataError.Remote.UNKNOWN           -> R.string.error_unknown
        DataError.Remote.NO_AUTH           -> R.string.error_no_auth
    }
    return UiText.StringResourceId(stringRes)
}