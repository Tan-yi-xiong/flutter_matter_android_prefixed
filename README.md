## 使用

```Groovy
dependencies {
  ....
  implementation 'com.github.Tan-yi-xiong:flutter_matter_android_prefixed:1.0.6'
}
```


## 打包发布步骤

1. 使用./gradlew flutter_matter_android_prefixed:assemble得到.aar文件
2. 将.aar文件放到`flutter_matter_android_prefixed/deploy`文件夹下
3. push到远程仓库
4. 创建版本TAG, 然后到github上创建release

## Upstream baseline

- Matter SDK: connectedhomeip `1.6.1`
- Source commit: `da8f6a0bffb72ddcb6a0817df710270f1f59bc2c`
- Android ABIs: `arm64-v8a`, `armeabi-v7a`
- Build toolchain: Android SDK 34, NDK `28.2.13676358`, JDK 17

Build the official Android artifacts with `scripts/build/build_examples.py` from a clean
connectedhomeip checkout at the source commit, using the `android-arm64-chip-tool` and
`android-arm-chip-tool` targets, then assemble this module and copy the release AAR to
`flutter_matter_android_prefixed/deploy/`.
