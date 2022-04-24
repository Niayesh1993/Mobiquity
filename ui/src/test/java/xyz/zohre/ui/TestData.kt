package xyz.zohre.ui

import xyz.zohre.data.model.*

object TestData {

    val categoryList = mutableListOf(
        mockCategory(1, "101", "Food", "",listOf(
            mockProduct(1, "201", "pasta", "101", "", "", mockSalePrice(1, "52.01", "EU")),
            mockProduct(2, "202", "sandwich", "101", "", "", mockSalePrice(1, "52.01", "EU"))
        )  ),
        mockCategory(2, "102", "Drink", "", listOf(
            mockProduct(3, "201", "Beer", "102", "", "", mockSalePrice(1, "45.12", "EU")),
            mockProduct(4, "202", "Water", "102", "", "", mockSalePrice(1, "52.01", "EU"))
        ) ),
        mockCategory(3, "103", "Fruit", "", listOf(
            mockProduct(5, "201", "apple", "102", "", "", mockSalePrice(1, "14.01", "EU")),
            mockProduct(6, "202", "orange", "102", "", "", mockSalePrice(1, "26.01", "EU"))
        ) )
    )


    private fun mockCategory(
        mockId: Int,
        id: String = "id$mockId",
        name: String = "name$mockId",
        description: String = "description$mockId",
        products: List<Product> = listOf(mockProduct(mockId))
        ): Category {
        return Category(
            id = id.toInt(),
            name = name,
            description = description,
            products = products
        )
    }

    private fun mockProduct(
        mockId: Int,
        id: String = "id$mockId",
        name: String = "name$mockId",
        categoryId: String = "categoryId$mockId",
        description: String = "description$mockId",
        url: String = "url$mockId",
        salePrice: SalePrice = mockSalePrice(mockId)
    ): Product {
        return Product(
            id = id.toInt(),
            name = name,
            categoryId = categoryId.toInt(),
            description = description,
            url = url,
            salePrice = salePrice
        )
    }

     private fun mockSalePrice(
        mockId: Int,
        amount: String = "amount$mockId",
        currency: String = "currency$mockId",
        ): SalePrice {
        return SalePrice(
            amount = amount.toDouble(),
            currency = currency
        )
    }
}