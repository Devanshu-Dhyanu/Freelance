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

private data class MatchProfile(
    val name: String,
    val age: Int,
    val city: String,
    val initials: String,
    val percentage: Int
)

private val matches = listOf(
    MatchProfile("Anjali", 24, "Delhi", "A", 94),
    MatchProfile("Pooja", 25, "Mumbai", "P", 91),
    MatchProfile("Sneha", 23, "Pune", "S", 89),
    MatchProfile("Kavya", 26, "Bengaluru", "K", 87)
)

@Composable
fun MilanMatchesScreen(
    onBackClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onChatClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

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
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "My Matches",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )
        }

        Text(
            text = "People who match your preferences",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = TextSecondary,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(matches) { match ->

                MilanMatchCard(
                    match = match,
                    onProfileClick = onProfileClick,
                    onChatClick = onChatClick
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun MilanMatchCard(
    match: MatchProfile,
    onProfileClick: () -> Unit,
    onChatClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .border(1.dp, RoseBorder, RoundedCornerShape(20.dp))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(62.dp)
                .clip(CircleShape)
                .background(RoseLight),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = match.initials,
                fontFamily = PoppinsFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = RosePrimary
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .clickable { onProfileClick() }
        ) {

            Text(
                text = "${match.name}, ${match.age}",
                fontFamily = PoppinsFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextMain
            )

            Text(
                text = match.city,
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "${match.percentage}% Compatible",
                fontFamily = PoppinsFamily,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = RosePrimary
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(RosePrimary)
                .clickable { onChatClick() }
                .padding(horizontal = 14.dp, vertical = 9.dp)
        ) {

            Text(
                text = "Chat",
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}