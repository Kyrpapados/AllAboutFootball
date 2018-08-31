package kyrpapados.footballapp.data.model.local.teams

import com.google.gson.annotations.SerializedName

data class SquadItem(

	@SerializedName("role")
	val role: String? = null,

	@SerializedName("nationality")
	val nationality: String? = null,

	@SerializedName("countryOfBirth")
	val countryOfBirth: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: String? = null
)