package com.example.aop.part5.chapter02.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aop.part5.chapter02.data.entity.product.ProductEntity
import com.example.aop.part5.chapter02.databinding.ItemProductBinding
import com.example.aop.part5.chapter02.extensions.loadCenterCrop

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder>() {

	private var productList: List<ProductEntity> = listOf()
	private lateinit var productItemClickListener: (ProductEntity) -> Unit

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
		val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ProductItemViewHolder(view, productItemClickListener)
	}

	override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
		holder.bindData(productList[position])
		holder.bindViews(productList[position])
	}

	override fun getItemCount(): Int = productList.size

	fun setProductList(productList: List<ProductEntity>, productItemClickListener: (ProductEntity) -> Unit = {}) {
		this.productList = productList
		this.productItemClickListener = productItemClickListener
		notifyDataSetChanged()
	}


	inner class ProductItemViewHolder(
		private val binding: ItemProductBinding,
		val productItemClickListener: (ProductEntity) -> Unit
	): RecyclerView.ViewHolder(binding.root) {

		fun bindData(data: ProductEntity) = with(binding) {
			productNameTextView.text = data.productName
			productImageView.loadCenterCrop(data.productImage, 8f)
			productPriceTextView.text = "${data.productPrice}원"
		}

		fun bindViews(data: ProductEntity) {
			binding.root.setOnClickListener {
				productItemClickListener(data)
			}
		}
	}
}