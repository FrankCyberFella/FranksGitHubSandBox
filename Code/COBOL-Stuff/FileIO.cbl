        IDENTIFICATION DIVISION.
        PROGRAM-ID. FILEIO.
        ENVIRONMENT DIVISION.
        INPUT-OUTPUT SECTION.
        FILE-CONTROL.

        SELECT INFILE ASSIGN TO "./INFILE.TXT"
            ORGANIZATION IS LINE SEQUENTIAL
            FILE STATUS  IS INFILE-FILE-STATUS.

        DATA DIVISION.
        FILE SECTION.
         FD INFILE
            RECORD CONTAINS 80.
           
        01  INPUT-RECORD  PIC X(80).
        
        WORKING-STORAGE SECTION.
        
         01 INFILE-FILE-STATUS   PIC 99 VALUE 0.
            88 NO-MORE-DATA   VALUE 10.

         01 IN-REC   PIC X(80).

        PROCEDURE DIVISION.
            DISPLAY 'GOOD MORNING FRANK!'.
            
            OPEN INPUT INFILE.
            
            PERFORM 7000-READ-A-RECORD
               THRU 7000-EXIT
           
            PERFORM UNTIL NO-MORE-DATA
                   DISPLAY IN-REC     
                    PERFORM 7000-READ-A-RECORD
                       THRU 7000-EXIT         
            END-PERFORM.

            CLOSE INFILE.

            DISPLAY 'GOOD BYE FOR NOW.'.
            
            GOBACK.

        7000-READ-A-RECORD.
            READ INFILE INTO IN-REC
              AT END SET NO-MORE-DATA TO TRUE.
        7000-EXIT.  
            EXIT.  
        