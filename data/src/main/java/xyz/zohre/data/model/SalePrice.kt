package xyz.zohre.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SalePrice(
    @Json(name = "amount") val amount  : Double,
    @Json(name = "currency") val currency  : String
): Parcelable
