package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kyrpapados.footballapp.data.model.local.Season

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
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readParcelable(AwayTeam::class.java.classLoader),
                parcel.readString(),
                parcel.readString(),
                parcel.readParcelable(Score::class.java.classLoader),
                parcel.readString(),
                parcel.createTypedArrayList(SubstitutionsItem),
                parcel.readParcelable(Season::class.java.classLoader),
                parcel.readParcelable(HomeTeam::class.java.classLoader),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.createTypedArrayList(BookingsItem),
                parcel.createTypedArrayList(RefereesItem),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.createTypedArrayList(GoalsItem)) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(matchday)
                parcel.writeParcelable(awayTeam, flags)
                parcel.writeString(utcDate)
                parcel.writeString(lastUpdated)
                parcel.writeParcelable(score, flags)
                parcel.writeString(stage)
                parcel.writeTypedList(substitutions)
                parcel.writeParcelable(season, flags)
                parcel.writeParcelable(homeTeam, flags)
                parcel.writeValue(id)
                parcel.writeTypedList(bookings)
                parcel.writeTypedList(referees)
                parcel.writeValue(attendance)
                parcel.writeString(status)
                parcel.writeString(group)
                parcel.writeTypedList(goals)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Matches> {
                override fun createFromParcel(parcel: Parcel): Matches {
                        return Matches(parcel)
                }

                override fun newArray(size: Int): Array<Matches?> {
                        return arrayOfNulls(size)
                }
        }
}