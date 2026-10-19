
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val MilanRose = Color(0xFFE85B78)
private val MilanRoseDark = Color(0xFFC94468)
private val MilanBackground = Color(0xFFFFF7F9)
private val MilanText = Color(0xFF333333)
private val MilanMuted = Color(0xFF9A7A82)
private val MilanBorder = Color(0xFFF1D5DC)
private val MilanGreen = Color(0xFF27835D)

private enum class InterestTab {
    RECEIVED, SENT, SHORTLIST
}

private data class InterestProfile(
    val id: Int,
    val name: String,
    val age: Int,
    val city: String,
    val profession: String,
    val education: String,
    val status: String
)

@Composable
fun InterestsScreen(
    onBack: () -> Unit = {},
    onViewProfile: (Int) -> Unit = {},
    onOpenChat: (Int) -> Unit = {}
) {
    var selectedTab by remember {
        mutableStateOf(InterestTab.RECEIVED)
    }

    var message by remember { mutableStateOf<String?>(null) }
    var showDeclineDialog by remember { mutableStateOf(false) }
    var selectedProfileId by remember { mutableStateOf<Int?>(null) }

    val received = remember {
        mutableStateListOf(
            InterestProfile(
                1, "Aarav Sharma", 27, "Delhi",
                "Software Engineer", "B.Tech", "New"
            ),
            InterestProfile(
                2, "Rohan Mehta", 28, "Jaipur",
                "Business Analyst", "MBA", "New"
            ),
            InterestProfile(
                3, "Karan Malhotra", 29, "Chandigarh",
                "Product Manager", "B.Tech", "New"
            )
        )
    }

    val sent = remember {
        mutableStateListOf(
            InterestProfile(
                4, "Ishita Verma", 26, "Noida",
                "Data Analyst", "M.Sc.", "Pending"
            ),
            InterestProfile(
                5, "Ananya Kapoor", 27, "Gurugram",
                "Designer", "B.Des.", "Pending"
            )
        )
    }

    val shortlisted = remember {
        mutableStateListOf(
            InterestProfile(
                6, "Meera Gupta", 25, "Delhi",
                "Doctor", "MBBS", "Shortlisted"
            ),
            InterestProfile(
                7, "Priya Sinha", 26, "Lucknow",
                "Teacher", "M.A.", "Shortlisted"
            )
        )
    }

    val currentProfiles = when (selectedTab) {
        InterestTab.RECEIVED -> received
        InterestTab.SENT -> sent
        InterestTab.SHORTLIST -> shortlisted
    }

    Scaffold(
        containerColor = MilanBackground,
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
                            horizontal = 16.dp,
                            vertical = 18.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onBack) {
                        Text(
                            text = "‹ Back",
                            color = MilanRoseDark,
                            fontSize = 15.sp
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Interests",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MilanText
                        )
                        Text(
                            text = "Manage your connections",
                            fontSize = 12.sp,
                            color = MilanMuted
                        )
                    }
                }

                HorizontalDivider(color = MilanBorder)
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SummaryItem(
                        count = received.size.toString(),
                        label = "Received"
                    )
                    SummaryItem(
                        count = sent.size.toString(),
                        label = "Sent"
                    )
                    SummaryItem(
                        count = shortlisted.size.toString(),
                        label = "Shortlisted"
                    )
                }
            }

            TabRow(
                selectedTabIndex = selectedTab.ordinal,
                containerColor = Color.White,
                contentColor = MilanRose,
                divider = {
                    HorizontalDivider(color = MilanBorder)
                }
            ) {
                InterestTab.entries.forEach { tab ->
                    Tab(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        text = {
                            Text(
                                text = when (tab) {
                                    InterestTab.RECEIVED -> "Received"
                                    InterestTab.SENT -> "Sent"
                                    InterestTab.SHORTLIST -> "Shortlist"
                                },
                                fontSize = 12.sp,
                                fontWeight = if (
                                    selectedTab == tab
                                ) FontWeight.Bold
                                else FontWeight.Normal
                            )
                        }
                    )
                }
            }

            Text(
                text = when (selectedTab) {
                    InterestTab.RECEIVED ->
                        "People interested in you"
                    InterestTab.SENT ->
                        "Interests you have sent"
                    InterestTab.SHORTLIST ->
                        "Profiles saved for later"
                },
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 18.dp,
                    bottom = 10.dp
                ),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = MilanText
            )

            if (currentProfiles.isEmpty()) {
                EmptyInterestsState(
                    selectedTab = selectedTab,
                    modifier = Modifier.weight(1f)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentPadding = androidx.compose.foundation.layout
                        .PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            top = 4.dp,
                            bottom = 24.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = currentProfiles,
                        key = { it.id }
                    ) { profile ->
                        InterestProfileCard(
                            profile = profile,
                            tab = selectedTab,
                            onViewProfile = {
                                onViewProfile(profile.id)
                            },
                            onAccept = {
                                received.removeAll {
                                    it.id == profile.id
                                }
                                message =
                                    "Interest accepted in demo. Connect the backend to save this action."
                            },
                            onDecline = {
                                selectedProfileId = profile.id
                                showDeclineDialog = true
                            },
                            onRemoveShortlist = {
                                shortlisted.removeAll {
                                    it.id == profile.id
                                }
                                message = "Profile removed from shortlist."
                            },
                            onWithdraw = {
                                sent.removeAll {
                                    it.id == profile.id
                                }
                                message = "Sent interest removed in demo."
                            },
                            onOpenChat = {
                                onOpenChat(profile.id)
                            }
                        )
                    }
                }
            }
        }
    }

    if (showDeclineDialog) {
        AlertDialog(
            onDismissRequest = {
                showDeclineDialog = false
            },
            title = {
                Text("Decline this interest?")
            },
            text = {
                Text(
                    "This demo will remove the interest from your received list."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        selectedProfileId?.let { id ->
                            received.removeAll { it.id == id }
                        }
                        showDeclineDialog = false
                        message = "Interest declined in demo."
                    }
                ) {
                    Text(
                        "Decline",
                        color = MilanRoseDark
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDeclineDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    message?.let { text ->
        AlertDialog(
            onDismissRequest = { message = null },
            title = { Text("Milan") },
            text = { Text(text) },
            confirmButton = {
                TextButton(onClick = { message = null }) {
                    Text("OK", color = MilanRoseDark)
                }
            }
        )
    }
}

@Composable
private fun SummaryItem(
    count: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MilanRose
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = MilanMuted,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun InterestProfileCard(
    profile: InterestProfile,
    tab: InterestTab,
    onViewProfile: () -> Unit,
    onAccept: () -> Unit,
    onDecline: () -> Unit,
    onRemoveShortlist: () -> Unit,
    onWithdraw: () -> Unit,
    onOpenChat: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(MilanRose.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = profile.name.first().toString(),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MilanRoseDark
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "${profile.name}, ${profile.age}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MilanText
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "⌖ ${profile.city}",
                        fontSize = 12.sp,
                        color = MilanMuted
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = profile.profession,
                        fontSize = 13.sp,
                        color = MilanText
                    )
                    Text(
                        text = profile.education,
                        fontSize = 12.sp,
                        color = MilanMuted
                    )
                }

                StatusPill(status = profile.status)
            }

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedButton(
                onClick = onViewProfile,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MilanRoseDark
                )
            ) {
                Text("View Profile")
            }

            Spacer(modifier = Modifier.height(8.dp))

            when (tab) {
                InterestTab.RECEIVED -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = onDecline,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Decline")
                        }

                        Button(
                            onClick = onAccept,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MilanRose
                            )
                        ) {
                            Text("Accept")
                        }
                    }
                }

                InterestTab.SENT -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Status: ${profile.status}",
                            fontSize = 12.sp,
                            color = MilanMuted
                        )
                        TextButton(onClick = onWithdraw) {
                            Text(
                                "Withdraw",
                                color = MilanRoseDark
                            )
                        }
                    }
                }

                InterestTab.SHORTLIST -> {
                    OutlinedButton(
                        onClick = onRemoveShortlist,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Remove from Shortlist")
                    }
                }
            }

            if (tab == InterestTab.RECEIVED &&
                profile.status == "Accepted"
            ) {
                TextButton(
                    onClick = onOpenChat,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Open Chat")
                }
            }
        }
    }
}

@Composable
private fun StatusPill(status: String) {
    val pillColor = when (status) {
        "Accepted" -> MilanGreen
        "Pending" -> Color(0xFFB7791F)
        "Shortlisted" -> MilanRoseDark
        else -> MilanMuted
    }

    Surface(
        color = pillColor.copy(alpha = 0.10f),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = status,
            modifier = Modifier.padding(
                horizontal = 9.dp,
                vertical = 5.dp
            ),
            color = pillColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun EmptyInterestsState(
    selectedTab: InterestTab,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when (selectedTab) {
                InterestTab.RECEIVED -> "♡"
                InterestTab.SENT -> "↗"
                InterestTab.SHORTLIST -> "☆"
            },
            fontSize = 48.sp,
            color = MilanRose
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = when (selectedTab) {
                InterestTab.RECEIVED -> "No interests received yet"
                InterestTab.SENT -> "No interests sent yet"
                InterestTab.SHORTLIST -> "Your shortlist is empty"
            },
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MilanText,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Explore profiles and start making meaningful connections.",
            fontSize = 13.sp,
            color = MilanMuted,
            textAlign = TextAlign.Center
        )
    }
}
