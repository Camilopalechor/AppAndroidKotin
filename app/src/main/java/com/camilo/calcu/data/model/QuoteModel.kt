package com.camilo.calcu.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

//Esto es un data class
data class QuoteModel(
    @SerializedName("quote")
    val quote:String,
    val author:String)