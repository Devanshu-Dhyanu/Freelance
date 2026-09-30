package com.example.matrimonal.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextPlaceholder
import com.example.matrimonal.ui.theme.TextSecondary

@Composable
fun MilanResetPasswordScreen(
    onPasswordReset: () -> Unit = {},
    onBackToLogin: () -> Unit = {}
) {

    var newPassword by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var newPasswordVisible by remember {
        mutableStateOf(false)
    }

    var confirmPasswordVisible by remember {
        mutableStateOf(false)
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

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Reset Password",
            fontFamily = PoppinsFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextMain
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Create a new password for your Milan account.",
            fontFamily = PoppinsFamily,
            fontSize = 14.sp,
            color = TextSecondary,
            lineHeight = 22.sp
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // New Password Label
        Text(
            text = "New Password",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextMain
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // New Password Field
        TextField(
            value = newPassword,
            onValueChange = {
                newPassword = it
                showError = false
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Enter new password",
                    fontFamily = PoppinsFamily,
                    color = TextPlaceholder
                )
            },
            visualTransformation =
                if (newPasswordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            trailingIcon = {
                Text(
                    text = if (newPasswordVisible) "Hide" else "Show",
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RosePrimary,
                    modifier = Modifier.clickable {
                        newPasswordVisible = !newPasswordVisible
                    }
                )
            },
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = RosePrimary
            )
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        // Confirm Password Label
        Text(
            text = "Confirm Password",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextMain
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // Confirm Password Field
        TextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                showError = false
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Confirm new password",
                    fontFamily = PoppinsFamily,
                    color = TextPlaceholder
                )
            },
            visualTransformation =
                if (confirmPasswordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            trailingIcon = {
                Text(
                    text = if (confirmPasswordVisible) "Hide" else "Show",
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RosePrimary,
                    modifier = Modifier.clickable {
                        confirmPasswordVisible = !confirmPasswordVisible
                    }
                )
            },
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = RosePrimary
            )
        )

        // Error Message
        if (showError) {

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text =
                    if (newPassword.length < 8) {
                        "Password must contain at least 8 characters."
                    } else {
                        "Passwords do not match."
                    },
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = Color.Red
            )
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // Reset Password Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(14.dp)
                )
                .background(RosePrimary)
                .clickable {

                    if (
                        newPassword.length < 8 ||
                        newPassword != confirmPassword
                    ) {
                        showError = true
                    } else {
                        onPasswordReset()
                    }
                }
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Reset Password",
                fontFamily = PoppinsFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // Back To Login
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onBackToLogin()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "← Back to Login",
                fontFamily = PoppinsFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = RosePrimary
            )
        }
    }
}