package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class Coach(

	@SerializedName("nationality")
	val nationality: String? = null,

	@SerializedName("countryOfBirth")
	val countryOfBirth: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
)