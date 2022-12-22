-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from Subject
order by Credit desc
limit 1;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select m.SubId, SubName, Credit, Status, Mark
from Mark m
join Subject s
using (subID)
WHERE Mark = (SELECT MAX(Mark) FROM Mark)

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select studentid, studentname, avg (Mark) 
from Mark
join Student
using (studentid)
group by studentid
