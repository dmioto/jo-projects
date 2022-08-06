package com.jordan.passportcard.domain.usecases

import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.domain.repository.PassportCardRepository

class AddPassportCardsUseCase(private val repository: PassportCardRepository) {

    suspend fun execute(passportCards: PassportCard) {
        repository.insert(passportCards)
    }
}