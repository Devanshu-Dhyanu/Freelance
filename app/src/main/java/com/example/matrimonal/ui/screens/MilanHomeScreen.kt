package com.example.matrimonal.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.*

/* ============================================================
   DATA
   ============================================================ */

private data class MilanHomeProfile(
    val name: String,
    val age: Int,
    val city: String,
    val profession: String = "",
    val matchPercent: Int,
    val religion: String = "",
    val tags: List<String> = emptyList()
)

private val featuredProfile = MilanHomeProfile(
    name = "Aarav Sharma",
    age = 25,
    city = "New Delhi",
    profession = "Software Engineer",
    matchPercent = 92,
    religion = "Hindu",
    tags = listOf(
        "Hindu",
        "MBA",
        "Non-smoker",
        "Family-oriented"
    )
)

private val discoverProfiles = listOf(
    MilanHomeProfile(
        name = "Riya",
        age = 24,
        city = "Chandigarh",
        matchPercent = 88
    ),
    MilanHomeProfile(
        name = "Aarav",
        age = 26,
        city = "Delhi",
        matchPercent = 90
    ),
    MilanHomeProfile(
        name = "Meera",
        age = 23,
        city = "Bengaluru",
        matchPercent = 85
    )
)

private val newMatchNames = listOf(
    "Anjali",
    "Pooja",
    "Sneha",
    "Kavya"
)

/* ============================================================
   MAIN HOME SCREEN
   ============================================================ */

@Composable
fun MilanHomeScreen(
    onDiscoverClick: () -> Unit = {},
    onMatchesClick: () -> Unit = {},
    onChatsClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onViewProfile: () -> Unit = {},
    onLikeProfile: () -> Unit = {}
) {

    var selectedNav by remember {
        mutableStateOf("Home")
    }

    var searchText by remember {
        mutableStateOf("")
    }

    val navHandler: (String) -> Unit = { item ->

        selectedNav = item

        when (item) {

            "Discover" -> onDiscoverClick()

            "Matches" -> onMatchesClick()

            "Chats" -> onChatsClick()

            "Profile" -> onProfileClick()
        }
    }

    Scaffold(

        bottomBar = {

            MilanHomeBottomNavigation(
                selectedItem = selectedNav,
                onNavigationItemClick = navHandler
            )
        },

        containerColor = Color(0xFFF7F0F2)

    ) { innerPadding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                )

        ) {

            /* =================================================
               HEADER
               ================================================= */

            Surface(
                color = Color.White,
                shadowElevation = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    MilanHomeTopBar(
                        onNotificationClick = onNotificationClick
                    )

                    MilanHomeGreeting()

                    MilanHomeSearchBar(
                        value = searchText,
                        onValueChange = {
                            searchText = it
                        },
                        onClick = onSearchClick
                    )

                    MilanHomeFilterRow()

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            /* =================================================
               RECOMMENDED FOR YOU
               ================================================= */

            Surface(
                color = Color.White,
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 18.dp
                    )
                ) {

                    MilanHomeSectionHeader(
                        title = "Recommended for You",
                        onSeeAll = {}
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    MilanHomeFeaturedCard(
                        profile = featuredProfile,
                        onViewProfile = onViewProfile,
                        onLike = onLikeProfile
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            /* =================================================
               DISCOVER MORE
               ================================================= */

            Surface(
                color = Color.White,
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(
                        vertical = 18.dp
                    )
                ) {

                    MilanHomeSectionHeader(
                        title = "Discover More",
                        onSeeAll = {},
                        modifier = Modifier.padding(
                            horizontal = 20.dp
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    LazyRow(

                        contentPadding = PaddingValues(
                            horizontal = 20.dp
                        ),

                        horizontalArrangement =
                            Arrangement.spacedBy(12.dp)

                    ) {

                        items(discoverProfiles) { profile ->

                            MilanHomeSmallCard(
                                profile = profile
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            /* =================================================
               NEW MATCHES
               ================================================= */

            Surface(
                color = Color.White,
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 18.dp
                    )
                ) {

                    MilanHomeSectionHeader(
                        title = "New Matches",
                        onSeeAll = {}
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Row(
                        horizontalArrangement =
                            Arrangement.spacedBy(16.dp)
                    ) {

                        newMatchNames.forEach { name ->

                            MilanHomeMatchAvatar(
                                name = name
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }
    }
}

/* ============================================================
   TOP BAR
   ============================================================ */

@Composable
private fun MilanHomeTopBar(
    onNotificationClick: () -> Unit
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 12.dp
            ),

        horizontalArrangement =
            Arrangement.SpaceBetween,

        verticalAlignment =
            Alignment.CenterVertically

    ) {

        /* Logo */

        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Canvas(
                modifier = Modifier.size(18.dp)
            ) {

                drawMilanHeart(
                    color = RosePrimary
                )
            }

            Spacer(
                modifier = Modifier.width(6.dp)
            )

            Text(
                text = "MILAN",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = RosePrimary,
                letterSpacing = 2.sp
            )
        }

        /* Actions */

        Row(

            verticalAlignment =
                Alignment.CenterVertically,

            horizontalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            /* Notification */

            Box(

                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(RoseVeryLight)
                    .clickable {
                        onNotificationClick()
                    },

                contentAlignment =
                    Alignment.Center

            ) {

                Canvas(
                    modifier = Modifier.size(20.dp)
                ) {

                    drawMilanBell(
                        color = RosePrimary
                    )
                }

                Box(

                    modifier = Modifier
                        .size(7.dp)
                        .clip(CircleShape)
                        .background(RosePrimary)
                        .align(Alignment.TopEnd)
                        .offset(
                            x = 2.dp,
                            y = (-2).dp
                        )
                )
            }

            /* Avatar */

            Box(

                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(
                        2.dp,
                        RosePrimary,
                        CircleShape
                    )
                    .background(RoseLight),

                contentAlignment =
                    Alignment.Center

            ) {

                Text(
                    text = "R",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = RosePrimary
                )
            }
        }
    }
}

/* ============================================================
   GREETING
   ============================================================ */

@Composable
private fun MilanHomeGreeting() {

    Column(

        modifier = Modifier.padding(
            horizontal = 20.dp,
            vertical = 4.dp
        )

    ) {

        Text(
            text = "Good Morning, Ritika ❤️",
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = TextMain
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = "Find someone who feels like home.",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = TextSecondary
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}

/* ============================================================
   SEARCH BAR
   ============================================================ */

@Composable
private fun MilanHomeSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit
) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(50.dp),

        placeholder = {

            Text(
                text = "Search profiles...",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = TextPlaceholder
            )
        },

        leadingIcon = {

            Canvas(
                modifier = Modifier.size(18.dp)
            ) {

                drawMilanSearch(
                    color = TextPlaceholder
                )
            }
        },

        singleLine = true,

        shape = RoundedCornerShape(14.dp),

        colors = OutlinedTextFieldDefaults.colors(

            focusedBorderColor = RosePrimary,

            unfocusedBorderColor = RoseBorder,

            focusedContainerColor =
                RoseVeryLight,

            unfocusedContainerColor =
                RoseVeryLight,

            cursorColor = RosePrimary,

            focusedTextColor = TextMain,

            unfocusedTextColor = TextMain
        ),

        textStyle = LocalTextStyle.current.copy(
            fontFamily = PoppinsFamily,
            fontSize = 13.sp
        )
    )

    Spacer(
        modifier = Modifier.height(14.dp)
    )
}

/* ============================================================
   FILTER ROW
   ============================================================ */

@Composable
private fun MilanHomeFilterRow() {

    val filters = listOf(
        "Age 22–28",
        "📍 Delhi",
        "Profession",
        "Religion",
        "More Filters"
    )

    var activeFilter by remember {
        mutableStateOf("Age 22–28")
    }

    Row(

        modifier = Modifier
            .horizontalScroll(
                rememberScrollState()
            )
            .padding(horizontal = 20.dp),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ) {

        filters.forEach { label ->

            MilanHomeFilterChip(
                label = label,
                active = label == activeFilter,
                onClick = {
                    activeFilter = label
                }
            )
        }
    }

    Spacer(
        modifier = Modifier.height(14.dp)
    )
}

@Composable
private fun MilanHomeFilterChip(
    label: String,
    active: Boolean,
    onClick: () -> Unit
) {

    val bg =
        if (active) RoseVeryLight
        else Color.White

    val border =
        if (active) RosePrimary
        else RoseBorder

    val text =
        if (active) RosePrimary
        else TextSecondary

    val weight =
        if (active)
            FontWeight.SemiBold
        else
            FontWeight.Normal

    Box(

        modifier = Modifier
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(bg)
            .border(
                1.5.dp,
                border,
                RoundedCornerShape(20.dp)
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 14.dp,
                vertical = 7.dp
            )

    ) {

        Text(
            text = label,
            fontFamily = PoppinsFamily,
            fontWeight = weight,
            fontSize = 12.sp,
            color = text
        )
    }
}

/* ============================================================
   SECTION HEADER
   ============================================================ */

@Composable
private fun MilanHomeSectionHeader(
    title: String,
    onSeeAll: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(

        modifier = modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.SpaceBetween,

        verticalAlignment =
            Alignment.CenterVertically

    ) {

        Text(
            text = title,
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = TextMain
        )

        Text(
            text = "See All →",
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = RosePrimary,

            modifier = Modifier.clickable {
                onSeeAll()
            }
        )
    }
}

/* ============================================================
   FEATURED PROFILE CARD
   ============================================================ */

@Composable
private fun MilanHomeFeaturedCard(
    profile: MilanHomeProfile,
    onViewProfile: () -> Unit,
    onLike: () -> Unit
) {

    var liked by remember {
        mutableStateOf(false)
    }

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                8.dp,
                RoundedCornerShape(20.dp)
            ),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )

    ) {

        Column {

            /* PHOTO */

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(

                        Brush.linearGradient(

                            colors = listOf(
                                RoseLight,
                                RosePrimary.copy(
                                    alpha = 0.55f
                                )
                            ),

                            start = Offset(0f, 0f),

                            end = Offset(
                                0f,
                                Float.POSITIVE_INFINITY
                            )
                        )
                    )

            ) {

                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {

                    val cx =
                        size.width / 2f

                    drawCircle(
                        color = RoseBorder,
                        radius = 60f,
                        center = Offset(
                            cx,
                            80f
                        )
                    )

                    drawOval(

                        color = RoseBorder,

                        topLeft = Offset(
                            cx - 80f,
                            150f
                        ),

                        size =
                            androidx.compose.ui.geometry.Size(
                                160f,
                                200f
                            )
                    )
                }

                /* Gradient overlay */

                Box(

                    modifier = Modifier
                        .fillMaxSize()
                        .background(

                            Brush.verticalGradient(

                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(
                                        alpha = 0.55f
                                    )
                                ),

                                startY = 120f
                            )
                        )
                )

                /* Match badge */

                Box(

                    modifier = Modifier
                        .padding(14.dp)
                        .align(Alignment.TopStart)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(

                            Brush.linearGradient(
                                listOf(
                                    RosePrimary,
                                    RoseDark
                                )
                            )
                        )
                        .padding(
                            horizontal = 12.dp,
                            vertical = 5.dp
                        )

                ) {

                    Text(
                        text =
                            "✦ ${profile.matchPercent}% Match",

                        fontFamily =
                            PoppinsFamily,

                        fontWeight =
                            FontWeight.Bold,

                        fontSize = 12.sp,

                        color = Color.White
                    )
                }

                /* Like */

                Box(

                    modifier = Modifier
                        .padding(14.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(
                                alpha = 0.95f
                            )
                        )
                        .clickable {

                            liked = !liked
                            onLike()
                        }
                        .align(Alignment.TopEnd),

                    contentAlignment =
                        Alignment.Center

                ) {

                    Text(
                        text =
                            if (liked) "♥"
                            else "♡",

                        fontSize = 18.sp,

                        color =
                            if (liked)
                                RosePrimary
                            else
                                TextSecondary
                    )
                }

                /* Profile information */

                Column(

                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)

                ) {

                    Row(
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(
                            text =
                                "${profile.name}, ${profile.age}",

                            fontFamily =
                                PoppinsFamily,

                            fontWeight =
                                FontWeight.Bold,

                            fontSize = 20.sp,

                            color = Color.White
                        )

                        Spacer(
                            modifier =
                                Modifier.width(6.dp)
                        )

                        Box(

                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape)
                                .background(
                                    RosePrimary
                                ),

                            contentAlignment =
                                Alignment.Center

                        ) {

                            Text(
                                text = "✓",
                                fontSize = 9.sp,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(
                        modifier =
                            Modifier.height(2.dp)
                    )

                    Text(
                        text =
                            "📍 ${profile.city}  ·  💼 ${profile.profession}",

                        fontFamily =
                            PoppinsFamily,

                        fontSize = 12.sp,

                        color =
                            Color.White.copy(
                                alpha = 0.85f
                            )
                    )
                }
            }

            /* CARD BODY */

            Column(
                modifier =
                    Modifier.padding(16.dp)
            ) {

                Row(

                    modifier =
                        Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.SpaceBetween,

                    verticalAlignment =
                        Alignment.CenterVertically

                ) {

                    Text(
                        text =
                            "Compatibility Score",

                        fontFamily =
                            PoppinsFamily,

                        fontWeight =
                            FontWeight.Medium,

                        fontSize = 11.sp,

                        color =
                            TextSecondary
                    )

                    Text(
                        text =
                            "${profile.matchPercent}%",

                        fontFamily =
                            PoppinsFamily,

                        fontWeight =
                            FontWeight.Bold,

                        fontSize = 12.sp,

                        color =
                            RosePrimary
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                /* Compatibility bar */

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(
                            RoundedCornerShape(3.dp)
                        )
                        .background(
                            RoseLight
                        )

                ) {

                    Box(

                        modifier = Modifier
                            .fillMaxWidth(
                                profile.matchPercent / 100f
                            )
                            .fillMaxHeight()
                            .clip(
                                RoundedCornerShape(3.dp)
                            )
                            .background(

                                Brush.horizontalGradient(
                                    listOf(
                                        RosePrimary,
                                        RoseDark
                                    )
                                )
                            )
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                /* Tags */

                Row(
                    horizontalArrangement =
                        Arrangement.spacedBy(6.dp)
                ) {

                    listOf(
                        "Hindu",
                        "MBA",
                        "Non-smoker"
                    ).forEach { tag ->

                        Box(

                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .background(
                                    RoseVeryLight
                                )
                                .border(
                                    1.dp,
                                    RoseBorder,
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 3.dp
                                )

                        ) {

                            Text(
                                text = tag,
                                fontFamily =
                                    PoppinsFamily,
                                fontSize = 10.sp,
                                color =
                                    TextSecondary
                            )
                        }
                    }
                }

                Spacer(
                    modifier =
                        Modifier.height(14.dp)
                )

                /* Buttons */

                Row(

                    modifier =
                        Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.spacedBy(10.dp)

                ) {

                    OutlinedButton(

                        onClick =
                            onViewProfile,

                        modifier =
                            Modifier
                                .weight(1f)
                                .height(44.dp),

                        shape =
                            RoundedCornerShape(12.dp),

                        border =
                            androidx.compose.foundation.BorderStroke(
                                1.5.dp,
                                RosePrimary
                            ),

                        colors =
                            ButtonDefaults.outlinedButtonColors(
                                containerColor =
                                    Color.White
                            )

                    ) {

                        Text(
                            text = "View Profile",

                            fontFamily =
                                PoppinsFamily,

                            fontWeight =
                                FontWeight.SemiBold,

                            fontSize = 13.sp,

                            color =
                                RosePrimary
                        )
                    }

                    Button(

                        onClick = {
                            liked = true
                            onLike()
                        },

                        modifier =
                            Modifier
                                .weight(1f)
                                .height(44.dp),

                        shape =
                            RoundedCornerShape(12.dp),

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor =
                                    Color.Transparent
                            ),

                        contentPadding =
                            PaddingValues(0.dp),

                        elevation =
                            ButtonDefaults.buttonElevation(
                                defaultElevation = 0.dp
                            )

                    ) {

                        Box(

                            modifier =
                                Modifier
                                    .fillMaxSize()
                                    .background(

                                        Brush.horizontalGradient(
                                            listOf(
                                                RosePrimary,
                                                RoseDark
                                            )
                                        ),

                                        shape =
                                            RoundedCornerShape(
                                                12.dp
                                            )
                                    ),

                            contentAlignment =
                                Alignment.Center

                        ) {

                            Text(
                                text = "♡ Like",

                                fontFamily =
                                    PoppinsFamily,

                                fontWeight =
                                    FontWeight.SemiBold,

                                fontSize = 13.sp,

                                color =
                                    Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

/* ============================================================
   SMALL DISCOVER CARD
   ============================================================ */

@Composable
private fun MilanHomeSmallCard(
    profile: MilanHomeProfile
) {

    var liked by remember {
        mutableStateOf(false)
    }

    Card(

        modifier = Modifier
            .width(140.dp)
            .shadow(
                4.dp,
                RoundedCornerShape(16.dp)
            ),

        shape =
            RoundedCornerShape(16.dp),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    Color.White
            ),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 0.dp
            )

    ) {

        Column {

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(

                        Brush.linearGradient(

                            listOf(
                                RoseLight,
                                RosePrimary.copy(
                                    alpha = 0.45f
                                )
                            ),

                            start = Offset(0f, 0f),

                            end = Offset(
                                0f,
                                Float.POSITIVE_INFINITY
                            )
                        )
                    )

            ) {

                Canvas(
                    modifier =
                        Modifier.fillMaxSize()
                ) {

                    val cx =
                        size.width / 2f

                    drawCircle(
                        color = RoseBorder,
                        radius = 36f,
                        center = Offset(
                            cx,
                            55f
                        )
                    )

                    drawOval(

                        color = RoseBorder,

                        topLeft = Offset(
                            cx - 50f,
                            95f
                        ),

                        size =
                            androidx.compose.ui.geometry.Size(
                                100f,
                                130f
                            )
                    )
                }

                /* Match badge */

                Box(

                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.BottomStart)
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                        .background(
                            RosePrimary.copy(
                                alpha = 0.92f
                            )
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 2.dp
                        )

                ) {

                    Text(
                        text =
                            "${profile.matchPercent}% Match",

                        fontFamily =
                            PoppinsFamily,

                        fontWeight =
                            FontWeight.SemiBold,

                        fontSize = 10.sp,

                        color =
                            Color.White
                    )
                }

                /* Like */

                Box(

                    modifier = Modifier
                        .padding(8.dp)
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(
                                alpha = 0.92f
                            )
                        )
                        .clickable {
                            liked = !liked
                        }
                        .align(Alignment.TopEnd),

                    contentAlignment =
                        Alignment.Center

                ) {

                    Text(
                        text =
                            if (liked) "♥"
                            else "♡",

                        fontSize = 13.sp,

                        color =
                            if (liked)
                                RosePrimary
                            else
                                TextSecondary
                    )
                }
            }

            Column(
                modifier =
                    Modifier.padding(10.dp)
            ) {

                Text(
                    text =
                        "${profile.name}, ${profile.age}",

                    fontFamily =
                        PoppinsFamily,

                    fontWeight =
                        FontWeight.SemiBold,

                    fontSize = 13.sp,

                    color =
                        TextMain
                )

                Spacer(
                    modifier =
                        Modifier.height(2.dp)
                )

                Text(
                    text =
                        profile.city,

                    fontFamily =
                        PoppinsFamily,

                    fontSize = 11.sp,

                    color =
                        TextSecondary
                )
            }
        }
    }
}

/* ============================================================
   NEW MATCH AVATAR
   ============================================================ */

@Composable
private fun MilanHomeMatchAvatar(
    name: String
) {

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Box(

            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .border(
                    2.5.dp,
                    RosePrimary,
                    CircleShape
                )
                .background(
                    RoseLight
                ),

            contentAlignment =
                Alignment.Center

        ) {

            Text(
                text =
                    name.first().toString(),

                fontFamily =
                    PoppinsFamily,

                fontWeight =
                    FontWeight.Bold,

                fontSize = 20.sp,

                color =
                    RosePrimary
            )
        }

        Spacer(
            modifier =
                Modifier.height(6.dp)
        )

        Text(
            text = name,

            fontFamily =
                PoppinsFamily,

            fontWeight =
                FontWeight.Medium,

            fontSize = 11.sp,

            color =
                TextMain,

            textAlign =
                TextAlign.Center
        )
    }
}

/* ============================================================
   BOTTOM NAVIGATION
   ============================================================ */

@Composable
private fun MilanHomeBottomNavigation(
    selectedItem: String,
    onNavigationItemClick: (String) -> Unit
) {

    val items = listOf(
        "Home",
        "Discover",
        "Matches",
        "Chats",
        "Profile"
    )

    Surface(

        color = Color.White,

        shadowElevation = 12.dp,

        modifier =
            Modifier.fillMaxWidth()

    ) {

        Row(

            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 10.dp
                    )
                    .navigationBarsPadding(),

            horizontalArrangement =
                Arrangement.SpaceAround,

            verticalAlignment =
                Alignment.CenterVertically

        ) {

            items.forEach { item ->

                MilanHomeNavItem(
                    label = item,
                    selected =
                        item == selectedItem,
                    onClick = {
                        onNavigationItemClick(item)
                    }
                )
            }
        }
    }
}

/* ============================================================
   NAVIGATION ITEM
   ============================================================ */

@Composable
private fun MilanHomeNavItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(

        modifier =
            Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .clickable {
                    onClick()
                }
                .padding(
                    horizontal = 10.dp,
                    vertical = 6.dp
                ),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.spacedBy(3.dp)

    ) {

        val iconColor =
            if (selected)
                RosePrimary
            else
                TextSecondary

        Canvas(
            modifier =
                Modifier.size(22.dp)
        ) {

            when (label) {

                "Home" ->
                    drawNavHome(iconColor)

                "Discover" ->
                    drawNavDiscover(iconColor)

                "Matches" ->
                    drawNavMatches(iconColor)

                "Chats" ->
                    drawNavChats(iconColor)

                "Profile" ->
                    drawNavProfile(iconColor)
            }
        }

        Text(

            text = label,

            fontFamily =
                PoppinsFamily,

            fontWeight =
                if (selected)
                    FontWeight.SemiBold
                else
                    FontWeight.Normal,

            fontSize = 10.sp,

            color =
                if (selected)
                    RosePrimary
                else
                    TextSecondary
        )

        if (selected) {

            Box(

                modifier =
                    Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(
                            RosePrimary
                        )
            )
        }
    }
}

/* ============================================================
   DRAW HEART
   ============================================================ */

private fun DrawScope.drawMilanHeart(
    color: Color
) {

    val path =
        Path().apply {

            moveTo(
                size.width / 2f,
                size.height * 0.88f
            )

            cubicTo(
                size.width * 0.1f,
                size.height * 0.62f,
                0f,
                size.height * 0.36f,
                0f,
                size.height * 0.28f
            )

            cubicTo(
                0f,
                size.height * 0.10f,
                size.width * 0.18f,
                0f,
                size.width * 0.34f,
                0f
            )

            cubicTo(
                size.width * 0.45f,
                0f,
                size.width / 2f,
                size.height * 0.12f,
                size.width / 2f,
                size.height * 0.12f
            )

            cubicTo(
                size.width / 2f,
                size.height * 0.12f,
                size.width * 0.55f,
                0f,
                size.width * 0.66f,
                0f
            )

            cubicTo(
                size.width * 0.82f,
                0f,
                size.width,
                size.height * 0.10f,
                size.width,
                size.height * 0.28f
            )

            cubicTo(
                size.width,
                size.height * 0.36f,
                size.width * 0.9f,
                size.height * 0.62f,
                size.width / 2f,
                size.height * 0.88f
            )

            close()
        }

    drawPath(
        path = path,
        color = color
    )
}

/* ============================================================
   DRAW BELL
   ============================================================ */

private fun DrawScope.drawMilanBell(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.6.dp.toPx(),
            cap = StrokeCap.Round
        )

    drawArc(

        color = color,

        startAngle = 180f,

        sweepAngle = 180f,

        useCenter = false,

        topLeft = Offset(
            size.width * 0.2f,
            size.height * 0.1f
        ),

        size =
            androidx.compose.ui.geometry.Size(
                size.width * 0.6f,
                size.height * 0.6f
            ),

        style = stroke
    )

    drawLine(

        color = color,

        start = Offset(
            0f,
            size.height * 0.72f
        ),

        end = Offset(
            size.width,
            size.height * 0.72f
        ),

        strokeWidth =
            1.6.dp.toPx(),

        cap = StrokeCap.Round
    )

    drawLine(

        color = color,

        start = Offset(
            size.width * 0.38f,
            size.height * 0.86f
        ),

        end = Offset(
            size.width * 0.62f,
            size.height * 0.86f
        ),

        strokeWidth =
            1.6.dp.toPx(),

        cap = StrokeCap.Round
    )
}

/* ============================================================
   DRAW SEARCH
   ============================================================ */

private fun DrawScope.drawMilanSearch(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.5.dp.toPx(),
            cap = StrokeCap.Round
        )

    drawCircle(

        color = color,

        radius =
            size.width * 0.32f,

        center =
            Offset(
                size.width * 0.44f,
                size.height * 0.44f
            ),

        style = stroke
    )

    drawLine(

        color = color,

        start =
            Offset(
                size.width * 0.68f,
                size.height * 0.68f
            ),

        end =
            Offset(
                size.width * 0.92f,
                size.height * 0.92f
            ),

        strokeWidth =
            1.5.dp.toPx(),

        cap = StrokeCap.Round
    )
}

/* ============================================================
   DRAW HOME ICON
   ============================================================ */

private fun DrawScope.drawNavHome(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.6.dp.toPx(),
            cap = StrokeCap.Round,
            join = StrokeJoin.Round
        )

    val path =
        Path().apply {

            moveTo(
                size.width * 0.12f,
                size.height * 0.46f
            )

            lineTo(
                size.width / 2f,
                size.height * 0.08f
            )

            lineTo(
                size.width * 0.88f,
                size.height * 0.46f
            )

            lineTo(
                size.width * 0.88f,
                size.height * 0.92f
            )

            lineTo(
                size.width * 0.60f,
                size.height * 0.92f
            )

            lineTo(
                size.width * 0.60f,
                size.height * 0.64f
            )

            lineTo(
                size.width * 0.40f,
                size.height * 0.64f
            )

            lineTo(
                size.width * 0.40f,
                size.height * 0.92f
            )

            lineTo(
                size.width * 0.12f,
                size.height * 0.92f
            )

            close()
        }

    drawPath(
        path = path,
        color = color,
        style = stroke
    )
}

/* ============================================================
   DRAW DISCOVER ICON
   ============================================================ */

private fun DrawScope.drawNavDiscover(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.6.dp.toPx()
        )

    val center =
        Offset(
            size.width / 2f,
            size.height / 2f
        )

    drawCircle(
        color = color,
        radius = size.width * 0.42f,
        center = center,
        style = stroke
    )

    drawCircle(
        color = color,
        radius = size.width * 0.16f,
        center = center,
        style = stroke
    )

    val lineWidth =
        1.6.dp.toPx()

    drawLine(
        color,
        Offset(
            center.x,
            size.height * 0.06f
        ),
        Offset(
            center.x,
            size.height * 0.26f
        ),
        lineWidth
    )

    drawLine(
        color,
        Offset(
            center.x,
            size.height * 0.74f
        ),
        Offset(
            center.x,
            size.height * 0.94f
        ),
        lineWidth
    )

    drawLine(
        color,
        Offset(
            size.width * 0.06f,
            center.y
        ),
        Offset(
            size.width * 0.26f,
            center.y
        ),
        lineWidth
    )

    drawLine(
        color,
        Offset(
            size.width * 0.74f,
            center.y
        ),
        Offset(
            size.width * 0.94f,
            center.y
        ),
        lineWidth
    )
}

/* ============================================================
   DRAW MATCHES ICON
   ============================================================ */

private fun DrawScope.drawNavMatches(
    color: Color
) {

    val path =
        Path().apply {

            moveTo(
                size.width / 2f,
                size.height * 0.88f
            )

            cubicTo(
                size.width * 0.1f,
                size.height * 0.62f,
                0f,
                size.height * 0.36f,
                0f,
                size.height * 0.30f
            )

            cubicTo(
                0f,
                size.height * 0.12f,
                size.width * 0.18f,
                0f,
                size.width * 0.34f,
                0f
            )

            cubicTo(
                size.width * 0.45f,
                0f,
                size.width / 2f,
                size.height * 0.12f,
                size.width / 2f,
                size.height * 0.12f
            )

            cubicTo(
                size.width / 2f,
                size.height * 0.12f,
                size.width * 0.55f,
                0f,
                size.width * 0.66f,
                0f
            )

            cubicTo(
                size.width * 0.82f,
                0f,
                size.width,
                size.height * 0.12f,
                size.width,
                size.height * 0.30f
            )

            cubicTo(
                size.width,
                size.height * 0.36f,
                size.width * 0.9f,
                size.height * 0.62f,
                size.width / 2f,
                size.height * 0.88f
            )

            close()
        }

    drawPath(

        path = path,

        color = color,

        style =
            androidx.compose.ui.graphics.drawscope.Stroke(
                width = 1.6.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
    )
}

/* ============================================================
   DRAW CHAT ICON
   ============================================================ */

private fun DrawScope.drawNavChats(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.6.dp.toPx(),
            join = StrokeJoin.Round
        )

    val path =
        Path().apply {

            moveTo(
                size.width * 0.12f,
                size.height * 0.14f
            )

            lineTo(
                size.width * 0.88f,
                size.height * 0.14f
            )

            cubicTo(
                size.width * 0.94f,
                size.height * 0.14f,
                size.width * 0.94f,
                size.height * 0.20f,
                size.width * 0.94f,
                size.height * 0.20f
            )

            lineTo(
                size.width * 0.94f,
                size.height * 0.68f
            )

            cubicTo(
                size.width * 0.94f,
                size.height * 0.74f,
                size.width * 0.88f,
                size.height * 0.74f,
                size.width * 0.88f,
                size.height * 0.74f
            )

            lineTo(
                size.width * 0.32f,
                size.height * 0.74f
            )

            lineTo(
                size.width * 0.12f,
                size.height * 0.94f
            )

            lineTo(
                size.width * 0.12f,
                size.height * 0.20f
            )

            close()
        }

    drawPath(
        path = path,
        color = color,
        style = stroke
    )

    val lineWidth =
        1.4.dp.toPx()

    drawLine(
        color,
        Offset(
            size.width * 0.30f,
            size.height * 0.42f
        ),
        Offset(
            size.width * 0.70f,
            size.height * 0.42f
        ),
        lineWidth,
        cap = StrokeCap.Round
    )

    drawLine(
        color,
        Offset(
            size.width * 0.30f,
            size.height * 0.56f
        ),
        Offset(
            size.width * 0.55f,
            size.height * 0.56f
        ),
        lineWidth,
        cap = StrokeCap.Round
    )
}

/* ============================================================
   DRAW PROFILE ICON
   ============================================================ */

private fun DrawScope.drawNavProfile(
    color: Color
) {

    val stroke =
        androidx.compose.ui.graphics.drawscope.Stroke(
            width = 1.6.dp.toPx(),
            cap = StrokeCap.Round
        )

    drawCircle(

        color = color,

        radius =
            size.width * 0.22f,

        center =
            Offset(
                size.width / 2f,
                size.height * 0.34f
            ),

        style = stroke
    )

    drawArc(

        color = color,

        startAngle = 0f,

        sweepAngle = 180f,

        useCenter = false,

        topLeft =
            Offset(
                size.width * 0.10f,
                size.height * 0.54f
            ),

        size =
            androidx.compose.ui.geometry.Size(
                size.width * 0.80f,
                size.height * 0.44f
            ),

        style = stroke
    )
}