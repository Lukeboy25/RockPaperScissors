package hva.nl.rockpaperscissors.model
    
import androidx.room.*
import hva.nl.rockpaperscissors.Converters
import java.time.LocalDateTime

@Entity(tableName = "game_table")
@TypeConverters(Converters::class)
data class Game (
    @ColumnInfo(name = "date")
    var date: LocalDateTime,

    @ColumnInfo(name = "player_move")
    var playerMove: GameEnum,

    @ColumnInfo(name = "computer_move")
    var computerMove: GameEnum,

    @ColumnInfo(name = "result")
    var result: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)