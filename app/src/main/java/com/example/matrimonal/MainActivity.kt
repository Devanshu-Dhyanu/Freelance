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
import com.example.matrimonal.ui.screens.InterestsScreen
import com.example.matrimonal.ui.screens.MilanProfileVerificationScreen
import com.example.matrimonal.ui.screens.MilanReportUserScreen
import com.example.matrimonal.ui.screens.MilanSavedProfilesScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MatrimonalTheme {

                var currentScreen by remember {
                    mutableStateOf("splash")
                }


                val discoverProfiles = remember {
                    androidx.compose.runtime.mutableStateListOf(
                        com.example.matrimonal.ui.screens.DiscoverProfile(
                            id = 1,
                            name = "Aarav Sharma",
                            age = 25,
                            city = "New Delhi",
                            profession = "Software Engineer",
                            education = "B.Tech",
                            match = 92
                        ),
                        com.example.matrimonal.ui.screens.DiscoverProfile(
                            id = 2,
                            name = "Arnav Sharma",
                            age = 26,
                            city = "Jalandhar",
                            profession = "IT Professional",
                            education = "B.Tech",
                            match = 93
                        ),
                        com.example.matrimonal.ui.screens.DiscoverProfile(
                            id = 3,
                            name = "Aditya Kapoor",
                            age = 26,
                            city = "Chandigarh",
                            profession = "Business Analyst",
                            education = "MBA",
                            match = 85
                        ),
                        com.example.matrimonal.ui.screens.DiscoverProfile(
                            id = 4,
                            name = "Karan Malhotra",
                            age = 28,
                            city = "Noida",
                            profession = "Software Developer",
                            education = "M.Tech",
                            match = 81
                        )
                    )
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
                            profiles = discoverProfiles,

                            onBackClick = {
                                currentScreen = "home"
                            },

                            onProfileClick = { profileId ->
                                currentScreen = "profileDetails"
                            },


                            onLikeClick = { profileId ->
                                val index = discoverProfiles.indexOfFirst {
                                    it.id == profileId
                                }
                                if (index != -1) {
                                    val profile = discoverProfiles[index]
                                    discoverProfiles[index] = profile.copy(
                                        isSaved = !profile.isSaved
                                    )
                                }
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
                            },

                            onSavedProfilesClick = {
                                currentScreen = "savedProfiles"
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
                                currentScreen = "reportUser"
                            },

                            onSecurityClick = {
                                currentScreen = "verification"
                            },

                            onPartnerPreferencesClick = {
                                currentScreen = "partnerPreferences"
                            },

                            onHelpClick = {
                                // Later
                            },

                            onReportProblemClick = {
                                currentScreen = "reportUser"
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
                    "interests" -> {
                        InterestsScreen(
                            onBack = {
                                currentScreen = "home"
                            },
                            onViewProfile = { profileId ->
                                currentScreen = "profileDetails"
                            },
                            onOpenChat = { profileId ->
                                currentScreen = "chat"
                            }
                        )
                    }

                    "verification" -> {
                        MilanProfileVerificationScreen(
                            onBackClick = {
                                currentScreen = "settings"
                            }
                        )
                    }

                    "reportUser" -> {
                        MilanReportUserScreen(
                            onBackClick = {
                                currentScreen = "settings"
                            }
                        )
                    }



                    "savedProfiles" -> {
                        MilanSavedProfilesScreen(
                            profiles = discoverProfiles,

                            onBackClick = {
                                currentScreen = "profile"
                            },

                            onProfileClick = { _: Int ->
                                currentScreen = "profileDetails"
                            },

                            onUnsaveClick = { profileId: Int ->
                                val index = discoverProfiles.indexOfFirst {
                                    it.id == profileId
                                }

                                if (index != -1) {
                                    val profile = discoverProfiles[index]
                                    discoverProfiles[index] = profile.copy(
                                        isSaved = false
                                    )
                                }
                            }
                        )
                    }



                }
            }
        }
    }
}