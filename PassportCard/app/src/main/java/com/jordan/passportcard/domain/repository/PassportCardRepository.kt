package com.jordan.passportcard.domain.repository

import androidx.lifecycle.LiveData
import com.jordan.passportcard.domain.entity.PassportCard

interface PassportCardRepository {
    fun insert(businessCard: PassportCard)
    fun getAll(): LiveData<List<PassportCard>>
}