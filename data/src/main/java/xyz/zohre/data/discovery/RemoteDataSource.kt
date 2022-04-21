package xyz.zohre.data.discovery

import retrofit2.Response
import retrofit2.http.GET
import xyz.zohre.data.model.Category

interface RemoteDataSource {

    @GET("/")
    suspend fun getProducts(): Response<List<Category>>
}