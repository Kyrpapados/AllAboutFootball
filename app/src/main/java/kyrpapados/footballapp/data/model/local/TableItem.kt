package kyrpapados.footballapp.data.model.local

import com.google.gson.annotations.SerializedName

data class TableItem(

        @SerializedName("goalsFor")
        val goalsFor: Int? = null,

        @SerializedName("lost")
        val lost: Int? = null,

        @SerializedName("won")
        val won: Int? = null,

        @SerializedName("playedGames")
        val playedGames: Int? = null,

        @SerializedName("position")
        val position: Int? = null,

        @SerializedName("team")
        val team: Team? = null,

        @SerializedName("draw")
        val draw: Int? = null,

        @SerializedName("goalsAgainst")
        val goalsAgainst: Int? = null,

        @SerializedName("goalDifference")
        val goalDifference: Int? = null,

        @SerializedName("points")
        val points: Int? = null
)