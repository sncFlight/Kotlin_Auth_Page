package com.simple_auth_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.indigo.first_ui_project.DbHelper
import com.indigo.first_ui_project.MainActivity
import com.indigo.first_ui_project.User

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val loginField: EditText = findViewById(R.id.login_auth)
        val passwordField: EditText = findViewById(R.id.password_auth)
        val button: Button = findViewById(R.id.button_auth)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = loginField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (
                login == ""
                || password == ""
            ) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(this, null)
                val isSuccessAuth = db.getUser(login, password)

                if (isSuccessAuth) {
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    loginField.text.clear()
                    passwordField.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Пользователь $login не авторизован", Toast.LENGTH_LONG).show()
                }


                loginField.text.clear()
                passwordField.text.clear()
            }
        }

    }
}