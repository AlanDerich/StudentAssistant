package com.eujoh.student_assistant.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.eujoh.student_assistant.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_password_reset.*

class PasswordReset : AppCompatActivity() {

    private var firebaseAuth: FirebaseAuth? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        firebaseAuth = FirebaseAuth.getInstance()

        reset_btn.setOnClickListener {
            ResetPassword()
        }
        login_btn_reset.setOnClickListener {
            var intent = Intent(Intent(this@PasswordReset,LogInActivity::class.java))
            startActivity(intent)
        }
        signup_btn_reset.setOnClickListener{
            var intent = Intent(Intent(this@PasswordReset,RegisterActivity::class.java))
            startActivity(intent)
        }
    }
    private fun ResetPassword(){
        val email = reset_email_txt?.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(applicationContext,"Please Enter Your Email", Toast.LENGTH_SHORT).show()
        }else{
            firebaseAuth?.sendPasswordResetEmail(email)?.addOnCompleteListener(object : OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {
                    if (task.isSuccessful){
                        Toast.makeText(applicationContext,"Please check your Email for Reset Password",Toast.LENGTH_SHORT).show()
                    }else{
                        val error = task.exception?.message
                        Toast.makeText(applicationContext,"Error "+ error,Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
