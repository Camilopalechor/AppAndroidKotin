package com.camilo.calcu.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("name") val name : String,
    @SerializedName("jwt") val jwt : String
 )