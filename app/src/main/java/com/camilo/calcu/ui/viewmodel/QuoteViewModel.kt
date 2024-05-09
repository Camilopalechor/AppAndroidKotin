package com.camilo.calcu.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilo.calcu.data.model.QuoteModel
import com.camilo.calcu.data.model.QuoteProvider
import com.camilo.calcu.domain.GetQuotesUseCase
import com.camilo.calcu.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel?>()
    val isLoading = MutableLiveData<Boolean>()
    var getQuotesUseCase= GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        isLoading.postValue(true)
       viewModelScope.launch {
           val  result:List<QuoteModel>? = getQuotesUseCase()
           if (!result.isNullOrEmpty()){
               isLoading.postValue(false)
               quoteModel.postValue(result[0])
           }
       }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()

        if (quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

}