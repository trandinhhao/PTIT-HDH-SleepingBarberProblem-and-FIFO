# 💻 Bài toán Người thợ cắt tóc và Thuật toán đổi trang theo nguyên tắc FIFO

Bài tập lớn môn **Hệ điều hành (Operating Systems)** tại Học viện Công nghệ Bưu chính Viễn thông - PTIT  
**Sinh viên**: Trần Đình Hào - B22DCCN278  
**Giảng viên**: Vũ Anh Đào | **Khóa**: D22  
📄 **Báo cáo PDF**: [PDF](https://drive.google.com/file/d/1JQEESnSFlFn912yzZP1-iTMSUkDZwCSe/view?usp=sharing)  
👉 *Cho tôi 1 ⭐ nếu nó hữu ích cho bạn nhé, làm cực lắm đó 😅*

---

## 📝 Giới thiệu đề tài

Đề tài số **19** bao gồm 2 phần:

1. **Bài toán Người thợ cắt tóc** – Một bài toán đồng bộ hóa kinh điển giữa các tiến trình trong môi trường đa luồng.
2. **Thuật toán đổi trang theo nguyên tắc FIFO** – Mô phỏng quá trình quản lý bộ nhớ ảo đơn giản bằng thuật toán FIFO.

---

## ✂️ 1. Bài toán Người Thợ Cắt Tóc

- 🔗 Mã nguồn: [`BarberShop.java`](https://github.com/trandinhhao/PTIT-HDH-SleepingBarberProblem-and-FIFO/blob/main/SourceCode/BarberShop.java)  
- 💡 Mô phỏng sự phối hợp giữa thợ cắt tóc và khách hàng trong tiệm có số ghế chờ hạn chế.
- 🧵 Áp dụng kỹ thuật **đa luồng (threading)** và **đồng bộ hóa bằng semaphore**.
- 🧠 Vấn đề xử lý:
  - Đảm bảo không có 2 khách hàng được phục vụ cùng lúc
  - Tránh deadlock và starvation
  - Quản lý hàng đợi khách hiệu quả

## 📄 2. Thuật toán đổi trang FIFO

- 🔗 Mã nguồn: [`FIFO19.java`](https://github.com/trandinhhao/PTIT-HDH-SleepingBarberProblem-and-FIFO/blob/main/SourceCode/FIFO19.java)  
- 🔁 Mô phỏng thuật toán **First-In-First-Out** cho việc thay thế trang trong bộ nhớ ảo.
- 📦 Cấu hình: 6 trang logic, 4 khung nhớ vật lý, truy cập 10 lần do người dùng nhập.
- 📊 Kết quả:
  - Hiển thị trạng thái hàng đợi trang sau mỗi lượt truy cập
  - In ra tổng số lỗi trang (page faults) xảy ra
