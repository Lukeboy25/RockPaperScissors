package hva.nl.rockpaperscissors.database

import android.content.Context
import hva.nl.rockpaperscissors.model.Game

class GameRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database =
            GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(product: Game) {
        gameDao.insertGame(product)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }
}