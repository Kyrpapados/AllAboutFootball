package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class RefereesItem(

	@SerializedName("nationality")
	val nationality: Any? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
)