package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class GoalsItem(

	@SerializedName("scorer")
	val scorer: Scorer? = null,

	@SerializedName("assist")
	val assist: Any? = null,

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("type")
	val type: Any? = null,

	@SerializedName("minute")
	val minute: Int? = null
)