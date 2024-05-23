package com.camilo.calcu.data.network.client

import com.camilo.calcu.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}