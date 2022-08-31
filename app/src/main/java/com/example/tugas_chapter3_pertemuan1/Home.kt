package com.example.tugas_chapter3_pertemuan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Home : AppCompatActivity() {
    lateinit var inputUmur : EditText
    lateinit var inputTinggi : EditText
    lateinit var inputBerat : EditText
    lateinit var buttonHitung : Button
    lateinit var buttonReset : Button

    lateinit var umur : TextView
    lateinit var tinggi : TextView
    lateinit var berat : TextView
    lateinit var bmi : TextView
    lateinit var kategori : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        umur = findViewById(R.id.hasilUmur)
        tinggi = findViewById(R.id.hasilTinggi)
        berat = findViewById(R.id.hasilBerat)

        umur.text = inputUmur.toString()
        tinggi.text = inputTinggi.toString()
        berat.text = inputBerat.toString()

        buttonHitung.setOnClickListener(){
            hitungHasil()
        }
        reset()
    }
    fun hitungHasil(){
        inputUmur = findViewById(R.id.editTextNumber)
        inputTinggi = findViewById(R.id.editTextNumber2)
        inputBerat = findViewById(R.id.editTextNumber3)
        buttonHitung = findViewById(R.id.button)
        buttonReset = findViewById(R.id.button2)
        bmi = findViewById(R.id.hasilBMI)
        kategori = findViewById(R.id.hasilKategori)

        val tinggiBadan = inputTinggi.toString()
        val beratBadan = inputBerat.toString()
        val kalkulasiTinggi = tinggiBadan.toDouble() / 100
        val totalBMI = beratBadan.toDouble() / (kalkulasiTinggi * kalkulasiTinggi)

        bmi.text = totalBMI.toString()
        if (totalBMI < 16){
            kategori.text = "Terlalu Kurus"
        }else if (totalBMI in 16.0..17.0){
            kategori.text = "Cukup Kurus"
        }else if (totalBMI in 17.1..18.5){
            kategori.text = "Sedikit Kurus"
        }else if (totalBMI in 18.6..25.0){
            kategori.text = "Normal"
        }else if (totalBMI in 25.1..30.0){
            kategori.text = "Gemuk"
        }else if (totalBMI in 30.1..35.0){
            kategori.text = "Obesitas Kelas 1"
        }else if (totalBMI in 35.1..40.0){
            kategori.text = "Obesitas Kelas 2"
        }else{
            kategori.text = "Obesitas Kelas 3"
        }

    }
    fun reset(){
        buttonReset.setOnClickListener  {
            inputUmur.setText("")
            inputTinggi.setText("")
            inputBerat.setText("")

            umur.setText("0 tahun")
            tinggi.setText("0 cm")
            berat.setText("0 Kg")
            bmi.setText("0")
            kategori.setText("")
        }
        }

}