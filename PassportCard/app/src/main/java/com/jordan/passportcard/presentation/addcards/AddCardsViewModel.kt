package com.jordan.passportcard.presentation.addcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.domain.usecases.AddPassportCardsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class AddCardsViewModel(
    private val useCase: AddPassportCardsUseCase,
    private val dispatcherIo: CoroutineDispatcher
) : ViewModel() {

    fun addPassportData(passportCard: PassportCard) {
        viewModelScope.launch(dispatcherIo) {
            useCase.execute(passportCard)
        }
    }
}