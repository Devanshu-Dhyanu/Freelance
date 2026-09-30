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
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.*
import androidx.compose.ui.focus.onFocusChanged
import com.example.matrimonal.ui.theme.*


@Composable
fun MilanLoginScreen(
    onSignIn: (String, String) -> Unit = {_, _ ->},
    onForgotPassword: () -> Unit = {},
    onRegister: () -> Unit = {},
    onGoogleLogin: () -> Unit = {},
    onFacebookLogin: () -> Unit = {},
    onAppleLogin: () -> Unit = {},
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    val emailValid = email.length > 3 && email.contains("@")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Background decorations
        BlobBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp)
                .padding(
                    top = 48.dp,
                    bottom = 32.dp
                )
        ) {

            // ---------------------------------------------------------
            // BRAND
            // ---------------------------------------------------------

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
                modifier = Modifier.height(24.dp)
            )


            // ---------------------------------------------------------
            // HEART
            // ---------------------------------------------------------

            HeartIcon()

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            // ---------------------------------------------------------
            // HEADER
            // ---------------------------------------------------------

            Text(
                text = "Welcome Back!",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = RosePrimary,
                lineHeight = 34.sp
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Find your perfect match",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )


            // ---------------------------------------------------------
            // EMAIL
            // ---------------------------------------------------------

            MilanInputField(
                label = "Email or Username",
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = "Enter your email here",

                leadingIcon = {

                    Text(
                        text = "✉",
                        fontSize = 18.sp,
                        color = TextPlaceholder
                    )
                },

                trailingIcon = if (emailValid) {

                    {
                        Text(
                            text = "✓",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = RosePrimary
                        )
                    }

                } else {
                    null
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // ---------------------------------------------------------
            // PASSWORD
            // ---------------------------------------------------------

            MilanInputField(
                label = "Password",
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = "••••••••",

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
                modifier = Modifier.height(12.dp)
            )


            // ---------------------------------------------------------
            // REMEMBER ME + FORGOT PASSWORD
            // ---------------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    modifier = Modifier.clickable {
                        rememberMe = !rememberMe
                    }
                ) {

                    Checkbox(
                        checked = rememberMe,

                        onCheckedChange = {
                            rememberMe = it
                        },

                        colors = CheckboxDefaults.colors(
                            checkedColor = RosePrimary,
                            uncheckedColor = RoseBorder,
                            checkmarkColor = Color.White
                        ),

                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(6.dp)
                    )

                    Text(
                        text = "Remember me",
                        fontFamily = PoppinsFamily,
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }


                TextButton(
                    onClick = onForgotPassword
                ) {

                    Text(
                        text = "Forgot Password?",
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = RosePrimary
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // ---------------------------------------------------------
            // SIGN IN BUTTON
            // ---------------------------------------------------------

            Button(
                onClick = {
                    onSignIn(email, password)
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(14.dp),
                        ambientColor = RosePrimary.copy(alpha = 0.4f),
                        spotColor = RosePrimary.copy(alpha = 0.4f)
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
                                ),

                                start = Offset(0f, 0f),

                                end = Offset(
                                    Float.POSITIVE_INFINITY,
                                    Float.POSITIVE_INFINITY
                                )
                            )
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Sign In",
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.White,
                        letterSpacing = 0.3.sp
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )


            // ---------------------------------------------------------
            // DIVIDER
            // ---------------------------------------------------------

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = RoseBorder
                )

                Text(
                    text = "  Or Login with  ",
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
                modifier = Modifier.height(20.dp)
            )


            // ---------------------------------------------------------
            // SOCIAL LOGIN
            // ---------------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                SocialLoginButton(
                    label = "G",
                    color = Color(0xFF4285F4),
                    onClick = onGoogleLogin
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                SocialLoginButton(
                    label = "f",
                    color = Color(0xFF1877F2),
                    onClick = onFacebookLogin
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                SocialLoginButton(
                    label = "●",
                    color = Color(0xFF1A1A1A),
                    onClick = onAppleLogin
                )
            }

            Spacer(
                modifier = Modifier.height(32.dp)
            )


            // ---------------------------------------------------------
            // REGISTER
            // ---------------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Don't have an account? ",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = TextSecondary
                )

                Text(
                    text = "Register Now",
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = RosePrimary,
                    textDecoration = TextDecoration.Underline,

                    modifier = Modifier.clickable {
                        onRegister()
                    }
                )
            }
        }
    }
}


// =====================================================================
// BLOB BACKGROUND
// =====================================================================

@Composable
fun BlobBackground() {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        drawBlobCircle(
            center = Offset(
                size.width + 60f,
                -60f
            ),
            radius = 200f,
            color = Color(0xFFF8DDE4)
                .copy(alpha = 0.85f)
        )

        drawBlobCircle(
            center = Offset(
                size.width + 20f,
                80f
            ),
            radius = 160f,
            color = Color(0xFFE85B78)
                .copy(alpha = 0.22f)
        )

        drawBlobCircle(
            center = Offset(
                size.width - 20f,
                180f
            ),
            radius = 100f,
            color = Color(0xFFF4C0CC)
                .copy(alpha = 0.55f)
        )

        drawBlobCircle(
            center = Offset(
                size.width - 100f,
                240f
            ),
            radius = 60f,
            color = Color(0xFFE85B78)
                .copy(alpha = 0.12f)
        )
    }
}


fun DrawScope.drawBlobCircle(
    center: Offset,
    radius: Float,
    color: Color
) {

    drawCircle(
        color = color,
        radius = radius,
        center = center
    )
}


// =====================================================================
// HEART ICON
// =====================================================================

@Composable
fun HeartIcon() {

    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF3F6)),

        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(Color(0xFFF8DDE4)),

            contentAlignment = Alignment.Center
        ) {

            Canvas(
                modifier = Modifier.size(32.dp)
            ) {

                val path = Path().apply {

                    moveTo(
                        size.width / 2f,
                        size.height * 0.95f
                    )

                    cubicTo(
                        size.width * 0.1f,
                        size.height * 0.7f,
                        0f,
                        size.height * 0.4f,
                        0f,
                        size.height * 0.32f
                    )

                    cubicTo(
                        0f,
                        size.height * 0.12f,
                        size.width * 0.18f,
                        0f,
                        size.width * 0.36f,
                        0f
                    )

                    cubicTo(
                        size.width * 0.46f,
                        0f,
                        size.width * 0.5f,
                        size.height * 0.08f,
                        size.width / 2f,
                        size.height * 0.14f
                    )

                    cubicTo(
                        size.width / 2f,
                        size.height * 0.08f,
                        size.width * 0.54f,
                        0f,
                        size.width * 0.64f,
                        0f
                    )

                    cubicTo(
                        size.width * 0.82f,
                        0f,
                        size.width,
                        size.height * 0.12f,
                        size.width,
                        size.height * 0.32f
                    )

                    cubicTo(
                        size.width,
                        size.height * 0.4f,
                        size.width * 0.9f,
                        size.height * 0.7f,
                        size.width / 2f,
                        size.height * 0.95f
                    )

                    close()
                }

                drawPath(
                    path = path,
                    color = Color(0xFFE85B78)
                )

                drawPath(
                    path = path,
                    color = Color(0xFFC94468),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(
                        width = 2f
                    )
                )
            }
        }
    }
}


// =====================================================================
// INPUT FIELD
// =====================================================================

@Composable
fun MilanInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation =
        VisualTransformation.None,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions.Default,
) {

    var focused by remember {
        mutableStateOf(false)
    }

    Column {

        Text(
            text = label,
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color =
                if (focused) {
                    RosePrimary
                } else {
                    TextSecondary
                }
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(

            value = value,

            onValueChange = onValueChange,

            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    focused = it.isFocused
                },

            placeholder = {

                Text(
                    text = placeholder,
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = TextPlaceholder
                )
            },

            leadingIcon = leadingIcon,

            trailingIcon = trailingIcon,

            visualTransformation = visualTransformation,

            keyboardOptions = keyboardOptions,

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
            )
        )
    }
}


// =====================================================================
// SOCIAL LOGIN BUTTON
// =====================================================================

@Composable
fun SocialLoginButton(
    label: String,
    color: Color,
    onClick: () -> Unit
) {

    OutlinedButton(

        onClick = onClick,

        modifier = Modifier.size(
            width = 72.dp,
            height = 52.dp
        ),

        shape = RoundedCornerShape(12.dp),

        border = BorderStroke(
            1.5.dp,
            RoseBorder
        ),

        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White
        ),

        contentPadding = PaddingValues(0.dp)
    ) {

        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}