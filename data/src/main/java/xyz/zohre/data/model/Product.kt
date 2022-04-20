package xyz.zohre.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "categoryId") val categoryId : Int,
    @Json(name = "description") val description: String,
    @Json(name = "url") val url: String,
    @Json(name = "salePrice ") val salePrice: SalePrice
): Parcelable
