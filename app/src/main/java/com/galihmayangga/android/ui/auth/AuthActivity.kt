package com.galihmayangga.android.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.databinding.DataBindingUtil
import com.galihmayangga.android.R
import com.galihmayangga.android.data.model.AuthUser
import com.galihmayangga.android.databinding.ActivityAuthBinding
import com.galihmayangga.android.ui.home.MainActivity


class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user: AuthUser?) {
    val intent = Intent(this, MainActivity::class.java)
   startActivity(intent)
        finish()
    }
}