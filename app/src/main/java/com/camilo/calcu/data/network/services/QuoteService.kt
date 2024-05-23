package com.camilo.calcu.data.network.services

import com.camilo.calcu.core.RetrofitHelper
import com.camilo.calcu.data.model.QuoteModel
import com.camilo.calcu.data.network.client.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {

    private  val  retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response:Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}