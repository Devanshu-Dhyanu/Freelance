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
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

private data class ChatPreview(
    val name: String,
    val initials: String,
    val message: String,
    val time: String,
    val unread: Int
)

private val chats = listOf(
    ChatPreview("Anjali", "A", "Hey! How are you?", "10:42 AM", 2),
    ChatPreview("Pooja", "P", "It was nice talking to you.", "Yesterday", 0),
    ChatPreview("Sneha", "S", "Are you from Delhi?", "Yesterday", 1),
    ChatPreview("Kavya", "K", "Have a great day!", "Monday", 0)
)

@Composable
fun MilanChatListScreen(
    onBackClick: () -> Unit = {},
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
                text = "Messages",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            items(chats) { chat ->

                MilanChatPreview(
                    chat = chat,
                    onClick = onChatClick
                )
            }
        }
    }
}

@Composable
private fun MilanChatPreview(
    chat: ChatPreview,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 12.dp),
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
                text = chat.initials,
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
                text = chat.name,
                fontFamily = PoppinsFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextMain
            )

            Text(
                text = chat.message,
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = TextSecondary,
                maxLines = 1
            )
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Text(
                text = chat.time,
                fontFamily = PoppinsFamily,
                fontSize = 10.sp,
                color = TextSecondary
            )

            if (chat.unread > 0) {

                Box(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(RosePrimary),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = chat.unread.toString(),
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}