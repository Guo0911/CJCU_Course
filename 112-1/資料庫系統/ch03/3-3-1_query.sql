select A.Em_id, Em_name, Q1, Q2
from Employee2 as A, performance as B
where A.Em_id = B.Em_id