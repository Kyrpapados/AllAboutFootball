package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class FullTime(

	@SerializedName("awayTeam")
	val awayTeam: Int? = null,

	@SerializedName("homeTeam")
	val homeTeam: Int? = null
)