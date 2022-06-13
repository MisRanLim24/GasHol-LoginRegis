package com.bangkit.capstone.gashol.loginregis

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.gashol.R
import com.bangkit.capstone.gashol.TestActivity
import com.bangkit.capstone.gashol.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textViewClickableSignUp.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonLogin.setOnClickListener{
            val email =binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()

            if (TextUtils.isEmpty(email.trim())){
                binding.editTextEmail.error = "Silahkan masukkan e-mail anda"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(pass.trim())){
                binding.editTextPassword.error = "Silahkan masukkan password anda"
                return@setOnClickListener
            }

            firebaseAuth.signInWithEmailAndPassword(
                email.trim(),
                pass.trim())
                .addOnCompleteListener{
                    Log.d("tst", "tst", it.exception)
                    if (it.isSuccessful){
                        val intent = Intent(this, TestActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Gagal Login, silahkan coba lagi!", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}