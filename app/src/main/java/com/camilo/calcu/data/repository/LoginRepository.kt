package com.camilo.calcu.data.repository

import com.camilo.calcu.data.dto.LoginDTO
import com.camilo.calcu.data.model.DataResponse
import com.camilo.calcu.data.network.services.LoginService
import com.camilo.calcu.data.providers.UserProvider

class LoginRepository {
    val loginService = LoginService()

    suspend fun signIn(loginDTO: LoginDTO): DataResponse {
        val response: DataResponse = loginService.signIn(loginDTO)
        if (response.status == "success") {
            if (response.data != null) {
                UserProvider.userModel = response.data
            }
        }
        return response
    }
}