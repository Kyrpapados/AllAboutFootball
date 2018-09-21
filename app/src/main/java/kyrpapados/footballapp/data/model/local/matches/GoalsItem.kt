package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GoalsItem(

	@SerializedName("scorer")
	val scorer: Scorer? = null,

	@SerializedName("assist")
	val assist: List<Assist>? = null,

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("minute")
	val minute: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readParcelable(Scorer::class.java.classLoader),
			parcel.createTypedArrayList(Assist),
			parcel.readParcelable(Team::class.java.classLoader),
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(scorer, flags)
		parcel.writeTypedList(assist)
		parcel.writeParcelable(team, flags)
		parcel.writeValue(minute)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<GoalsItem> {
		override fun createFromParcel(parcel: Parcel): GoalsItem {
			return GoalsItem(parcel)
		}

		override fun newArray(size: Int): Array<GoalsItem?> {
			return arrayOfNulls(size)
		}
	}
}