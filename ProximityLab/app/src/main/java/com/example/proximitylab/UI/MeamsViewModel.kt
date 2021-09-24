package com.example.proximitylab.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proximitylab.Model.Meme
import com.example.proximitylab.Network.ApiInterface

class MeamsViewModel:ViewModel() {
    private val _memesLiveData = MutableLiveData<List<Meme>>()
    val memesLiveData :LiveData<List<Meme>> = _memesLiveData
    init {
        viewModelScope.launch {
            val flickerResponse =  ApiInterface.fetchMems()
            val flickerList = flickerResponse.photos.photo.map {
                Meme(
                    id = it.id,
                    url = "https://api.imgflip.com/get_memes",
                    name = it.name
                )
            }
            _memesLiveData.postValue(flickerList)
        }
    }

}