package com.soten.moco.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<DB : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
) : AppCompatActivity() {

    protected lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()

        initViews()
        bindViews()
        observeData()
    }
    
    open fun initViews() = Unit
    open fun bindViews() = Unit
    open fun observeData() = Unit

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)

        binding.lifecycleOwner = this
    }
}
