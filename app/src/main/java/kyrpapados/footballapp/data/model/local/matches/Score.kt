package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class Score(

	@SerializedName("duration")
	val duration: String? = null,

	@SerializedName("winner")
	val winner: String? = null,

	@SerializedName("penalties")
	val penalties: Penalties? = null,

	@SerializedName("halfTime")
	val halfTime: HalfTime? = null,

	@SerializedName("fullTime")
	val fullTime: FullTime? = null,

	@SerializedName("extraTime")
	val extraTime: ExtraTime? = null
)