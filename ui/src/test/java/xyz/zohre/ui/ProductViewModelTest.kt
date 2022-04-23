package xyz.zohre.ui

import org.junit.Before
import org.junit.Rule
import xyz.zohre.data.shared.MainCoroutineRule
import xyz.zohre.ui.product.ProductViewModel
import kotlinx.coroutines.delay
import org.junit.Assert
import org.junit.Test
import xyz.zohre.data.shared.TestData
import xyz.zohre.data.shared.runBlockingTest
import xyz.zohre.ui.util.LiveDataTestUtil


class ProductViewModelTest {

    @get:Rule
    var coroutineRule = MainCoroutineRule()


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