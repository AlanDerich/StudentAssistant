package com.eujoh.student_assistant.my_profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eujoh.student_assistant.R
import com.eujoh.student_assistant.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "ProfileActivity"
    lateinit var mUser: User
    lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        floatingActionButton_profile.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.floatingActionButton_profile ->{
                startActivity(Intent(this,EditProfileActivity::class.java))
            }
        }
    }
}
