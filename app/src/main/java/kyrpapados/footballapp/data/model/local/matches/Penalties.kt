package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class Penalties(

	@SerializedName("awayTeam")
	val awayTeam: Any? = null,

	@SerializedName("homeTeam")
	val homeTeam: Any? = null
)