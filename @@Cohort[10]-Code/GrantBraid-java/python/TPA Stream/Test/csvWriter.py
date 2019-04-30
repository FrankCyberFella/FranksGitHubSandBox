import csv

#/Users/grantbraid/workspace/GrantBraid-java/python/TPA Stream/csv
#TPA Stream/csv

dic = {"John": "john@example.com", "Mary": "mary@example.com","Steve": "steve@gamil.com"} #dictionary

download_dir = "exampleCSV.csv" #where you want the file to be downloaded to

csv = open(download_dir, "w")
#"w" indicates that you're writing strings to the file

columnTitleRow = "name, email\n"
csv.write(columnTitleRow)

for key in dic.keys():
	name = key
	email = dic[key]
	row = name + "," + email + "\n"
	csv.write(row)