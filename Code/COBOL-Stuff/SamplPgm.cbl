        IDENTIFICATION DIVISION.
        PROGRAM-ID. SAMPLPGM.
        ENVIRONMENT DIVISION.
        DATA DIVISION.
        WORKING-STORAGE SECTION.
         01 NUMBER-1               PIC 999.
         
        PROCEDURE DIVISION.
            DISPLAY 'GOOD MORNING FRANK!'.
            
            DISPLAY 'PLEASE ENTER A NUMBER'.
            ACCEPT NUMBER-1.
               
            DISPLAY 'YOU ENTERED: ' NUMBER-1.

            GOBACK.