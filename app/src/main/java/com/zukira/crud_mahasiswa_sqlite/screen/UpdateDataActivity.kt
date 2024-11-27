package com.zukira.crud_mahasiswa_sqlite.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zukira.crud_mahasiswa_sqlite.R
import com.zukira.crud_mahasiswa_sqlite.databinding.ActivityUpdateDataBinding
import com.zukira.crud_mahasiswa_sqlite.helper.MahasiswaDatabaseHelper
import com.zukira.crud_mahasiswa_sqlite.model.ModelDataMahasiswa

class UpdateDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateDataBinding
    private lateinit var db : MahasiswaDatabaseHelper
    private var dataId : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MahasiswaDatabaseHelper(this)

        dataId = intent.getIntExtra("data_id",-1)

        if (dataId == -1){
            finish()
            return
        }

        val data = db.getDataById(dataId)
        binding.etEditNama.setText(data.namaMahasiswa)
        binding.etEditNim.setText(data.nim)
        binding.etEditJurusan.setText(data.jurusan)

        binding.imgEdit.setOnClickListener{
            val newName = binding.etEditNama.text.toString()
            val newNim = binding.etEditNim.text.toString()
            val newJurusan = binding.etEditJurusan.text.toString()

            val updateData = ModelDataMahasiswa(dataId, newName, newNim, newJurusan)
            db.updateData(updateData)
            finish()
            Toast.makeText(this,"Data berhasil diubah", Toast.LENGTH_SHORT).show()
        }

    }
}