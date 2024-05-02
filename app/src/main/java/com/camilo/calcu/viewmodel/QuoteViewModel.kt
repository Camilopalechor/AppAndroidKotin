package com.camilo.calcu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.camilo.calcu.model.QuoteModel
import com.camilo.calcu.model.QuoteProvider

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}