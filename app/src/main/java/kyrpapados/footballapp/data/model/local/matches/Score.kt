package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Score(

	@SerializedName("duration")
	val duration: String? = null,

	@SerializedName("winner")
	val winner: String? = null,

	@SerializedName("penalties")
	val penalties: Penalties? = null,

	@SerializedName("halfTime")
	val halfTime: HalfTime? = null,

	@SerializedName("fullTime")
	val fullTime: FullTime? = null,

	@SerializedName("extraTime")
	val extraTime: ExtraTime? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString(),
			parcel.readParcelable(Penalties::class.java.classLoader),
			parcel.readParcelable(HalfTime::class.java.classLoader),
			parcel.readParcelable(FullTime::class.java.classLoader),
			parcel.readParcelable(ExtraTime::class.java.classLoader)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(duration)
		parcel.writeString(winner)
		parcel.writeParcelable(penalties, flags)
		parcel.writeParcelable(halfTime, flags)
		parcel.writeParcelable(fullTime, flags)
		parcel.writeParcelable(extraTime, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Score> {
		override fun createFromParcel(parcel: Parcel): Score {
			return Score(parcel)
		}

		override fun newArray(size: Int): Array<Score?> {
			return arrayOfNulls(size)
		}
	}
}