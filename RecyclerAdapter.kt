package com.android.example.sha2a

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.*

/**
 * Created by Mark on 4/17/2018.
 */
class RecyclerAdapter(private val list: ArrayList<AppartementClass>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val database = FirebaseDatabase.getInstance()
    val ref: DatabaseReference = database.getReference("appartement")

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        var appartementClass :AppartementClass = list[position]
        holder!!.name.text = appartementClass.renter_name
        holder.user_id.text = appartementClass.id
        holder.water_bill.text = appartementClass.water_bill
        holder.gas_bill.text = appartementClass.gas_bill
        holder.electricity.text = appartementClass.electricity
        holder.maintainance.text = appartementClass.maintenance

        holder.electButton.setOnClickListener {
            holder.adapterPosition
            appartementClass.electricity = "0"
            ref.child(appartementClass.id).child("electricity").setValue("0")
        }
        holder.waterButton.setOnClickListener {
            appartementClass.water_bill = "0"
            ref.child(appartementClass.id).child("water_bill").setValue("0")
            holder.adapterPosition
        }
        holder.maintanceButton.setOnClickListener {
            appartementClass.maintenance = "0"
            ref.child(appartementClass.id).child("maintenance").setValue("0")
            holder.adapterPosition
        }
        holder.gasButton.setOnClickListener {
            appartementClass.gas_bill = "0"
            ref.child(appartementClass.id).child("gas_bill").setValue("0")
            holder.adapterPosition
        }


        holder.newelect.setOnClickListener {
            if(holder.updateElectET.text.toString()!= "")
            {
                holder.adapterPosition

                appartementClass.electricity = holder.updateElectET.text.toString()
                ref.child(appartementClass.id).child("electricity").setValue(holder.updateElectET.text.toString())
            }
        }
        holder.newgas.setOnClickListener {
            if(holder.updategasET.text.toString()!= "")
            {
                appartementClass.gas_bill = holder.updategasET.text.toString()
                ref.child(appartementClass.id).child("gas_bill").setValue(holder.updategasET.text.toString())
                holder.adapterPosition
            }
        }
        holder.newwater.setOnClickListener {
            if(holder.updatewaterET.text.toString()!= "")
            {
                appartementClass.water_bill = holder.updatewaterET.text.toString()
                ref.child(appartementClass.id).child("water_bill").setValue(holder.updatewaterET.text.toString())
                holder.adapterPosition
            }
        }
        holder.newmaint.setOnClickListener {
            if(holder.updateMaintET.text.toString()!= "")
            {
                appartementClass.maintenance = holder.updateMaintET.text.toString()
                ref.child(appartementClass.id).child("maintenance").setValue(holder.updateMaintET.text.toString())
                holder.adapterPosition
            }
        }

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var user_id: TextView
        var water_bill: TextView
        var gas_bill: TextView
        var electricity: TextView
        var maintainance: TextView
        var electButton: Button
        var gasButton: Button
        var waterButton: Button
        var maintanceButton: Button
        var newwater : Button
        var newgas : Button
        var newelect : Button
        var newmaint : Button

        var updatewaterET : EditText
        var updategasET : EditText
        var updateElectET : EditText
        var updateMaintET : EditText


        init {
            name = itemView.findViewById(R.id.renter_name)
            user_id = itemView.findViewById(R.id.id)
            water_bill = itemView.findViewById(R.id.water_bill)
            gas_bill = itemView.findViewById(R.id.gas_bill)
            electricity = itemView.findViewById(R.id.electricity)
            maintainance = itemView.findViewById(R.id.maintenance)
            electButton = itemView.findViewById(R.id.electricity_button)
            gasButton = itemView.findViewById(R.id.gasbill_button)
            waterButton = itemView.findViewById(R.id.waterbill_button)
            maintanceButton = itemView.findViewById(R.id.maintenance_button)

            newwater = itemView.findViewById(R.id.newwater)
            newgas = itemView.findViewById(R.id.newgas)
            newelect = itemView.findViewById(R.id.newelect)
            newmaint = itemView.findViewById(R.id.newMaint)

            updatewaterET = itemView.findViewById(R.id.waterupdate)
            updategasET = itemView.findViewById(R.id.gasupdate)
            updateElectET = itemView.findViewById(R.id.electupdate)
            updateMaintET = itemView.findViewById(R.id.maintananceupdate)


        }
    }
}