package xyz.zohre.ui

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.zohre.data.discovery.ProductRepository
import xyz.zohre.data.model.Category
import xyz.zohre.domain.entities.ApiResult

class FakeProductRepository(override val coroutineDispatcher: CoroutineDispatcher): ProductRepository {

    private lateinit var firstEmit: List<Category>

    fun setEmits(firstEmit: List<Category>) {
        this.firstEmit = firstEmit
    }

    override suspend fun execute(): Flow<ApiResult<List<Category>>> {
        return flow {
            emit(ApiResult.Success(firstEmit))
        }
    }

}