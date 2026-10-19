
package com.example.matrimonal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MilanReportUserScreen(
    profileName: String = "This profile",
    onBackClick: () -> Unit = {},
    onReportSubmitted: () -> Unit = {},
    onBlockConfirmed: () -> Unit = {}
) {
    var selectedReason by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var showBlockDialog by remember { mutableStateOf(false) }
    var showReportSuccess by remember { mutableStateOf(false) }
    var isBlocked by remember { mutableStateOf(false) }

    val reasons = listOf(
        "Fake or misleading profile",
        "Inappropriate photos or content",
        "Harassment or abusive behaviour",
        "Asking for money or financial fraud",
        "Already married or relationship misrepresentation",
        "Other"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        TextButton(onClick = onBackClick) {
            Text("← Back")
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = "Safety & Privacy",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Help us keep Milan a safe and respectful community.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "Report $profileName",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(8.dp))

        Text("Why are you reporting this profile?")

        Spacer(Modifier.height(8.dp))

        reasons.forEach { reason ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(
                    selected = selectedReason == reason,
                    onClick = { selectedReason = reason }
                )
                Text(
                    text = reason,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 12.dp)
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Additional details (optional)") },
            placeholder = { Text("Tell us what happened") },
            minLines = 3
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { showReportSuccess = true },
            enabled = selectedReason.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Submit Report")
        }

        Spacer(Modifier.height(24.dp))

        HorizontalDivider()

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Block $profileName",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = if (isBlocked) {
                "This profile has been blocked in this demo."
            } else {
                "Blocking prevents this profile from contacting you in the app once connected to the backend."
            },
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = { showBlockDialog = true },
            enabled = !isBlocked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isBlocked) "Profile Blocked" else "Block Profile")
        }
    }

    if (showBlockDialog) {
        AlertDialog(
            onDismissRequest = { showBlockDialog = false },
            title = { Text("Block this profile?") },
            text = {
                Text(
                    "Are you sure you want to block $profileName? " +
                            "This action only updates the demo screen."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        isBlocked = true
                        showBlockDialog = false
                        onBlockConfirmed()
                    }
                ) {
                    Text("Block")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showBlockDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showReportSuccess) {
        AlertDialog(
            onDismissRequest = { showReportSuccess = false },
            title = { Text("Report recorded in demo") },
            text = {
                Text(
                    "Reason: $selectedReason\n\n" +
                            "No report has been sent to a server yet."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showReportSuccess = false
                        onReportSubmitted()
                    }
                ) {
                    Text("Done")
                }
            }
        )
    }
}
