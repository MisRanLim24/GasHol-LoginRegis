package com.bangkit.capstone.gashol.loginregis

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.gashol.R
import com.bangkit.capstone.gashol.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@Suppress("DEPRECATION")
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    /*private lateinit var databaseReference: DatabaseReference*/
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        binding.textViewClickableLogin.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonSignUp.setOnClickListener {

            val email = binding.editTextEmail.text.toString()
            val userName = binding.editTextUserName.text.toString()
            val mobileNumber = binding.editTextMobileNum.text.toString()
            val pass = binding.editTextPassword.text.toString()
            val confirmPass = binding.editTextConfirmPassword.text.toString()

            firebaseAuth = FirebaseAuth.getInstance()


            if(TextUtils.isEmpty(email)){
                binding.editTextEmail.error = "Silahkan masukkan alamat Email anda"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(userName)){
                binding.editTextEmail.error = "Silahkan masukkan User Name anda"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(mobileNumber)){
                binding.editTextMobileNum.error = "Silahkan masukkan Nomor handphone anda"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(pass)) {
                binding.editTextPassword.error = "Silahkan masukkan Password yang anda inginkan"
                return@setOnClickListener
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextEmail.error = "Silahkan masukkan alamat Email yang valid"
                return@setOnClickListener
            }else if (pass.length < 8) {
                binding.editTextPassword.error = "Setidaknya dibutuhkan 8 karakter untuk membuat Password"
                return@setOnClickListener
            }else if (confirmPass != pass){
                binding.editTextConfirmPassword.error = "Isi dari Password dan Confirm Password harus sama"
                return@setOnClickListener
            }


            /*databaseReference = FirebaseDatabase.getInstance().getReference("Users")*/

            /*val regUserData = RegistUserData(mobileNumber, userName)
            databaseReference.child(userName).setValue(regUserData).addOnSuccessListener {*/

                firebaseAuth.createUserWithEmailAndPassword(email, pass)

                binding.editTextEmail.text.clear()
                binding.editTextUserName.text.clear()
                binding.editTextMobileNum.text.clear()
                binding.editTextPassword.text.clear()
                binding.editTextConfirmPassword.text.clear()

                Toast.makeText(this, "Berhasil membuat akun!", Toast.LENGTH_SHORT).show()
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()

           /* }.addOnFailureListener{

                Toast.makeText(this, "Gagal membuat akun, silahkan coba lagi!", Toast.LENGTH_SHORT).show()

            }*/
        }

    }
}