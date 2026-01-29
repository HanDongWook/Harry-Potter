package com.handongwook.harry_potter.data.mapper

import com.handongwook.harry_potter.model.Character
import com.handongwook.harry_potter.network.model.CharacterResponse

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