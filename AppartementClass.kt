package com.android.example.sha2a

/**
 * Created by Mark on 4/17/2018.
 */
data class AppartementClass
(

    var id:String,
    var renter_name:String,
    var gas_bill:String,
    var water_bill:String,
    var electricity:String,
    var maintenance:String)
{
    constructor(): this("","","","","",""
           )
}

