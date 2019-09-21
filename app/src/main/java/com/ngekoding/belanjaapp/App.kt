package com.ngekoding.belanjaapp

import android.app.Application
import com.ngekoding.belanjaapp.data.remote.BelanjaApi
import com.ngekoding.belanjaapp.repository.ProductRepository

class App : Application() {

    val repository: ProductRepository by lazy {
        ProductRepository(BelanjaApi.create())
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object{
        @Volatile
        private var INSTANCE : App? = null

        val instance: App
            get() {
                if (INSTANCE == null) {
                    synchronized(App::class.java) {
                        if (INSTANCE == null) {
                            throw RuntimeException("Something went wrong.")
                        }
                    }
                }
                return INSTANCE!!
            }
    }
}