package com.jordan.passportcard.domain.usecases

import androidx.lifecycle.LiveData
import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.domain.repository.PassportCardRepository

class GetPassportsCardsUseCase(private val repository: PassportCardRepository) {

    suspend fun execute() : LiveData<List<PassportCard>> {
        return repository.getAll()
    }
}