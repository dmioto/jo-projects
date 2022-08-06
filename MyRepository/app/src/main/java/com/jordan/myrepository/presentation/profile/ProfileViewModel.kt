package com.jordan.myrepository.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordan.myrepository.domain.entity.Repo
import com.jordan.myrepository.domain.usecase.GetRepoUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val useCase: GetRepoUseCase,
    private val dispatcherIo: CoroutineDispatcher
) : ViewModel() {

    private val _repos = MutableLiveData<State>()
    var repos: LiveData<State> = _repos

    fun getPassportData(user: String) {
        viewModelScope.launch(dispatcherIo) {
            useCase.execute(user).let {
                _repos.postValue(State.Success(it))
            }
        }
    }

    sealed class State {
        data class Success(val list: List<Repo>) : State()
        data class Error(val error: Throwable) : State()
        object Loading : State()
    }
}