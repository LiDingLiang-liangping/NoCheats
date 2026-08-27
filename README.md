# NoCheats - Fabric 1.21.11

## 功能
- 禁用 `/give` 指令
- 禁用创造模式切换（包括 `/gamemode creative` 和 F3+F4）
- 允许旁观模式切换
- **仅局域网主机（发起者）安装生效，加入者无需安装**

## GitHub Actions 自动编译

### 1. 上传此仓库到 GitHub
1. 创建 GitHub 仓库（名为 NoCheats）
2. 把此文件夹内所有文件上传到仓库根目录
3. 确保文件结构完整

### 2. 触发编译
1. 进入仓库的 Actions 页面
2. 点击 "Build NoCheats Mod (Fabric)"
3. 点击 "Run workflow"
4. 等待编译完成（约 5-10 分钟）

### 3. 下载 JAR
编译完成后，在 Actions 运行记录的 Artifacts 区域下载。

## 手动编译（本地）

### 环境要求
- JDK 21

### 编译命令
```bash
gradle build
```

## PCL2 安装

1. 打开 PCL2 → 选择 **1.21.11 + Fabric** 版本
2. 点击「版本设置」→「Mod 管理」→「打开 Mod 文件夹」
3. 将编译好的 `nocheats-1.0.0.jar` 拖入
4. 启动游戏，创建局域网世界

## 注意事项
- 此 Mod 仅在内置服务端（单人/局域网主机）生效
- 专用服务器无需安装
- F3+N 仍可切换旁观模式
- **加入者不需要安装此 Mod**
