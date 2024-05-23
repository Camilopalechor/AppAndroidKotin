package com.camilo.calcu.domain

import com.camilo.calcu.data.dto.LoginDTO
import com.camilo.calcu.data.model.DataResponse
import com.camilo.calcu.data.repository.LoginRepository

class PostSignInUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(loginDTO: LoginDTO):DataResponse{
        return repository.signIn(loginDTO)
    }
}