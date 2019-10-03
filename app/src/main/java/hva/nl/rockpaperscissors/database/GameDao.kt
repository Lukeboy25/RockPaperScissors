package hva.nl.rockpaperscissors.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hva.nl.rockpaperscissors.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM game_table ORDER BY date DESC")
    suspend fun getAllGames(): List<Game>

    @Query("SELECT COUNT(result) FROM game_table WHERE result = 'You win!'")
    suspend fun getAllWinGames(): Int

    @Query("SELECT COUNT(result) FROM game_table WHERE result = 'Draw'")
    suspend fun getAllDrawGames(): Int

    @Query("SELECT COUNT(result) FROM game_table WHERE result = 'Computer wins!'")
    suspend fun getAllLostGames(): Int

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAllGames()
}