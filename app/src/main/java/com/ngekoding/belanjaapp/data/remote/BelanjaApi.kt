package com.ngekoding.belanjaapp.data.remote

import com.google.gson.JsonObject
import com.ngekoding.belanjaapp.BuildConfig
import com.ngekoding.belanjaapp.data.model.Product
import com.ngekoding.belanjaapp.data.remote.response.ProductResponse
import com.ngekoding.belanjaapp.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object BelanjaApi {

    fun create(): Api {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
        return retrofit.create(Api::class.java)

    }

    interface Api {
        @GET("/products")
        fun getProducts(): Call<ProductsResponse>

        @POST("/products")
        fun saveProduct(@Body product: Product): Call<ProductResponse>

        @DELETE("/products/{id}")
        fun deleteProduct(@Path("id") id: Int): Call<JsonObject>

        @PUT("/products/{id}")
        fun updateProduct(@Path("id") id: Int, @Body product: Product): Call<ProductResponse>
    }
}