package kyrpapados.footballapp.data.model.local.matches

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HomeTeam(

	@SerializedName("bench")
	val bench: List<BenchItem?>? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("lineup")
	val lineup: List<LineupItem?>? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("captain")
	val captain: Captain? = null,

	@SerializedName("coach")
	val coach: Coach? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.createTypedArrayList(BenchItem),
			parcel.readString(),
			parcel.createTypedArrayList(LineupItem),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readParcelable(Captain::class.java.classLoader),
			parcel.readParcelable(Coach::class.java.classLoader)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(bench)
		parcel.writeString(name)
		parcel.writeTypedList(lineup)
		parcel.writeValue(id)
		parcel.writeParcelable(captain, flags)
		parcel.writeParcelable(coach, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<HomeTeam> {
		override fun createFromParcel(parcel: Parcel): HomeTeam {
			return HomeTeam(parcel)
		}

		override fun newArray(size: Int): Array<HomeTeam?> {
			return arrayOfNulls(size)
		}
	}
}