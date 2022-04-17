package com.dashingqi.coroutine.select

import android.util.Log
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/4/16 21:03
 */

private const val TAG = "SelectMain"

fun selectMethod() = runBlocking {

    val startTime = System.currentTimeMillis()
    val productId = "xxxID"

    val cacheDeferred = async {
        getCacheInfo(productId)
    }

    val latestDeferred = async {
        getNetworkInfo(productId)
    }


    val product = select<Product?> {
        cacheDeferred.onAwait {
            it?.copy(isCache = true)
        }

        latestDeferred.onAwait {
            it?.copy(isCache = false)
        }
    }

    product?.let {
        updateUI(it)
        Log.d(TAG, "Time cost :${System.currentTimeMillis() - startTime}")

        if (it.isCache) {
            val latest = latestDeferred.await() ?: return@runBlocking
            updateUI(latest)
            Log.d(TAG, "Time cost: ${System.currentTimeMillis() - startTime}")
        }
    }

}

suspend fun getCacheInfo(productId: String): Product? {
    Log.d(TAG, "getCacheInfo perform currentThread is ${Thread.currentThread().name}")
    delay(100L)
    return Product(productId, 9.9)

}

suspend fun getNetworkInfo(productId: String): Product? {
    Log.d(TAG, "getNetworkInfo perform currentThread is ${Thread.currentThread().name}")
    delay(200L)
    return Product(productId, 9.8)
}

fun updateUI(product: Product) {
    Log.d(TAG, "${product.productId} == ${product.price}")
}

data class Product(
    val productId: String,
    val price: Double,
    val isCache: Boolean = false
)