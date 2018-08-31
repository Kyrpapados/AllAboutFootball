package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class HomeTeam(

	@SerializedName("bench")
	val bench: List<BenchItem?>? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("lineup")
	val lineup: List<LineupItem?>? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("captain")
	val captain: Captain? = null,

	@SerializedName("coach")
	val coach: Coach? = null
)