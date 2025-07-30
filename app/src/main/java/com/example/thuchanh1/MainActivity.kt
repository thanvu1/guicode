package com.example.thuchanh1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.thuchanh1.adapter.StudentRecyclerAdapter
import com.example.thuchanh1.models.Student
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottieView = findViewById<LottieAnimationView>(R.id.lottieView)
        val recyclerViewStudents: RecyclerView = findViewById(R.id.recyclerViewStudents)
        val fabAddStudent: FloatingActionButton = findViewById(R.id.fabAddStudent)
        recyclerViewStudents.layoutManager = LinearLayoutManager(this)

        // Tạo dữ liệu sinh viên mẫu
        val students = mutableListOf(
            Student(R.drawable.svnam, "Nguyễn Văn A", "KTPM2025"),
            Student(R.drawable.svnam, "Trần Thị B", "HTTT2024"),
            Student(R.drawable.svnam, "Lê Minh C", "CNTT2023"),
            Student(R.drawable.svnam, "Phạm Thị D", "ATTT2025"),
            Student(R.drawable.svnam, "Hoàng Gia E", "KTPM2024")
        )

        val adapter = StudentRecyclerAdapter(students) { clickedStudent ->
            Toast.makeText(this, "Bạn đã chọn: ${clickedStudent.fullName}", Toast.LENGTH_SHORT).show()
        }
        recyclerViewStudents.adapter = adapter

        fabAddStudent.setOnClickListener {
            val newStudent = Student(R.drawable.svnam, "Sinh viên mới", "Lớp mới")
            adapter.addStudent(newStudent)
            recyclerViewStudents.smoothScrollToPosition(adapter.itemCount - 1)
        }
    }
}