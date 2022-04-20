package xyz.zohre.data.discovery

import retrofit2.Response
import retrofit2.http.GET
import xyz.zohre.data.model.Category

interface RemoteDataSource {

    @GET("/v1/gifs/random")
    suspend fun getProducts(): Response<List<Category>>
}