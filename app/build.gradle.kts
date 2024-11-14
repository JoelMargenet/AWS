plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.myawstest"
    compileSdk = 34  // Set to the latest Android SDK version (API Level 34)

    defaultConfig {
        applicationId = "com.example.myawstest"
        minSdk = 24  // Minimum SDK for AWS Amplify library compatibility
        targetSdk = 34  // Target SDK set to the latest API level (34)
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Amplify dependencies (set to 2.24.0 for consistency)
    implementation("com.amplifyframework:core:2.24.0")
    implementation("com.amplifyframework:aws-api:2.24.0")
    implementation("com.amplifyframework:aws-datastore:2.24.0")
    implementation("com.amplifyframework:aws-auth-cognito:2.24.0")
    implementation("com.amplifyframework:aws-storage-s3:2.24.0")

    // AndroidX and Material dependencies
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.room:room-ktx:2.6.1")

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")

    // Add desugaring library for Java 8+ features
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
}
