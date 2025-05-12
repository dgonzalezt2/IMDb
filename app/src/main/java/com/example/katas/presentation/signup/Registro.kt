package com.example.katas.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.katas.R
import com.example.katas.data.model.local.AppDatabase
import com.example.katas.data.model.local.entity.User
import com.example.katas.presentation.login.Login
import kotlinx.coroutines.launch

class Registro : AppCompatActivity() {
    lateinit var inputNombre: EditText
    lateinit var inputCorreo: EditText
    lateinit var inputContrasena: EditText
    lateinit var buttonAceptarRegistro: Button
    private lateinit var  btnRegresarLogin : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        inputNombre = findViewById(R.id.inputNombre)
        inputCorreo = findViewById(R.id.inputCorreo)
        inputContrasena = findViewById(R.id.inputContrasena)
        buttonAceptarRegistro = findViewById(R.id.buttonAceptarRegistro)
        btnRegresarLogin = findViewById(R.id.btnRegresarLogin)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateInputs()
            }

            override fun afterTextChanged(p0: Editable?) {}


        }
        inputNombre.addTextChangedListener(textWatcher)
        inputCorreo.addTextChangedListener(textWatcher)
        inputContrasena.addTextChangedListener(textWatcher)

        buttonAceptarRegistro.setOnClickListener{

            registerUser()
        }
        btnRegresarLogin.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }


    fun registerUser(){
        val nombre = inputNombre.text.toString()
        val correo = inputCorreo.text.toString()
        val contrasena = inputContrasena.text.toString()


        if(nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()){
            Toast.makeText(this,"por favor complete todo los campos ",Toast.LENGTH_SHORT).show()
            return
        }

        val user = User(name = nombre, email = correo, password = contrasena)

        // insertamos el usuario en la bd con corutinas
        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(applicationContext)
            db.userDao().registerUser(user)
            Toast.makeText(this@Registro, "Usuario regsitrado con exito",Toast.LENGTH_SHORT).show()
            // Redirgir al usuario al login despues de registrarse
            val intent = Intent(this@Registro, Login::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun validateInputs() {
        val nombre = inputNombre.text
        val correo = inputCorreo.text
        val contrasena = inputContrasena.text

        buttonAceptarRegistro.isEnabled = nombre.isNotEmpty() && correo.isNotEmpty() &&  contrasena.isNotEmpty()

        buttonAceptarRegistro.setBackgroundColor(
            if (buttonAceptarRegistro.isEnabled) getColor(R.color.blackButton) else getColor(
                R.color.grayButtonAndText
            )
        )
    }
}