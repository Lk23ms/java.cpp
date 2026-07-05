# Chương 00: Giới thiệu & Cài đặt môi trường

## 1. Java là gì?

Java là ngôn ngữ lập trình hướng đối tượng, chạy trên máy ảo JVM (Java Virtual Machine) — nhờ vậy code Java viết một lần chạy được trên nhiều hệ điều hành ("Write Once, Run Anywhere"). Minecraft (bản Java Edition) được viết hoàn toàn bằng Java, nên toàn bộ hệ sinh thái mod/plugin (Forge, Fabric, Spigot, Paper) đều dùng Java.

## 2. Cài đặt JDK

1. Tải **JDK 17** hoặc **21** (LTS) từ [Adoptium (Eclipse Temurin)](https://adoptium.net/).
2. Cài đặt, sau đó kiểm tra bằng terminal:

```bash
java -version
javac -version
```

Nếu hiện ra số phiên bản (ví dụ `17.0.x`) là thành công.

## 3. Cài đặt IDE

- **IntelliJ IDEA Community** (khuyên dùng, hỗ trợ Gradle/Maven tốt): https://www.jetbrains.com/idea/
- Hoặc **VS Code** + extension "Extension Pack for Java"

## 4. Cài đặt Git

Dùng để quản lý code và tải source mod mẫu:

```bash
git --version
```

## 5. Chương trình Java đầu tiên

Tạo file `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Xin chào, mình bắt đầu học Java để làm mod Minecraft!");
    }
}
```

Biên dịch và chạy:

```bash
javac HelloWorld.java
java HelloWorld
```

## 6. Cấu trúc một dự án Java thực tế

Các dự án lớn (bao gồm mod Minecraft) không chạy 1 file `.java` thủ công mà dùng **build tool**:

- **Maven** — quản lý qua file `pom.xml`
- **Gradle** — quản lý qua file `build.gradle` (Forge & Fabric đều dùng Gradle)

Bạn sẽ làm quen với Gradle chi tiết ở Chương 02 và dùng thật ở Chương 03.

➡️ Tiếp theo: [Chương 01 - Java cơ bản](../01-co-ban)
