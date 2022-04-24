package xyz.zohre.data

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import xyz.zohre.data.discovery.ProductRepositoryImpl
import xyz.zohre.data.discovery.RemoteDataSource
import xyz.zohre.data.model.Category
import xyz.zohre.domain.entities.ApiResult

class ProductRepositoryImplTest {

    private lateinit var productRepositoryImpl: ProductRepositoryImpl

    @MockK
    lateinit var remoteDataSource: RemoteDataSource

    @MockK
    lateinit var remoteResult: Response<List<Category>>

    @get:Rule
    var coroutineRule = xyz.zohre.test_shared.MainCoroutineRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        productRepositoryImpl = ProductRepositoryImpl(
            remoteDataSource,
            coroutineRule.testDispatcher,
            coroutineRule.testDispatcher
        )
    }

    @Test
    fun checkRepositoryEmitCorrectListSize() = runBlockingTest {

        //When
        coEvery { remoteDataSource.getProducts() } returns remoteResult
        every { remoteResult.isSuccessful } returns true
        every { remoteResult.body() } returns NetworkTestData.remoteList()


        //Given
        val results: List<ApiResult<List<Category>>> = productRepositoryImpl.execute().toList()


        //Then
        Assert.assertEquals(1, results.size)
    }

    @Test
    fun checkRepositoryEmitCorrectData() = runBlockingTest {

        //When
        val expectedRemote = TestData.categoryList

        coEvery { remoteDataSource.getProducts() } returns remoteResult
        every { remoteResult.isSuccessful } returns true
        every { remoteResult.body() } returns NetworkTestData.remoteList()

        //Given
        val results: List<ApiResult<List<Category>>> = productRepositoryImpl.execute().toList()

        //Then
        Assert.assertEquals(expectedRemote, (results[0] as ApiResult.Success).data.sortedBy { it.id })
        Assert.assertEquals(expectedRemote[0].products, (results[0] as ApiResult.Success).data[0].products)
    }

}