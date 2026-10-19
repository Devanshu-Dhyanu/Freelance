
package com.example.matrimonal.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val VerificationRose = Color(0xFFE85B78)
private val VerificationRoseDark = Color(0xFFC94468)
private val VerificationBackground = Color(0xFFFFF7F9)
private val VerificationText = Color(0xFF333333)
private val VerificationMuted = Color(0xFF9A7A82)
private val VerificationBorder = Color(0xFFF1D5DC)
private val VerificationGreen = Color(0xFF27835D)
private val VerificationAmber = Color(0xFFB7791F)

private enum class VerificationStatus {
    NOT_STARTED,
    PENDING,
    VERIFIED,
    REJECTED
}

@Composable
fun MilanProfileVerificationScreen(
    onBackClick: () -> Unit = {},
    onLearnMoreClick: () -> Unit = {},
    onStartVerification: () -> Unit = {}
) {
    var status by remember {
        mutableStateOf(VerificationStatus.NOT_STARTED)
    }

    var consentGiven by remember {
        mutableStateOf(false)
    }

    var showConsentError by remember {
        mutableStateOf(false)
    }

    var showInfoDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = VerificationBackground,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                            vertical = 14.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onBackClick) {
                        Text(
                            text = "‹ Back",
                            color = VerificationRoseDark,
                            fontSize = 15.sp
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(
                            text = "Profile Verification",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = VerificationText
                        )

                        Text(
                            text = "Build trust on Milan",
                            fontSize = 12.sp,
                            color = VerificationMuted
                        )
                    }
                }

                HorizontalDivider(color = VerificationBorder)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(88.dp)
                            .background(
                                VerificationRose.copy(alpha = 0.12f),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when (status) {
                                VerificationStatus.VERIFIED -> "✓"
                                VerificationStatus.PENDING -> "◷"
                                VerificationStatus.REJECTED -> "!"
                                VerificationStatus.NOT_STARTED -> "♙"
                            },
                            fontSize = 38.sp,
                            color = when (status) {
                                VerificationStatus.VERIFIED ->
                                    VerificationGreen
                                VerificationStatus.PENDING ->
                                    VerificationAmber
                                VerificationStatus.REJECTED ->
                                    VerificationRoseDark
                                VerificationStatus.NOT_STARTED ->
                                    VerificationRose
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = when (status) {
                            VerificationStatus.NOT_STARTED ->
                                "Verify your profile"
                            VerificationStatus.PENDING ->
                                "Verification pending"
                            VerificationStatus.VERIFIED ->
                                "Profile verified"
                            VerificationStatus.REJECTED ->
                                "Verification needs attention"
                        },
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = VerificationText,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = when (status) {
                            VerificationStatus.NOT_STARTED ->
                                "A verification badge can help other members feel more confident connecting with you."
                            VerificationStatus.PENDING ->
                                "Your request has been marked as submitted in this demo. No real identity check has taken place."
                            VerificationStatus.VERIFIED ->
                                "This is a demonstration status. Real verification must be confirmed by the verification service."
                            VerificationStatus.REJECTED ->
                                "Review the requirements and contact support before submitting again."
                        },
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        color = VerificationMuted,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    StatusLabel(status = status)
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "How verification works",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = VerificationText
                )

                VerificationStep(
                    number = "1",
                    title = "Review the requirements",
                    description = "Understand which identity information may be required."
                )

                VerificationStep(
                    number = "2",
                    title = "Continue to secure verification",
                    description = "In the production app, a secure verification provider or backend will handle the identity check."
                )

                VerificationStep(
                    number = "3",
                    title = "Receive your result",
                    description = "Your status should change only after the server confirms the verification outcome."
                )
            }

            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Privacy matters",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = VerificationText
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Only provide identity information through an approved, secure verification flow. Do not upload identity documents to this demo screen.",
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        color = VerificationMuted
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = {
                            showInfoDialog = true
                            onLearnMoreClick()
                        }
                    ) {
                        Text(
                            text = "Learn about data privacy",
                            color = VerificationRoseDark
                        )
                    }
                }
            }

            if (
                status == VerificationStatus.NOT_STARTED ||
                status == VerificationStatus.REJECTED
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top
                        ) {
                            androidx.compose.material3.Checkbox(
                                checked = consentGiven,
                                onCheckedChange = {
                                    consentGiven = it
                                    showConsentError = false
                                }
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 10.dp)
                            ) {
                                Text(
                                    text = "Consent to verification",
                                    fontWeight = FontWeight.SemiBold,
                                    color = VerificationText
                                )

                                Text(
                                    text = "I understand that the real verification process may require identity information and that it must be handled securely.",
                                    fontSize = 12.sp,
                                    lineHeight = 18.sp,
                                    color = VerificationMuted
                                )
                            }
                        }

                        if (showConsentError) {
                            Text(
                                text = "Please provide consent before continuing.",
                                color = VerificationRoseDark,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(
                                    start = 8.dp,
                                    top = 4.dp
                                )
                            )
                        }
                    }
                }

                Button(
                    onClick = {
                        if (consentGiven) {
                            // Demo state only. Do not treat this as
                            // a real identity verification result.
                            status = VerificationStatus.PENDING
                            onStartVerification()
                        } else {
                            showConsentError = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VerificationRose
                    )
                ) {
                    Text(
                        text = if (
                            status == VerificationStatus.REJECTED
                        ) "Try Again (Demo)"
                        else "Start Verification (Demo)",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                }
            } else {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Back to Milan")
                }
            }

            Text(
                text = "Demo interface only • No documents are uploaded or verified",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                fontSize = 11.sp,
                color = VerificationMuted,
                textAlign = TextAlign.Center
            )
        }
    }

    if (showInfoDialog) {
        AlertDialog(
            onDismissRequest = { showInfoDialog = false },
            title = {
                Text("Your privacy")
            },
            text = {
                Text(
                    "This demo does not collect identity documents. Before launch, Milan must define what data is collected, why it is needed, who can access it, how long it is retained, and how users can request deletion."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { showInfoDialog = false }
                ) {
                    Text(
                        "Got it",
                        color = VerificationRoseDark
                    )
                }
            }
        )
    }
}

@Composable
private fun VerificationStep(
    number: String,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .background(
                        VerificationRose.copy(alpha = 0.12f),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    fontWeight = FontWeight.Bold,
                    color = VerificationRoseDark
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = VerificationText
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = description,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    color = VerificationMuted
                )
            }
        }
    }
}

@Composable
private fun StatusLabel(
    status: VerificationStatus
) {
    val label = when (status) {
        VerificationStatus.NOT_STARTED -> "Not started"
        VerificationStatus.PENDING -> "Demo: pending"
        VerificationStatus.VERIFIED -> "Demo: verified"
        VerificationStatus.REJECTED -> "Demo: rejected"
    }

    val color = when (status) {
        VerificationStatus.NOT_STARTED -> VerificationMuted
        VerificationStatus.PENDING -> VerificationAmber
        VerificationStatus.VERIFIED -> VerificationGreen
        VerificationStatus.REJECTED -> VerificationRoseDark
    }

    Surface(
        color = color.copy(alpha = 0.10f),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 7.dp
            ),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    }
}
