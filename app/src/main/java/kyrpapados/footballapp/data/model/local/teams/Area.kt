package kyrpapados.footballapp.data.model.local.teams

import com.google.gson.annotations.SerializedName

data class Area(

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
)