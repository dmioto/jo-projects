package com.jordan.passportcard.presentation.showcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.domain.usecases.GetPassportsCardsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.net.PasswordAuthentication

class ShowCardsViewModel(
    private val useCase: GetPassportsCardsUseCase,
    private val dispatcherIo: CoroutineDispatcher
) : ViewModel() {

    private val _passportCards = MutableLiveData<List<PassportCard>>()
    var passportCards: LiveData<List<PassportCard>> = _passportCards

    fun getPassportData() {
        viewModelScope.launch(dispatcherIo) {
            useCase.execute().let {
                passportCards = it
            }
        }
    }
}