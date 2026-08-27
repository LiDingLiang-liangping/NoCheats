# Gradle Wrapper Files for NoCheats (NeoForge 1.21.11)

## 包含文件
- gradlew (Linux/Mac)
- gradlew.bat (Windows)
- gradle/wrapper/gradle-wrapper.properties

## 缺少的文件
**gradle-wrapper.jar** 需要手动下载或从 NeoForge MDK 复制。

## 获取 gradle-wrapper.jar

### 方法 1：从 NeoForge MDK 复制
1. 下载 https://github.com/NeoForgeMDKs/MDK-1.21.11-NeoGradle
2. 解压后找到 gradle/wrapper/gradle-wrapper.jar
3. 复制到本项目的 gradle/wrapper/ 目录

### 方法 2：手动下载
https://raw.githubusercontent.com/NeoForgeMDKs/MDK-1.21.11-NeoGradle/main/gradle/wrapper/gradle-wrapper.jar

## 上传到 GitHub
把这 4 个文件上传到你的 NoCheats 仓库：
```
NoCheats/
├── gradlew
├── gradlew.bat
└── gradle/
    └── wrapper/
        ├── gradle-wrapper.jar
        └── gradle-wrapper.properties
```

## 然后重新运行 GitHub Actions
