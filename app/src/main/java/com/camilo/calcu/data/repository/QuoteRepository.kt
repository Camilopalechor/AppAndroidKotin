package com.camilo.calcu.data.repository

import com.camilo.calcu.data.model.QuoteModel
import com.camilo.calcu.data.model.QuoteProvider
import com.camilo.calcu.data.network.services.QuoteService

class QuoteRepository {

    private val api = QuoteService()
    suspend fun  getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}