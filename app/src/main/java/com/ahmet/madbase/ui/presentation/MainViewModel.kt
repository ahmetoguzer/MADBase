package com.ahmet.madbase.ui.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmet.madbase.common.util.Event
import com.ahmet.madbase.data.repository.DummyRepository
import com.ahmet.madbase.data.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {

    /**
     * SingleLiveEvent with LiveData
     */
    private val _event = MutableLiveData<Event<MainUIState>>()
    val event: MutableLiveData<Event<MainUIState>>
        get() = _event

    fun getPokemonList() {
        viewModelScope.launch {
            dummyRepository.getPokemonList(limit = 10, offset = 20)
                .collect {
                    when (it.status) {
                        Status.SUCCESS -> event.value = Event(MainUIState.SUCCESS)
                        Status.ERROR -> event.value = Event(MainUIState.ERROR)
                        Status.LOADING -> event.value = Event(MainUIState.LOADING)
                    }
                }
        }
    }
}


