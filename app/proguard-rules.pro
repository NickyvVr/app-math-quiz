# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep all classes in our app
-keep class com.mathquiz.**  { *; }

# Keep AndroidX classes
-keep class androidx.** { *; }
-dontwarn androidx.**

# Keep kotlin metadata
-keepclassmembers class * { *; }
