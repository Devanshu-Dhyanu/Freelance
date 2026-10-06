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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

@Composable
fun MilanNotificationsScreen(
    onBackClick: () -> Unit = {}
) {

    var pushNotifications by remember { mutableStateOf(true) }
    var newMatches by remember { mutableStateOf(true) }
    var messages by remember { mutableStateOf(true) }
    var profileLikes by remember { mutableStateOf(true) }
    var emailNotifications by remember { mutableStateOf(false) }
    var promotionalEmails by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

        // TOP BAR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 18.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(RoseLight)
                    .clickable {
                        onBackClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "‹",
                    fontSize = 32.sp,
                    color = RosePrimary
                )
            }

            Spacer(modifier = Modifier.size(14.dp))

            Column {
                Text(
                    text = "Notifications",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Text(
                    text = "Manage how Milan keeps you updated",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }
        }

        Divider(color = RoseBorder)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(22.dp))

            // PUSH NOTIFICATIONS
            Text(
                text = "Push Notifications",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(modifier = Modifier.height(12.dp))

            NotificationSwitchRow(
                title = "Push Notifications",
                description = "Receive notifications on your device",
                checked = pushNotifications,
                onCheckedChange = {
                    pushNotifications = it
                }
            )

            NotificationSwitchRow(
                title = "New Matches",
                description = "Get notified when you have a new match",
                checked = newMatches,
                onCheckedChange = {
                    newMatches = it
                }
            )

            NotificationSwitchRow(
                title = "Messages",
                description = "Get notified when someone sends you a message",
                checked = messages,
                onCheckedChange = {
                    messages = it
                }
            )

            NotificationSwitchRow(
                title = "Profile Likes",
                description = "Know when someone likes your profile",
                checked = profileLikes,
                onCheckedChange = {
                    profileLikes = it
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            // EMAIL
            Text(
                text = "Email Notifications",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(modifier = Modifier.height(12.dp))

            NotificationSwitchRow(
                title = "Email Notifications",
                description = "Receive important updates by email",
                checked = emailNotifications,
                onCheckedChange = {
                    emailNotifications = it
                }
            )

            NotificationSwitchRow(
                title = "Promotional Emails",
                description = "Receive offers, tips and updates from Milan",
                checked = promotionalEmails,
                onCheckedChange = {
                    promotionalEmails = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // INFO CARD
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(RoseLight)
                    .padding(16.dp)
            ) {
                Column {

                    Text(
                        text = "💡 Notification Tips",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosePrimary
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Keep match and message notifications enabled so you never miss an important connection.",
                        fontSize = 12.sp,
                        color = TextSecondary,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}


@Composable
private fun NotificationSwitchRow(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextMain
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = description,
                fontSize = 11.sp,
                color = TextSecondary,
                lineHeight = 16.sp
            )
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = RoseVeryLight,
                checkedTrackColor = RosePrimary,
                uncheckedThumbColor = RoseVeryLight,
                uncheckedTrackColor = RoseBorder
            )
        )
    }
}