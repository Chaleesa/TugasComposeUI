package com.example.halamanprofil

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfilScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF6650a4)),
                tint = Color.White
            )
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Alchalisa Fathinna",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "NIM: 245150407111066",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = "Sistem Informasi - FILKOM UB",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Email -> buka aplikasi email
            KontakItem(icon = Icons.Default.Email, label = "Email") {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:alchalisafathinna@gmail.com")
                }
                context.startActivity(intent)
            }

            KontakItem(icon = Icons.Default.Phone, label = "Telepon") {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:082282713297")
                }
                context.startActivity(intent)
            }

            KontakItem(icon = Icons.Default.Place, label = "Lokasi") {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://maps.app.goo.gl/6meUnEhEChknAFgu8")
                }
                context.startActivity(intent)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = { /* aksi hubungi */ }) {
                Text("Hubungi")
            }
            Button(onClick = { /* aksi bagikan */ }) {
                Text("Bagikan Profil")
            }
        }
    }
}

@Composable
fun KontakItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFE7E0EC))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFF6650a4)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilScreen() {
    ProfilScreen()
}