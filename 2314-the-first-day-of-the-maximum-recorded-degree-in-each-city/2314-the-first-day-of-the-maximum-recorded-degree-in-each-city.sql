# Write your MySQL query statement below

select w.city_id as city_id, min(w.day) as day, w.degree as degree
from Weather w JOIN 
(
select city_id, max(degree) as max_degree
from Weather
Group by city_id
) m on w.city_id = m.city_id and w.degree = m.max_degree
group by w.city_id
order by w.city_id