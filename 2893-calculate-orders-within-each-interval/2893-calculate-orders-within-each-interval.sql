# Write your MySQL query statement below

With Intervals as (
    select *, ceil(minute / 6) as interval_no
    from Orders
)


select interval_no, sum(order_count) as total_orders
from intervals
group by interval_no
order by interval_no
