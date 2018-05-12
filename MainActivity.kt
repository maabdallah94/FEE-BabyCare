package com.android.example.sha2a

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.TestOnly

class MainActivity : AppCompatActivity() {
    @TestOnly

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //owner clicked, move to the owner activity
        owner_button.setOnClickListener{
            val intent: Intent = Intent(this@MainActivity,OwnerLoginActivity::class.java)
            startActivity(intent)
        }

        //renter clicked, move to renter activity
        renter_button.setOnClickListener{
            val intent: Intent = Intent(this@MainActivity,RenterLogin::class.java)
            startActivity(intent)
        }


    }

    override fun onPause() {
        super.onPause()
    }

}
