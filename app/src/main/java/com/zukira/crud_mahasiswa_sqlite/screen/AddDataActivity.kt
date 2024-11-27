package com.zukira.crud_mahasiswa_sqlite.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zukira.crud_mahasiswa_sqlite.R
import com.zukira.crud_mahasiswa_sqlite.databinding.ActivityAddDataBinding
import com.zukira.crud_mahasiswa_sqlite.helper.MahasiswaDatabaseHelper
import com.zukira.crud_mahasiswa_sqlite.model.ModelDataMahasiswa

class AddDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddDataBinding
    private lateinit var db: MahasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MahasiswaDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val nama = binding.namaEditText.text.toString()
            val nim = binding.nimEditText.text.toString()
            val jurusan = binding.jurusanEditText.text.toString()

            val data = ModelDataMahasiswa(0, nama,nim,jurusan)

            db.insertData(data)
            finish()
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}