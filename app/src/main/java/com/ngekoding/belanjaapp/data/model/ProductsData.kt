package com.ngekoding.belanjaapp.data.model

object ProductsData {

    val listProduct: ArrayList<Product>
        get() {
            val list = arrayListOf<Product>()
            for (data in dataProducts) {
                var products = Product()
                products.name = data[0].toString()
                products.price = Integer.valueOf(data[1].toString())
                products.image = data[2].toString()
                list.add(products)
            }
            return list
        }

    private var dataProducts = arrayOf(
        arrayOf("Kaos", 100000, "https://picsum.photos/id/100/300/300"),
        arrayOf("Sandal", 75000, "https://picsum.photos/id/100/300/300"),
        arrayOf("Topi", 50000, "https://picsum.photos/id/100/300/300")
    )
}