package com.camilo.calcu.domain

import com.camilo.calcu.data.model.QuoteModel
import com.camilo.calcu.data.repository.QuoteRepository

class GetQuotesUseCase {
    private val  repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}