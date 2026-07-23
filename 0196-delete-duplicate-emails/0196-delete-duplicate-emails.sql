# Write your MySQL query statement below
delete p1
from Person p2
join Person p1
on p1.email=p2.email
where p1.id>p2.id
