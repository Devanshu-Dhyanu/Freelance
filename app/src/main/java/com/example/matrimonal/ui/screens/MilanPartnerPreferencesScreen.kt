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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrimonal.ui.theme.RoseBorder
import com.example.matrimonal.ui.theme.RoseLight
import com.example.matrimonal.ui.theme.RosePrimary
import com.example.matrimonal.ui.theme.RoseVeryLight
import com.example.matrimonal.ui.theme.TextMain
import com.example.matrimonal.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilanPartnerPreferencesScreen(
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    var ageRange by remember { mutableStateOf(22f..28f) }
    var heightRange by remember { mutableStateOf(62f..68f) }

    var religion by remember { mutableStateOf("Select Religion") }
    var community by remember { mutableStateOf("Select Community") }
    var location by remember { mutableStateOf("Select Location") }
    var education by remember { mutableStateOf("Select Education") }
    var occupation by remember { mutableStateOf("Select Occupation") }
    var maritalStatus by remember { mutableStateOf("Never Married") }
    var lifestyle by remember { mutableStateOf("Select Lifestyle") }

    var expandedField by remember { mutableStateOf<String?>(null) }

    val isExpanded: (String) -> Boolean = { field ->
        expandedField == field
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RoseVeryLight
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // ---------------------------------------------------------
            // TOP BAR
            // ---------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(RoseVeryLight)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 18.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(RoseLight)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "‹",
                        fontSize = 32.sp,
                        color = RosePrimary,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = "Partner Preferences",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMain
                    )

                    Text(
                        text = "Tell us what you're looking for",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

            Divider(color = RoseBorder)

            // ---------------------------------------------------------
            // CONTENT
            // ---------------------------------------------------------
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                item {
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Basic Preferences",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMain
                    )
                }

                // -----------------------------------------------------
                // AGE
                // -----------------------------------------------------
                item {
                    PreferenceSliderSection(
                        title = "Age",
                        valueText = "${ageRange.start.toInt()} - ${ageRange.endInclusive.toInt()} years"
                    ) {
                        RangeSlider(
                            value = ageRange,
                            onValueChange = {
                                ageRange = it
                            },
                            valueRange = 18f..60f,
                            steps = 41,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // -----------------------------------------------------
                // HEIGHT
                // -----------------------------------------------------
                item {
                    PreferenceSliderSection(
                        title = "Height",
                        valueText = "${formatHeight(heightRange.start)} - ${formatHeight(heightRange.endInclusive)}"
                    ) {
                        RangeSlider(
                            value = heightRange,
                            onValueChange = {
                                heightRange = it
                            },
                            valueRange = 48f..84f,
                            steps = 35,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                item {
                    Text(
                        text = "Personal Preferences",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMain
                    )
                }

                // -----------------------------------------------------
                // RELIGION
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Religion",
                        value = religion,
                        expanded = isExpanded("religion"),
                        onClick = {
                            expandedField =
                                if (expandedField == "religion") null
                                else "religion"
                        },
                        options = listOf(
                            "Hindu",
                            "Muslim",
                            "Christian",
                            "Sikh",
                            "Buddhist",
                            "Jain",
                            "Other"
                        ),
                        onOptionSelected = {
                            religion = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // COMMUNITY
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Community",
                        value = community,
                        expanded = isExpanded("community"),
                        onClick = {
                            expandedField =
                                if (expandedField == "community") null
                                else "community"
                        },
                        options = listOf(
                            "General",
                            "OBC",
                            "SC",
                            "ST",
                            "Other"
                        ),
                        onOptionSelected = {
                            community = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // LOCATION
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Location",
                        value = location,
                        expanded = isExpanded("location"),
                        onClick = {
                            expandedField =
                                if (expandedField == "location") null
                                else "location"
                        },
                        options = listOf(
                            "Delhi",
                            "Gurgaon",
                            "Noida",
                            "Chandigarh",
                            "Mumbai",
                            "Bangalore",
                            "Hyderabad",
                            "Pune"
                        ),
                        onOptionSelected = {
                            location = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // EDUCATION
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Education",
                        value = education,
                        expanded = isExpanded("education"),
                        onClick = {
                            expandedField =
                                if (expandedField == "education") null
                                else "education"
                        },
                        options = listOf(
                            "Bachelor's Degree",
                            "Master's Degree",
                            "MBA",
                            "M.Tech",
                            "PhD",
                            "Any"
                        ),
                        onOptionSelected = {
                            education = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // OCCUPATION
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Occupation",
                        value = occupation,
                        expanded = isExpanded("occupation"),
                        onClick = {
                            expandedField =
                                if (expandedField == "occupation") null
                                else "occupation"
                        },
                        options = listOf(
                            "Software Engineer",
                            "Doctor",
                            "Teacher",
                            "Business",
                            "Government Employee",
                            "Finance",
                            "Any"
                        ),
                        onOptionSelected = {
                            occupation = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // MARITAL STATUS
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Marital Status",
                        value = maritalStatus,
                        expanded = isExpanded("marital"),
                        onClick = {
                            expandedField =
                                if (expandedField == "marital") null
                                else "marital"
                        },
                        options = listOf(
                            "Never Married",
                            "Divorced",
                            "Widowed",
                            "Any"
                        ),
                        onOptionSelected = {
                            maritalStatus = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // LIFESTYLE
                // -----------------------------------------------------
                item {
                    PreferenceDropdown(
                        title = "Lifestyle",
                        value = lifestyle,
                        expanded = isExpanded("lifestyle"),
                        onClick = {
                            expandedField =
                                if (expandedField == "lifestyle") null
                                else "lifestyle"
                        },
                        options = listOf(
                            "Non-Smoker",
                            "Non-Drinker",
                            "Vegetarian",
                            "Fitness Enthusiast",
                            "Any"
                        ),
                        onOptionSelected = {
                            lifestyle = it
                            expandedField = null
                        }
                    )
                }

                // -----------------------------------------------------
                // SAVE BUTTON
                // -----------------------------------------------------
                item {
                    Spacer(modifier = Modifier.height(4.dp))

                    Button(
                        onClick = {
                            onSaveClick()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = RosePrimary
                        )
                    ) {
                        Text(
                            text = "Save Preferences",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}


// ================================================================
// SLIDER SECTION
// ================================================================

@Composable
private fun PreferenceSliderSection(
    title: String,
    valueText: String,
    slider: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextMain
            )

            Text(
                text = valueText,
                fontSize = 13.sp,
                color = RosePrimary,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        slider()
    }
}


// ================================================================
// DROPDOWN
// ================================================================

@Composable
private fun PreferenceDropdown(
    title: String,
    value: String,
    expanded: Boolean,
    onClick: () -> Unit,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = title,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextMain
        )

        Spacer(modifier = Modifier.height(7.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(RoseVeryLight)
        ) {

            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(RoseVeryLight)
                        .clickable {
                            onClick()
                        }
                        .padding(
                            horizontal = 16.dp,
                            vertical = 15.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = value,
                        fontSize = 14.sp,
                        color = if (value.startsWith("Select")) {
                            TextSecondary
                        } else {
                            TextMain
                        }
                    )

                    Text(
                        text = if (expanded) "⌃" else "›",
                        fontSize = 22.sp,
                        color = RosePrimary
                    )
                }

                if (expanded) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(RoseLight)
                            .padding(vertical = 5.dp)
                    ) {

                        options.forEach { option ->

                            Text(
                                text = option,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onOptionSelected(option)
                                    }
                                    .padding(
                                        horizontal = 18.dp,
                                        vertical = 12.dp
                                    ),
                                fontSize = 13.sp,
                                color = TextMain
                            )
                        }
                    }
                }
            }
        }
    }
}


// ================================================================
// HEIGHT FORMATTER
// ================================================================

private fun formatHeight(value: Float): String {
    val totalInches = value.toInt()
    val feet = totalInches / 12
    val inches = totalInches % 12

    return "$feet' $inches\""
}