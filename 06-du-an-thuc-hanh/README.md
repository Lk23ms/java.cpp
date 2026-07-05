# Chương 06: Dự án thực hành tổng hợp

Sau khi hoàn thành 5 chương trước, hãy chọn 1-2 dự án dưới đây để luyện tập tổng hợp kiến thức. Độ khó tăng dần.

## 🟢 Mức dễ

1. **Plugin chào mừng nâng cao**: khi người chơi join lần đầu, tặng họ 1 bộ đồ khởi đầu (kiếm gỗ, bánh mì), lưu trạng thái "đã nhận" vào file config để không tặng lại lần sau.
2. **Mod thêm 1 loại thức ăn mới**: có hiệu ứng hồi máu/tốc độ khi ăn, thêm texture và recipe chế tạo (crafting).

## 🟡 Mức trung bình

3. **Plugin hệ thống kinh tế đơn giản**: lệnh `/pay <người chơi> <số tiền>`, `/balance`, lưu số dư bằng file YAML hoặc SQLite.
4. **Mod thêm 1 block máy móc**: ví dụ máy nghiền quặng — người chơi bỏ quặng vào, sau X giây nhận được nguyên liệu tinh chế (dùng `BlockEntity` + Tick logic).
5. **Client mod Minimap đơn giản**: vẽ lên HUD vị trí tương đối của một vài tọa độ đã lưu (waypoint), dùng kiến thức HUD render ở Chương 05.

## 🔴 Mức nâng cao

6. **Plugin minigame (ví dụ Spleef hoặc Parkour)**: quản lý trạng thái nhiều người chơi, đếm giờ, bảng xếp hạng, dùng Scheduler + Event kết hợp.
7. **Mod thêm Entity (quái vật) mới**: có AI riêng (dùng Goal system của Forge/Fabric), model 3D riêng, âm thanh riêng.
8. **Kết hợp Mod + Plugin**: viết 1 mod Forge thêm item đặc biệt, đồng thời viết plugin (nếu server dùng Forge+Spigot hybrid như Mohist) để item đó có thêm tính năng quản trị qua lệnh.

## 📌 Gợi ý quy trình làm dự án

1. Viết ra yêu cầu chức năng rõ ràng trước khi code (giống một "spec" nhỏ).
2. Chia nhỏ thành từng phần: đăng ký (register) → logic → giao diện/hiển thị → test trong game.
3. Dùng Git để version code ngay từ đầu, commit thường xuyên.
4. Test kỹ trên môi trường dev (`runClient`/server test riêng) trước khi đưa cho người khác dùng.
5. Đọc log console khi có lỗi — 90% lỗi mod/plugin đều có stack trace chỉ rõ dòng code gây lỗi.

## 🎓 Sau khóa học này, bạn có thể tiếp tục học gì?

- Học sâu hơn về **Mixin** để can thiệp mọi ngóc ngách của game.
- Tìm hiểu **Datapacks** kết hợp với mod để mở rộng nội dung không cần code.
- Học **NeoForge** (nhánh mới thay thế Forge cho các phiên bản Minecraft mới).
- Tham gia cộng đồng modding: Discord của Fabric, Forge, SpigotMC để hỏi đáp và xem code người khác.

Chúc bạn code vui và cho ra đời những mod/plugin thật thú vị! 🚀
