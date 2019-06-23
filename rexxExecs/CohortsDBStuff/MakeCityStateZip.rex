/* Rexx Program */
Call LoadCityStateZip

Say 'Number courses read: ' city.0

do index = 1 by 1 for city.0
say  city.index','state.index','zip.index
end

exit


LoadCityStateZip:

num = 0
do while lines(CityStateZip.csv) > 0  
num = num + 1
line_str = linein(CityStateZip.csv) 
parse var line_str city.num ',' state.num ',' zip.num  .
end  
city.0 = num


