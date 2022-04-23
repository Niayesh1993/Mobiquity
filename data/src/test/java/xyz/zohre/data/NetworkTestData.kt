package xyz.zohre.data

import xyz.zohre.data.model.Category
import xyz.zohre.data.shared.TestData

object NetworkTestData {
    fun remoteList(): List<Category> {
        return TestData.categoryList
    }


}

//private fun List<VenueBaseEntity>.toResponseList(fromIndex: Int, toIndex: Int): MutableList<Venues> {
//    val result = mutableListOf<Venues>()
//    for (index in fromIndex until toIndex) {
//        result.add(this[index].toResponse())
//    }
//    return result
//}

