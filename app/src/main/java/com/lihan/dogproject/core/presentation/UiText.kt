package com.lihan.dogproject.core.presentation

import android.content.Context
import androidx.compose.runtime.Composable

sealed interface UiText {

    data class DynamicString(val value: String): UiText
    class StringResourceId(
        val id: Int,
        val args: Array<Any> = arrayOf()
    ): UiText

    @Composable
    fun asString(context: Context): String {
        return when(this){
            is DynamicString -> value
            is StringResourceId -> context.getString(
                id , args
            )
        }
    }

}