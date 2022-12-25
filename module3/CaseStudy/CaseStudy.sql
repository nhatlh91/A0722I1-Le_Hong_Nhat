-- Câu 2
select * from nhan_vien
where ma_nhan_vien in (3,9);

-- Câu 3
select * from khach_hang
where ma_khach_hang in (2,4,10);

-- Cau 4
select hd.ma_khach_hang, ho_ten , count(hd.ma_khach_hang) as so_lan_dat_phong
from hop_dong hd
join khach_hang kh
using (ma_khach_hang)
where hd.ma_khach_hang in (3,4,7)
group by hd.ma_khach_hang
order by so_lan_dat_phong;

-- Cau 5 
select hd.ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
		ngay_ket_thuc, so_luong * chi_phi_thue as tong_tien
from hop_dong hd
left join hop_dong_chi_tiet
using (ma_hop_dong)
join khach_hang kh
using (ma_khach_hang)
join loai_khach
using (ma_loai_khach)
join dich_vu dv
using (ma_dich_vu)
group by ma_hop_dong
order by hd.ma_khach_hang;

-- Cau 6
select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu)
where ma_loai_dich_vu in (1,3);

-- Cau 7
select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu
join loai_dich_vu
using (ma_loai_dich_vu)
where ma_dich_vu = 3;

-- Cau 8
select ho_ten
from khach_hang
where ma_khach_hang = 1;

-- Cau 9
select month(ngay_dat_hang)