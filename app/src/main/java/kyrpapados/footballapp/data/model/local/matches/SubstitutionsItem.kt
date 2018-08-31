package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class SubstitutionsItem(

	@SerializedName("playerIn")
	val playerIn: PlayerIn? = null,

	@SerializedName("playerOut")
	val playerOut: PlayerOut? = null,

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("minute")
	val minute: Int? = null
)