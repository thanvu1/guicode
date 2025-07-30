package com.example.thuchanh1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thuchanh1.R
import com.example.thuchanh1.models.Student

class StudentRecyclerAdapter(
    private val students: MutableList<Student>,
    private val onItemClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewClass: TextView = itemView.findViewById(R.id.textViewClass)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.imageViewAvatar.setImageResource(student.avatarResId)
        holder.textViewName.text = student.fullName
        holder.textViewClass.text = "Lớp: ${student.className}"
        holder.itemView.setOnClickListener { onItemClick(student) }
    }

    override fun getItemCount(): Int = students.size

    fun addStudent(student: Student) {
        students.add(student)
        notifyItemInserted(students.size - 1)
    }
}
