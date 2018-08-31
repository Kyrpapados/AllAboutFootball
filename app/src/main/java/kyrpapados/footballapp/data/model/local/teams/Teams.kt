package kyrpapados.footballapp.data.model.local.teams

import com.google.gson.annotations.SerializedName

data class Teams(

	@SerializedName("area")
	val area: Area? = null,

	@SerializedName("venue")
	val venue: String? = null,

	@SerializedName("website")
	val website: String? = null,

	@SerializedName("address")
	val address: String? = null,

	@SerializedName("crestUrl")
	val crestUrl: String? = null,

	@SerializedName("tla")
	val tla: String? = null,

	@SerializedName("founded")
	val founded: Int? = null,

	@SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@SerializedName("clubColors")
	val clubColors: String? = null,

	@SerializedName("squad")
	val squad: List<SquadItem?>? = null,

	@SerializedName("phone")
	val phone: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("shortName")
	val shortName: String? = null,

	@SerializedName("email")
	val email: String? = null
)