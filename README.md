🪖 Military English Learning Platform (Backend)

Dự án Nghiên cứu Khoa học: Xây dựng nền tảng học và rèn luyện tiếng Anh chuyên ngành dành riêng cho môi trường Quân đội.

🎯 Mục tiêu dự án

Hệ thống tập trung vào kỹ năng Nghe và Đọc, đặc biệt tích hợp chức năng mô phỏng âm thanh nhiễu sóng chiến trường (tiếng bộ đàm, tiếng mưa, bom đạn) vào các bài nghe để rèn luyện phản xạ thực tế cho quân nhân.

🛠 Tech Stack

Ngôn ngữ: Java 17

Framework: Spring Boot 3.x (Spring Web, Spring Data JPA)

Cơ sở dữ liệu: MySQL

Lưu trữ Media: Cloudinary (Video, Audio)

Tiện ích: Lombok, MapStruct (Auto mapping Entity <-> DTO)

Xử lý file Word: Apache POI (Dự kiến - dùng để bóc tách đề thi trắc nghiệm)

👥 Phân quyền & Trình độ (Roles & Levels)

Hệ thống chia làm 4 Role và quản lý truy cập bài học theo Level cứng:

Admin: Quản lý CRUD hệ thống tài khoản, cấp quyền.

Teacher (Giáo viên): Upload bài giảng (Video/Audio/Word), quản lý khoá học, tạo bài thi trắc nghiệm trực tuyến (từ file Word).

Officer (Sĩ quan - B2): Chỉ truy cập các bài học và bài thi thuộc trình độ B2.

Cadet (Học viên - B1): Chỉ truy cập các bài học và bài thi thuộc trình độ B1.

🚀 Các tính năng cốt lõi (Core Features)

Quản lý Khoá học & Bài học: Tích hợp file nghe với biến noise_type (RADIO, WARFARE, RAIN) để frontend giả lập môi trường chiến tranh thực tế.

Thi Trắc nghiệm Trực tuyến: Giáo viên upload file đề thi Word (theo template chuẩn), hệ thống tự động bóc tách thành bộ câu hỏi JSON lưu vào DB và cho phép học viên thi tính giờ.

Từ vựng hằng ngày (Daily Vocab): Hệ thống cung cấp danh sách từ mới ngẫu nhiên mỗi ngày (lấy cảm hứng từ Quizlet) giúp bộ đội ôn tập nhanh chóng.

Quản lý File & Media: Tự động đồng bộ và lưu trữ file tĩnh trên hệ thống Cloudinary.

📁 Cấu trúc thư mục (Project Structure)

src/main/java/com/military/english/
 ├── config/       # Cấu hình hệ thống (Cloudinary, Security...)
 ├── controller/   # REST APIs (Endpoints)
 ├── entity/       # Các lớp ánh xạ bảng Database (JPA)
 ├── enums/        # Các hằng số (Role, Level, NoiseType)
 ├── mapper/       # MapStruct interfaces (Chuyển Entity <-> DTO)
 ├── model/        # DTOs (Request/Response objects)
 ├── repository/   # Giao tiếp với MySQL Database
 └── service/      # Chứa business logic (Interfaces & Impl)


⚙️ Hướng dẫn cài đặt sơ bộ (Local)

Cài đặt MySQL và tạo database: military_english_db

Cập nhật username và password của MySQL trong src/main/resources/application.yml

(Sắp tới) Thêm các biến môi trường của Cloudinary API Key.

Chạy file MilitaryEnglishApplication.java.