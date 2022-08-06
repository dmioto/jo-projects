package com.jordan.passportcard.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PassportCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String,
    var nationality: String,
    var telephone: String,
    var email: String,
    var document: String,
    var expiration: String,
    var color: String
)