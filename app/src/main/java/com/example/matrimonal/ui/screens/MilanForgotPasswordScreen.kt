package com.example.matrimonal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextPlaceholder
import com.example.matrimonal.ui.theme.TextSecondary

@Composable
fun MilanForgotPasswordScreen(
    onBackClick: () -> Unit = {},
    onSendResetLink: () -> Unit = {}
) {
    var email by remember {
        mutableStateOf("")
    }

    var showError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .padding(horizontal = 24.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "‹",
                fontSize = 38.sp,
                color = TextMain,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Back to login",
                fontFamily = PoppinsFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = TextMain
            )
        }

        Spacer(modifier = Modifier.height(45.dp))
//
//        Box(
//            modifier = Modifier
//                .size(78.dp)
//                .clip(RoundedCornerShape(24.dp))
//                .background(Color.White)
//                .border(
//                    1.dp,
//                    RoseBorder,
//                    RoundedCornerShape(24.dp)
//                ),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = "✉",
//                fontSize = 36.sp,
//                color = RosePrimary
//            )
//        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Forgot your password?",
            fontFamily = PoppinsFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextMain
        )

        Spacer(modifier = Modifier.height(8.dp))



        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Email Address",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextMain
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
                showError = false
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Enter your email",
                    fontFamily = PoppinsFamily,
                    color = TextPlaceholder
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = RosePrimary
            )
        )

        if (showError) {
            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Please enter a valid email address.",
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(RosePrimary)
                .clickable {
                    if (email.contains("@") && email.contains(".")) {
                        onSendResetLink()
                    } else {
                        showError = true
                    }
                }
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Send Reset Link",
                fontFamily = PoppinsFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onBackClick()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Text(
//                text = "← ",
//                fontSize = 17.sp,
//                color = RosePrimary
//            )
//
//            Text(
//                text = "Back to Login",
//                fontFamily = PoppinsFamily,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = RosePrimary
//            )
        }
    }
}