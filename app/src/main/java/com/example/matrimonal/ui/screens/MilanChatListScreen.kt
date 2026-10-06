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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MoreVert

data class MilanChatPreview(
    val name: String,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int,
    val isOnline: Boolean,
    val initials: String
)

@Composable
fun MilanChatListScreen(
    onBackClick: () -> Unit = {},
    onChatClick: () -> Unit = {}
) {

    var searchText by remember {
        mutableStateOf("")
    }

    var selectedTab by remember {
        mutableStateOf("All")
    }

    val chats = listOf(
        MilanChatPreview(
            name = "Anjali Verma",
            lastMessage = "That sounds really nice 😊",
            time = "10:42 PM",
            unreadCount = 2,
            isOnline = true,
            initials = "AV"
        ),
        MilanChatPreview(
            name = "Pooja Sharma",
            lastMessage = "Would love to know more about you!",
            time = "8:15 PM",
            unreadCount = 1,
            isOnline = true,
            initials = "PS"
        ),
        MilanChatPreview(
            name = "Sneha Kapoor",
            lastMessage = "Thank you! Have a great day.",
            time = "Yesterday",
            unreadCount = 0,
            isOnline = false,
            initials = "SK"
        ),
        MilanChatPreview(
            name = "Kavya Mehta",
            lastMessage = "Let's talk tomorrow 😊",
            time = "Yesterday",
            unreadCount = 0,
            isOnline = true,
            initials = "KM"
        )
    )

    val filteredChats = chats.filter { chat ->
        val matchesSearch =
            chat.name.contains(searchText, ignoreCase = true)

        val matchesTab = when (selectedTab) {
            "Unread" -> chat.unreadCount > 0
            "Active" -> chat.isOnline
            else -> true
        }

        matchesSearch && matchesTab
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
    ) {

        // ---------------- TOP BAR ----------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 16.dp,
                    bottom = 8.dp
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

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Chats",
                    fontFamily = PoppinsFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Text(
                    text = "Connect with your matches",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    color = TextSecondary
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

        // ---------------- SEARCH ----------------

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
                ),
            placeholder = {
                Text(
                    text = "Search conversations",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = TextSecondary
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = RosePrimary
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RosePrimary,
                unfocusedBorderColor = RoseBorder,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // ---------------- TABS ----------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            ChatTab(
                text = "All",
                selected = selectedTab == "All",
                onClick = {
                    selectedTab = "All"
                }
            )

            ChatTab(
                text = "Unread",
                selected = selectedTab == "Unread",
                onClick = {
                    selectedTab = "Unread"
                }
            )

            ChatTab(
                text = "Active",
                selected = selectedTab == "Active",
                onClick = {
                    selectedTab = "Active"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // ---------------- CHAT LIST ----------------

        if (filteredChats.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "💬",
                        fontSize = 42.sp
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "No conversations found",
                        fontFamily = PoppinsFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextMain
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Try searching for another match",
                        fontFamily = PoppinsFamily,
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    bottom = 24.dp
                )
            ) {

                items(
                    items = filteredChats,
                    key = {
                        it.name
                    }
                ) { chat ->

                    MilanChatRow(
                        chat = chat,
                        onClick = onChatClick
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    TextButton(
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) {
                    RosePrimary
                } else {
                    RoseLight
                }
            )
    ) {

        Text(
            text = text,
            fontFamily = PoppinsFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected) {
                Color.White
            } else {
                RosePrimary
            }
        )
    }
}

@Composable
private fun MilanChatRow(
    chat: MilanChatPreview,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // ---------------- AVATAR ----------------

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
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = RosePrimary
            )

            if (chat.isOnline) {

                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50))
                        .align(Alignment.BottomEnd)
                )
            }
        }

        Spacer(
            modifier = Modifier.width(14.dp)
        )

        // ---------------- MESSAGE INFO ----------------

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = chat.name,
                    fontFamily = PoppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = chat.time,
                    fontFamily = PoppinsFamily,
                    fontSize = 10.sp,
                    color = if (chat.unreadCount > 0) {
                        RosePrimary
                    } else {
                        TextSecondary
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = chat.lastMessage,
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    color = if (chat.unreadCount > 0) {
                        TextMain
                    } else {
                        TextSecondary
                    },
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )

                if (chat.unreadCount > 0) {

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .size(22.dp)
                            .clip(CircleShape)
                            .background(RosePrimary),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = chat.unreadCount.toString(),
                            fontFamily = PoppinsFamily,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}