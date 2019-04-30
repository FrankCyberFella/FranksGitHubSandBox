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
		int initialRacoons = 3;
		int	racoonsAtHome = 2;
		int remainingRacoons = initialRacoons - racoonsAtHome;
		System.out.println("remainingRacoons is " + remainingRacoons);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numFlowers = 5;
		int numBees = 3;
		int beesLessThanFlowers = numFlowers - numBees;
		System.out.println("diff is " + beesLessThanFlowers);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int initialPigeon = 1;
		int nextPigeon = 1;
		int currentPigeons = initialPigeon + nextPigeon;
		System.out.println(currentPigeons);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int initialOwls = 3;
		int nextOwls = 2;
		int currentOwls = initialOwls + nextOwls;
		System.out.println(currentOwls);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int initialWorkingBeavers = 2;
		int swimBeaver = 1;
		int currentWorkBeaver = initialWorkingBeavers - swimBeaver;
		System.out.println(currentWorkBeaver);
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int initialToucans = 2;
		int newToucans = 1;
		int currentToucans = initialToucans + newToucans;
		System.out.println(currentToucans);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels = 4;
		int nuts = 2;
		int diffSquirrelsAndNuts = squirrels - nuts;
		System.out.println(diffSquirrelsAndNuts);
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .1;
		double nickels = .1;
		double hiltMoney = quarter + dime + nickels;
		System.out.println(hiltMoney);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierMuffins = 18;
		int macadamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalFirstGradeMuffins = brierMuffins + macadamsMuffins + flanneryMuffins;
		System.out.println(totalFirstGradeMuffins);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double hiltYoyo = 0.24;
		double hiltWhistle = 0.14;
		double toysCost = hiltYoyo + hiltWhistle;
		System.out.println(toysCost);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int hiltLargeMarshmallows = 8;
		int hiltMiniMarshmallows = 10;
		int totalMarshmallows = hiltLargeMarshmallows + hiltMiniMarshmallows;
		System.out.println(totalMarshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltHouseSnow = 29;
		int brecknockElemSnow = 17;
		int snowDiff = hiltHouseSnow - brecknockElemSnow;
		System.out.println(snowDiff);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int hiltInitialCash = 10;
		int costToyTruck = 3;
		int costPencilCase = 2;
		int hiltCashLeft = hiltInitialCash - costToyTruck - costPencilCase;
		System.out.println(hiltCashLeft);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initialMarbles = 16;
		int lostMarbles = 7;
		int marblesLeft = initialMarbles - lostMarbles;
		System.out.println(marblesLeft);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int ownedSeashells = 19;
		int desiredSeashells = 25;
		int seashellsNeeded = desiredSeashells - ownedSeashells;
		System.out.println(seashellsNeeded);
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		System.out.println(greenBalloons);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialBooks = 38;
		int newBooks = 10;
		int newTotalBooks = initialBooks + newBooks;
		System.out.println(newTotalBooks);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsPerBee = 6;
		int numberOfBees = 8;
		int totalLegs = legsPerBee * numberOfBees;
		System.out.println(totalLegs);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamConeCost = .99;
		int numberOfCones = 2;
		double costOfTwoCones = iceCreamConeCost * numberOfCones;
		System.out.println(costOfTwoCones);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int rocksToComplete = 125;
		int rocksOwned = 64;
		int rocksNeeded = rocksToComplete - rocksOwned;
		System.out.println(rocksNeeded);
		
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hiltInitialMarbles = 38;
		int hiltLostMarbles = 15;
		int currentMarbles = hiltInitialMarbles - hiltLostMarbles;
		System.out.println(currentMarbles);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalDistance = 78;
		int milesDriven = 32;
		int milesLeft = totalDistance - milesDriven;
		System.out.println(milesLeft);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int morningShovelingMinutes = 90;
		int afternoonShovelingMinutes = 45;
		int totalShovelingMinutes = morningShovelingMinutes + afternoonShovelingMinutes;
		System.out.println(totalShovelingMinutes);
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int totalHotDogs = 6;
		double hotDogCost = .5;
		double totalHotDogCost = totalHotDogs * hotDogCost;
		System.out.println(totalHotDogCost);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double hiltMoneyCents = .5;
		double pencilCost = .07;
		double pencilsCanBuy = hiltMoneyCents / pencilCost;
		System.out.println(pencilsCanBuy);
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		System.out.println(redButterflies);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kateMoney = 1.0;
		double candyCost = .54;
		double kateChange = kateMoney - candyCost;
		System.out.println(kateChange);
		
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int markInitialTrees = 13;
		int markPlantedTrees = 12;
		int markTotalTrees = markInitialTrees + markPlantedTrees;
		System.out.println(markTotalTrees);
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysJoySeeGrandma = 2;
		int hoursInDay = 24;
		int hoursToSeeGrandma = daysJoySeeGrandma * hoursInDay;
		System.out.println(hoursToSeeGrandma);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimCousins = 4;
		int gumToGive = 5;
		int gumNeeded = kimCousins * gumToGive;
		System.out.println(gumNeeded);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		int danMoneyStart = 3;
		int danMoneySpent = 1;
		int danMoneyLeft = danMoneyStart - danMoneySpent;
		System.out.println(danMoneyLeft);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsOnLake = 5;
		int peoplePerBoat = 3;
		int totalPeopleInAllBoats = boatsOnLake * peoplePerBoat;
		System.out.println(totalPeopleInAllBoats);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenStartLegos = 380;
		int lostLegos = 57;
		int currentLegos = ellenStartLegos - lostLegos;
		System.out.println(currentLegos);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsBaked = 35;
		int muffinsDesired = 83;
		int muffinsToBake = muffinsDesired - muffinsBaked;
		System.out.println(muffinsToBake);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int willyDiffLucy = willyCrayons - lucyCrayons;
		System.out.println(willyDiffLucy);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int numberOfPages = 22;
		int totalStickersOnPage = stickersPerPage * numberOfPages;
		System.out.println(totalStickersOnPage);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int numberOfChildren = 8;
		int cupcakesPerChild = totalCupcakes / numberOfChildren;
		System.out.println(cupcakesPerChild);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerbreakCookies = 47;
		int cookiesPerJar = 6;
		int cookiesRemaining = gingerbreakCookies % cookiesPerJar;
		System.out.println(cookiesRemaining);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int numberOfCroissants = 59;
		int croissantsPerNeighbor = 8;
		int croissantsRemaining = numberOfCroissants % croissantsPerNeighbor;
		System.out.println(croissantsRemaining);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesPerTray = 12;
		int totalCookies = 276;
		int totalTraysNeeded = totalCookies / cookiesPerTray;
		System.out.println(totalTraysNeeded);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int pretzelsPerServing = 12;
		int totalPretzelServings = totalPretzels / pretzelsPerServing;
		System.out.println(totalPretzelServings);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int totalLemonCupcakes = 53;
		int cupcakesLeftAtHome = 2;
		int cupcakesPerBox = 3;
		int totalCupcakeBoxes = (totalLemonCupcakes - cupcakesLeftAtHome) / cupcakesPerBox;
		System.out.println(totalCupcakeBoxes);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int totalCarrotSticks = 74;
		int carrotSticksPerPerson = 12;
		int uneatenCarrotSticks = totalCarrotSticks % carrotSticksPerPerson;
		System.out.println(uneatenCarrotSticks);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int bearsPerShelf = 7;
		int shelvesFilled = totalTeddyBears / bearsPerShelf;
		System.out.println(shelvesFilled);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int picsPerAlbum = 20;
		int totalPics = 480;
		int albumsNeeded = totalPics / picsPerAlbum;
		System.out.println(albumsNeeded);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int numberOfTradingCards = 94;
		int cardsPerBox = 8;
		int boxesNeeded = numberOfTradingCards / cardsPerBox;
		int cardsInUnfilledBox = numberOfTradingCards % cardsPerBox;
		System.out.println(boxesNeeded);
		System.out.println(cardsInUnfilledBox);
		/*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooks = 210;
		int totalShelves = 10;
		int booksPerShelf = totalBooks / totalShelves;
		System.out.println(booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int christinaTotalCroissants = 17;
		int numberOfGuests = 7;
		int croissantsPerGuest = christinaTotalCroissants / numberOfGuests;
		System.out.println(croissantsPerGuest);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		/*double roomSqFt = 12 * 14;
		double numOfPainters = 2;
		double numOfRooms = 5;
		double billHourlyRateMins = 129;
		double jillHourlyRateMins = 114;
		double billSqFtPerMin = roomSqFt / billHourlyRateMins;
		double jillSqFtPerMin = roomSqFt / jillHourlyRateMins;
		System.out.println(billSqFtPerMin);
		System.out.println(jillSqFtPerMin);
		double timeToPaintFiveRooms = ((roomSqFt * numOfRooms) / (billSqFtPerMin + jillSqFtPerMin));
		System.out.println(timeToPaintFiveRooms + " minutes");
		double challengeNumOfRooms = 623;
		double minsPerDayWorked = 480;
		double howManyDaysToPaint = ((challengeNumOfRooms * roomSqFt) / (billSqFtPerMin + jillSqFtPerMin) / minsPerDayWorked);
		System.out.println(howManyDaysToPaint + " days");
		*/
		final double ROOM_SQ_FOOT = 12 * 14;
		final double NUMBER_OF_ROOMS = 5;
		double billHourlyRatePerTwelveByFourteenRoom = 2.15;
		double jillHourlyRatePerTwelveByFourteenRoom = 1.90;
		double billSqFtPerHourlyRate = ROOM_SQ_FOOT / billHourlyRatePerTwelveByFourteenRoom;
		double jillSqFtPerHourlyRate = ROOM_SQ_FOOT / jillHourlyRatePerTwelveByFourteenRoom;
		System.out.println(billSqFtPerHourlyRate);
		System.out.println(jillSqFtPerHourlyRate);
		double timeToPaintFiveRooms = ((ROOM_SQ_FOOT * NUMBER_OF_ROOMS) / (billSqFtPerHourlyRate + jillSqFtPerHourlyRate));
		System.out.println(timeToPaintFiveRooms + " hours");
		final double CHALLENGE_NUMBER_OF_ROOMS = 623;
		final double HOURS_PER_DAY_WORKED = 8;
		double howManyDaysToPaint = ((CHALLENGE_NUMBER_OF_ROOMS * ROOM_SQ_FOOT) / (billSqFtPerHourlyRate + jillSqFtPerHourlyRate) / HOURS_PER_DAY_WORKED);
		System.out.println(howManyDaysToPaint + " days");
		
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String myFirstName = "Alec";
		String myMiddleInitial = "W";
		String myLastName = "Petro";
		String myFullName = myLastName + ", " + myFirstName + " " + myMiddleInitial + ".";
		System.out.println(myFullName);
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		int nyToChi = 800;
		int distTravelled = 537;
		double percentComplete = ((double)distTravelled / nyToChi) * 100;
		int finalValue = (int)percentComplete;
		System.out.println(finalValue +"%");
		

	}

}
