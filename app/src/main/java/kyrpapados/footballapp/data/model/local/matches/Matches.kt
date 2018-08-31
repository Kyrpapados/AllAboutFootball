package kyrpapados.footballapp.data.model.local.matches

import com.google.gson.annotations.SerializedName

data class Matches(

	@SerializedName("matchday")
	val matchday: Int? = null,

	@SerializedName("awayTeam")
	val awayTeam: AwayTeam? = null,

	@SerializedName("utcDate")
	val utcDate: String? = null,

	@SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@SerializedName("score")
	val score: Score? = null,

	@SerializedName("stage")
	val stage: String? = null,

	@SerializedName("substitutions")
	val substitutions: List<SubstitutionsItem?>? = null,

	@SerializedName("season")
	val season: Season? = null,

	@SerializedName("homeTeam")
	val homeTeam: HomeTeam? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("bookings")
	val bookings: List<BookingsItem?>? = null,

	@SerializedName("referees")
	val referees: List<RefereesItem?>? = null,

	@SerializedName("attendance")
	val attendance: Int? = null,

	@SerializedName("status")
	val status: String? = null,

	@SerializedName("group")
	val group: String? = null,

	@SerializedName("goals")
	val goals: List<GoalsItem?>? = null
)