package xyz.zohre.ui.product

import kotlinx.coroutines.delay
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import xyz.zohre.test_shared.runBlockingTest
import xyz.zohre.ui.FakeProductRepository
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import xyz.zohre.test_shared.LiveDataTestUtil
import xyz.zohre.ui.TestData


class ProductViewModelTest{

    @get:Rule
    var coroutineRule = xyz.zohre.test_shared.MainCoroutineRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var viewModel: ProductViewModel

    private lateinit var repository: FakeProductRepository

    @Before
    fun setup() {
        repository = FakeProductRepository(coroutineRule.testDispatcher)
        viewModel = ProductViewModel(repository)
    }

    @Test
    fun checkRemoteWorkProperly() = coroutineRule.runBlockingTest {
        // when
        val firstEmit = TestData.categoryList
        repository.setEmits(firstEmit)

        // given
        val results = LiveDataTestUtil.getValuesLater(viewModel.categories)
        viewModel.loadCategories()
        delay(510)

        // then
        Assert.assertEquals(results[0], firstEmit)
    }

}