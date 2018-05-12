package com.android.example.sha2a

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.card_layout.*

class OwnerActivity : AppCompatActivity() {


    val database = FirebaseDatabase.getInstance()
    val ref: DatabaseReference = database.getReference("appartement")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner)

        lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>

         var layoutManager: RecyclerView.LayoutManager? = null
        layoutManager = LinearLayoutManager(this)
        var recyclerView: RecyclerView
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = layoutManager

        val mylist: ArrayList<AppartementClass> = ArrayList<AppartementClass>()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {


                for (e in p0!!.children)
                {
                    var appartement = AppartementClass()

                    appartement.renter_name = p0.child(e.key).child("renter_name").value!!.toString()
                    appartement.id = p0.child(e.key).child("id").value!!.toString()
                    appartement.water_bill = p0.child(e.key).child("water_bill").value!!.toString()
                    appartement.gas_bill = p0.child(e.key).child("gas_bill").value!!.toString()
                    appartement.electricity = p0.child(e.key).child("electricity").value!!.toString()
                    appartement.maintenance = p0.child(e.key).child("maintenance").value!!.toString()
                    mylist.add(appartement)


                }
                adapter = RecyclerAdapter(mylist)
                recyclerView.adapter = adapter

            }


        }

        )




    }
}
