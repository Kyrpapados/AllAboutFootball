package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SubstitutionsItem(

	@SerializedName("playerIn")
	val playerIn: PlayerIn? = null,

	@SerializedName("playerOut")
	val playerOut: PlayerOut? = null,

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("minute")
	val minute: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readParcelable(PlayerIn::class.java.classLoader),
			parcel.readParcelable(PlayerOut::class.java.classLoader),
			parcel.readParcelable(Team::class.java.classLoader),
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(playerIn, flags)
		parcel.writeParcelable(playerOut, flags)
		parcel.writeParcelable(team, flags)
		parcel.writeValue(minute)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<SubstitutionsItem> {
		override fun createFromParcel(parcel: Parcel): SubstitutionsItem {
			return SubstitutionsItem(parcel)
		}

		override fun newArray(size: Int): Array<SubstitutionsItem?> {
			return arrayOfNulls(size)
		}
	}
}