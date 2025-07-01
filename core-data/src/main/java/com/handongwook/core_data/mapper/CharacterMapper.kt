package com.handongwook.core_data.mapper

import com.handongwook.core_network.model.CharacterResponse
import com.handongwook.core_model.model.Character

fun CharacterResponse.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        alternateNames = this.alternateNames,
        species = this.species,
        gender = this.gender,
        house = this.house,
        dateOfBirth = this.dateOfBirth,
        yearOfBirth = this.yearOfBirth,
        wizard = this.wizard,
        ancestry = this.ancestry,
        eyeColour = this.eyeColour,
        hairColour = this.hairColour,
        wand = this.wand.toDomain(),
        patronus = this.patronus,
        hogwartsStudent = this.hogwartsStudent,
        hogwartsStaff = this.hogwartsStaff,
        actor = this.actor,
        alternateActors = this.alternateActors,
        alive = this.alive,
        imageUrl = this.imageUrl
    )
}