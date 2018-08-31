package kyrpapados.footballapp.data.model.local

import com.google.gson.annotations.SerializedName

data class Standings(

        @SerializedName("stage")
	val stage: String? = null,

        @SerializedName("type")
	val type: String? = null,

        @SerializedName("table")
	val table: List<TableItem?>? = null,

        @SerializedName("group")
	val group: Any? = null
)