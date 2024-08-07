
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // needed by the local database
    //id("com.google.devtools.ksp")

    // needed for the dependency injection
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ca.tetervak.githubreposapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "ca.tetervak.githubreposapp"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // needed for viewModel() function
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // needed for the dependency injection
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    // needed for the navigation with view models
    //val navVersion = "2.7.5"
    //implementation("androidx.navigation:navigation-compose:$navVersion")

    // needed for the view model per destination, the hiltViewModel() function
    //implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // need to receive remote data
    //implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // needed by the local database, do not change it to 2.6.0
    //val roomVersion="2.6.0"
    //implementation("androidx.room:room-runtime:$roomVersion")
    //ksp("androidx.room:room-compiler:$roomVersion")
    //implementation("androidx.room:room-ktx:$roomVersion")

    // display images from web or assets
    //implementation("io.coil-kt:coil-compose:2.4.0")

    // needed for the work manager
    //implementation("androidx.work:work-runtime-ktx:2.8.1")

    // needed for Hilt with Work Manager
    //implementation("androidx.hilt:hilt-work:1.1.0")
    //kapt("androidx.hilt:hilt-compiler:1.1.0")

    // needed to initialize the Hilt worker factory
    //implementation("androidx.startup:startup-runtime:1.1.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.paging:paging-compose:3.3.0-alpha02")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}