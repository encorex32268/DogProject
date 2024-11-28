package com.lihan.dogproject.home_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.dogproject.core.domain.util.onError
import com.lihan.dogproject.core.domain.util.onSuccess
import com.lihan.dogproject.core.presentation.toUiText
import com.lihan.dogproject.home_list.domain.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DogViewModel(
    private val dogRepository: DogRepository
): ViewModel() {

    private val _state = MutableStateFlow(DogState())
    val state =
        _state
            .onStart {
                getDogs()
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000L),
                _state.value
            )


    private fun getDogs() {
        viewModelScope.launch {
            dogRepository.getDogs()
                .onSuccess { items ->
                   _state.update {
                       it.copy(
                           items = items,
                           isLoading = false
                       )
                   }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            errorMessage = error.toUiText(),
                            isLoading = false
                        )
                    }
                }
        }
    }
}