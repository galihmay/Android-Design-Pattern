package com.galihmayangga.android.ui.auth

import android.content.Context
import android.widget.ActionMenuView
import com.galihmayangga.android.data.model.ActionState
import com.galihmayangga.android.data.repository.AuthRepository
import kotlinx.coroutines.*

object AndroidDesignPatternAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null ) {
      val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}