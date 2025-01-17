package com.camilo.calcu.data.network

import com.camilo.calcu.core.RetrofitHelper
import com.camilo.calcu.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create

class QuoteService {

    private  val  retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response:Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}