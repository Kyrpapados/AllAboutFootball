package kyrpapados.footballapp.data.model.local

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Area(
		@SerializedName("name") var name: String? = null,
		@SerializedName("id") var id: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	init {
		this.name = name
		this.id = id

	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeValue(id)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Area> {
		override fun createFromParcel(parcel: Parcel): Area {
			return Area(parcel)
		}

		override fun newArray(size: Int): Array<Area?> {
			return arrayOfNulls(size)
		}
	}
}
