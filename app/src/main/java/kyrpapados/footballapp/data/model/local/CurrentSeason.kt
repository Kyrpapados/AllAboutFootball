package kyrpapados.footballapp.data.model.local

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CurrentSeason(
		@SerializedName("currentMatchday") val currentMatchday: Int? = null,
		@SerializedName("endDate") val endDate: String? = null,
		@SerializedName("id") val id: Int? = null,
		@SerializedName("startDate") val startDate: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString())

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(currentMatchday)
		parcel.writeString(endDate)
		parcel.writeValue(id)
		parcel.writeString(startDate)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<CurrentSeason> {
		override fun createFromParcel(parcel: Parcel): CurrentSeason {
			return CurrentSeason(parcel)
		}

		override fun newArray(size: Int): Array<CurrentSeason?> {
			return arrayOfNulls(size)
		}
	}
}