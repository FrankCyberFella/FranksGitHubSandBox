package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Log {
	private String auditFileName = "Log.txt";
	private File auditFile = new File(auditFileName);

protected Queue<String> auditList = new LinkedList<String>();	
	
public Log() {
		
	}
//***********************Audit Log Methods**********************************************
public void createAuditLog() {
	try {
		auditFile.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public void  writeToAuditLog() {
	try(PrintWriter auditWriter = new PrintWriter(auditFile)) { 
		while(auditList.size() > 0) {
			String auditLine = auditList.poll();
			auditWriter.println(auditLine + "\n");
			//System.out.println(auditLine + "\n");
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // System.out.print(auditLog);
}

}
