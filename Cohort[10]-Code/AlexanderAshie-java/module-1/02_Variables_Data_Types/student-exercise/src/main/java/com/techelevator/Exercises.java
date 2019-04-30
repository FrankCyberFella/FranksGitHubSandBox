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

		int numberOfRaccoons = 3;
		numberOfRaccoons = numberOfRaccoons - 2;
		
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int remainderOfBees = numberOfFlowers - numberOfBees;
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int numberOfPidgeons = 1;
		numberOfPidgeons += 1;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int numberOfOwls = 3;
		numberOfOwls += 2;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int numberOfBeavers = 2;
		numberOfBeavers -= 1;

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		
		int numberOfToucans = 2;
		numberOfToucans += 1;

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int differenceOfSquirrels = numberOfSquirrels - numberOfNuts;

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		
		double QUARTER = 0.25;
		double DIME = 0.10;
		double NICKEL = 0.05;
		double totalAmountOfMoney = QUARTER + DIME + (NICKEL * 2);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int brierMuffinTotal = 18;
		int macadamsMuffinTotal = 20;
		int flanneryMuffinTotal = 17;
		int totalNumberOfMuffins = brierMuffinTotal + macadamsMuffinTotal + flanneryMuffinTotal;
		

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		double yoyoCost = 0.24;
		double whistleCost = 0.12;
		double totalToyCost = yoyoCost + whistleCost;

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		
		int numberOfLargeMarshmallows = 8;
		int numberOfMiniMarshmallows = 10;
		int totalNumberOfMarshmallows = numberOfLargeMarshmallows + numberOfMiniMarshmallows;

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int hiltHouseInchesOfSnow = 29;
		int brecknockEleInchesOfSnow = 17;
		int snowDifference = hiltHouseInchesOfSnow - brecknockEleInchesOfSnow;

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int hiltMoneyRemaining = 10;
		int toyTruckCost = 3;
		int pencilCaseCost = 2;
		hiltMoneyRemaining = hiltMoneyRemaining - (toyTruckCost + pencilCaseCost);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int joshMarbleCount = 16;
		joshMarbleCount -= 7;
		//System.out.println(joshMarbleCount);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int meganDesiredSeashellCount = 25;
		int meganSeashellCount = 19;
		int meganSeashellDifference = meganDesiredSeashellCount - meganSeashellCount;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int bradBalloonCount = 17;
		int bradNumberOfRedBalloons = 8;
		int bradNumberOfGreenBalloons = bradBalloonCount - bradNumberOfRedBalloons;

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int numberOfBooksOnShelf = 38;
		numberOfBooksOnShelf += 10;

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int indBeeLegCount = 6;
		int numberOfBees2 = 8;
		int totalBeeLegCount = indBeeLegCount * numberOfBees2;
		

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		double iceCreamConeCost = 0.99;
		iceCreamConeCost *= 2;

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int requiredBorderRockCount = 125;
		int hiltNumberOfRocksNeeded = requiredBorderRockCount - 64;

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int hiltMarbleCount = 38;
		hiltMarbleCount -= 15;
		
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int hiltConcertDistance = 78;
		hiltConcertDistance -= 32;

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		
		int saturdayTimeSpentInMinutes = 90;
		int sundayTimeSpentInMinutes = 45;
		int totalTimeSpentShovelingInMinutes = saturdayTimeSpentInMinutes + sundayTimeSpentInMinutes;
		

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		int hiltHotDogCount = 6;
		double hiltIndHotDogCost = 0.50;
		double hiltTotalHotDogCost = hiltHotDogCount * hiltIndHotDogCost;

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		double hiltMoneyInHand = 0.50;
		double pencilCost = 0.07;
		double totalPencilsPurchasable = hiltMoneyInHand / pencilCost;

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int hiltTotalButterflyCount = 33;
		int hiltOrangeButterflyCount = 20;
		int hiltRedButterflyCount = hiltTotalButterflyCount - hiltOrangeButterflyCount;

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		double kateMoneyInHand = 1.00;
		double kateCandyCost = 0.54;
		kateMoneyInHand -= kateCandyCost;

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int markTreeCount = 13;
		markTreeCount += 12;

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int HOURS_PER_DAY = 24;
		int grandmaVisitCountdown = HOURS_PER_DAY * 2;

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int kimCousinCount = 4;
		int totalGumCount = kimCousinCount *= 5;

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		double danMoneyInHand = 3.00;
		double danCandyBarCost = 1.00;
		danMoneyInHand -= danCandyBarCost;

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int boatsOnLake = 5;
		int peoplePerBoat = 3;
		int totalPeopleOnBoats = boatsOnLake * peoplePerBoat;

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		
		int ellenLegoCount = 380;
		ellenLegoCount -= 57;

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int arthurDesiredMuffinCount = 83;
		arthurDesiredMuffinCount -= 35;

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willyCrayonCount = 1400;
		int lucyCrayonCount = 290;
		int crayonDifferenceCount = willyCrayonCount - lucyCrayonCount;

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int pageAmount = 22;
		int stickersPerPage = 10;
		int totalStickers = pageAmount * stickersPerPage;

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int totalCupcakes = 96;
		int numberOfChildren = 8;
		int cupCakesPerChild = totalCupcakes / numberOfChildren;

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		
		int gingerbreadCookieCount = 47;
		int cookiesRemaining = gingerbreadCookieCount % 6;

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int totalCroissants = 59;
		int leftoverCroissants = 59 % 8;

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int marianOatmealCookieCount = 276;
		int traysNeeded = marianOatmealCookieCount / 12;

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int pretzelsTotal = 480;
		int servingSize = 12;
		int totalServings = pretzelsTotal / servingSize;

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int totalOrphanCupcakes = 53;
		totalOrphanCupcakes -= 2;
		int cupcakesPerBox = 3;
		
		int cupcakeBoxesGivenAway = totalOrphanCupcakes / cupcakesPerBox;

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int carrotSticksCount = 74;
		carrotSticksCount %= 12;

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int totalTeddyBearCount = 98;
		int shelfMaxThreshold = 7;
		int filledShelves = totalTeddyBearCount / shelfMaxThreshold;

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int numberOfPictures = 480;
		int albumMaxPictureCount = 20;
		int totalAlbumsNeeded = numberOfPictures / albumMaxPictureCount;

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int joeTradingCardCount = 94;
		int joeBoxMaximumCardThreshold = 8;
		int joeBoxesFilled = joeTradingCardCount / joeBoxMaximumCardThreshold;
		int joeRemainingCards = joeTradingCardCount % joeBoxMaximumCardThreshold;

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		
		int totalBooks = 210;
		int maxShelves = 10;
		int booksPerShelf = totalBooks / maxShelves;
		

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		int christinaCroisssantCount = 17;
		int guestCroissantCount = christinaCroisssantCount / 7;
		

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		double totalFeetInTwelveByFourteenRoom = (12 * 2) + (14 * 2);
		double billHourlyRate = totalFeetInTwelveByFourteenRoom / 2.15;
		double jillHourlyRate = totalFeetInTwelveByFourteenRoom / 1.90;
		double teamHourlyRate = billHourlyRate + jillHourlyRate;
		
		int HOURS_IN_A_DAY = 24;
		
		double timeTakenForFiveRoomsInHours = (totalFeetInTwelveByFourteenRoom * 5) / teamHourlyRate;
		double timeTakenForManyRoomsInDays = ((totalFeetInTwelveByFourteenRoom * 623) / teamHourlyRate) / HOURS_IN_A_DAY;
		
		
		System.out.println("It will take the team " + timeTakenForFiveRoomsInHours + " hours to complete 5 rooms.");
		System.out.println("It will take the team " + timeTakenForManyRoomsInDays + " days to complete 623 rooms.");


        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		
		String firstName = "Alexander";
		String lastName = "Ashie";
		String middleInitial = "T";
		
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";
		System.out.println(fullName);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		
		double totalDistance = 800;
		double currentMile = 537;
		double percentCompleted = currentMile / totalDistance;
		
		percentCompleted = percentCompleted *= 100;
		
		System.out.println((int)percentCompleted + "%");


	}

}
