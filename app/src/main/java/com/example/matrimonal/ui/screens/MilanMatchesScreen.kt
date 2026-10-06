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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseDark
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

data class MilanMatch(
    val name: String,
    val age: Int,
    val city: String,
    val profession: String,
    val matchPercentage: Int,
    val lastActive: String
)

@Composable
fun MilanMatchesScreen(
    onBackClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onChatClick: () -> Unit = {}
) {

    val matches = listOf(

        MilanMatch(
            name = "Anjali Verma",
            age = 24,
            city = "New Delhi",
            profession = "UI/UX Designer",
            matchPercentage = 94,
            lastActive = "Active now"
        ),

        MilanMatch(
            name = "Pooja Sharma",
            age = 25,
            city = "Gurgaon",
            profession = "Software Engineer",
            matchPercentage = 91,
            lastActive = "Active 10m ago"
        ),

        MilanMatch(
            name = "Sneha Kapoor",
            age = 26,
            city = "Chandigarh",
            profession = "Data Analyst",
            matchPercentage = 87,
            lastActive = "Active 1h ago"
        ),

        MilanMatch(
            name = "Kavya Mehta",
            age = 25,
            city = "Noida",
            profession = "Product Designer",
            matchPercentage = 84,
            lastActive = "Active 2h ago"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

        // =========================================================
        // TOP BAR
        // =========================================================

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

            Spacer(
                modifier = Modifier.size(14.dp)
            )

            Column {

                Text(
                    text = "Matches",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Text(
                    text = "People who match your preferences",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }
        }

        Divider(
            color = RoseBorder
        )

        // =========================================================
        // MATCH SUMMARY
        // =========================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                )
                .clip(RoundedCornerShape(18.dp))
                .background(RoseLight)
                .padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(RosePrimary),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "♥",
                        fontSize = 25.sp,
                        color = RoseVeryLight
                    )
                }

                Spacer(
                    modifier = Modifier.size(14.dp)
                )

                Column {

                    Text(
                        text = "${matches.size} Great Matches",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMain
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Start a conversation and discover more",
                        fontSize = 11.sp,
                        color = TextSecondary
                    )
                }
            }
        }

        // =========================================================
        // MATCH LIST
        // =========================================================

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            item {

                Text(
                    text = "Your Matches",
                    modifier = Modifier.padding(
                        horizontal = 20.dp
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )
            }

            items(matches) { match ->

                MilanMatchCard(
                    match = match,
                    onProfileClick = onProfileClick,
                    onChatClick = onChatClick
                )
            }

            item {

                Spacer(
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}


// =============================================================
// MATCH CARD
// =============================================================

@Composable
private fun MilanMatchCard(
    match: MilanMatch,
    onProfileClick: () -> Unit,
    onChatClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(RoseVeryLight)
            .clickable {
                onProfileClick()
            }
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // =====================================================
        // AVATAR
        // =====================================================

        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(RoseLight),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = match.name.first().toString(),
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = RosePrimary
            )
        }

        Spacer(
            modifier = Modifier.size(14.dp)
        )

        // =====================================================
        // DETAILS
        // =====================================================

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "${match.name}, ${match.age}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = match.profession,
                fontSize = 11.sp,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = "📍 ${match.city}",
                fontSize = 11.sp,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = match.lastActive,
                fontSize = 10.sp,
                color = RosePrimary
            )
        }

        // =====================================================
        // RIGHT SIDE
        // =====================================================

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(RoseLight)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            ) {

                Text(
                    text = "${match.matchPercentage}%",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = RoseDark
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(RosePrimary)
                    .clickable {
                        onChatClick()
                    },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "➤",
                    fontSize = 17.sp,
                    color = RoseVeryLight
                )
            }
        }
    }
}