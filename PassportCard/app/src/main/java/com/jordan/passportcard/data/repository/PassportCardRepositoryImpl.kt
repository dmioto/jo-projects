package com.jordan.passportcard.data.repository

import androidx.lifecycle.LiveData
import com.jordan.passportcard.data.datasource.local.PassportCardDao
import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.domain.repository.PassportCardRepository
import kotlinx.coroutines.runBlocking

class PassportCardRepositoryImpl(private val dao: PassportCardDao) : PassportCardRepository {

    override fun insert(businessCard: PassportCard) = runBlocking {
        dao.insert(businessCard)
    }

    override fun getAll(): LiveData<List<PassportCard>> = dao.getAll()
}