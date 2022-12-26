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
SELECT ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(so_luong) as so_luong_dich_vu_di_kem
FROM hop_dong
LEFT JOIN hop_dong_chi_tiet
USING (ma_hop_dong)
GROUP BY hop_dong.ma_hop_dong
HAVING sum(so_luong) is not null
UNION
SELECT ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, 0 as so_luong_dich_vu_di_kem
FROM hop_dong
LEFT JOIN hop_dong_chi_tiet
USING (ma_hop_dong)
GROUP BY hop_dong.ma_hop_dong
HAVING sum(so_luong) is null
ORDER BY ma_hop_dong

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
-- có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

