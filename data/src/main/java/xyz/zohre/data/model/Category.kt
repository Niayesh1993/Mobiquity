package xyz.zohre.data.model

import com.squareup.moshi.Json

data class Category(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "description") val description  : String,
    @Json(name = "products") val products: List<Product>
)
