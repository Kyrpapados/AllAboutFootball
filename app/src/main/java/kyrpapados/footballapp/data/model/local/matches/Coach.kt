package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Coach(

	@SerializedName("nationality")
	val nationality: String? = null,

	@SerializedName("countryOfBirth")
	val countryOfBirth: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(nationality)
		parcel.writeString(countryOfBirth)
		parcel.writeString(name)
		parcel.writeValue(id)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Coach> {
		override fun createFromParcel(parcel: Parcel): Coach {
			return Coach(parcel)
		}

		override fun newArray(size: Int): Array<Coach?> {
			return arrayOfNulls(size)
		}
	}
}