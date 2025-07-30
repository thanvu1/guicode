package com.example.thuchanh1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.thuchanh1.R
import com.example.thuchanh1.models.Student

class StudentAdapter(context: Context, private val studentList: List<Student>)
    :ArrayAdapter<Student>(context, 0, studentList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_student, parent, false)
        }

        val currentStudent = getItem(position)

        val imageViewAvatar: ImageView = itemView!!.findViewById(R.id.imageViewAvatar)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewClass: TextView = itemView.findViewById(R.id.textViewClass)

        currentStudent?.let {
            imageViewAvatar.setImageResource(it.avatarResId)
            textViewName.text = it.fullName
            textViewClass.text = "Lớp: ${it.className}"
        }

        return itemView
    }
}