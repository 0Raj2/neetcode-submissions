-- Write your query below

select cust.name from customers cust where cust.id not in (select customer_id from orders)