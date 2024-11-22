package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SectionHeader(){
    Box(modifier = Modifier.fillMaxWidth()
        .background(color = Color.Blue)
    )
    {
        Row (
            modifier = Modifier.padding(15.dp)
        )
        {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = " ",
                    Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }

            Column(Modifier.padding(15.dp))
            {
                Text(text = "Halo",
                    color = Color.White)
                Spacer(Modifier.padding (3.dp))
                Text(text = "VINA RAHMA VIONITA",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                        ),
                    )
            }
            Icon(
                Icons.Filled.Notifications,
                contentDescription = " ",
                Modifier.padding(end = 13.dp),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun Screen(modifier: Modifier = Modifier) {

   Column (
       modifier = modifier.fillMaxSize()
   ) {
       Spacer(modifier = Modifier.padding(5.dp)) //memberi jarak kosong antara komponen UI
       Text(text = "Masukkan Biodata Kamu!",
           style = TextStyle(
               fontSize = 15.sp,
               fontWeight = FontWeight.Bold,
               color = Color.Black,
           ),
       )

       Spacer(modifier = Modifier.padding(top = 5.dp))
       Text(text = " Silahkan isi data dengan sebenar benarnya",
           style = TextStyle(
               fontSize = 15.sp,
               color = Color.Gray,
           )
       )
   }

    var email by remember { mutableStateOf(" ") }
    var alamat by remember { mutableStateOf(" ") }
    var noHp by remember { mutableStateOf(" ") }
    var selectedThn by remember { mutableStateOf(" ") }

    val Tahun = listOf("2020", "2021", "2022")

    //Data Pengguna yang Tersimpan
    var emailUser by remember { mutableStateOf(" ") }
    var alamatUser by remember { mutableStateOf(" ") }
    var noHpUser by remember { mutableStateOf(" ") }
    var selectedThnUser by remember { mutableStateOf(" ") }

    Box (Modifier.fillMaxWidth() //Mengisi seluruh ukuran layar
        .padding(top = 50.dp)
        .background(color = Color.Gray)

    )
    {
        Column {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Masukkan Email") },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)

            )

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                placeholder = { Text("Masukkan Alamat") },
                label = { Text("Alamat") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
            )

            OutlinedTextField(
                value = noHp,
                onValueChange = { noHp = it },
                placeholder = { Text("Masukkan NoHP") },
                label = { Text("NoHp") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
            )

            Text(
                text = "Tahun Masuk : ",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )

            Row() {
                Tahun.forEach { item -> //loop
                    Row(verticalAlignment = Alignment.CenterVertically) //agar sejajar dengan radio button
                    {
                        RadioButton(selected = selectedThn == item,
                            onClick = {
                                selectedThn = item //variable item untuk menyimpan nilai tahun
                            })
                        Text(item)
                    }
                }

            }

            Card(modifier.size(height = 400.dp, width = 300.dp)) {
                CardSection(judulParam = "Email", isiParam = emailUser)
                CardSection(judulParam = "Alamat", isiParam = alamatUser)
                CardSection(judulParam = "NoHp", isiParam = noHpUser)
                CardSection(judulParam = "Jenis Kelamin", isiParam = selectedThnUser)
            }
        }
    }
}


@Composable
fun CardSection (judulParam:String, isiParam:String) {

    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(10.dp)
    ) // Mengatur agar elemen di dalam Column sejajar ke kiri
    {
        Row(
            modifier = Modifier.fillMaxWidth() //Row mengisi seluruh lebar yang tersedia
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
            //Mengatur jarak antar elemen di dalam Row agar sejajar
        )
        {
            Text(text = judulParam, modifier = Modifier.weight(0.8f)) //jarak 0,8f
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            ) //Menampilkan teks ":" sebagai pemisah antara judul dan nilai.
            Text(
                text = "$isiParam", //Menampilkan nilai yang diterima dari parameter isiParam
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        SectionHeader() // Menampilkan header
        Screen() // Menampilkan form biodata
    }
}







