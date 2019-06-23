/* Rexx Program */
Call LoadCourse
Call LoadLocation

Say 'Number courses read: ' CourseID.0

do index = 1 by 1 for CourseID.0
say 'ID: ' CourseID.index  'Name: ' CourseName.index    'Duration: ' Duration.index
end

Say 'Number locations read: ' LocationID.0

do index = 1 by 1 for locationID.0
say LocationID.index   LocationCity.index    LocationState.index  OpenDate.index
end

exit


LoadLocation:

num = 0
do while lines(locations.txt) > 0  
num = num + 1
line_str = linein(locations.txt) 
parse var line_str LocationID.num 10 LocationCity.num 21 LocationState.num 24 OpenDate.num .
end  
LocationID.0 = num


LoadCourse:
num = 0
do while lines(courses.txt) > 0  
num = num + 1
line_str = linein(courses.txt) 
parse var line_str CourseID.num CourseName.num Duration.num .
end  
CourseID.0 = num
