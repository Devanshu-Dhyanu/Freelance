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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

@Composable
fun MilanProfileScreen(
    onBackClick: () -> Unit = {},
    onEditProfile: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .verticalScroll(rememberScrollState())
    ) {

        // ---------------- TOP BAR ----------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
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

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Text(
                text = "My Profile",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "⚙",
                fontSize = 23.sp,
                color = TextMain,
                modifier = Modifier.clickable {
                    onSettingsClick()
                }
            )
        }

        // ---------------- PROFILE PHOTO ----------------

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .background(RoseLight)
                    .border(
                        width = 3.dp,
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "R",
                    fontFamily = PoppinsFamily,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = RosePrimary
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Ritika Goel, 21",
                fontFamily = PoppinsFamily,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = "Ludhiana, Punjab",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = TextSecondary
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // ---------------- PROFILE STATS ----------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            MilanProfileStat(
                number = "12",
                label = "Likes",
                modifier = Modifier.weight(1f)
            )

            MilanProfileStat(
                number = "8",
                label = "Matches",
                modifier = Modifier.weight(1f)
            )

            MilanProfileStat(
                number = "5",
                label = "Chats",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // ---------------- ABOUT ----------------

        MilanProfileSection(
            title = "About Me",
            content = "I am a software engineering student who enjoys technology, learning new things and building meaningful relationships."
        )

        // ---------------- EDUCATION ----------------

        MilanProfileSection(
            title = "Education",
            content = "B.Tech Computer Science & Engineering"
        )

        // ---------------- PROFESSION ----------------

        MilanProfileSection(
            title = "Profession",
            content = "Software Engineering Student"
        )

        // ---------------- LOCATION ----------------

        MilanProfileSection(
            title = "Location",
            content = "Punjab, India"
        )

        // ---------------- INTERESTS ----------------

        MilanProfileSection(
            title = "Interests",
            content = "Technology • Travel • Music • Reading"
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // ---------------- EDIT PROFILE BUTTON ----------------

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(RosePrimary)
                .clickable {
                    onEditProfile()
                }
                .padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Edit Profile",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )
    }
}


// ============================================================
// PROFILE STAT
// ============================================================

@Composable
private fun MilanProfileStat(
    number: String,
    label: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = RoseBorder,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = number,
            fontFamily = PoppinsFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = RosePrimary
        )

        Spacer(
            modifier = Modifier.height(3.dp)
        )

        Text(
            text = label,
            fontFamily = PoppinsFamily,
            fontSize = 11.sp,
            color = TextSecondary
        )
    }
}


// ============================================================
// PROFILE SECTION
// ============================================================

@Composable
private fun MilanProfileSection(
    title: String,
    content: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 8.dp
            )
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {

        Text(
            text = title,
            fontFamily = PoppinsFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = RosePrimary
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            text = content,
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = TextMain
        )
    }
}