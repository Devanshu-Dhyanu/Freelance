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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
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
fun MilanEditProfileScreen(
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {

    // ============================================================
    // PERSONAL INFORMATION
    // ============================================================

    var fullName by remember {
        mutableStateOf("Ritika Goel")
    }

    var dateOfBirth by remember {
        mutableStateOf("15 June 2005")
    }

    var gender by remember {
        mutableStateOf("Female")
    }

    var phoneNumber by remember {
        mutableStateOf("+91 9876543210")
    }

    var location by remember {
        mutableStateOf("New Delhi")
    }

    // ============================================================
    // EDUCATION & CAREER
    // ============================================================

    var education by remember {
        mutableStateOf("B.Tech Computer Science")
    }

    var occupation by remember {
        mutableStateOf("Software Developer")
    }

    var workLocation by remember {
        mutableStateOf("New Delhi")
    }

    // ============================================================
    // ABOUT
    // ============================================================

    var aboutMe by remember {
        mutableStateOf(
            "I am a passionate and ambitious person who enjoys learning new things, travelling and spending quality time with family and friends."
        )
    }

    // ============================================================
    // LIFESTYLE
    // ============================================================

    var diet by remember {
        mutableStateOf("Vegetarian")
    }

    var smoking by remember {
        mutableStateOf("Never")
    }

    var drinking by remember {
        mutableStateOf("Occasionally")
    }

    // ============================================================
    // INTERESTS
    // ============================================================

    var interests by remember {
        mutableStateOf("Travel, Music, Technology")
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(RoseVeryLight),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // ========================================================
        // TOP BAR
        // ========================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 14.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "‹",
                    fontSize = 34.sp,
                    color = TextMain,
                    modifier = Modifier
                        .clickable {
                            onBackClick()
                        }
                        .padding(end = 12.dp)
                )

                Text(
                    text = "Edit Profile",
                    fontFamily = PoppinsFamily,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMain
                )
            }
        }

        // ========================================================
        // PROFILE PHOTO
        // ========================================================

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(105.dp)
                        .clip(CircleShape)
                        .background(RoseLight),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "R",
                        fontFamily = PoppinsFamily,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosePrimary
                    )
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Change Photo",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RosePrimary,
                    modifier = Modifier.clickable {
                        // Photo picker will be connected later.
                    }
                )
            }
        }

        // ========================================================
        // PERSONAL INFORMATION
        // ========================================================

        item {

            EditProfileSectionTitle(
                title = "Personal Information"
            )
        }

        item {

            EditProfileInput(
                label = "Full Name",
                value = fullName,
                onValueChange = {
                    fullName = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Date of Birth",
                value = dateOfBirth,
                onValueChange = {
                    dateOfBirth = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Gender",
                value = gender,
                onValueChange = {
                    gender = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Phone Number",
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                keyboardType = KeyboardType.Phone
            )
        }

        item {

            EditProfileInput(
                label = "Location",
                value = location,
                onValueChange = {
                    location = it
                }
            )
        }

        // ========================================================
        // EDUCATION & CAREER
        // ========================================================

        item {

            EditProfileSectionTitle(
                title = "Education & Career"
            )
        }

        item {

            EditProfileInput(
                label = "Education",
                value = education,
                onValueChange = {
                    education = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Occupation",
                value = occupation,
                onValueChange = {
                    occupation = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Work Location",
                value = workLocation,
                onValueChange = {
                    workLocation = it
                }
            )
        }

        // ========================================================
        // ABOUT ME
        // ========================================================

        item {

            EditProfileSectionTitle(
                title = "About Me"
            )
        }

        item {

            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "Bio",
                    fontFamily = PoppinsFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextMain
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                OutlinedTextField(
                    value = aboutMe,
                    onValueChange = {
                        aboutMe = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 4,
                    maxLines = 6,
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {
                        Text(
                            text = "Tell something about yourself...",
                            fontFamily = PoppinsFamily,
                            fontSize = 12.sp
                        )
                    },
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = RosePrimary,
                        unfocusedBorderColor = RoseBorder,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }
        }

        // ========================================================
        // LIFESTYLE
        // ========================================================

        item {

            EditProfileSectionTitle(
                title = "Lifestyle"
            )
        }

        item {

            EditProfileInput(
                label = "Diet",
                value = diet,
                onValueChange = {
                    diet = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Smoking",
                value = smoking,
                onValueChange = {
                    smoking = it
                }
            )
        }

        item {

            EditProfileInput(
                label = "Drinking",
                value = drinking,
                onValueChange = {
                    drinking = it
                }
            )
        }

        // ========================================================
        // INTERESTS
        // ========================================================

        item {

            EditProfileSectionTitle(
                title = "Interests"
            )
        }

        item {

            EditProfileInput(
                label = "Your Interests",
                value = interests,
                onValueChange = {
                    interests = it
                }
            )
        }

        // ========================================================
        // SAVE BUTTON
        // ========================================================

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 18.dp
                    )
            ) {

                Button(
                    onClick = {
                        onSaveClick()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RosePrimary
                    )
                ) {

                    Text(
                        text = "Save Changes",
                        fontFamily = PoppinsFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Your profile information is private and secure.",
                    fontFamily = PoppinsFamily,
                    fontSize = 10.sp,
                    color = TextSecondary,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}


// ================================================================
// SECTION TITLE
// ================================================================

@Composable
private fun EditProfileSectionTitle(
    title: String
) {

    Text(
        text = title,
        fontFamily = PoppinsFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = TextMain,
        modifier = Modifier.padding(
            start = 20.dp,
            top = 8.dp,
            bottom = 2.dp
        )
    )
}


// ================================================================
// INPUT FIELD
// ================================================================

@Composable
private fun EditProfileInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    Column(
        modifier = Modifier.padding(
            horizontal = 20.dp
        )
    ) {

        Text(
            text = label,
            fontFamily = PoppinsFamily,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = TextSecondary,
            modifier = Modifier.padding(
                bottom = 5.dp
            )
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RosePrimary,
                unfocusedBorderColor = RoseBorder,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = RosePrimary
            )
        )
    }
}