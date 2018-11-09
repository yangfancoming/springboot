show VARIABLES like '%max_allowed_packet%';

USE test;
SELECT * FROM ews_grade;

SELECT e_date  FROM ews_grade GROUP BY e_date HAVING e_result = 'yes'



;

SELECT * FROM ews_grade WHERE e_result = 'yes';

