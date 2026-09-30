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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.PoppinsFamily
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

private data class MilanMessage(
    val text: String,
    val mine: Boolean
)

@Composable
fun MilanChatScreen(
    onBackClick: () -> Unit = {}
) {

    var message by remember { mutableStateOf("") }

    var messages by remember {
        mutableStateOf(
            listOf(
                MilanMessage("Hey! How are you?", false),
                MilanMessage("I'm doing great! How about you?", true),
                MilanMessage("I'm good too 😊", false),
                MilanMessage("Nice to connect with you!", true)
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .imePadding()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "‹",
                fontSize = 36.sp,
                color = TextMain,
                modifier = Modifier
                    .width(40.dp)
                    .padding(bottom = 3.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(RoseLight),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "A",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.Bold,
                    color = RosePrimary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = "Anjali",
                    fontFamily = PoppinsFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain
                )

                Text(
                    text = "Online",
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    color = RosePrimary
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            reverseLayout = false
        ) {

            items(messages) { msg ->

                MilanMessageBubble(msg)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        text = "Type a message...",
                        fontFamily = PoppinsFamily,
                        fontSize = 13.sp
                    )
                },
                shape = RoundedCornerShape(22.dp),
                singleLine = true
            )

            TextButton(
                onClick = {

                    if (message.isNotBlank()) {

                        messages = messages + MilanMessage(
                            message,
                            true
                        )

                        message = ""
                    }
                }
            ) {

                Text(
                    text = "Send",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = RosePrimary
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
        horizontalArrangement = if (message.mine)
            Arrangement.End
        else
            Arrangement.Start
    ) {

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 18.dp,
                        bottomStart = if (message.mine) 18.dp else 4.dp,
                        bottomEnd = if (message.mine) 4.dp else 18.dp
                    )
                )
                .background(
                    if (message.mine) RosePrimary else Color.White
                )
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {

            Text(
                text = message.text,
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = if (message.mine) Color.White else TextMain
            )
        }
    }
}