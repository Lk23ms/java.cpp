# Java Minecraft Course 🎮☕

Khóa học Java **từ cơ bản đến nâng cao**, mục tiêu cuối cùng: tự tay viết được **mod Minecraft (Forge/Fabric)**, **plugin server (Spigot/Paper)**, và hiểu cách chỉnh sửa/mở rộng client Minecraft.

## 🗺️ Lộ trình

| Chương | Nội dung | Trạng thái |
|---|---|---|
| [00 - Giới thiệu](./00-gioi-thieu) | Cài JDK, IDE, Git, chạy chương trình Java đầu tiên | ✅ |
| [01 - Java cơ bản](./01-co-ban) | Biến, kiểu dữ liệu, điều kiện, vòng lặp, mảng, chuỗi, OOP | ✅ |
| [02 - Java nâng cao](./02-nang-cao) | Collection, Generic, Exception, Lambda/Stream, Đa luồng, Maven/Gradle | ✅ |
| [03 - Minecraft Mod (Forge)](./03-minecraft-forge-mod) | Setup môi trường mod, tạo Item/Block, xử lý Event | ✅ |
| [04 - Minecraft Plugin (Spigot/Paper)](./04-minecraft-plugin-spigot) | Setup plugin, Command, Event, Config, Lưu dữ liệu | ✅ |
| [05 - Minecraft Client (Fabric)](./05-minecraft-fabric-client) | Client-side mod, Mixin cơ bản, custom rendering/HUD | ✅ |
| [06 - Dự án thực hành](./06-du-an-thuc-hanh) | Ý tưởng dự án để luyện tập tổng hợp | ✅ |
| [07 - Thực Chiến 🐱⚡](./07-thuc-chien) | Trang web bài tập thực hành (giao diện neon), có gợi ý từng bước + đáp án tham khảo | ✅ |

## 🎯 Cách học hiệu quả

1. Học tuần tự từ chương 00 → 06, đừng nhảy cóc phần OOP ở chương 01, vì Forge/Fabric/Spigot đều dùng OOP + interface + annotation rất nhiều.
2. Mỗi chương có thư mục `vi-du/` chứa code chạy được — hãy tự gõ lại, đừng chỉ copy-paste.
3. Sau chương 02, bạn đã đủ kiến thức Java lõi để đọc code mod/plugin của người khác.
4. Chương 03–05 yêu cầu cài thêm công cụ riêng (được hướng dẫn trong từng chương).

## 🛠️ Công cụ cần chuẩn bị

- JDK 17 hoặc 21 (Minecraft hiện đại dùng Java 17+)
- IntelliJ IDEA (khuyên dùng) hoặc VS Code + Extension Pack for Java
- Git
- Tài khoản Mojang/Microsoft (để test mod/plugin trong game thật)

## 🐱⚡ Trang "Thực Chiến"

Chương [07-thuc-chien](./07-thuc-chien) là một trang web tĩnh (`index.html`) chứa các bài tập thực hành có gợi ý
từng bước.

## 🏠 Trang chủ tích hợp

File [`index.html`](./index.html) ở gốc repo là trang chủ có **nút bấm dẫn thẳng vào phòng Thực Chiến**,
cùng danh sách 7 chương dạng thẻ (card) để click nhanh vào từng phần. Mở trực tiếp file này bằng trình duyệt,
hoặc bật **GitHub Pages** cho repo (Settings → Pages → Source: chọn branch `main`, thư mục `/ (root)`) để có
link web online — khi đó nút "Vào phòng Thực Chiến" sẽ hoạt động như một website thật.

## ⚠️ Lưu ý

- Chương "Minecraft Client" trong khóa học này tập trung vào **modding hợp lệ** (thêm tính năng, HUD, rendering...) để chạy trên client của chính bạn hoặc server cho phép mod — **không hướng dẫn cheat/hack trên server không được phép**, vì vi phạm điều khoản dịch vụ và có thể bị ban.
