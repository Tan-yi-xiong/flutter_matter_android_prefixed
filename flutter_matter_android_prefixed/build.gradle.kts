plugins {
    apply {
        id("maven-publish")
        id("com.android.library")
    }
}

android {
    namespace = "com.example.flutter_matter_android_prefixed"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        getByName("main") {
            jniLibs.srcDir("libs/jniLibs")
        }
    }
    packagingOptions {
      jniLibs {
        useLegacyPackaging = true
      }
    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
    implementation(fileTree("libs") {
        include("*.jar", "*.so")
    })
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.tyx.flutter_matter"
                artifactId = "flutter_matter_android_prefixed"
                version = "1.0.0"

                // 使用 bundleReleaseAar 任务
//                artifact("$buildDir/outputs/aar/${project.name}-release.aar")

                // 添加源码包
//            artifact(tasks.create<Jar>("sourceJar") {
//                from(android.sourceSets["main"].java.srcDirs)
//                archiveClassifier.set("sources")
//            })
                artifact("deploy/flutter_matter_android_prefixed-release.aar")

                afterEvaluate {
                    from(components.findByName("release"))
                }
            }
        }
    }
}

