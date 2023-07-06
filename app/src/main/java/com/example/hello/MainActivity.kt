package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hello.databinding.ActivityLoginBinding
import com.example.hello.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            clearErrors()
            validateSignUp()
        }
    }




    fun validateSignUp() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmation = binding.etPasswordConfirmation.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }

        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }

        if (password.isBlank()) {
            binding.tilEmail.error = "Password is required"
            error = true
        }

        if (confirmation.isBlank()) {
            binding.tilPasswordConfirmation.error = "Password confirmation is required"
            error = true
        }

        if (password != confirmation) {
            binding.tilPasswordConfirmation.error = "Password and confirmation do not match"
            error = true
        }

        if (!error) {
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun clearErrors() {
        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilPasswordConfirmation.error = null
    }
}