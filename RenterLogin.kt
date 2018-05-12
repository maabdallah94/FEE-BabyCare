package com.android.example.sha2a

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_renter_login.*


class RenterLogin : AppCompatActivity() {
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("appartement")
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renter_login)
        val mylist: ArrayList<AppartementClass> = ArrayList<AppartementClass>()

        renter_login.setOnClickListener {
           myRef.addValueEventListener(object : ValueEventListener{
               override fun onCancelled(p0: DatabaseError?) {
               }

               override fun onDataChange(p0: DataSnapshot?) {

                    if(validate())
                    {
                    if(admin_id.text.toString() == admin_password.text.toString() )
                    {

                        if(p0!!.child(admin_id.text.toString()).exists())
                        {
                            var appartement = AppartementClass()

                            appartement.renter_name = p0.child(admin_id.text.toString()).child("renter_name").value!!.toString()
                            appartement.id = p0.child(admin_id.text.toString()).child("id").value!!.toString()
                            appartement.water_bill = p0.child(admin_id.text.toString()).child("water_bill").value!!.toString()
                            appartement.gas_bill = p0.child(admin_id.text.toString()).child("gas_bill").value!!.toString()
                            appartement.electricity = p0.child(admin_id.text.toString()).child("electricity").value!!.toString()
                            appartement.maintenance = p0.child(admin_id.text.toString()).child("maintenance").value!!.toString()
                            mylist.add(appartement)


                            renter_name.text = appartement.renter_name
                            gas_bill.text = appartement.gas_bill
                            water_bill.text = appartement.water_bill
                            id.text = appartement.id
                            electricity.text = appartement.electricity
                            maintenance.text = appartement.maintenance

                        }
                        }
                    }

               }
           })

        }
    }
    private fun validate(): Boolean {
        var valid = true
        if (TextUtils.isEmpty(admin_id.text.toString())) {
            admin_id.error =  "Enter user id"
            valid = false
        }
        if (TextUtils.isEmpty(admin_password.text.toString())) {
            admin_password.error = "Enter user password"
            valid = false
        }

        return valid
    }
}
