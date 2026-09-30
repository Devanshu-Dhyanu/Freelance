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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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

private data class DiscoverProfile(
    val name: String,
    val age: Int,
    val city: String,
    val profession: String,
    val match: Int,
    val initials: String
)

private val discoverProfiles = listOf(
    DiscoverProfile(
        "Riya Sharma",
        24,
        "Chandigarh",
        "Software Engineer",
        88,
        "RS"
    ),
    DiscoverProfile(
        "Aarav Mehta",
        26,
        "New Delhi",
        "Product Designer",
        90,
        "AM"
    ),
    DiscoverProfile(
        "Meera Kapoor",
        23,
        "Bengaluru",
        "Data Analyst",
        85,
        "MK"
    ),
    DiscoverProfile(
        "Kavya Singh",
        25,
        "Mumbai",
        "Marketing Manager",
        91,
        "KS"
    )
)

@Composable
fun MilanDiscoverScreen(
    onBackClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "‹",
                fontSize = 36.sp,
                color = TextMain,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Discover",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(RoseLight),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "☰",
                    fontSize = 19.sp,
                    color = RosePrimary
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            DiscoverFilterChip("All", true)

            DiscoverFilterChip("Nearby", false)

            DiscoverFilterChip("New", false)
        }

        Spacer(modifier = Modifier.height(18.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(discoverProfiles) { profile ->

                MilanDiscoverCard(
                    profile = profile,
                    onProfileClick = onProfileClick,
                    onLikeClick = onLikeClick
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun DiscoverFilterChip(
    text: String,
    selected: Boolean
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) RosePrimary else Color.White
            )
            .border(
                1.dp,
                if (selected) RosePrimary else RoseBorder,
                RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 18.dp, vertical = 9.dp)
    ) {

        Text(
            text = text,
            fontFamily = PoppinsFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected) Color.White else TextSecondary
        )
    }
}

@Composable
private fun MilanDiscoverCard(
    profile: DiscoverProfile,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color.White)
            .border(
                1.dp,
                RoseBorder,
                RoundedCornerShape(22.dp)
            )
            .clickable { onProfileClick() }
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(RoseLight),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = profile.initials,
                    fontFamily = PoppinsFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = RosePrimary
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "${profile.name}, ${profile.age}",
                    fontFamily = PoppinsFamily,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "${profile.city} • ${profile.profession}",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = "${profile.match}% Match",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RosePrimary
                )
            }

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(RoseLight)
                    .clickable { onLikeClick() },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "♥",
                    fontSize = 20.sp,
                    color = RosePrimary
                )
            }
        }
    }
}