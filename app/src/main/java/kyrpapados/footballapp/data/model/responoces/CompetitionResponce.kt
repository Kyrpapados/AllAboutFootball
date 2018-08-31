package kyrpapados.footballapp.data.model.responoces

import com.google.gson.annotations.SerializedName
import kyrpapados.footballapp.data.model.local.Competition

data class CompetitionResponce(
        @SerializedName("competitions") val competitions: List<Competition>,
        @SerializedName("count") val count: Int? = null
)
