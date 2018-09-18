Select to_date('02/01/2018','MM/DD/YYYY') - to_date('01/01/2018','MM/DD/YYYY') as Date1
      ,to_date('10/16/2018','MM/DD/YYYY') - to_date('06/15/2018','MM/DD/YYYY') as Date2
      ,to_date('03/19/2018','MM/DD/YYYY') - to_date('02/01/2018','MM/DD/YYYY') as Date4
      ,to_date('03/19/2016','MM/DD/YYYY') - to_date('02/01/2016','MM/DD/YYYY') as Date5
      ,to_date('03/19/2000','MM/DD/YYYY') - to_date('02/01/2000','MM/DD/YYYY') as Date6
      ,to_date('03/19/1900','MM/DD/YYYY') - to_date('02/01/1900','MM/DD/YYYY') as Date7
      ,to_date('04/21/1900','MM/DD/YYYY') - to_date('03/19/1900','MM/DD/YYYY') as Date8
      ,to_date('05/10/1900','MM/DD/YYYY') - to_date('03/01/1900','MM/DD/YYYY') as Date9
      ,to_date('04/03/2018','MM/DD/YYYY') - to_date('03/03/2018','MM/DD/YYYY') as Date10
      ,to_date('05/03/2018','MM/DD/YYYY') - to_date('03/03/2018','MM/DD/YYYY') as Date11
      ,to_date('05/11/2018','MM/DD/YYYY') - to_date('05/10/2018','MM/DD/YYYY') as Date12
from project;
