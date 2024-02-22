package com.simple_auth_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.indigo.first_ui_project.DbHelper
import com.indigo.first_ui_project.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginField: EditText = findViewById(R.id.login)
        val emailField: EditText = findViewById(R.id.email)
        val passwordField: EditText = findViewById(R.id.password)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val login = loginField.text.toString().trim()
            val email = emailField.text.toString().trim();
            val password = passwordField.text.toString().trim()

            if (
                login == ""
                || email == ""
                || password == ""
            ) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else {
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                loginField.text.clear()
                emailField.text.clear()
                passwordField.text.clear()
            }
        }
    }
}