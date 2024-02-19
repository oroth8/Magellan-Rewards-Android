package com.magellan_rewards_android;

import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment;
import dev.hotwire.turbo.BuildConfig
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass


class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
        override val sessionName = "main"

        override val startLocation = "https://3d8547b6269a.ngrok.app/"

        override val registeredActivities: List<KClass<out AppCompatActivity>>
        get() = listOf(
        // Leave empty unless you have more
        // than one TurboActivity in your app
        )

        override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
        WebFragment::class,
                WebBottomSheetFragment::class
        )

                override val pathConfigurationLocation: TurboPathConfiguration.Location
                get() = TurboPathConfiguration.Location(
                assetFilePath = "json/configuration.json",
//                remoteFileUrl = "https://turbo.hotwired.dev/demo/configurations/android-v1.json"
                )

        override fun onSessionCreated() {
                super.onSessionCreated()
                session.webView.settings.userAgentString = customUserAgent(session.webView)
        }

        private fun customUserAgent(webView: WebView): String {
                return listOf(
                        "MagellanRewardsMobile",
//                        "version: ${BuildConfig.VERSION_NAME}",
                        "baseUA: ${webView.settings.userAgentString}"
                ).joinToString(separator = " | ")
        }
                }