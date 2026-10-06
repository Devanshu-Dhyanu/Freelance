package com.example.matrimonal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.ui.text.font.FontWeight
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseDark
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary


@Composable
fun MilanSettingsScreen(
    onBackClick: () -> Unit = {},
    onPersonalInfoClick: () -> Unit = {},
    onChangePasswordClick: () -> Unit = {},
    onProfileVisibilityClick: () -> Unit = {},
    onBlockedUsersClick: () -> Unit = {},
    onSecurityClick: () -> Unit = {},
    onPartnerPreferencesClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    onReportProblemClick: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    onPrivacyClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    var pushNotifications by remember { mutableStateOf(true) }
    var emailNotifications by remember { mutableStateOf(true) }
    var showLogoutDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.navigationBars),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            item {

                // ---------------- TOP BAR ----------------

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(
                            horizontal = 20.dp,
                            vertical = 16.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    BackArrow(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(RoseVeryLight)
                            .clickable {
                                onBackClick()
                            }
                            .padding(11.dp)
                    )

                    Spacer(modifier = Modifier.size(14.dp))

                    Text(
                        text = "Settings",
                        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = TextMain
                    )
                }

                Divider(
                    color = RoseBorder,
                    thickness = 1.dp
                )

                Spacer(modifier = Modifier.height(18.dp))


                // ---------------- PROFILE SUMMARY ----------------

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(58.dp)
                            .clip(CircleShape)
                            .background(RoseLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "R",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = RoseDark
                        )
                    }

                    Spacer(modifier = Modifier.size(14.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Ritika Goel",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextMain
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Manage your account and preferences",
                            fontSize = 12.sp,
                            color = TextSecondary
                        )
                    }

                    Text(
                        text = "Edit",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = RosePrimary
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }


            // ---------------- ACCOUNT ----------------

            item {

                SettingsSectionTitle("ACCOUNT")

                SettingsCard {

                    SettingsRow(
                        icon = SettingsIconType.Person,
                        title = "Personal Information",
                        subtitle = "Name, email, phone and basic details",
                        onClick = onPersonalInfoClick
                    )

                    SettingsDivider()

                    SettingsRow(
                        icon = SettingsIconType.Lock,
                        title = "Change Password",
                        subtitle = "Update your account password",
                        onClick = onChangePasswordClick
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }


            // ---------------- PRIVACY & SECURITY ----------------

            item {

                SettingsSectionTitle("PRIVACY & SECURITY")

                SettingsCard {

                    SettingsRow(
                        icon = SettingsIconType.Eye,
                        title = "Profile Visibility",
                        subtitle = "Control who can see your profile",
                        onClick = onProfileVisibilityClick
                    )

                    SettingsDivider()

                    SettingsRow(
                        icon = SettingsIconType.Block,
                        title = "Blocked Users",
                        subtitle = "Manage blocked profiles",
                        onClick = onBlockedUsersClick
                    )

                    SettingsDivider()

                    SettingsRow(
                        icon = SettingsIconType.Security,
                        title = "Security",
                        subtitle = "Manage account security",
                        onClick = onSecurityClick
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }


            // ---------------- NOTIFICATIONS ----------------

            item {

                SettingsSectionTitle("NOTIFICATIONS")

                SettingsCard {

                    NotificationRow(
                        icon = SettingsIconType.Bell,
                        title = "Push Notifications",
                        subtitle = "Matches, messages and profile activity",
                        checked = pushNotifications,
                        onCheckedChange = {
                            pushNotifications = it
                        }
                    )

                    SettingsDivider()

                    NotificationRow(
                        icon = SettingsIconType.Mail,
                        title = "Email Notifications",
                        subtitle = "Receive updates through email",
                        checked = emailNotifications,
                        onCheckedChange = {
                            emailNotifications = it
                        }
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }


            // ---------------- DISCOVERY ----------------

            item {

                SettingsSectionTitle("DISCOVERY")

                SettingsCard {

                    SettingsRow(
                        icon = SettingsIconType.Heart,
                        title = "Partner Preferences",
                        subtitle = "Age, location, education, lifestyle and more",
                        onClick = onPartnerPreferencesClick
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }


            // ---------------- SUPPORT ----------------

            item {

                SettingsSectionTitle("SUPPORT")

                SettingsCard {

                    SettingsRow(
                        icon = SettingsIconType.Help,
                        title = "Help & Support",
                        subtitle = "Get help with Milan",
                        onClick = onHelpClick
                    )

                    SettingsDivider()

                    SettingsRow(
                        icon = SettingsIconType.Warning,
                        title = "Report a Problem",
                        subtitle = "Tell us about an issue",
                        onClick = onReportProblemClick
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }


            // ---------------- LEGAL ----------------

            item {

                SettingsSectionTitle("LEGAL")

                SettingsCard {

                    SettingsRow(
                        icon = SettingsIconType.Document,
                        title = "Terms & Conditions",
                        subtitle = null,
                        onClick = onTermsClick
                    )

                    SettingsDivider()

                    SettingsRow(
                        icon = SettingsIconType.Privacy,
                        title = "Privacy Policy",
                        subtitle = null,
                        onClick = onPrivacyClick
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))
            }


            // ---------------- LOGOUT ----------------

            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .clickable {
                            showLogoutDialog = true
                        }
                        .padding(vertical = 15.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        LogoutIcon(
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.size(9.dp))

                        Text(
                            text = "Log Out",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = RoseDark
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Milan",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextSecondary
                )

                Text(
                    text = "Version 1.0.0",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 10.sp,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(35.dp))
            }
        }
    }


    // ---------------- LOGOUT DIALOG ----------------

    if (showLogoutDialog) {

        AlertDialog(
            onDismissRequest = {
                showLogoutDialog = false
            },
            title = {
                Text(
                    text = "Log Out?",
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to log out of your Milan account?",
                    color = TextSecondary
                )
            },
            confirmButton = {

                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        onLogout()
                    }
                ) {
                    Text(
                        text = "Log Out",
                        color = RoseDark,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            dismissButton = {

                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    }
                ) {
                    Text(
                        text = "Cancel",
                        color = TextSecondary
                    )
                }
            },
            containerColor = Color.White
        )
    }
}


// ============================================================
// SECTION TITLE
// ============================================================

@Composable
private fun SettingsSectionTitle(
    title: String
) {

    Text(
        text = title,
        modifier = Modifier.padding(
            start = 20.dp,
            bottom = 9.dp
        ),
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.8.sp,
        color = TextSecondary
    )
}


// ============================================================
// SETTINGS CARD
// ============================================================

@Composable
private fun SettingsCard(
    content: @Composable () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(17.dp))
            .background(Color.White)
    ) {
        content()
    }
}


// ============================================================
// SETTINGS ROW
// ============================================================

@Composable
private fun SettingsRow(
    icon: SettingsIconType,
    title: String,
    subtitle: String?,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 14.dp,
                vertical = 13.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(RoseVeryLight),
            contentAlignment = Alignment.Center
        ) {

            MilanSettingsIcon(
                type = icon,
                modifier = Modifier.size(21.dp)
            )
        }

        Spacer(modifier = Modifier.size(13.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TextMain
            )

            if (subtitle != null) {

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = subtitle,
                    fontSize = 11.sp,
                    color = TextSecondary
                )
            }
        }

        ChevronIcon(
            modifier = Modifier.size(18.dp)
        )
    }
}


// ============================================================
// NOTIFICATION ROW
// ============================================================

@Composable
private fun NotificationRow(
    icon: SettingsIconType,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 14.dp,
                vertical = 13.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(RoseVeryLight),
            contentAlignment = Alignment.Center
        ) {

            MilanSettingsIcon(
                type = icon,
                modifier = Modifier.size(21.dp)
            )
        }

        Spacer(modifier = Modifier.size(13.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TextMain
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = TextSecondary
            )
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = RosePrimary,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = RoseBorder,
                uncheckedBorderColor = RoseBorder
            )
        )
    }
}


// ============================================================
// DIVIDER
// ============================================================

@Composable
private fun SettingsDivider() {

    Divider(
        modifier = Modifier.padding(start = 69.dp),
        color = RoseBorder,
        thickness = 0.7.dp
    )
}


// ============================================================
// ICON TYPE
// ============================================================

private enum class SettingsIconType {
    Person,
    Lock,
    Eye,
    Block,
    Security,
    Bell,
    Mail,
    Heart,
    Help,
    Warning,
    Document,
    Privacy
}


// ============================================================
// CUSTOM MILAN ICONS
// ============================================================

@Composable
private fun MilanSettingsIcon(
    type: SettingsIconType,
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
    ) {

        val stroke = Stroke(
            width = 1.8f,
            cap = StrokeCap.Round
        )

        when (type) {

            SettingsIconType.Person -> {

                drawCircle(
                    color = RoseDark,
                    radius = size.minDimension * 0.22f,
                    center = center.copy(
                        y = center.y - size.height * 0.18f
                    ),
                    style = stroke
                )

                drawArc(
                    color = RoseDark,
                    startAngle = 200f,
                    sweepAngle = 140f,
                    useCenter = false,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.22f,
                        size.height * 0.35f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.56f,
                        size.height * 0.48f
                    ),
                    style = stroke
                )
            }

            SettingsIconType.Lock -> {

                drawRoundRect(
                    color = RoseDark,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.25f,
                        size.height * 0.43f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.5f,
                        size.height * 0.4f
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(3f),
                    style = stroke
                )

                drawArc(
                    color = RoseDark,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.33f,
                        size.height * 0.18f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.34f,
                        size.height * 0.45f
                    ),
                    style = stroke
                )
            }

            SettingsIconType.Eye -> {

                val path = Path().apply {
                    moveTo(
                        size.width * 0.12f,
                        size.height * 0.5f
                    )
                    cubicTo(
                        size.width * 0.3f,
                        size.height * 0.18f,
                        size.width * 0.7f,
                        size.height * 0.18f,
                        size.width * 0.88f,
                        size.height * 0.5f
                    )
                    cubicTo(
                        size.width * 0.7f,
                        size.height * 0.82f,
                        size.width * 0.3f,
                        size.height * 0.82f,
                        size.width * 0.12f,
                        size.height * 0.5f
                    )
                }

                drawPath(
                    path = path,
                    color = RoseDark,
                    style = stroke
                )

                drawCircle(
                    color = RoseDark,
                    radius = size.minDimension * 0.14f,
                    center = center
                )
            }

            SettingsIconType.Block -> {

                drawCircle(
                    color = RoseDark,
                    radius = size.minDimension * 0.34f,
                    center = center,
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.27f,
                        size.height * 0.27f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.73f,
                        size.height * 0.73f
                    ),
                    strokeWidth = 1.8f
                )
            }

            SettingsIconType.Security -> {

                val path = Path().apply {
                    moveTo(
                        size.width * 0.5f,
                        size.height * 0.1f
                    )
                    lineTo(
                        size.width * 0.82f,
                        size.height * 0.23f
                    )
                    lineTo(
                        size.width * 0.76f,
                        size.height * 0.65f
                    )
                    lineTo(
                        size.width * 0.5f,
                        size.height * 0.88f
                    )
                    lineTo(
                        size.width * 0.24f,
                        size.height * 0.65f
                    )
                    lineTo(
                        size.width * 0.18f,
                        size.height * 0.23f
                    )
                    close()
                }

                drawPath(
                    path = path,
                    color = RoseDark,
                    style = stroke
                )
            }

            SettingsIconType.Bell -> {

                drawArc(
                    color = RoseDark,
                    startAngle = 200f,
                    sweepAngle = 140f,
                    useCenter = false,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.25f,
                        size.height * 0.2f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.5f,
                        size.height * 0.55f
                    ),
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.2f,
                        size.height * 0.72f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.8f,
                        size.height * 0.72f
                    ),
                    strokeWidth = 1.8f,
                    cap = StrokeCap.Round
                )

                drawCircle(
                    color = RoseDark,
                    radius = 1.7f,
                    center = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.82f
                    )
                )
            }

            SettingsIconType.Mail -> {

                drawRoundRect(
                    color = RoseDark,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.12f,
                        size.height * 0.25f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.76f,
                        size.height * 0.5f
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(3f),
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.15f,
                        size.height * 0.3f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.55f
                    ),
                    strokeWidth = 1.8f
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.85f,
                        size.height * 0.3f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.55f
                    ),
                    strokeWidth = 1.8f
                )
            }

            SettingsIconType.Heart -> {

                val path = Path().apply {

                    moveTo(
                        size.width * 0.5f,
                        size.height * 0.82f
                    )

                    cubicTo(
                        size.width * 0.38f,
                        size.height * 0.7f,
                        size.width * 0.12f,
                        size.height * 0.53f,
                        size.width * 0.12f,
                        size.height * 0.32f
                    )

                    cubicTo(
                        size.width * 0.12f,
                        size.height * 0.08f,
                        size.width * 0.4f,
                        size.height * 0.08f,
                        size.width * 0.5f,
                        size.height * 0.27f
                    )

                    cubicTo(
                        size.width * 0.6f,
                        size.height * 0.08f,
                        size.width * 0.88f,
                        size.height * 0.08f,
                        size.width * 0.88f,
                        size.height * 0.32f
                    )

                    cubicTo(
                        size.width * 0.88f,
                        size.height * 0.53f,
                        size.width * 0.62f,
                        size.height * 0.7f,
                        size.width * 0.5f,
                        size.height * 0.82f
                    )
                }

                drawPath(
                    path = path,
                    color = RoseDark,
                    style = stroke
                )
            }

            SettingsIconType.Help -> {

                drawCircle(
                    color = RoseDark,
                    radius = size.minDimension * 0.35f,
                    center = center,
                    style = stroke
                )

                drawCircle(
                    color = RoseDark,
                    radius = 1.5f,
                    center = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.72f
                    )
                )

                drawArc(
                    color = RoseDark,
                    startAngle = 210f,
                    sweepAngle = 140f,
                    useCenter = false,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.34f,
                        size.height * 0.22f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.32f,
                        size.height * 0.38f
                    ),
                    style = stroke
                )
            }

            SettingsIconType.Warning -> {

                val path = Path().apply {
                    moveTo(
                        size.width * 0.5f,
                        size.height * 0.12f
                    )
                    lineTo(
                        size.width * 0.88f,
                        size.height * 0.82f
                    )
                    lineTo(
                        size.width * 0.12f,
                        size.height * 0.82f
                    )
                    close()
                }

                drawPath(
                    path = path,
                    color = RoseDark,
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.35f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.5f,
                        size.height * 0.6f
                    ),
                    strokeWidth = 1.8f,
                    cap = StrokeCap.Round
                )
            }

            SettingsIconType.Document -> {

                drawRoundRect(
                    color = RoseDark,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.25f,
                        size.height * 0.12f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.5f,
                        size.height * 0.76f
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(2f),
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.35f,
                        size.height * 0.4f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.65f,
                        size.height * 0.4f
                    ),
                    strokeWidth = 1.5f
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.35f,
                        size.height * 0.55f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.65f,
                        size.height * 0.55f
                    ),
                    strokeWidth = 1.5f
                )
            }

            SettingsIconType.Privacy -> {

                drawCircle(
                    color = RoseDark,
                    radius = size.minDimension * 0.35f,
                    center = center,
                    style = stroke
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.28f,
                        size.height * 0.5f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.44f,
                        size.height * 0.66f
                    ),
                    strokeWidth = 1.8f
                )

                drawLine(
                    color = RoseDark,
                    start = androidx.compose.ui.geometry.Offset(
                        size.width * 0.44f,
                        size.height * 0.66f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width * 0.73f,
                        size.height * 0.33f
                    ),
                    strokeWidth = 1.8f
                )
            }
        }
    }
}


// ============================================================
// BACK ARROW
// ============================================================

@Composable
private fun BackArrow(
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
    ) {

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.7f,
                size.height * 0.5f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.3f,
                size.height * 0.5f
            ),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.3f,
                size.height * 0.5f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.5f,
                size.height * 0.3f
            ),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.3f,
                size.height * 0.5f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.5f,
                size.height * 0.7f
            ),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )
    }
}


// ============================================================
// CHEVRON
// ============================================================

@Composable
private fun ChevronIcon(
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
    ) {

        drawLine(
            color = TextSecondary,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.35f,
                size.height * 0.25f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.65f,
                size.height * 0.5f
            ),
            strokeWidth = 1.8f,
            cap = StrokeCap.Round
        )

        drawLine(
            color = TextSecondary,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.65f,
                size.height * 0.5f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.35f,
                size.height * 0.75f
            ),
            strokeWidth = 1.8f,
            cap = StrokeCap.Round
        )
    }
}


// ============================================================
// LOGOUT ICON
// ============================================================

@Composable
private fun LogoutIcon(
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
    ) {

        drawRoundRect(
            color = RoseDark,
            topLeft = androidx.compose.ui.geometry.Offset(
                size.width * 0.18f,
                size.height * 0.12f
            ),
            size = androidx.compose.ui.geometry.Size(
                size.width * 0.38f,
                size.height * 0.76f
            ),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(2f),
            style = Stroke(width = 1.8f)
        )

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.42f,
                size.height * 0.5f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.84f,
                size.height * 0.5f
            ),
            strokeWidth = 1.8f,
            cap = StrokeCap.Round
        )

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.68f,
                size.height * 0.33f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.84f,
                size.height * 0.5f
            ),
            strokeWidth = 1.8f,
            cap = StrokeCap.Round
        )

        drawLine(
            color = RoseDark,
            start = androidx.compose.ui.geometry.Offset(
                size.width * 0.68f,
                size.height * 0.67f
            ),
            end = androidx.compose.ui.geometry.Offset(
                size.width * 0.84f,
                size.height * 0.5f
            ),
            strokeWidth = 1.8f,
            cap = StrokeCap.Round
        )
    }
}

