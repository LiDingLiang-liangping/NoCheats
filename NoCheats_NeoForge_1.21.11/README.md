# NoCheats - NeoForge 1.21.11

## 功能
- 禁用 `/give` 指令
- 禁用创造模式切换（包括 `/gamemode creative` 和 F3+F4）
- 允许旁观模式切换
- **仅局域网主机（发起者）安装生效，加入者无需安装**

## 环境要求
- JDK 21
- NeoForge 1.21.11

## 编译步骤

### 1. 准备 Gradle Wrapper
需要以下文件：
```
项目根目录/
├── gradlew.bat          (Windows)
├── gradlew              (Linux/Mac)
└── gradle/wrapper/
    ├── gradle-wrapper.jar          (需从 NeoForge MDK 复制)
    └── gradle-wrapper.properties
```

从 NeoForge 1.21.11 MDK 复制 `gradle-wrapper.jar`：
https://github.com/NeoForgeMDKs/MDK-1.21.11-NeoGradle

### 2. 编译
```bash
gradlew build
```

### 3. 获取 jar
编译完成后在 `build/libs/` 目录下

## 解决网络问题

如果下载依赖超时，修改 `build.gradle` 里的 repositories，把国内镜像放前面：
```gradle
repositories {
    maven { url = "https://bmclapi2.bangbang93.com/maven" }
    maven { url = "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/" }
    mavenCentral()
    maven { url = "https://maven.neoforged.net/releases" }
}
```

或者手动下载缺失的 jar 放到 `.gradle/caches/` 对应目录。

## PCL2 安装

1. 打开 PCL2 → 选择 **1.21.11 + NeoForge** 版本
2. 点击「版本设置」→「Mod 管理」→「打开 Mod 文件夹」
3. 将 `nocheats-1.0.0.jar` 拖入
4. 启动游戏，创建局域网世界

## 注意事项
- 此 Mod 仅在内置服务端（单人/局域网主机）生效
- 专用服务器无需安装
- F3+N 仍可切换旁观模式
- **加入者不需要安装此 Mod**
