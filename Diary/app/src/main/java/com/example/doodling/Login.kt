package com.example.doodling

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity() {

    //id_text,pw_text
    var auth : FirebaseAuth?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            joinAndLogin()
        }
    }

    fun joinAndLogin(){
        auth?.createUserWithEmailAndPassword(id_text.text.toString(),pw_text.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    movePage(task.result?.user)
                }else{
                    signinEmail()
                }
            }
    }

    fun signinEmail(){
        auth?.signInWithEmailAndPassword(id_text.text.toString(),pw_text.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    //Login
                    movePage(task.result?.user)
                } else{
                    //show the error message
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
                }
            }
    }

    fun movePage(user:FirebaseUser?){
        if (user != null){ // 유저가 존재할 때
            val intent = Intent(this,Main::class.java)
            startActivity(intent)
            finish()
        }
    }


}