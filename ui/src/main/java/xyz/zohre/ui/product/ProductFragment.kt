package xyz.zohre.ui.product

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product.*
import xyz.zohre.presentation_shared.BaseFragment
import xyz.zohre.presentation_shared.adapter.BaseViewHolder
import xyz.zohre.presentation_shared.shortToast
import xyz.zohre.ui.R

@AndroidEntryPoint
class ProductFragment : BaseFragment() {

    private val viewModel: ProductViewModel by getLazyViewModel()
    private val adapter = CategoryRecyclerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        category_recycler.adapter = adapter
        category_recycler.itemAnimator = DefaultItemAnimator()

        adapter.itemClickListener = BaseViewHolder.OnItemClickListener { _, item ->
            val action = ProductFragmentDirections.actionProductFragmentToProductDetailFragment(item)
            findNavController().navigate(action)
        }

        initObservers()
        progressbar.visibility = View.VISIBLE
        viewModel.loadCategories()
    }

    private fun initObservers() {
        viewModel.categories.observe(
            viewLifecycleOwner,
            {
                progressbar.visibility = View.GONE
                adapter.insertItems(it)
            }
        )
        viewModel.loading.observe(
            viewLifecycleOwner,
            {
                if (it) progressbar.visibility = View.VISIBLE
            }
        )
        viewModel.showError.observe(
            viewLifecycleOwner,
            { event ->
                event.getContentIfNotHandled()?.shortToast(this.requireView())
                progressbar.visibility = View.GONE
            }
        )
    }

}