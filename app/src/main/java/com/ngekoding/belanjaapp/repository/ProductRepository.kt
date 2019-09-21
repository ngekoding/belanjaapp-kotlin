package com.ngekoding.belanjaapp.repository

import com.ngekoding.belanjaapp.data.model.Product
import com.ngekoding.belanjaapp.data.remote.BelanjaApi
import com.ngekoding.belanjaapp.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository(val api: BelanjaApi.Api) {

    fun get(onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit) {
        api.getProducts().enqueue(object : Callback<ProductsResponse> {
            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.data?.map {
                        with(it) {
                            Product(name, price, image, id)
                        }
                    }
                    result?.let {
                        onSuccess(it)
                    }
                } else {
                    onError(Throwable("Something went wrong."))
                }
            }

        })
    }
}