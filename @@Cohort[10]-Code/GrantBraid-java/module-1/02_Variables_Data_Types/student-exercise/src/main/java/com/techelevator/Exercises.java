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
		System.out.println("1. " + remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println("2. " + numberOfExtraBirds);
		
        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int numberOfRaccoonsLeaving = 2;
		int raccoonsLeft = numberOfRaccoons - numberOfRaccoonsLeaving;
		System.out.println("3. " + raccoonsLeft);



        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberFlowers = 5;
		int numberBees = 3;
		int beesLessThanFlowers = numberFlowers - numberBees;
		System.out.println("4. " + beesLessThanFlowers);


        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int totalPigeon = lonelyPigeon + anotherPigeon;
		System.out.println("5. " + totalPigeon);


        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int initialOwls = 3;
		int joiningOwls = 2;
		int totalOwls = initialOwls + joiningOwls;
		System.out.println("6. " + totalOwls);


        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int initialBeavers = 2;
		int swimmingBeaver = 1;
		int beaversLeft = initialBeavers - swimmingBeaver;
		System.out.println("7. " + beaversLeft);


        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int initialToucans = 2;
		int joiningToucan = 1;
		int totalToucans = initialToucans + joiningToucan;
		System.out.println("8. " + totalToucans);


        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int moreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts;
		System.out.println("9. " + moreSquirrelsThanNuts);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did 
        she find?
        */
		double quarter = 0.25;
		double dime = 0.1;
		double nickels = 2 * 0.05;
		double totalMoney = quarter + dime + nickels;
		System.out.println("10. " + totalMoney);


        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brier = 18;
		int macAdams = 20;
		int flannery = 17;
		int firstGradeTotal = brier + macAdams + flannery;
		System.out.println("11. " + firstGradeTotal);


        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyo = .24;
		double whistle = .14;
		double hiltTotal = yoyo + whistle;
		System.out.println("12. " + hiltTotal);


        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarsh = 8;
		int miniMarsh = 10;
		int totalMarsh = largeMarsh + miniMarsh;
		System.out.println("13. " + totalMarsh);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltsHouse = 29;
		int brecknock = 17;
		int moreSnowAtHilts = hiltsHouse - brecknock;
		System.out.println("14. " + moreSnowAtHilts);

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int initialMoney = 10;
		int toyTruck = 3;
		int pencilCase = 2;
		int moneyLeft = initialMoney - toyTruck - pencilCase;
		System.out.println("15. " + moneyLeft);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initialMarbles = 16;
		int lostMarbles = 7;
		int marblesLeft = initialMarbles - lostMarbles;
		System.out.println("16. " + marblesLeft);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int initialSeashells = 19;
		int seashellsWanted = 25;
		int neededSeashells = seashellsWanted - initialSeashells;
		System.out.println("17. " + neededSeashells);


        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		System.out.println("18. " + greenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialBooks = 38;
		int booksPutOn = 10;
		int totalBooks = initialBooks + booksPutOn;
		System.out.println("19. " + totalBooks);


        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfBees = 8;
		int legsOnBee = 6;
		int totalLegs = numberOfBees * legsOnBee;
		System.out.println("20. " + totalLegs);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamCost = 0.99;
		int    iceCreamQuantity = 2;
		double totaliceCreamCost = iceCreamCost * iceCreamQuantity;
		System.out.println("21. " + totaliceCreamCost);


        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocks = 125;
		int rocksOwned = 64;
		int rocksNeeded = totalRocks - rocksOwned;
		System.out.println("22. " + rocksNeeded);


        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hiltMarbles = 38;
		int hiltLost = 15;
		int hiltMarblesLeft = hiltMarbles - hiltLost;
		System.out.println("23. " + hiltMarblesLeft);


        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesToConcert = 78;
		int milesDriven = 32;
		int milesLeft = milesToConcert - milesDriven;
		System.out.println("24. " + milesLeft);


        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minutesSaturdayMorn = 90;
		int minutesSaturdayNigh = 45;
		int totalTimeShovelingMinutes = minutesSaturdayMorn + minutesSaturdayNigh;
		System.out.println("25. " + totalTimeShovelingMinutes);

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double costOfHotDog = 0.5;
		int numberOfHotDogs = 6;
		double totalForHotDogs = costOfHotDog * numberOfHotDogs;
		System.out.println("26. " + totalForHotDogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int currentMoney = 50;
		int pencilCost = 7;
		int totalAllowablePencils = currentMoney / pencilCost;
		System.out.println("27. " + totalAllowablePencils);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		System.out.println("28. " + redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kateInitialMoney = 1.00;
		double kateCandyCost = 0.54;
		double kateMoneyFinal = kateInitialMoney - kateCandyCost;
		System.out.println("29. " + kateMoneyFinal);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int markInitialTrees = 13;
		int markAddedTrees = 12;
		int markFinalTrees = markInitialTrees + markAddedTrees;
		System.out.println("30. " + markFinalTrees);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInDay = 24;
		int numberOfDays = 2;
		int joySeeGrandma = hoursInDay * numberOfDays;
		System.out.println("31. " + joySeeGrandma);

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousins = 4;
		int piecesPerCousin = 5;
		int piecesOfGum = numberOfCousins * piecesPerCousin;
		System.out.println("32. " + piecesOfGum);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danInitialMoney = 3.00;
		double danCandyBar = 1.00;
		double danFinalMoney = danInitialMoney - danCandyBar;
		System.out.println("33. " + danFinalMoney);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoats = 5;
		int peoplePerBoat = 3;
		int peopleOnLake = numberOfBoats * peoplePerBoat;
		System.out.println("34. " + peopleOnLake);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenInitialLegos = 380;
		int ellenLostLegos = 57;
		int ellenFinalLegos = ellenInitialLegos - ellenLostLegos;
		System.out.println("35. " + ellenFinalLegos);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int arthurBaked = 35;
		int arthurNeedToMake = 83;
		int arthurHaveToBake = arthurNeedToMake - arthurBaked;
		System.out.println("36. " + arthurHaveToBake);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int willyCrayonSurplus = willyCrayons - lucyCrayons;
		System.out.println("37. " + willyCrayonSurplus);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int pagesOfStickers = 22;
		int stickersPerPage = 10;
		int totalStickers = pagesOfStickers * stickersPerPage;
		System.out.println("38. " + totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalNumberOfCupcakes = 96;
		int numberOfChildren = 8;
		int cupcakesPerChild = totalNumberOfCupcakes / numberOfChildren;
		System.out.println("39. " + cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalGingerbread = 47;
		int cookiesPerJar = 6;
		int numberOfJars = totalGingerbread % cookiesPerJar;
		System.out.println("40. " + numberOfJars);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsPrepared = 59;
		int croissantNeighbors = 8;
		int croissantsForHer = croissantsPrepared % croissantNeighbors;
		System.out.println("41. " + croissantsForHer);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int marianRequiredCookies = 276;
		int marianCookiesPerTray = 12;
		int marianNumberOfTrays = marianRequiredCookies / marianCookiesPerTray;
		System.out.println("42. " + marianNumberOfTrays);
		

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int marianPretzelsMade = 480;
		int pretzelsPerServing = 12;
		int marianPretzelServings = marianPretzelsMade / pretzelsPerServing;
		System.out.println("43. " + marianPretzelServings);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int marianLemonCupcakes = 53;
		int marianLemonHome = 2;
		int marianLemonNumPerBox = 3;
		int marianLemonBoxes = (marianLemonCupcakes - marianLemonHome) / marianLemonNumPerBox;
		System.out.println("44. " + marianLemonBoxes);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int susieMomCarrot = 74;
		int susieMomPeople = 12;
		int susieMomCarrotLeft = susieMomCarrot % susieMomPeople;
		System.out.println("45. " + susieMomCarrotLeft);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int susieTeddyBears = 98;
		int susieMaxPerShelf = 7;
		int susieShelfFilled = susieTeddyBears / susieMaxPerShelf;
		System.out.println("46. " + susieShelfFilled);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int susieMomPic = 480;
		int susieMomAlbumSize = 20;
		int susieMomAlbumsNeeded = susieMomPic / susieMomAlbumSize;
		System.out.println("47. " + susieMomAlbumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int joeTradingCards = 94;
		int joeCardsPerBox = 8;
		int joeUnfilledBox = joeTradingCards % joeCardsPerBox;
		int joeNumBox = joeTradingCards / joeCardsPerBox;
		System.out.println("48. " + joeNumBox + " " + joeUnfilledBox);
		
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int susieFatherBooks = 210;
		int susieFatherNumShelf = 10;
		int susieFatherBookPerShelf = susieFatherBooks / susieFatherNumShelf;
		System.out.println("49. " + susieFatherBookPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double cristinaBakedCroissants = 17;
		double cristinaNumGuests = 7;
		double cristinaNumPerGuest = cristinaBakedCroissants / cristinaNumGuests;
		System.out.println("50. " + cristinaNumPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		double billRoomsPerHour = 1 / 2.15;
		double jillRoomsPerHour = 1 / 1.9;
		double avgRoomPerOneHour = billRoomsPerHour + jillRoomsPerHour;
		int numOfRooms = 5;
		double timeForFiveRooms = (1/avgRoomPerOneHour) * numOfRooms;
		System.out.println("\nChallenge problem 1: Time for five rooms " + timeForFiveRooms);
		numOfRooms = 623; 
		double DaysForLotOfRooms = ((1/avgRoomPerOneHour) * numOfRooms) / 8;
		System.out.println("Days for 623 rooms " + DaysForLotOfRooms);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String firstName = "Grant";
		String lastName = "Braid";
		String middleInitial = "W";
		String nameConcat = lastName + ", " + firstName + " " + middleInitial;
		System.out.println("\nChallenge 2: " + nameConcat);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		double distanceTraveled = 537;
		double totalDistance = 800;
		double percentTraveled = (distanceTraveled / totalDistance) * 100;
		int percentTraveledInt = (int)percentTraveled;

		System.out.println("\nChallenge 3: " + percentTraveledInt);


	}

}
