package com.example.memeapp

import androidx.lifecycle.ViewModel
import com.example.memeapp.api.ApiBuilder
import com.example.memeapp.api.ApiInterface
import com.example.memeapp.memeModal.MemeModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel : ViewModel() {

    private lateinit var apiData : Response<MemeModal>
    var memeImageUrl = "str"

    private val memeApi = ApiBuilder.getInstance().create(ApiInterface::class.java)

    fun getApiData(){

        CoroutineScope(Dispatchers.Main).launch {
            apiData = memeApi.getMemes()
            memeImageUrl = apiData.body()!!.url
        }
    }
}