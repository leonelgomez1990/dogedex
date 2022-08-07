package com.leonelg.dogedex.dog.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonelg.dogedex.dog.domain.Dog
import com.leonelg.dogedex.dog.usecases.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            try {
                _dogList.value = getDogsUseCase.invoke()
            }
            catch (e: Exception) {
                Log.e("viewModel", e.message.toString())
            }
        }
    }
}