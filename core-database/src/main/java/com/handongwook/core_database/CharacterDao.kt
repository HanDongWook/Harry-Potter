package com.handongwook.core_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.handongwook.core_database.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(pokemonList: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity WHERE page = :page")
    suspend fun getCharacters(page: Int): List<CharacterEntity>

    @Query("SELECT * FROM CharacterEntity WHERE page <= :page")
    suspend fun getAllCharacter(page: Int): List<CharacterEntity>
}