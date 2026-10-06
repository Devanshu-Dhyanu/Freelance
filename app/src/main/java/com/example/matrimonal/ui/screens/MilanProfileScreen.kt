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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun MilanProfileScreen(
    onBackClick: () -> Unit = {},
    onEditProfileClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // =========================================================
        // TOP BAR
        // =========================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 14.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "‹",
                    fontSize = 34.sp,
                    color = TextMain,
                    modifier = Modifier
                        .clickable {
                            onBackClick()
                        }
                        .padding(end = 12.dp)
                )

                Text(
                    text = "My Profile",
                    fontFamily = PoppinsFamily,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "⚙",
                    fontSize = 23.sp,
                    color = TextMain,
                    modifier = Modifier
                        .clickable {
                            onSettingsClick()
                        }
                        .padding(6.dp)
                )
            }
        }

        // =========================================================
        // PROFILE HEADER
        // =========================================================

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(112.dp)
                        .clip(CircleShape)
                        .background(RoseLight),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "R",
                        fontFamily = PoppinsFamily,
                        fontSize = 44.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosePrimary
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "Ritika Goel",
                    fontFamily = PoppinsFamily,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "21 • Female • New Delhi",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    color = TextSecondary
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Software Developer",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = RosePrimary
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Button(
                    onClick = onEditProfileClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RosePrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text(
                        text = "✎  Edit Profile",
                        fontFamily = PoppinsFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }

        // =========================================================
        // PROFILE COMPLETION
        // =========================================================

        item {

            ProfileCard {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Profile Completion",
                            fontFamily = PoppinsFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextMain
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Complete your profile to get better matches",
                            fontFamily = PoppinsFamily,
                            fontSize = 10.sp,
                            color = TextSecondary
                        )
                    }

                    Text(
                        text = "80%",
                        fontFamily = PoppinsFamily,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosePrimary
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                // Progress bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(7.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(RoseLight)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(7.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(RosePrimary)
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Add your family details and interests",
                    fontFamily = PoppinsFamily,
                    fontSize = 10.sp,
                    color = TextSecondary
                )
            }
        }

        // =========================================================
        // ABOUT ME
        // =========================================================

        item {

            ProfileCard {

                Text(
                    text = "About Me",
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "I am a passionate and ambitious person who enjoys learning new things, travelling and spending quality time with family and friends.",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    color = TextSecondary
                )
            }
        }

        // =========================================================
        // BASIC INFORMATION
        // =========================================================

        item {

            ProfileCard {

                Text(
                    text = "Basic Information",
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                ProfileInfoRow(
                    label = "Age",
                    value = "21 years"
                )

                ProfileInfoRow(
                    label = "Height",
                    value = "5'5\""
                )

                ProfileInfoRow(
                    label = "Religion",
                    value = "Hindu"
                )

                ProfileInfoRow(
                    label = "Location",
                    value = "New Delhi"
                )

                ProfileInfoRow(
                    label = "Marital Status",
                    value = "Never Married"
                )
            }
        }

        // =========================================================
        // EDUCATION AND CAREER
        // =========================================================

        item {

            ProfileCard {

                Text(
                    text = "Education & Career",
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                ProfileInfoRow(
                    label = "Education",
                    value = "B.Tech Computer Science"
                )

                ProfileInfoRow(
                    label = "Occupation",
                    value = "Software Developer"
                )

                ProfileInfoRow(
                    label = "Work Location",
                    value = "New Delhi"
                )
            }
        }

        // =========================================================
        // LIFESTYLE
        // =========================================================

        item {

            ProfileCard {

                Text(
                    text = "Lifestyle",
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                ProfileInfoRow(
                    label = "Diet",
                    value = "Vegetarian"
                )

                ProfileInfoRow(
                    label = "Smoking",
                    value = "Never"
                )

                ProfileInfoRow(
                    label = "Drinking",
                    value = "Occasionally"
                )

                ProfileInfoRow(
                    label = "Interests",
                    value = "Travel • Music • Technology"
                )
            }
        }

        // =========================================================
        // ACCOUNT
        // =========================================================

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 8.dp
                    )
            ) {

                Text(
                    text = "Account",
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                ProfileActionRow(
                    icon = "✎",
                    title = "Edit Profile",
                    subtitle = "Update your personal information",
                    onClick = onEditProfileClick
                )

                ProfileActionRow(
                    icon = "⚙",
                    title = "Settings",
                    subtitle = "Privacy, security and preferences",
                    onClick = onSettingsClick
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                TextButton(
                    onClick = onLogout,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Log Out",
                        fontFamily = PoppinsFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFD6455D)
                    )
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}


// =============================================================
// PROFILE CARD
// =============================================================

@Composable
private fun ProfileCard(
    content: @Composable () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {

        content()
    }
}


// =============================================================
// PROFILE INFORMATION ROW
// =============================================================

@Composable
private fun ProfileInfoRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            fontFamily = PoppinsFamily,
            fontSize = 11.sp,
            color = TextSecondary,
            modifier = Modifier.width(110.dp)
        )

        Text(
            text = value,
            fontFamily = PoppinsFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextMain,
            modifier = Modifier.weight(1f)
        )
    }
}


// =============================================================
// ACCOUNT ACTION ROW
// =============================================================

@Composable
private fun ProfileActionRow(
    icon: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(RoseLight),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = icon,
                fontSize = 19.sp,
                color = RosePrimary
            )
        }

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextMain
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = subtitle,
                fontFamily = PoppinsFamily,
                fontSize = 10.sp,
                color = TextSecondary
            )
        }

        Text(
            text = "›",
            fontSize = 22.sp,
            color = TextSecondary
        )
    }
}