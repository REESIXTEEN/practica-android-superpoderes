package com.example.practica_android_superpoderes.ui.herolist

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_android_superpoderes.data.Repository
import com.example.practica_android_superpoderes.ui.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val repository: Repository,
    private val shared: SharedPreferences): ViewModel() {

    private val _heros = MutableStateFlow<List<Hero>>(emptyList())
    val heros: StateFlow<List<Hero>> get() = _heros

    private val _mainStatus = MutableStateFlow<MainStatus>(MainStatus.Loading)
    val mainStatus: StateFlow<MainStatus> = _mainStatus

    init {
        getHeros()
    }

    fun getHeros() {
        _mainStatus.value = MainStatus.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {

//                val result = withContext(Dispatchers.IO) {
//                    repository.getHeros()
//                }
//                _heros.update { result }


                launch(Dispatchers.IO) {
                    repository.getHeros().collect{ result ->
                        _heros.update { result }
                    }
                }
                Log.i("TAG", "Heroes obtained from api")
                _mainStatus.update { MainStatus.Success }
            }catch (e: Exception) {
                _mainStatus.value = MainStatus.Error("Something went wrong. $e")
            }
        }

    }

    sealed class MainStatus {
        object Loading : MainStatus()
        data class Error(val error: String) : MainStatus()
        object Success : MainStatus()
    }
}

