package com.handongwook.harry_potter.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.handongwook.harry_potter.model.Wand

@Entity
data class CharacterEntity(
    var page: Int = 0,
    @PrimaryKey val id: String,
    val name: String,
    val alternateNames: List<String>,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String?,
    val yearOfBirth: Int?,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alternateActors: List<String>,
    val alive: Boolean,
    val imageUrl: String
)