package edu.iesam.loginexam1eval.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.domain.CheckUserExistsUseCase
import edu.iesam.loginexam1eval.domain.SaveUserUseCase
import edu.iesam.loginexam1eval.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SingupViewModel(
    private val checkUserExistsUseCase: CheckUserExistsUseCase,
    private val saveUserUseCase: SaveUserUseCase
):ViewModel() {

    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun userExists(user: User){
        viewModelScope.launch (Dispatchers.IO){
            _uiState.postValue(UiState(userExists = checkUserExistsUseCase(user)))
        }
    }

    fun saveUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            saveUserUseCase.invoke(user)
        }
    }


    data class UiState(
        val userExists: Boolean =false
    )
}