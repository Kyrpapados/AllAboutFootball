package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class BookingsItem(

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("card")
	val card: String? = null,

	@SerializedName("minute")
	val minute: Int? = null,

	@SerializedName("player")
	val player: Player? = null
)