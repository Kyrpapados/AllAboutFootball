package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PlayerOut(

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeValue(id)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PlayerOut> {
		override fun createFromParcel(parcel: Parcel): PlayerOut {
			return PlayerOut(parcel)
		}

		override fun newArray(size: Int): Array<PlayerOut?> {
			return arrayOfNulls(size)
		}
	}
}