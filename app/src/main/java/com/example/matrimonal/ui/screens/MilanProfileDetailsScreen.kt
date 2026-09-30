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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

@Composable
fun MilanProfileDetailsScreen(
    onBackClick: () -> Unit = {},
    onLikeClick: () -> Unit = {},
    onChatClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight)
            .verticalScroll(rememberScrollState())
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
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Profile",
                fontFamily = PoppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextMain
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(280.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(RoseLight),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "AS",
                fontFamily = PoppinsFamily,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = RosePrimary
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Aarav Sharma, 25",
                    fontFamily = PoppinsFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(RosePrimary)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {

                    Text(
                        text = "92%",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Text(
                text = "New Delhi • Software Engineer",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(18.dp))

            DetailSection(
                "About",
                "A software professional who enjoys travelling, technology, music and spending time with family."
            )

            DetailSection(
                "Education",
                "MBA • Business Management"
            )

            DetailSection(
                "Lifestyle",
                "Non-smoker • Family-oriented"
            )

            DetailSection(
                "Religion",
                "Hindu"
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .border(
                            1.dp,
                            RoseBorder,
                            RoundedCornerShape(15.dp)
                        )
                        .clickable {
                            onLikeClick()
                        }
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "♥ Like",
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = RosePrimary
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(15.dp))
                        .background(RosePrimary)
                        .clickable {
                            onChatClick()
                        }
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Message",
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
private fun DetailSection(
    title: String,
    value: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
    ) {

        Text(
            text = title,
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = RosePrimary
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = value,
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = TextMain
        )
    }
}