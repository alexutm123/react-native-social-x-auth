package com.socialxauth

import android.app.Activity
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.Promise
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = SocialXAuthModule.NAME)
class SocialXAuthModule(reactContext: ReactApplicationContext) :
  NativeSocialXAuthSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  override fun open(url: String, promise: Promise) {
    val activity: Activity? = currentActivity
    if (activity == null) {
      promise.reject("NO_ACTIVITY", "Current activity is null")
      return
    }

    try {
      val builder = CustomTabsIntent.Builder()
      val customTabsIntent = builder.build()
      customTabsIntent.launchUrl(activity, Uri.parse(url))
      promise.resolve(true)
    } catch (e: Exception) {
      promise.reject("ERROR_OPENING_URL", e.message)
    }
  }

  companion object {
    const val NAME = "SocialXAuth"
  }
}
