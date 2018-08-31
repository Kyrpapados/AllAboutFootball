package kyrpapados.footballapp.data.model.responoces

import com.google.gson.annotations.SerializedName
import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.data.model.local.matches.Matches

class MatchesResponce(
        @SerializedName("competitions") val competitions: List<Competition>,
        @SerializedName("matches") val matches: List<Matches>,
        @SerializedName("count") val count: Int? = null
)