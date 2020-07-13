
/*
17. SQL query to show all details of the Prime Ministerial winners after 1972 of Menachem Begin and Yitzhak Rabin
*/

select distinct * from nobel_win where category = 'Prime Minister' and year > 1972 and winner ='Yitzhak Rabin';

/*
18. SQL query to show all the details of the winners with first name Louis
*/

select distinct * from nobel_win where winner like 'Louis%';

/*
19. SQL query to show all the winners in Physics for 1970 together with the winner of Economics for 1971
*/

SELECT * FROM nobel_win  WHERE (subject ='Physics' AND year=1970) UNION (SELECT * FROM nobel_win  WHERE (subject ='Economics' AND year=1971));

/*
20. SQL query to show all the winners of nobel prize in the year 1970 except the subject Physiology and Economics.
*/

select distinct * from nobel_win where year = 1970 and subject not in('Physiology','Economics');

select salary as SecondHighestSalary from Employee where id = 2;

/*SQL query to display all orders where purchase amount less than 200 or exclude those orders which order date is on or greater than 10th Feb,2012 and customer id is below 3009*/

select * 
from orders 
where(purch_amt < 200 or 
NOT(ord_date >= '2012-02-10' and 
customer_id < 3009));



/*Write a SQL query to display order number, purchase amount, the achieved and unachieved percentage (%) for those order which exceeds the 50% of the target value of 6000.*/

select ord_no, purch_amt, (100*purch_amt)/6000 as "Achived %",
                          (100*(6000-purch_amt)/6000) as "Unachived %"
from orders
where (100*purch_amt)/6000>50;

