package com.android.example.sha2a

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_owner_login.*

class OwnerLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_login)

        admin_login.setOnClickListener {
            if(admin_id.text.toString() == "admin_admin" && admin_password.text.toString() == "123456789")
            {
                    val intent: Intent = Intent(this@OwnerLoginActivity,OwnerActivity::class.java)
                    startActivity(intent)
            }
        }

    }
}
