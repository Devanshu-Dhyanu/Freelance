
package com.example.matrimonal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val RosePrimary = Color(0xFFE85B78)
private val TextMain = Color(0xFF333333)

data class MilanEditableProfile(
    val fullName: String = "Ritika Goel",
    val dateOfBirth: String = "15 June 2005",
    val gender: String = "Female",
    val phoneNumber: String = "",
    val location: String = "",
    val education: String = "",
    val occupation: String = "",
    val workLocation: String = "",
    val aboutMe: String = "",
    val diet: String = "Vegetarian",
    val smoking: String = "Never",
    val drinking: String = "Occasionally",
    val interests: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilanEditProfileScreen(
    onBackClick: () -> Unit = {},
    initialProfile: MilanEditableProfile = MilanEditableProfile(),
    onSaveClick: (MilanEditableProfile) -> Unit = {}
) {
    var fullName by remember(initialProfile) {
        mutableStateOf(initialProfile.fullName)
    }
    var dateOfBirth by remember(initialProfile) {
        mutableStateOf(initialProfile.dateOfBirth)
    }
    var gender by remember(initialProfile) {
        mutableStateOf(initialProfile.gender)
    }
    var phoneNumber by remember(initialProfile) {
        mutableStateOf(initialProfile.phoneNumber)
    }
    var location by remember(initialProfile) {
        mutableStateOf(initialProfile.location)
    }
    var education by remember(initialProfile) {
        mutableStateOf(initialProfile.education)
    }
    var occupation by remember(initialProfile) {
        mutableStateOf(initialProfile.occupation)
    }
    var workLocation by remember(initialProfile) {
        mutableStateOf(initialProfile.workLocation)
    }
    var aboutMe by remember(initialProfile) {
        mutableStateOf(initialProfile.aboutMe)
    }
    var diet by remember(initialProfile) {
        mutableStateOf(initialProfile.diet)
    }
    var smoking by remember(initialProfile) {
        mutableStateOf(initialProfile.smoking)
    }
    var drinking by remember(initialProfile) {
        mutableStateOf(initialProfile.drinking)
    }
    var interests by remember(initialProfile) {
        mutableStateOf(initialProfile.interests)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Edit Profile",
                        fontWeight = FontWeight.Bold,
                        color = TextMain
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        },
        containerColor = Color(0xFFFFF8FA)
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            SectionTitle("Personal Information")

            ProfileEditField(
                label = "Full Name",
                value = fullName,
                onValueChange = { fullName = it }
            )

            ProfileEditField(
                label = "Date of Birth",
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it }
            )

            ProfileDropdown(
                label = "Gender",
                selected = gender,
                options = listOf("Female", "Male", "Other"),
                onSelected = { gender = it }
            )

            ProfileEditField(
                label = "Phone Number",
                value = phoneNumber,
                onValueChange = { phoneNumber = it }
            )

            ProfileEditField(
                label = "City / Location",
                value = location,
                onValueChange = { location = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            SectionTitle("Education & Career")

            ProfileEditField(
                label = "Education",
                value = education,
                onValueChange = { education = it }
            )

            ProfileEditField(
                label = "Occupation",
                value = occupation,
                onValueChange = { occupation = it }
            )

            ProfileEditField(
                label = "Work Location",
                value = workLocation,
                onValueChange = { workLocation = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            SectionTitle("About Me")

            ProfileEditField(
                label = "Tell us about yourself",
                value = aboutMe,
                onValueChange = { aboutMe = it },
                singleLine = false
            )

            Spacer(modifier = Modifier.height(8.dp))

            SectionTitle("Lifestyle")

            ProfileDropdown(
                label = "Diet",
                selected = diet,
                options = listOf(
                    "Vegetarian",
                    "Non-Vegetarian",
                    "Eggetarian",
                    "Vegan"
                ),
                onSelected = { diet = it }
            )

            ProfileDropdown(
                label = "Smoking",
                selected = smoking,
                options = listOf("Never", "Occasionally", "Regularly"),
                onSelected = { smoking = it }
            )

            ProfileDropdown(
                label = "Drinking",
                selected = drinking,
                options = listOf("Never", "Occasionally", "Regularly"),
                onSelected = { drinking = it }
            )

            ProfileEditField(
                label = "Interests",
                value = interests,
                onValueChange = { interests = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val updatedProfile = MilanEditableProfile(
                        fullName = fullName.trim(),
                        dateOfBirth = dateOfBirth.trim(),
                        gender = gender,
                        phoneNumber = phoneNumber.trim(),
                        location = location.trim(),
                        education = education.trim(),
                        occupation = occupation.trim(),
                        workLocation = workLocation.trim(),
                        aboutMe = aboutMe.trim(),
                        diet = diet,
                        smoking = smoking,
                        drinking = drinking,
                        interests = interests.trim()
                    )

                    onSaveClick(updatedProfile)
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
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = RosePrimary
    )
}

@Composable
private fun ProfileEditField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = singleLine,
        shape = RoundedCornerShape(12.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileDropdown(
    label: String,
    selected: String,
    options: List<String>,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

