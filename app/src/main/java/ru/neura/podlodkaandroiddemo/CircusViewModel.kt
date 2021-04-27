package ru.neura.podlodkaandroiddemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class CircusViewState(
    val title: String = "Silent Hill",
    val count: Int = 3,
    val ticketsCount: Int = 20
)

class CircusViewModel: ViewModel() {

    val viewState: MutableLiveData<CircusViewState> = MutableLiveData(CircusViewState())

    fun soldOut() {
        viewModelScope.launch {
            viewState.postValue(viewState.value?.copy(ticketsCount = 0))
        }
    }
}