# Write your MySQL query statement below
select id
from 
(select *,
lag(temperature) over(order by recordDate asc) as prevTemp,
lag(recordDate) over(order by recordDate asc) as prevDate
from Weather) as w
where temperature>prevTemp and datediff(recordDate,prevDate)=1
