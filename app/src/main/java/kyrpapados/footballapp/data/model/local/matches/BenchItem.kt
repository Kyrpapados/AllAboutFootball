package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BenchItem(

	@SerializedName("shirtNumber")
	val shirtNumber: Int? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(shirtNumber)
		parcel.writeString(name)
		parcel.writeValue(id)
		parcel.writeString(position)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BenchItem> {
		override fun createFromParcel(parcel: Parcel): BenchItem {
			return BenchItem(parcel)
		}

		override fun newArray(size: Int): Array<BenchItem?> {
			return arrayOfNulls(size)
		}
	}
}