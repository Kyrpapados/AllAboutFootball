package kyrpapados.footballapp.data.model.responoces

import com.google.gson.annotations.SerializedName
import kyrpapados.footballapp.data.model.local.Season
import kyrpapados.footballapp.data.model.local.Standings

data class StandingsResponce (@SerializedName("standings") val standings: List<Standings>,
                              @SerializedName("season") val season: Season)