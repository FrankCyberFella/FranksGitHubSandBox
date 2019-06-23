/* Rexx Program */
Call LoadFirstName
Call LoadLastName
Call LoadCityStateZip
Call Loadlocation
Call LoadStreet
Call LoadCourses
Call LoadStatus
Call LoadInstructor

Say '   # fnames: ' fname.0
Say '   # lnames: ' lname.0
Say '   # cities: ' city.0
Say '# locations: ' location.0
Say '  # streets: ' street.0
Say '  # statuss: ' status.0
Say '  # Instruc: ' insstructor.0
Say
do index = 1 by 1 for 120
fnameIx  = random(1,fname.0) 
lnameIx  = random(1,lname.0) 
cityIx   = random(1,city.0) 
locIx    = random(1,location.0) 
stIx     = random(1,street.0) 
courseIX = random(1,course.0) 
statusIX = random(1,status.0) 

say 'Insert into Students'
say '(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)'
say  "Values('"fname.fnameIX"', '"lname.lnameix"', '"random(1,99999) street.stIx"', '"city.cityIx"', '"state.cityIX"', '"zip.cityIX"', '" strip(locationID.locIX)"', " courseID.courseIX",'"status.statusIX"');"
end

do index = 1 by 1 for 20
cohortNum = random(11,16);
locIx    = random(1,location.0) 
insIx     = random(1,instructor.0) 
courseIX = random(1,course.0) 
Say 'Insert into cohorts'
say '(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)'
say "values("cohortNum", " courseID.courseIX", '"locationID.locIX"', '"insID.insIX"', current_date, current_date + interval '70 days');" 
end
exit

LoadFirstName:
    num = 0
    do while lines(firstnames.txt) > 0  
        num = num + 1
        line_str = linein(firstnames.txt) 
        parse var line_str fname.num 
    end  
    fname.0 = num
    return

LoadLastName:
    num1 = 0
    do while lines(lastnames.txt) > 0  
        num1 = num1 + 1
        line_str = linein(lastnames.txt) 
        parse var line_str lname.num1 
    end  
    lname.0 = num1
    return

LoadCityStateZip:
    num2 = 0
    do while lines(CityStateZip.csv) > 0  
        num2 = num2 + 1
        line_str = linein(CityStateZip.csv) 
        parse var line_str city.num2 ',' state.num2 ',' zip.num2  .
    end  
    city.0 = num2
    return

LoadLocation:
    num3 = 0
    do while lines(locations.txt) > 0  
        num3 = num3 + 1
        line_str = linein(locations.txt) 
        parse var line_str LocationID.num3 10 LocationCity.num3 21 LocationState.num3 24 OpenDate.num3 .
    end  
    Location.0 = num3
    return

LoadStreet:
    num4 = 0
    do while lines(streets.txt) > 0  
        num4 = num4 + 1
        line_str = linein(streets.txt) 
        parse var line_str street.num4
    end  
    Street.0 = num4
    return

    LoadCourses:
    num5 = 0
    do while lines(courses.txt) > 0  
        num5 = num5 + 1
        line_str = linein(courses.txt) 
        parse var line_str courseId.num5 courseName.num5 duration.num5 .
    end  
    course.0 = num5
    return

    LoadStatus:
    num6 = 0
    do while lines(status.txt) > 0  
        num6 = num6 + 1
        line_str = linein(status.txt) 
        parse var line_str status.num6 . .
    end  
    status.0 = num6
    return

     LoadInstructor:
    num7 = 0
    do while lines(instructors.txt) > 0  
        num7 = num7 + 1
        line_str = linein(instructors.txt) 
        parse var line_str insID.num7 insFname.num7 insInitial.num7 insLname.num7 insHome.num7 .
    end  
    instructor.0 = num7
    return