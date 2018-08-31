package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class Captain(

	@SerializedName("shirtNumber")
	val shirtNumber: Int? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
)