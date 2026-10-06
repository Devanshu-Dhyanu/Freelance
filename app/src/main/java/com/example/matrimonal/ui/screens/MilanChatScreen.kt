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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

data class MilanMessage(
    val text: String,
    val isMine: Boolean,
    val time: String
)

@Composable
fun MilanChatScreen(
    onBackClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onCallClick: () -> Unit = {},
    onVideoCallClick: () -> Unit = {}
) {

    var messageText by remember {
        mutableStateOf("")
    }

    val messages = remember {
        mutableStateListOf(
            MilanMessage(
                text = "Hi! Nice to connect with you 😊",
                isMine = false,
                time = "10:32 PM"
            ),
            MilanMessage(
                text = "Hi Anjali! Nice to connect with you too.",
                isMine = true,
                time = "10:34 PM"
            ),
            MilanMessage(
                text = "How was your day?",
                isMine = false,
                time = "10:36 PM"
            ),
            MilanMessage(
                text = "It was good! I had a busy day at work.",
                isMine = true,
                time = "10:38 PM"
            ),
            MilanMessage(
                text = "That sounds really nice 😊",
                isMine = false,
                time = "10:42 PM"
            )
        )
    }

    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .imePadding()
    ) {

        // ============================================================
        // TOP BAR
        // ============================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = TextMain
                )
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        onProfileClick()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(RoseLight),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "AV",
                        fontFamily = PoppinsFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosePrimary
                    )

                    Box(
                        modifier = Modifier
                            .size(11.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4CAF50))
                            .align(Alignment.BottomEnd)
                    )
                }

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Column {

                    Text(
                        text = "Anjali Verma",
                        fontFamily = PoppinsFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextMain
                    )

                    Text(
                        text = "Online",
                        fontFamily = PoppinsFamily,
                        fontSize = 11.sp,
                        color = Color(0xFF4CAF50)
                    )
                }
            }

            IconButton(
                onClick = onCallClick
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = RosePrimary
                )
            }

            TextButton(
                onClick = onVideoCallClick
            ) {
                Text(
                    text = "📹",
                    fontSize = 22.sp
                )
            }

            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = TextMain
                )
            }
        }

        // ============================================================
        // PROFILE CONNECTION BANNER
        // ============================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                )
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White)
                .clickable {
                    onProfileClick()
                }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(RoseLight),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "AV",
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = RosePrimary
                )
            }

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "You matched with Anjali",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain
                )

                Text(
                    text = "92% compatibility • View profile",
                    fontFamily = PoppinsFamily,
                    fontSize = 10.sp,
                    color = TextSecondary
                )
            }

            Text(
                text = "♥",
                fontSize = 20.sp,
                color = RosePrimary
            )
        }

        // ============================================================
        // DATE
        // ============================================================

        Text(
            text = "Today",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            fontFamily = PoppinsFamily,
            fontSize = 10.sp,
            color = TextSecondary
        )

        // ============================================================
        // MESSAGES
        // ============================================================

        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                top = 8.dp,
                bottom = 12.dp
            )
        ) {

            items(
                items = messages
            ) { message ->

                MilanMessageBubble(
                    message = message
                )
            }
        }

        // ============================================================
        // MESSAGE INPUT
        // ============================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    horizontal = 12.dp,
                    vertical = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = messageText,
                onValueChange = {
                    messageText = it
                },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        text = "Type a message...",
                        fontFamily = PoppinsFamily,
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(24.dp),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RosePrimary,
                    unfocusedBorderColor = RoseBorder,
                    focusedContainerColor = RoseVeryLight,
                    unfocusedContainerColor = RoseVeryLight
                )
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        if (messageText.isNotBlank()) {
                            RosePrimary
                        } else {
                            RoseLight
                        }
                    )
                    .clickable {

                        if (messageText.isNotBlank()) {

                            messages.add(
                                MilanMessage(
                                    text = messageText.trim(),
                                    isMine = true,
                                    time = "Now"
                                )
                            )

                            messageText = ""
                        }
                    },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = if (messageText.isNotBlank()) {
                        Color.White
                    } else {
                        RosePrimary
                    }
                )
            }
        }
    }
}

@Composable
private fun MilanMessageBubble(
    message: MilanMessage
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isMine) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {

        Column(
            horizontalAlignment = if (message.isMine) {
                Alignment.End
            } else {
                Alignment.Start
            }
        ) {

            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 18.dp,
                            topEnd = 18.dp,
                            bottomStart = if (message.isMine) 18.dp else 4.dp,
                            bottomEnd = if (message.isMine) 4.dp else 18.dp
                        )
                    )
                    .background(
                        if (message.isMine) {
                            RosePrimary
                        } else {
                            Color.White
                        }
                    )
                    .padding(
                        horizontal = 14.dp,
                        vertical = 10.dp
                    )
            ) {

                Text(
                    text = message.text,
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    color = if (message.isMine) {
                        Color.White
                    } else {
                        TextMain
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = message.time,
                fontFamily = PoppinsFamily,
                fontSize = 9.sp,
                color = TextSecondary
            )
        }
    }
}