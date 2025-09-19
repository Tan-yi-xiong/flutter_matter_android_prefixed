## 打包发布步骤

1. 使用./gradlew flutter_matter_android_prefixed:assemble得到.aar文件
2. 将.aar文件放到`flutter_matter_android_prefixed/deploy`文件夹下
3. push到远程仓库
4. 创建版本TAG, 然后到github上创建release