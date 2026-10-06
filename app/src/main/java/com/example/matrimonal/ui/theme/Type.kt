package com.example.matrimonal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.matrimonal.R

val PoppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 13.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 11.sp
    )
)