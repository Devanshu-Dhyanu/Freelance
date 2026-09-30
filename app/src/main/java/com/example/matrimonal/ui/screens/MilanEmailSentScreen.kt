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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

@Composable
fun MilanEmailSentScreen(
    email: String = "",
    onBackToLogin: () -> Unit = {},
    onResendEmail: () -> Unit = {},
    onOpenEmail: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(80.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(RoseLight)
                .padding(28.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✉",
                fontSize = 55.sp,
                color = RosePrimary
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Check Your Email",
            fontFamily = PoppinsFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextMain
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (email.isNotEmpty()) {
                "We've sent a password reset link to $email"
            } else {
                "We've sent a password reset link to your email address."
            },
            fontFamily = PoppinsFamily,
            fontSize = 14.sp,
            color = TextSecondary,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(RosePrimary)
                .clickable {
                    onOpenEmail()
                }
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Open Email App",
                fontFamily = PoppinsFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Didn't receive the email? ",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = TextSecondary
            )

            Text(
                text = "Resend",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = RosePrimary,
                modifier = Modifier.clickable {
                    onResendEmail()
                }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "← Back to Login",
            fontFamily = PoppinsFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = RosePrimary,
            modifier = Modifier.clickable {
                onBackToLogin()
            }
        )
    }
}