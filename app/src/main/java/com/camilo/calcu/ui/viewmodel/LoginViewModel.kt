package com.camilo.calcu.ui.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.camilo.calcu.data.dto.LoginDTO
import com.camilo.calcu.data.model.DataResponse
import com.camilo.calcu.data.model.UserModel
import com.camilo.calcu.domain.PostSignInUseCase

class LoginViewModel:ViewModel() {
    val dataResponse = MutableLiveData<DataResponse>()
    val userModel = MutableLiveData<UserModel>()
    val message = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    val loginUseCase = PostSignInUseCase()

    fun signIn(loginDTO: LoginDTO){
        viewModelScope.launch {
            isLoading.postValue(true)

            val resultado:DataResponse = loginUseCase(loginDTO)
            dataResponse.postValue(resultado)

            when(resultado.status){
                "success" -> {
                    userModel.postValue(resultado.data!!)
                    Log.e("Model User", userModel.toString())
                    isLoading.postValue(false)
                }
                "invalid" -> {
                    message.postValue(resultado.message)
                    isLoading.postValue(false)
                }
                "error" ->{
                    message.postValue("Username no registrado! \uD83D\uDE14")
                    isLoading.postValue(false)
                }
            }
           }
      }
}