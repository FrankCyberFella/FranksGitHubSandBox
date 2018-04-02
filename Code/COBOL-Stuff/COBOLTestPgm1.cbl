  
       Identification Division.
       Program-ID. Testpgm1.
       Environment Division.
       Data Division.
       Working-Storage Section.
        01 NUMBER-1  PIC 99.
        01 NUMBER-2  PIC 99.

       Procedure Division.
            Display 'Good Morning Frank!'.
            
            Display 'Please enter the first number'.
            Accept NUMBER-1.
            
            Display 'Please enter the second number'.
            Accept NUMBER-2.
            
            Display 'You entered: ' NUMBER-1 ' and ' NUMBER-2.
            
            Goback.
            