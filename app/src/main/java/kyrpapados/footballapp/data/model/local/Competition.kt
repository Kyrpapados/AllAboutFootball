package kyrpapados.footballapp.data.model.local

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Competition(
        @SerializedName("area") val area: Area? = null,
        @SerializedName("lastUpdated") val lastUpdated: String? = null,
        @SerializedName("code") val code: String? = null,
        @SerializedName("currentSeason") val currentSeason: CurrentSeason? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("numberOfAvailableSeasons") val numberOfAvailableSeasons: Int? = null,
        @SerializedName("plan") val plan: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readParcelable(Area::class.java.classLoader),
			parcel.readString(),
			parcel.readString(),
			parcel.readParcelable(CurrentSeason::class.java.classLoader),
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(area, flags)
		parcel.writeString(lastUpdated)
		parcel.writeString(code)
		parcel.writeParcelable(currentSeason, flags)
		parcel.writeString(name)
		parcel.writeValue(id)
		parcel.writeValue(numberOfAvailableSeasons)
		parcel.writeString(plan)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Competition> {
		override fun createFromParcel(parcel: Parcel): Competition {
			return Competition(parcel)
		}

		override fun newArray(size: Int): Array<Competition?> {
			return arrayOfNulls(size)
		}
	}
}