package com.example.practica_android_superpoderes.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_android_superpoderes.data.Repository
import com.example.practica_android_superpoderes.ui.model.Comic
import com.example.practica_android_superpoderes.ui.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _detailStatus = MutableStateFlow<DetailStatus>(DetailStatus.Loading)
    val detailStatus: StateFlow<DetailStatus> = _detailStatus

    private val _hero = MutableStateFlow<Hero>(Hero(0,"","","",false))
    val hero: StateFlow<Hero> get() = _hero

    private val _comics = MutableStateFlow<List<Comic>>(emptyList())
    val comics: StateFlow<List<Comic>> get() = _comics


    fun getHero(id: String) {
        _detailStatus.value = DetailStatus.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                launch(Dispatchers.IO) {
                    repository.getHero(id).collect{ result ->
                        _hero.update { result }
                    }
                }
                Log.i("TAG", "Hero obtained from room")
                _detailStatus.update { DetailStatus.Success }
            }catch (e: Exception) {
                _detailStatus.value = DetailStatus.Error("Something went wrong. $e")
            }
        }
    }

    fun getHeroComics(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val comics = repository.getComics(id)
                _comics.update { comics }
                Log.i("TAG", "Hero obtained from room")
            }catch (e: Exception) {
                _detailStatus.value = DetailStatus.Error("Something went wrong. $e")
            }
        }
    }

    fun updateFav() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newHero = hero.first()
                newHero.favorite = !newHero.favorite
                repository.updateHero(newHero)
                Log.i("TAG", "Hero updated")
            }catch (e: Exception) {
                _detailStatus.value = DetailStatus.Error("Error updating fav in server. $e")
            }
        }
    }


    sealed class DetailStatus {
        object Loading : DetailStatus()
        data class Error(val error: String) : DetailStatus()
        object Success : DetailStatus()
    }
}

