package com.ngekoding.belanjaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngekoding.belanjaapp.adapter.ListProductAdapter
import com.ngekoding.belanjaapp.data.model.Product
import com.ngekoding.belanjaapp.data.model.ProductsData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Product> = arrayListOf()
    private lateinit var listProductAdapter: ListProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListProducts()
        setupAddProduct()
        setListClickAction()
    }

    private fun setupAddProduct() {
        btnAddProduct.setOnClickListener {
            val detailIntent = Intent(this, DetailProductActivity::class.java)
            startActivity(detailIntent)
        }
    }

    private fun showListProducts() {
        list.addAll(ProductsData.listProduct)
        listProductAdapter = ListProductAdapter(list)

        rvProducts.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listProductAdapter
            setHasFixedSize(true)
        }
    }

    private fun setListClickAction() {
        listProductAdapter.setOnItemClickCallbak(
            object : ListProductAdapter.OnItemClickCallback {
                override fun onItemClick(data: Product) {
                    val manageDetailIntent = Intent(this@MainActivity,
                        DetailProductActivity::class.java).apply {
                        putExtra(DetailProductActivity.EXTRA_NAME, data.name)
                        putExtra(DetailProductActivity.EXTRA_PRICE, data.price.toString())
                        putExtra(DetailProductActivity.EXTRA_IMAGE_URL, data.image)
                    }
                    startActivity(manageDetailIntent)
                }

            }
        )
    }
}
