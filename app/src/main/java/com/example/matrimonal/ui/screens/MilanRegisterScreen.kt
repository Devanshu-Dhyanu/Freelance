package com.example.matrimonal.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.focus.onFocusChanged
import com.example.matrimonal.ui.theme.*


@Composable
fun MilanRegisterScreen(
    onCreateAccount: () -> Unit = {},
    onSignIn: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    onPrivacyClick: () -> Unit = {},
    onGoogleSignUp: () -> Unit = {},
    onFacebookSignUp: () -> Unit = {},
    onAppleSignUp: () -> Unit = {}
) {

    // ---------------------------------------------------------
    // STATE
    // ---------------------------------------------------------

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var selectedGender by remember {
        mutableStateOf("")
    }

    var dob by remember {
        mutableStateOf("")
    }

    var termsAccepted by remember {
        mutableStateOf(false)
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var confirmPasswordVisible by remember {
        mutableStateOf(false)
    }


    // ---------------------------------------------------------
    // MAIN SCREEN
    // ---------------------------------------------------------

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        RegisterBlobBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 28.dp,
                    vertical = 40.dp
                )
        ) {

            // -------------------------------------------------
            // BRAND
            // -------------------------------------------------

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(RosePrimary)
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Text(
                    text = "MILAN",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp,
                    color = RosePrimary,
                    letterSpacing = 2.sp
                )
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // -------------------------------------------------
            // HEART
            // -------------------------------------------------

            SmallHeartIcon()

            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // -------------------------------------------------
            // HEADER
            // -------------------------------------------------

            Text(
                text = "Create Account",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = RosePrimary
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "Start your journey to find your perfect match",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )


            // -------------------------------------------------
            // PERSONAL INFORMATION
            // -------------------------------------------------

            SectionDivider(
                title = "Personal Information"
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // -------------------------------------------------
            // FULL NAME
            // -------------------------------------------------

            MilanInputField(
                label = "Full Name",
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                placeholder = "Enter your full name",

                leadingIcon = {
                    Text(
                        text = "●",
                        fontSize = 14.sp,
                        color = TextPlaceholder
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // -------------------------------------------------
            // EMAIL
            // -------------------------------------------------

            MilanInputField(
                label = "Email",
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = "Enter your email",

                leadingIcon = {
                    Text(
                        text = "✉",
                        fontSize = 17.sp,
                        color = TextPlaceholder
                    )
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // -------------------------------------------------
            // PHONE
            // -------------------------------------------------

            MilanInputField(
                label = "Phone Number",
                value = phone,
                onValueChange = {
                    phone = it
                },
                placeholder = "Enter your phone number",

                leadingIcon = {
                    Text(
                        text = "☎",
                        fontSize = 17.sp,
                        color = TextPlaceholder
                    )
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // -------------------------------------------------
            // PASSWORD
            // -------------------------------------------------

            MilanInputField(
                label = "Password",
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = "Create a password",

                visualTransformation =
                    if (passwordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                leadingIcon = {
                    Text(
                        text = "🔒",
                        fontSize = 16.sp
                    )
                },

                trailingIcon = {

                    IconButton(
                        onClick = {
                            passwordVisible = !passwordVisible
                        }
                    ) {

                        Text(
                            text =
                                if (passwordVisible) {
                                    "🙈"
                                } else {
                                    "👁"
                                },
                            fontSize = 18.sp
                        )
                    }
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // -------------------------------------------------
            // CONFIRM PASSWORD
            // -------------------------------------------------

            MilanInputField(
                label = "Confirm Password",
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                placeholder = "Confirm your password",

                visualTransformation =
                    if (confirmPasswordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                leadingIcon = {
                    Text(
                        text = "🔒",
                        fontSize = 16.sp
                    )
                },

                trailingIcon = {

                    IconButton(
                        onClick = {
                            confirmPasswordVisible =
                                !confirmPasswordVisible
                        }
                    ) {

                        Text(
                            text =
                                if (confirmPasswordVisible) {
                                    "🙈"
                                } else {
                                    "👁"
                                },
                            fontSize = 18.sp
                        )
                    }
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // -------------------------------------------------
            // GENDER
            // -------------------------------------------------

            SectionDivider(
                title = "About You"
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Text(
                text = "Gender",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                GenderOption(
                    text = "Male",
                    selected = selectedGender == "Male",
                    onClick = {
                        selectedGender = "Male"
                    },
                    modifier = Modifier.weight(1f)
                )

                GenderOption(
                    text = "Female",
                    selected = selectedGender == "Female",
                    onClick = {
                        selectedGender = "Female"
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // -------------------------------------------------
            // DATE OF BIRTH
            // -------------------------------------------------

            DobPickerField(
                value = dob,
                onValueChange = {
                    dob = it
                }
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // -------------------------------------------------
            // TERMS
            // -------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {

                Checkbox(
                    checked = termsAccepted,

                    onCheckedChange = {
                        termsAccepted = it
                    },

                    colors = CheckboxDefaults.colors(
                        checkedColor = RosePrimary,
                        uncheckedColor = RoseBorder,
                        checkmarkColor = Color.White
                    ),

                    modifier = Modifier.size(20.dp)
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                TermsText(
                    onTermsClick = onTermsClick,
                    onPrivacyClick = onPrivacyClick
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // -------------------------------------------------
            // CREATE ACCOUNT
            // -------------------------------------------------

            Button(
                onClick = onCreateAccount,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(14.dp),
                        ambientColor =
                            RosePrimary.copy(alpha = 0.35f),
                        spotColor =
                            RosePrimary.copy(alpha = 0.35f)
                    ),

                shape = RoundedCornerShape(14.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),

                contentPadding = PaddingValues(0.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    RosePrimary,
                                    RoseDark
                                )
                            )
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Create Account",
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(26.dp)
            )


            // -------------------------------------------------
            // DIVIDER
            // -------------------------------------------------

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = RoseBorder
                )

                Text(
                    text = "  Or Sign Up with  ",
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    color = TextPlaceholder,
                    fontWeight = FontWeight.Medium
                )

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = RoseBorder
                )
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // -------------------------------------------------
            // SOCIAL SIGN UP
            // -------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                SocialLoginButton(
                    label = "G",
                    color = Color(0xFF4285F4),
                    onClick = onGoogleSignUp
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                SocialLoginButton(
                    label = "f",
                    color = Color(0xFF1877F2),
                    onClick = onFacebookSignUp
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                SocialLoginButton(
                    label = "●",
                    color = Color(0xFF1A1A1A),
                    onClick = onAppleSignUp
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )


            // -------------------------------------------------
            // SIGN IN
            // -------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Already have an account? ",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = TextSecondary
                )

                Text(
                    text = "Sign In",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = RosePrimary,

                    modifier = Modifier.clickable {
                        onSignIn()
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}


// =====================================================================
// REGISTER BACKGROUND
// =====================================================================

@Composable
fun RegisterBlobBackground() {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        drawCircle(
            color = Color(0xFFF8DDE4)
                .copy(alpha = 0.85f),
            radius = 190f,
            center = Offset(
                size.width + 50f,
                -40f
            )
        )

        drawCircle(
            color = Color(0xFFE85B78)
                .copy(alpha = 0.18f),
            radius = 145f,
            center = Offset(
                size.width + 20f,
                100f
            )
        )

        drawCircle(
            color = Color(0xFFF4C0CC)
                .copy(alpha = 0.5f),
            radius = 90f,
            center = Offset(
                size.width - 20f,
                190f
            )
        )
    }
}


// =====================================================================
// SMALL HEART
// =====================================================================

@Composable
fun SmallHeartIcon() {

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF3F6)),

        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "♥",
            fontSize = 26.sp,
            color = RosePrimary
        )
    }
}


// =====================================================================
// SECTION DIVIDER
// =====================================================================

@Composable
fun SectionDivider(
    title: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            color = RosePrimary
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = RoseBorder
        )
    }
}


// =====================================================================
// GENDER OPTION
// =====================================================================

@Composable
fun GenderOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (selected) {
                    RoseVeryLight
                } else {
                    Color.White
                }
            )
            .border(
                width = 1.dp,
                color =
                    if (selected) {
                        RosePrimary
                    } else {
                        RoseBorder
                    },
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            }
            .padding(horizontal = 14.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color =
                        if (selected) {
                            RosePrimary
                        } else {
                            RoseBorder
                        },
                    shape = CircleShape
                )
                .padding(4.dp)
        ) {

            if (selected) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(RosePrimary)
                )
            }
        }

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = text,
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = TextMain
        )
    }
}


// =====================================================================
// DATE OF BIRTH
// =====================================================================

@Composable
fun DobPickerField(
    value: String,
    onValueChange: (String) -> Unit
) {

    Column {

        Text(
            text = "Date of Birth",
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = TextSecondary
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(

            value = value,

            onValueChange = onValueChange,

            modifier = Modifier.fillMaxWidth(),

            placeholder = {

                Text(
                    text = "DD/MM/YYYY",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = TextPlaceholder
                )
            },

            leadingIcon = {

                Text(
                    text = "▣",
                    fontSize = 17.sp,
                    color = TextPlaceholder
                )
            },

            trailingIcon = {

                Text(
                    text = "⌄",
                    fontSize = 20.sp,
                    color = TextPlaceholder
                )
            },

            singleLine = true,

            shape = RoundedCornerShape(12.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedBorderColor = RosePrimary,

                unfocusedBorderColor = RoseBorder,

                focusedContainerColor = Color.White,

                unfocusedContainerColor = Color.White,

                cursorColor = RosePrimary,

                focusedTextColor = TextMain,

                unfocusedTextColor = TextMain
            ),

            textStyle = LocalTextStyle.current.copy(
                fontFamily = PoppinsFamily,
                fontSize = 13.sp
            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}


// =====================================================================
// TERMS TEXT
// =====================================================================

@Composable
fun TermsText(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "I agree to the ",
            fontFamily = PoppinsFamily,
            fontSize = 11.sp,
            color = TextSecondary
        )

        Text(
            text = "Terms & Conditions",
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 11.sp,
            color = RosePrimary,

            modifier = Modifier.clickable {
                onTermsClick()
            }
        )

        Text(
            text = " and ",
            fontFamily = PoppinsFamily,
            fontSize = 11.sp,
            color = TextSecondary
        )

        Text(
            text = "Privacy Policy",
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 11.sp,
            color = RosePrimary,

            modifier = Modifier.clickable {
                onPrivacyClick()
            }
        )
    }
}