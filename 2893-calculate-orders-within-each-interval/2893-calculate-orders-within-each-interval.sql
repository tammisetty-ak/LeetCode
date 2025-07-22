# Write your MySQL query statement below

select intervals.interval_no, sum(order_count) as total_orders
from (select *, ceil(minute / 6) as interval_no from orders) as intervals
group by intervals.interval_no
order by intervals.interval_no
