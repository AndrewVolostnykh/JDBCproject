
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