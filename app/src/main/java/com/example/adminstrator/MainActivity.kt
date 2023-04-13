package com.example.adminstrator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminstrator.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    private var database:DatabaseReference?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        var id: String? = null
        database = FirebaseDatabase.getInstance().reference
        database?.child("Pending Request")?.get()?.addOnSuccessListener { dataSnapshot ->

            binding?.registrationNumber?.text = (dataSnapshot?.key).toString()

        }
            database?.child(id.toString())?.get()?.addOnSuccessListener {
                val endDate = it.child("endDate").value
                val parentsName = it.child("parentsName").value
                val registrationNo = it.child("registrationNo").value
                val startDate = it.child("startDate").value
                val studentsName = it.child("studentsName").value
                binding?.parentName?.text = parentsName.toString()
                binding?.studentName?.text = studentsName.toString()
                binding?.registrationNumber?.text = registrationNo.toString()
                binding?.tvStart?.text = startDate.toString()
                binding?.tvEnd?.text = endDate.toString()
            }
        }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    }


