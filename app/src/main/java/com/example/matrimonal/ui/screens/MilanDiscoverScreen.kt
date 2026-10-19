
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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

data class DiscoverProfile(
    val id: Int,
    val name: String,
    val age: Int,
    val city: String,
    val profession: String,
    val education: String,
    val match: Int,
    val isSaved: Boolean = false
)

@Composable
fun MilanDiscoverScreen(
    profiles: List<DiscoverProfile>,
    onBackClick: () -> Unit = {},
    onProfileClick: (Int) -> Unit = {},
    onLikeClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {
        // TOP BAR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(RoseLight)
                    .clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "‹",
                    fontSize = 32.sp,
                    color = RosePrimary
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Discover",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Text(
                    text = "Find someone who matches you",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(RoseLight),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "⚙",
                    fontSize = 19.sp,
                    color = RosePrimary
                )
            }
        }

        HorizontalDivider(color = RoseBorder)

        // FILTERS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DiscoverFilter(
                text = "Age",
                modifier = Modifier.weight(1f)
            )

            DiscoverFilter(
                text = "Location",
                modifier = Modifier.weight(1f)
            )

            DiscoverFilter(
                text = "Religion",
                modifier = Modifier.weight(1f)
            )
        }

        // PROFILE LIST
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "${profiles.size} profiles found",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    fontSize = 13.sp,
                    color = TextSecondary
                )
            }

            items(
                items = profiles,
                key = { profile -> profile.id }
            ) { profile ->
                DiscoverProfileCard(
                    profile = profile,
                    onProfileClick = {
                        onProfileClick(profile.id)
                    },
                    onLikeClick = {
                        onLikeClick(profile.id)
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun DiscoverFilter(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(RoseLight)
            .padding(horizontal = 10.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = RoseDark
        )
    }
}

@Composable
private fun DiscoverProfileCard(
    profile: DiscoverProfile,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(RoseVeryLight)
    ) {
        // PROFILE IMAGE PLACEHOLDER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(RoseLight)
                .clickable { onProfileClick() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(RosePrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = profile.name.firstOrNull()?.toString() ?: "?",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = RoseVeryLight
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Profile Photo",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(14.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(RosePrimary)
                    .padding(horizontal = 10.dp, vertical = 7.dp)
            ) {
                Text(
                    text = "${profile.match}% Match",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = RoseVeryLight
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // PROFILE DETAILS
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "${profile.name}, ${profile.age}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "📍 ${profile.city}",
                fontSize = 12.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "💼 ${profile.profession}",
                fontSize = 12.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "🎓 ${profile.education}",
                fontSize = 12.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(14.dp))

            // BUTTONS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(RoseLight)
                        .clickable { onProfileClick() }
                        .padding(vertical = 13.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "View Profile",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = RoseDark
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(RosePrimary)
                        .clickable { onLikeClick() }
                        .padding(vertical = 13.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (profile.isSaved) "♥ Saved" else "♥ Like",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = RoseVeryLight
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}