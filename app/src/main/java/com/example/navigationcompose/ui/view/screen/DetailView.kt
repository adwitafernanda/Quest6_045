package com.example.navigationcompose.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

@Composable
fun DetailView(
    dataMHS: Mahasiswa,
    dataKRS: RencanaStudi,
    onBackButtonClicked: () -> Unit
){
    val listDataMHS = listOf(
        Pair("NIM", dataMHS.nim),
        Pair("Nama", dataMHS.nama),
        Pair("Email", dataMHS.email)
    )
    val listDataKRS = listOf(
        Pair("Mata Kuliah", dataKRS.mataKuliah),
        Pair("Kelas", dataKRS.kelas)
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = "Detail Data Mahasiswa",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,

            )
        HorizontalDivider()
        listDataMHS.forEach { data ->
            DetailMHS(
                judul = data.first,
                isinya = data.second
            )
        }

        listDataKRS.forEach { data ->
            DetailMHS(
                judul = data.first,
                isinya = data.second
            )
        }

        Button (
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onBackButtonClicked()
            }
        ) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun DetailMHS(
    judul: String,
    isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(top = 2.dp)
        ) {
            Text(
                text = judul,
                modifier = Modifier.weight(1f)
            )
            Text(text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(text = isinya,
                modifier = Modifier.weight(2f)
            )
        }
    }
}