package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BookingsItem(

	@SerializedName("team")
	val team: Team? = null,

	@SerializedName("card")
	val card: String? = null,

	@SerializedName("minute")
	val minute: Int? = null,

	@SerializedName("player")
	val player: Player? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readParcelable(Team::class.java.classLoader),
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readParcelable(Player::class.java.classLoader)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(team, flags)
		parcel.writeString(card)
		parcel.writeValue(minute)
		parcel.writeParcelable(player, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BookingsItem> {
		override fun createFromParcel(parcel: Parcel): BookingsItem {
			return BookingsItem(parcel)
		}

		override fun newArray(size: Int): Array<BookingsItem?> {
			return arrayOfNulls(size)
		}
	}
}