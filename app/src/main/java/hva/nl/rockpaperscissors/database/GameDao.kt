package hva.nl.rockpaperscissors.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hva.nl.rockpaperscissors.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM game_table ORDER BY date DESC")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAllGames()
}