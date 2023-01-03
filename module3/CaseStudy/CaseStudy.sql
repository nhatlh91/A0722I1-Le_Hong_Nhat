-- Câu 2
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'K%' or ho_ten like 'T%') and (character_length(ho_ten) <=15);

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * , (YEAR(CURDATE()) - YEAR(ngay_sinh)) - (RIGHT(CURDATE(), 5) < RIGHT(ngay_sinh, 5)) AS tuoi
from khach_hang
where ((YEAR(CURDATE()) - YEAR(ngay_sinh)) - (RIGHT(CURDATE(), 5) < RIGHT(ngay_sinh, 5)) between 18 and 50) and (dia_chi like '%Quảng Trị%' or dia_chi like '%Đà Nẵng%');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select hd.ma_khach_hang, ho_ten , count(hd.ma_khach_hang) as so_lan_dat_phong
from hop_dong hd
join khach_hang kh
using (ma_khach_hang)
where ma_loai_khach = 1
group by hd.ma_khach_hang
order by so_lan_dat_phong;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
		ngay_ket_thuc, chi_phi_thue + gia * so_luong as tong_tien
from khach_hang kh
left join hop_dong hd
using (ma_khach_hang)
join hop_dong_chi_tiet
using (ma_hop_dong)
join loai_khach
using (ma_loai_khach)
left join dich_vu
using (ma_dich_vu) 
left join dich_vu_di_kem
using (ma_dich_vu_di_kem)
union
select kh.ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
		ngay_ket_thuc, chi_phi_thue as tong_tien
from khach_hang kh
left join hop_dong hd
using (ma_khach_hang)
left join hop_dong_chi_tiet
using (ma_hop_dong)
join loai_khach
using (ma_loai_khach)
left join dich_vu
using (ma_dich_vu) 
left join dich_vu_di_kem
using (ma_dich_vu_di_kem)
where so_luong is null
order by ma_khach_hang;


-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
CREATE VIEW view1 as
select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu, ngay_lam_hop_dong
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu) 
left join hop_dong
using (ma_dich_vu)
where ngay_lam_hop_dong < '2021-03-30';

CREATE VIEW view2 as
select ma_dich_vu, ngay_lam_hop_dong
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu) 
left join hop_dong
using (ma_dich_vu)
where ngay_lam_hop_dong > '2021-03-30';

select view1.* from 
view1
left join view2
using (ma_dich_vu)
where view2.ngay_lam_hop_dong is null
group by (ma_dich_vu);

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả 
-- các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
CREATE VIEW dich_vu_da_dung_2021 as
select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu, ngay_lam_hop_dong
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu) 
left join hop_dong
using (ma_dich_vu)
where year(ngay_lam_hop_dong) = 2021
group by (ma_dich_vu);

CREATE VIEW dich_vu_da_dung_2020 as
select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu, ngay_lam_hop_dong
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu) 
left join hop_dong
using (ma_dich_vu)
where year(ngay_lam_hop_dong) = 2020
group by (ma_dich_vu);

select dich_vu_da_dung_2020.* from 
dich_vu_da_dung_2020
left join dich_vu_da_dung_2021
using (ma_dich_vu);

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select distinct(ho_ten)
from khach_hang;

select (ho_ten)
from khach_hang
group by (ho_ten);

select (ho_ten)
from khach_hang
union
select (ho_ten)
from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong) as thang, count(ma_hop_dong) as so_luong_hop_dong
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, 
-- ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, if (sum(so_luong) is null ,0, sum(so_luong)) as so_luong_dich_vu_di_kem
FROM hop_dong
LEFT JOIN hop_dong_chi_tiet
USING (ma_hop_dong)
GROUP BY hop_dong.ma_hop_dong
ORDER BY ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
-- có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select ho_ten, ma_dich_vu_di_kem, ten_dich_vu_di_kem
from hop_dong
join hop_dong_chi_tiet
using (ma_hop_dong)
join khach_hang
using (ma_khach_hang)
join dich_vu_di_kem
using (ma_dich_vu_di_kem)
where ma_loai_khach = 1 and (dia_chi like '%Vinh%' or dia_chi like '%Quảng Ngãi%');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, ten_dich_vu, tien_dat_coc, sum(so_luong), ngay_lam_hop_dong
from hop_dong hd
join dich_vu dv
using (ma_dich_vu)
join nhan_vien nv
using (ma_nhan_vien)
join khach_hang kh
using (ma_khach_hang)
join hop_dong_chi_tiet
using (ma_hop_dong)
left join dich_vu_di_kem
using(ma_dich_vu_di_kem)
where ngay_lam_hop_dong between '2020-10-01' and '2020-12-31';

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất 
-- bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dich_vu_di_kem.*
from hop_dong_chi_tiet
join dich_vu_di_kem 
using (ma_dich_vu_di_kem)
group by ma_dich_vu_di_kem
having sum(so_luong) = (select max(so_luong) from hop_dong_chi_tiet);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm 
-- ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet
join hop_dong
using (ma_hop_dong)
join dich_vu_di_kem
using (ma_dich_vu_di_kem)
join dich_vu
using (ma_dich_vu)
join loai_dich_vu
using (ma_loai_dich_vu)
group by ma_dich_vu_di_kem
having count(ma_dich_vu_di_kem) = 1
order by ma_hop_dong;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nhan_vien.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi, count(ma_hop_dong) as so_luong_hop_dong_da_ky
from hop_dong
join nhan_vien
using (ma_nhan_vien)
join trinh_do
using (ma_trinh_do)
join bo_phan
using (ma_bo_phan)
where year(ngay_lam_hop_dong) between 2020 and 2021
group by ma_nhan_vien
having count(ma_hop_dong)<=3
order by ma_nhan_vien;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
create view nhan_vien_chua_co_hop_dong_tu_2019 as
select ma_nhan_vien
from nhan_vien
left join hop_dong
using (ma_nhan_vien)
group by ma_nhan_vien
having count(ma_hop_dong) = 0;

delete from nhan_vien
where ma_nhan_vien in (select * from nhan_vien_chua_co_hop_dong_tu_2019);

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
create view khach_len_diamond as
select ma_khach_hang
from khach_hang
join hop_dong
using (ma_khach_hang)
join dich_vu
using (ma_dich_vu)
where year (ngay_lam_hop_dong) = 2021
group by ma_khach_hang
having sum(chi_phi_thue) > 10000000;

update khach_hang
set ma_loai_khach = 1
where ma_khach_hang in (select * from khach_len_diamond);

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
update khach_hang
set ho_ten = 'del'
where ma_khach_hang in (
	select * from (select ma_khach_hang from khach_hang kh left join hop_dong hd using (ma_khach_hang)
					where year(hd.ngay_lam_hop_dong)<2021) as kh_can_xoa
);

delete from hop_dong_chi_tiet
where ma_hop_dong_chi_tiet in (
	select * from (select ma_hop_dong_chi_tiet from khach_hang kh left join hop_dong hd using (ma_khach_hang) join hop_dong_chi_tiet hdct using (ma_hop_dong)
					where kh.ho_ten = 'del') as hdct_can_xoa
);

delete from hop_dong
where ma_khach_hang in (
	select ma_khach_hang from khach_hang where ho_ten = 'del');

delete from khach_hang
where ho_ten = 'del';

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem
set gia = gia *2
where ma_dich_vu_di_kem in (
select * from (select ma_dich_vu_di_kem from dich_vu_di_kem
join hop_dong_chi_tiet
using (ma_dich_vu_di_kem)
join hop_dong
using (ma_hop_dong)
where year(ngay_lam_hop_dong) = 2020
group by ma_dich_vu_di_kem
having sum(so_luong)>=10) as dich_vu_di_kem_can_nag_gia
);

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as
select nhan_vien.* from nhan_vien
join hop_dong
using (ma_nhan_vien)
where ngay_lam_hop_dong = '2019-12-12' and dia_chi like '%Hải Châu%';

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien
set dia_chi = 'Liên Chiểu';

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó 
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
DELIMITER //
CREATE PROCEDURE sp_xoa_khach_hang(ma_khach_hang_can_xoa tinyint)
BEGIN
  delete from khach_hang
  where ma_khach_hang = ma_khach_hang_can_xoa;
END //
DELIMITER ;

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong 
-- với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
DELIMITER //
CREATE PROCEDURE sp_them_moi_hop_dong(new_ma_hop_dong tinyint , new_ngay_lam_hop_dong date , new_ngay_ket_thuc date , new_tien_dat_doc int , new_ma_nhan_vien tinyint , new_ma_khach_hang tinyint, new_ma_dich_vu tinyint)
BEGIN
  INSERT INTO hop_dong(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_doc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
  values (new_ma_hop_dong, new_ngay_lam_hop_dong, new_ngay_ket_thuc, new_tien_dat_doc, new_ma_nhan_vien, new_ma_khach_hang, new_ma_dich_vu);
END //
DELIMITER ;

-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng 
-- mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
-- Mã của khách hàng được truyền vào như là 1 tham số của function này.
DELIMITER $$

CREATE FUNCTION func_dem_dich_vu()
RETURNS tinyint
DETERMINISTIC
BEGIN
Declare count tinyint;
set count = (select count(*) from (select count(ma_dich_vu)
    from dich_vu 
    join hop_dong
    using (ma_dich_vu)
    group by (ma_dich_vu)
    having sum(chi_phi_thue)>2000000) as dich_vu_can_dem);
return count;
END $$

DELIMITER ;

DELIMITER $$

CREATE FUNCTION func_tinh_thoi_gian_hop_dong(
	ma_khach_hang_can_kiem_tra tinyint
)
RETURNS tinyint
DETERMINISTIC
BEGIN
Declare timedif tinyint;
set timedif = (
select ma_khach_hang, ma_hop_dong, ngay_ket_thuc, ngay_lam_hop_dong, ngay_ket_thuc - ngay_lam_hop_dong as thoi_gian, max(ngay_ket_thuc - ngay_lam_hop_dong)
from hop_dong
where ma_khach_hang = ma_khach_hang_can_kiem_tra
);
return timedif;
END $$

DELIMITER ;

-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó 
-- (tức là xóa các bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác.
DELIMITER //
CREATE PROCEDURE sp_xoa_dich_vu_va_hd_room()
BEGIN
DECLARE @hop_dong_can_xoa TABLE(ma_hop_dong tinyint, ma_dich_vu tinyint)
INSERT INTO hop_dong_can_xoa
VALUES (SELECT ma_hop_dong, ma_dich_vu
		FROM hop_dong 
		JOIN dich_vu
		USING (ma_dich_vu)
		JOIN loai_dich_vu 
		USING (ma_loai_dich_vu)
		WHERE ten_loai_dich_vu = 'Room' AND (YEAR(ngay_lam_hop_dong) BETWEEN 2015 AND 2019));
        
DELETE FROM hop_dong
WHERE ma_hop_dong IN (SELECT ma_hop_dong FROM @hop_dong_can_xoa);

DELETE FROM dich_vu
WHERE ma_dich_vu IN (SELECT ma_dich_vu FROM @hop_dong_can_xoa);
END//
DELIMITER ;



