package com.example.matrimonal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import com.example.matrimonal.ui.screens.MilanChatListScreen
import com.example.matrimonal.ui.screens.MilanChatScreen
import com.example.matrimonal.ui.screens.MilanDiscoverScreen
import com.example.matrimonal.ui.screens.MilanEditProfileScreen
import com.example.matrimonal.ui.screens.MilanEmailSentScreen
import com.example.matrimonal.ui.screens.MilanForgotPasswordScreen
import com.example.matrimonal.ui.screens.MilanHomeScreen
import com.example.matrimonal.ui.screens.MilanLoginScreen
import com.example.matrimonal.ui.screens.MilanMatchesScreen
import com.example.matrimonal.ui.screens.MilanProfileDetailsScreen
import com.example.matrimonal.ui.screens.MilanProfileScreen
import com.example.matrimonal.ui.screens.MilanRegisterScreen
import com.example.matrimonal.ui.screens.MilanResetPasswordScreen
import com.example.matrimonal.ui.screens.MilanSplashScreen
import com.example.matrimonal.ui.screens.MilanSettingsScreen
import com.example.matrimonal.ui.screens.MilanPartnerPreferencesScreen
import com.example.matrimonal.ui.screens.MilanNotificationsScreen
import com.example.matrimonal.ui.theme.MatrimonalTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MatrimonalTheme {

                var currentScreen by remember {
                    mutableStateOf("splash")
                }

                when (currentScreen) {

                    // =========================================================
                    // SPLASH
                    // =========================================================

                    "splash" -> {

                        MilanSplashScreen(
                            onSplashFinished = {
                                currentScreen = "login"
                            }
                        )
                    }


                    // =========================================================
                    // LOGIN
                    // =========================================================

                    "login" -> {

                        MilanLoginScreen(

                            // HARD-CODED LOGIN
                            onSignIn = { email, password ->

                                if (
                                    email.trim() == "ritika@gmail.com" &&
                                    password == "Ritu@345"
                                ) {
                                    currentScreen = "home"
                                }
                            },

                            onForgotPassword = {
                                currentScreen = "forgotPassword"
                            },

                            onRegister = {
                                currentScreen = "register"
                            },

                            // Frontend placeholders
                            onGoogleLogin = {
                                currentScreen = "home"
                            },

                            onFacebookLogin = {
                                currentScreen = "home"
                            },

                            onAppleLogin = {
                                currentScreen = "home"
                            }
                        )
                    }


                    // =========================================================
                    // REGISTER
                    // =========================================================

                    "register" -> {

                        MilanRegisterScreen(

                            onCreateAccount = {
                                currentScreen = "home"
                            },

                            onSignIn = {
                                currentScreen = "login"
                            },

                            onTermsClick = {
                                // Terms screen can be added later
                            },

                            onPrivacyClick = {
                                // Privacy screen can be added later
                            },

                            onGoogleSignUp = {
                                currentScreen = "home"
                            },

                            onFacebookSignUp = {
                                currentScreen = "home"
                            },

                            onAppleSignUp = {
                                currentScreen = "home"
                            }
                        )
                    }


                    // =========================================================
                    // FORGOT PASSWORD
                    // =========================================================

                    "forgotPassword" -> {

                        MilanForgotPasswordScreen(

                            onBackClick = {
                                currentScreen = "login"
                            },

                            onSendResetLink = {
                                currentScreen = "emailSent"
                            }
                        )
                    }


                    // =========================================================
                    // EMAIL SENT
                    // =========================================================

                    "emailSent" -> {

                        MilanEmailSentScreen(

                            onBackToLogin = {
                                currentScreen = "login"
                            },

                            onResendEmail = {
                                // Real email functionality will be added
                                // when backend authentication is implemented.
                            },

                            onOpenEmail = {
                                currentScreen = "resetPassword"
                            }
                        )
                    }


                    // =========================================================
                    // RESET PASSWORD
                    // =========================================================

                    "resetPassword" -> {

                        MilanResetPasswordScreen(

                            onPasswordReset = {
                                currentScreen = "login"
                            },

                            onBackToLogin = {
                                currentScreen = "login"
                            }
                        )
                    }


                    // =========================================================
                    // HOME
                    // =========================================================

                    "home" -> {

                        MilanHomeScreen(

                            onDiscoverClick = {
                                currentScreen = "discover"
                            },

                            onMatchesClick = {
                                currentScreen = "matches"
                            },

                            onChatsClick = {
                                currentScreen = "chats"
                            },

                            onProfileClick = {
                                currentScreen = "profile"
                            },

                            onNotificationClick = {
                                currentScreen = "notifications"
                            },

                            onSearchClick = {
                                currentScreen = "discover"
                            },

                            onViewProfile = {
                                currentScreen = "profileDetails"
                            },

                            onLikeProfile = {
                                // Like functionality will be added later.
                            }
                        )
                    }


                    // =========================================================
                    // DISCOVER
                    // =========================================================

                    "discover" -> {

                        MilanDiscoverScreen(

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onProfileClick = {
                                currentScreen = "profileDetails"
                            },

                            onLikeClick = {
                                // Like functionality will be added later.
                            }
                        )
                    }


                    // =========================================================
                    // MATCHES
                    // =========================================================

                    "matches" -> {

                        MilanMatchesScreen(

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onProfileClick = {
                                currentScreen = "profileDetails"
                            },

                            onChatClick = {
                                currentScreen = "chat"
                            }
                        )
                    }


                    // =========================================================
                    // CHAT LIST
                    // =========================================================

                    "chats" -> {

                        MilanChatListScreen(

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onChatClick = {
                                currentScreen = "chat"
                            }
                        )
                    }


                    // =========================================================
                    // CHAT
                    // =========================================================

                    "chat" -> {
                        MilanChatScreen(
                            onBackClick = {
                                currentScreen = "chats"
                            },
                            onProfileClick = {
                                currentScreen = "profileDetails"
                            },
                            onCallClick = {
                                // Call feature will be added later
                            },
                            onVideoCallClick = {
                                // Video call feature will be added later
                            }
                        )
                    }


                    // =========================================================
                    // MY PROFILE
                    // =========================================================

                    "profile" -> {

                        MilanProfileScreen(

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onEditProfileClick = {
                                currentScreen = "editProfile"
                            },

                            onSettingsClick = {
                                currentScreen = "settings"
                            }
                        )
                    }


                    // =========================================================
                    // EDIT PROFILE
                    // =========================================================

                    "editProfile" -> {

                        MilanEditProfileScreen(

                            onBackClick = {
                                currentScreen = "profile"
                            },

                            onSaveClick = {
                                currentScreen = "profile"
                            }
                        )
                    }


                    // =========================================================
                    // OTHER USER PROFILE
                    // =========================================================

                    "profileDetails" -> {

                        MilanProfileDetailsScreen(

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onLikeClick = {
                                // Like functionality will be added later.
                            },

                            onChatClick = {
                                currentScreen = "chat"
                            }
                        )
                    }


                    // =========================================================
                    // SETTINGS
                    // =========================================================

                    "settings" -> {

                        MilanSettingsScreen(

                            onBackClick = {
                                currentScreen = "profile"
                            },

                            onPersonalInfoClick = {
                                currentScreen = "editProfile"
                            },

                            onChangePasswordClick = {
                                currentScreen = "resetPassword"
                            },

                            onProfileVisibilityClick = {
                                // Later
                            },

                            onBlockedUsersClick = {
                                // Later
                            },

                            onSecurityClick = {
                                // Later
                            },

                            onPartnerPreferencesClick = {
                                currentScreen = "partnerPreferences"
                            },

                            onHelpClick = {
                                // Later
                            },

                            onReportProblemClick = {
                                // Later
                            },

                            onTermsClick = {
                                // Later
                            },

                            onPrivacyClick = {
                                // Later
                            },

                            onLogout = {
                                currentScreen = "login"
                            }
                        )
                    }


                    // =========================================================
                    // PARTNER PREFERENCES
                    // =========================================================

                    "partnerPreferences" -> {

                        MilanPartnerPreferencesScreen(

                            onBackClick = {
                                currentScreen = "settings"
                            },

                            onSaveClick = {
                                currentScreen = "settings"
                            }
                        )
                    }


                    // =========================================================
                    // NOTIFICATIONS
                    // =========================================================

                    "notifications" -> {

                        MilanNotificationsScreen(

                            onBackClick = {
                                currentScreen = "settings"
                            }
                        )
                    }
                }
            }
        }
    }
}