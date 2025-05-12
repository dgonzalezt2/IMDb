package com.example.katas.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.katas.presentation.MainActivity
import com.example.katas.R
import com.example.katas.presentation.signup.Registro
import com.example.katas.data.model.local.AppDatabase
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {
    private lateinit var editTextUsuario: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var ButtonLogin: Button
    private lateinit var LabelInvitado: TextView
    private lateinit var labelRegistrase : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        editTextUsuario = findViewById(R.id.usuario_input)
        editTextContrasena = findViewById(R.id.contrasena_input)
        ButtonLogin = findViewById(R.id.buttonLogin)
        LabelInvitado = findViewById(R.id.labeInvitado)
        labelRegistrase = findViewById(R.id.labelRegistrase)


        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateInputs()
            }

            override fun afterTextChanged(p0: Editable?) {}


        }
        editTextUsuario.addTextChangedListener(textWatcher)
        editTextContrasena.addTextChangedListener(textWatcher)

        ButtonLogin.setOnClickListener{
            loginUser()
        }

        LabelInvitado.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        labelRegistrase.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }

    fun loginUser(){
        val email = editTextUsuario.text.toString()
        val password = editTextContrasena.text.toString()
        //verificar que los campos no  esten vacios
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Por favro, completa todos los campos ",Toast.LENGTH_SHORT).show()
        }

        //verificar las credenciales de la bd
        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(applicationContext)
            val user = db.userDao().loginUser(email,password)
            if(user!= null){
                //inicio de sesion exitoso
                val welcomeMessage = "Binevenido, ${user.name}"

                Toast.makeText(this@Login,welcomeMessage,Toast.LENGTH_SHORT).show()

                Log.d("Login",welcomeMessage)


                val intent = Intent(this@Login, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this@Login,"Credenciales incorrectas. Intenta de nuevo ",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validateInputs() {
        val usuario = editTextUsuario.text.toString()
        val contrasena = editTextContrasena.text.toString()

        ButtonLogin.isEnabled = usuario.isNotEmpty() && contrasena.isNotEmpty()

        ButtonLogin.setBackgroundColor(if (ButtonLogin.isEnabled)getColor(R.color.blackButton) else getColor(
            R.color.grayButtonAndText
        ))


    }
}