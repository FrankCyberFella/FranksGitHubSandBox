package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int racconsWoods = 3;
		int raccoonsEat =  2;
		int raccoonsInWoods = racconsWoods - raccoonsEat;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int beesFlowers = flowers - bees; 
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int piegonLonely = 1;
		int piegonCame = 1;
		int totalPiegon = piegonLonely + piegonCame; 
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsSitting = 3;
		int owlsJoined = 2;
		int totalOwls = owlsSitting + owlsJoined;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversHome = 2;
		int beaversSwim = 1;
		int beaversWorking = beaversHome - beaversSwim;
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSitting = 2;
		int toucansJoins = 1; 
		int totalToucans = toucansSitting + toucansJoins; 
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsTree = 4;
	    int nuts = 2;
	    int Squarrels = squirrelsTree - nuts;
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
	    int quarter = 1;
	    int dime = 1;
	    int nickles = 2;
	    int moneyFound = quarter + dime + nickles;
	    
	    System.out.println(moneyFound);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
	    int brier = 18;
	    int macAdam = 20;
	    int flannery = 17;
	    int sum = brier + macAdam + flannery;
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
	    int yoyo = 24;
	    int whistle = 14;
	    int sum1 = yoyo + whistle;
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
	    int rice = 5;
	    int marshmallows = 8;
	    int miniMarsh = 10; 
	    int sum2 = rice + marshmallows + miniMarsh; 
	    
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
	    int hilt = 29;
	    int brecknock = 17;
	    int sum3 = hilt - brecknock;
	    
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
	    int hiltTotal = 10;
	    int truck = 3;
	    int pencil = 2; 
	    int sum4 = hiltTotal - (truck - pencil);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
	    int marbles = 16;
	    int marblesLost = 7;
	    int sum5 = marbles - marblesLost;
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
	    int seashellsTotal = 19;
	    int seashellsNeed = 25; 
	    int sum6 = seashellsNeed - seashellsTotal;
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
	    int totalBalloons = 17;
	    int red = 8;
	    int GreenBalloons = totalBalloons - red; 
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
	    int booksTotal = 38;
	    int booksPut = 10;
	    int booksOnShelf = booksTotal - booksPut;
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
	    int legsPerbee = 6;
	    int eightbees = 8;
	    int totalLegseightBees = legsPerbee * eightbees;
	    
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
	    int cone = 99;
	    int iceCone = cone * 2; 
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
	   int rocks = 64;
	   int rocksNeed = 125;
	   int difference =  rocksNeed - rocks;

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
	   int marbles1 = 38;
	   int lost = 15;
	   int left = marbles - lost; 
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
	   int concert = 78;
	   int gas = 32;
	   int gasLeft = concert - gas;
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
	   int morning = 90;
	   int afternoon = 45;
	   int sum7 = morning + afternoon;
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
	   double dogsBought = 6;
	   double dogsCost = .50;
	   double costOfHotdogs = dogsBought * dogsCost; 
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
	   double hilt1 = .50;
	   double pencil1 = .7;
	   double sum8 = hilt - pencil;
	   
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
	   int saw = 33;
	   int orange =  20;
	   int sum9 = saw - orange; 
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
	   double gave = .60;
	   double cost = .54;
	   double sum10 = gave - cost;
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
	   int trees = 13;
	   int plant = 12;
	   int sum11 = trees + plant; 
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
	   int days = 2;
	   int hours = 24;
	   int total = days * hours;
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
	   int cousins = 4;
	   int give = 5;
	   int sum12 = give - cousins; 
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
	   double bar = 3.00;
	   double bought = 1.00;
	   double sum13 = bar - bought;
	   
	   System.out.println(sum13);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
	   int boatsInLake = 5;
	   int boatCap = 3;
	   int sum14 = boatsInLake - boatCap; 
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
	   int had = 380;
	   int lost1 = 57;
	   int total1 = had - lost;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
	   int has = 35;
	   int need = 83;
	   int sum15 = need - has; 
	   System.out.println(sum15);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
	   int willy = 1400;
	   int lucy = 290;
	   int sum16 = willy - lucy; 
	   System.out.println("Willy has " + (sum16) + " more crayons then Lucy.");
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
	    int page1 = 10;
	    int manyPage = 22; 
	    int sum17 = page1 * manyPage;
	    System.out.println(sum17);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
	    int cupcakesTotal = 96;
	    int children = 8;
	    int sum18 = cupcakesTotal/children;
	    System.out.println(sum18);
	    
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
	    int gingerbread = 47; 
	    int jar = 6;
	    int sum19 = gingerbread/jar;
	    System.out.println(sum19);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
	    int prepared = 59;
	    int neighbors1 = 8;
	    int sum20 = prepared/neighbors1;
	    System.out.println(sum20);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
	    int place = 12;
	    int preparedT = 276;
	    int sum22 = preparedT/place;
	    System.out.println(sum22);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
	    int pretzlesMade = 480;
	    int serving = 12;
	    int sum23 = pretzlesMade/serving;
	    System.out.println(pretzlesMade);
	    

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
	    int bakedTotal = 53;
	    int leftCookies = 2;
	    int boxes = 3;
	    int sum24 = (bakedTotal - leftCookies)/boxes;
	    System.out.println(sum24);
	    
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
	    int preparedCarrot = 74;
	    int served = 12;
	    int sum25 = preparedCarrot/served;
	    System.out.println(sum25);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
	    int bears = 98;
	    int shelf = 7; 
	    int sum26 = bears/shelf;
	    System.out.println(sum26);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
	    int wholeAlbum = 20;
	    int pics = 480;
	    int sum27 = pics/wholeAlbum;
	    System.out.println(sum27);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
	    int cards8 = 94;
	    int boxes9 = 8;
	    int sum28 = cards8/boxes9;
	    System.out.println(sum28);
         

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
	    int books12 = 210;
	    int shelves = 10;
	    int sum29 = books12/shelves;
	    System.out.println(sum29);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
	    int croissant = 17;
	    int guest1 = 7;
	    int sum30 = croissant/guest1;
	    System.out.println(sum30);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
	    int bill = 135;
	    int jill = 150;
	    int combinedPainters = 285;
	    // 8*12 = 96 ft (is two sides to the wall) *  2 (2 sided to a room) = 192 then (192 /5) = 
	    // 8*14= 112 ft (sides wall) * 2 (2 sided to a room) = 
	    
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
	    String firstName = "Antoinette";
	    String lastName = "McKinney";
	    String middleIn = "Q";
	    String fullName = lastName + ", " + firstName + ", " + middleIn + ". ";
	    System.out.println(fullName);
	    
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
	   int travled = 537;
	   int distance = 800;
	   int total5 = distance/travled;

	}

}