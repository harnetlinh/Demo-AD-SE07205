plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.se07205_b41"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.se07205_b41"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    // implementation(libs.activity)    // ← BỎ DÒNG NÀY
    implementation(libs.constraintlayout)

    // Giữ đúng duy nhất bản cần dùng:
    implementation("androidx.activity:activity:1.9.3")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}