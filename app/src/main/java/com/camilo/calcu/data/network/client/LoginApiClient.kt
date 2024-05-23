package com.camilo.calcu.data.network.client

import com.camilo.calcu.data.dto.LoginDTO
import com.camilo.calcu.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import kotlin.math.sign

interface LoginApiClient {
    @POST("sign_in")
    suspend fun signIn(@Body loginDTO: LoginDTO): Response<DataResponse>

}