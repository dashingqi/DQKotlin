package com.dashingqi.process.ipc

import android.content.Context
import android.os.Bundle

/**
 * 通过Provider调用到主进程
 */
fun callOnMainProcessByProvider(
    context: Context, params: Bundle, delegate: Class<out AbsDelegateProvider>
): DelegateResult {
    val bundleResult = runCatching {
       context.contentResolver.call(
            IpcMainProcessDelegateProvider.PROVIDER_URI, delegate.name, null, params
        )
    }.onFailure {
        it.message.logD()
    }.getOrNull()
    bundleResult ?: return DelegateResult(resultCode = DelegateResultCode.UN_KNOW_ERROR_CODE)
    return DelegateResult(resultCode = bundleResult.getInt(KEY_RESULT_CODE))
}