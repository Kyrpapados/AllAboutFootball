package kyrpapados.footballapp.data.model.local

import com.google.gson.annotations.SerializedName

data class Team(

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("crestUrl")
	val crestURI: String? = null
)