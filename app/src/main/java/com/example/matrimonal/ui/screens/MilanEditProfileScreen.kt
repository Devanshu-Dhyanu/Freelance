package com.example.matrimonal.ui.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain

@Composable
fun MilanEditProfileScreen(
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {

    var name by remember { mutableStateOf("Ritika Goel") }
    var city by remember { mutableStateOf("Ludhiana") }
    var education by remember {
        mutableStateOf("B.Tech Computer Science & Engineering")
    }
    var profession by remember {
        mutableStateOf("Software Engineering Student")
    }
    var about by remember {
        mutableStateOf(
            "I enjoy technology, learning new things and building meaningful relationships."
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .padding(20.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "‹",
                fontSize = 36.sp,
                color = TextMain,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Edit Profile",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text("Name")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = {
                    Text("City")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = education,
                onValueChange = { education = it },
                label = {
                    Text("Education")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            OutlinedTextField(
                value = profession,
                onValueChange = { profession = it },
                label = {
                    Text("Profession")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            OutlinedTextField(
                value = about,
                onValueChange = { about = it },
                label = {
                    Text("About Me")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(14.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                onClick = onSaveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        RosePrimary,
                        RoundedCornerShape(14.dp)
                    )
            ) {

                Text(
                    text = "Save Changes",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 7.dp)
                )
            }
        }
    }
}