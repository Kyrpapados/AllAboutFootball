package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HalfTime(

	@SerializedName("awayTeam")
	val awayTeam: Int? = null,

	@SerializedName("homeTeam")
	val homeTeam: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(awayTeam)
		parcel.writeValue(homeTeam)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<HalfTime> {
		override fun createFromParcel(parcel: Parcel): HalfTime {
			return HalfTime(parcel)
		}

		override fun newArray(size: Int): Array<HalfTime?> {
			return arrayOfNulls(size)
		}
	}
}