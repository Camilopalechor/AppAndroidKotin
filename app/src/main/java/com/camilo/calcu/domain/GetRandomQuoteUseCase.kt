package com.camilo.calcu.domain

import com.camilo.calcu.data.model.QuoteModel
import com.camilo.calcu.data.model.QuoteProvider
import com.camilo.calcu.data.repository.QuoteRepository

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val  randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
      return null
    }

}