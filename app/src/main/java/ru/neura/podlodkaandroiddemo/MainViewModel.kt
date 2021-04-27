package ru.neura.podlodkaandroiddemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _count: MutableLiveData<Int> = MutableLiveData(3)
    val count: LiveData<Int> = _count

    fun releaseNewKittens() {
        viewModelScope.launch {
            delay(2000)
            _count.postValue(count.value?.plus(10))
        }
    }
}