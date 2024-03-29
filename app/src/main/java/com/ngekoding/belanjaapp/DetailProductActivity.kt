package com.ngekoding.belanjaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_product.*
import kotlinx.android.synthetic.main.item_list_product.*

class DetailProductActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_IMAGE_URL = "extra_image_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        showProductDetail()
    }

    private fun showProductDetail() {
        etProductNameDetail.setText(intent.getStringExtra(EXTRA_NAME))
        etProductPriceDetail.setText(intent.getStringExtra(EXTRA_PRICE))
        etProductImageDetail.setText(intent.getStringExtra(EXTRA_IMAGE_URL))
        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_IMAGE_URL))
            .into(imgProductDetail)


    }
}
