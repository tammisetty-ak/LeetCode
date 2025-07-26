# Write your MySQL query statement below

select city_id, min(day) as day, degree
from Weather
where (city_id, degree) in (
select city_id, max(degree)
from Weather
Group by city_id
)
group by city_id
order by city_id