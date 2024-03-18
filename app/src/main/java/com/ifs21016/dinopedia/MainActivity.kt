package com.ifs21016.dinopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvDinos: RecyclerView
    private val list = arrayListOf<Dino>()


    // nanti akhiran coba pake binding
    //private lateinit var binding: ActivityMainBinding

    // Buat apa?
    private fun showSelectedDino(dino: Dino) {
        Toast.makeText(this, "Kamu memilih " + dino.name, Toast.LENGTH_SHORT).show()
//        Log.v("MainActivity", "dinoIsTouched")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDinos = findViewById(R.id.rv_dinos)
        rvDinos.setHasFixedSize(true)

        // menambahkan data dino dari array list dino ke variabel list
        list.addAll(getListDinos())
        showRecyclerList()

        // Tombol pindah ke halaman about me
        val btnAboutMe: Button = findViewById(R.id.btn_about_page)
        btnAboutMe.setOnClickListener{
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
    }



    // Mengambil data dino dari data array dan memasukkannya pada sebuah array list bertipe dino
    private fun getListDinos(): ArrayList<Dino> {
        // mengambil seluruh data dari array
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescPreview = resources.getStringArray(R.array.data_desc_list)
        val dataDescription = resources.getStringArray(R.array.data_desc_detail)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val dataEra = resources.getStringArray(R.array.karakteristik)
        val dataYear = resources.getStringArray(R.array.kelompok)
        val dataType = resources.getStringArray(R.array.habitat)
        val dataDiet = resources.getStringArray(R.array.makanan)
        val dataRegion = resources.getStringArray(R.array.kelemahan)
        val dataWeight = resources.getStringArray(R.array.data_weight)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataLength = resources.getStringArray(R.array.data_length)
        val listDino = arrayListOf<Dino>()

        // memasukkan data ke array list dino
        for (i in dataName.indices) {
            val dino = Dino(dataName[i], dataDescPreview[i], dataDescription[i], dataEra[i], dataYear[i], dataType[i], dataDiet[i], dataRegion[i], dataWeight[i], dataHeight[i], dataLength[i], dataImg.getResourceId(i, -1))
            listDino.add(dino)
        }

        // mengembalikan array list yang sudah berisikan semua data dino
        return  listDino
    }

    private fun showRecyclerList() {
        rvDinos.layoutManager = LinearLayoutManager(this)
        val listDinoAdapter = ListDinoAdapter(list)
        rvDinos.adapter = listDinoAdapter


        // Buat apa?
        listDinoAdapter.setOnItemClickCallback(object : ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data)

                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra(DetailActivity.EXTRA_DINO, data)
                startActivity(detailIntent)
            }
        })

    }
}