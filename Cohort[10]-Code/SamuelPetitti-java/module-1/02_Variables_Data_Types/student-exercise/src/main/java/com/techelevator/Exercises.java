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
		System.out.println("remainingNumberOfBirds = " + remainingNumberOfBirds);
        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println("numberOfExtraBirds = " + numberOfExtraBirds);

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
			int raccoonsInWoods = 3;
			int raccoonsHomeForDinner = 2;
			int raccoonsLeftInWoods = raccoonsInWoods - raccoonsHomeForDinner;
			System.out.println("raccoonsLeftInWoods = " + raccoonsLeftInWoods);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
			int flowers = 5;
			int bees = 3;
			int flowersLessBees = flowers - bees;
			System.out.println("flowersLessBees = " + flowersLessBees);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
			int pigeonEatingBreadcrumbs = 1;
			pigeonEatingBreadcrumbs += 1;
			System.out.println("pigeonEatingBreadcrumbs = " + pigeonEatingBreadcrumbs);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
			int owlsOnFence = 3;
			owlsOnFence += 2;
			System.out.println("owlsOnFence = " + owlsOnFence);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */ 
			int beaversWorking = 2;
			int beaversSwimming = 1;
			beaversWorking = beaversWorking- beaversSwimming;
			System.out.println("beaversWorking = " + beaversWorking);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
			int toucansOnTreeLimb = 2;
			int joiningToucans = 1;
			int totalToucans = toucansOnTreeLimb + joiningToucans;
			System.out.println("totalToucans = " + totalToucans);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
			int squirrelsInTree = 4;
			int nutsInTree = 2;
			int squirrelsLessNuts = squirrelsInTree - nutsInTree;
			System.out.println("squirrelsLessNuts = " + squirrelsLessNuts);
			
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
			double quarter = 0.25;
			double dime = 0.10;
			double nickel = 0.05;
			double mrsHiltFound = (quarter + dime + nickel + nickel);
			System.out.println("mrsHiltFound = " + mrsHiltFound);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
			int mrsHiltsClassMuffins = 18;
			int mrsBriersClassMuffins = 20;
			int mrsFlannerysClassMuffins = 17;
			int totalMuffins = mrsHiltsClassMuffins + mrsBriersClassMuffins + mrsFlannerysClassMuffins;
			System.out.println("totalMuffins = " + totalMuffins);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
			double yoyo = 0.24;
			double whistle = 0.14;
			double mrsHiltSpent = yoyo + whistle;
			System.out.println("mrsHiltSpent = $" + mrsHiltSpent);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
			int riceKrispieTreats = 5;
			int lgMarshmallows = 8;
			int miniMarshmallows = 10;
			int totalMarshmallows = lgMarshmallows + miniMarshmallows;
			System.out.println("totalMarshmallows = " + totalMarshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
			int mrsHiltSnow = 29;
			int brecknockElementarySnow = 17;
			int snowDifference = mrsHiltSnow - brecknockElementarySnow;
			System.out.println("snowDifference = " + snowDifference);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */  
			int mrsHiltCash = 10;
			int toyTruckCost = 3;
			int pencilCaseCost = 2;
			int mrsHiltCashLeft = mrsHiltCash - toyTruckCost - pencilCaseCost;
			System.out.println("mrsHiltCashLeft = " + mrsHiltCashLeft);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
			int joshMarbles = 16;
			joshMarbles -= 7;
			System.out.println("JoshMarbles = " + joshMarbles);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
			int goalAmountOfSeashells = 25;
			int meganSeashells = 19;
			int seashellsNeeded = goalAmountOfSeashells - meganSeashells;
			System.out.println("seashellsNeeded = " + seashellsNeeded);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
			int bradTotalBalloons = 17;
			int bradRedBalloons = 8;
			int bradGreenBalloons = bradTotalBalloons - bradRedBalloons;
			System.out.println("bradGreenBalloons = " + bradGreenBalloons);
        
		/*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
		*/ 
			int booksOnShelf = 38;
			int martaBooks = 10;
			booksOnShelf += martaBooks;
			System.out.println("booksOnShelf = " + booksOnShelf);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
			int beeLegs = 6;
			int totalBeeLegs = beeLegs * 8;
			System.out.println("totalBeeLegs = " + totalBeeLegs);
			
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */ 
			double iceCreamConeCost = 0.99;
			double mrsHiltIceCreamCost = iceCreamConeCost * 2;
			System.out.println("mrsHiltIceCreamCost = $" + mrsHiltIceCreamCost);
			

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
			int totalRocksNeeded = 125;
			int mrsHiltRocks = 64;
			totalRocksNeeded -= mrsHiltRocks;
			System.out.println("totalRocksNeeded = " + totalRocksNeeded);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
			int mrsHiltMarblesLeft = 38 - 15;
			System.out.println("mrsHiltMarblesLeft = " + mrsHiltMarblesLeft);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
			int mrsHiltConcertTrip = 78;
			int milesToGas = 32;
			int milesLeft = mrsHiltConcertTrip - milesToGas;
			System.out.println("milesLeft = " + milesLeft);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
			int satMorningTimeShoveling = 90;
			int satAfternoonTimeShoveling = 45;
			int totalTimeShoveling = satMorningTimeShoveling + satAfternoonTimeShoveling;
			System.out.println("totalTimeShoveling = " + totalTimeShoveling + " minutes");
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
			double hotDogCost = 0.50;
			double mrsHiltHotDogCostTotal = hotDogCost * 6;
			System.out.println("mrsHiltHotDogCostTotal = " + mrsHiltHotDogCostTotal);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
			int mrsHiltMoney = 50;
			int pencilCost = 7;
			int pencilsAfforded = mrsHiltMoney/ pencilCost;
			System.out.println("pencilsAfforded = " + pencilsAfforded);
			
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
			int totalButterfliesSeen = 33;
			int orangeButterflies = 20;
			int redButterflies = totalButterfliesSeen - orangeButterflies;
			System.out.println("redButterflies =" + redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
			double kateMoney = 1.00;
			double candyCost = 0.54;
			double change = kateMoney - candyCost;
			System.out.println("change = " + change);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
			int markTrees = 13;
			markTrees += 12;
			System.out.println("markTrees = " + markTrees);
			
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
			int hoursInDay = 24;
			int joyDaysUntilGrandma = 2;
			int joyHoursUntilGrandma = hoursInDay * joyDaysUntilGrandma;
			System.out.println("joyHoursUntilGrandma = " + joyHoursUntilGrandma);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
			int kimCousins = 4;
			int piecesOfGumToGive = 5;
			int totalGumToGive = kimCousins * piecesOfGumToGive;
			System.out.println("totalGumToGive = " + totalGumToGive);
			
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
			double danCash = 3.00;
			double candyBarCost = 1.00;
			double moneyLeft = danCash - candyBarCost;
			System.out.println("moneyLeft = " + moneyLeft);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
			int boatsInLake = 5;
			int peoplePerBoat = 3;
			int totalPeopleOnBoats = boatsInLake * peoplePerBoat;
			System.out.println("totalPeopleOnBoats = " + totalPeopleOnBoats);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
			int ellenTotalLegos = 380;
			ellenTotalLegos -= 57;
			
			System.out.println("ellenTotalLegos = " + ellenTotalLegos);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
			int arthurBakedMuffins = 35;
			int desiredBakedMuffins = 83;
			int amountMuffinsNeeded = desiredBakedMuffins - arthurBakedMuffins;
			System.out.println("amountMuffinsNeeded = " + amountMuffinsNeeded);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
			int willyCrayons = 1400;
			int lucyCrayons = 290;
			int willyLucyDiff = willyCrayons - lucyCrayons;
			System.out.println("willyLucyDiff = " + willyLucyDiff);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
			int stickersPerPage = 10;
			int totalPages = 22;
			int totalStickers = stickersPerPage * totalPages;
			System.out.println("totalStickers = " + totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
			int cupcakes = 96;
			int children = 8;
			int cupcakesPerChild = cupcakes/ children;
			System.out.println("cupcakesPerChild = " + cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
			int totalGingerbreadCookies = 47;
			int jarCapacity = 6;
			int cookiesLeftover = 47 % 6;
			System.out.println("cookiesLeftover = " + cookiesLeftover);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */  
			int preparedCroissants = 59;
			int numOfNeighbors = 8;
			int leftoverCroissants = 59 % 8;
			System.out.println(" leftoverCroissants = " +  leftoverCroissants);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
			int cookiesPerTray = 12;
			int totalCookies = 276;
			int totalTraysNeeded = totalCookies / cookiesPerTray;
			if(totalCookies % cookiesPerTray > 0) {
				totalTraysNeeded += 1;
			}
			System.out.println("totalTraysNeeded = " + totalTraysNeeded);
			
			//conditional for if totalTraysNeeded not evenly divisible
		/*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
			int totalPretzels = 480;
			int oneServing = 12;
			int totalServings = totalPretzels/oneServing;
			System.out.println("totalServings = " + totalServings);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
			int lemonCupcakes = 53;
			int cupcakesLeftatHome = 2;
			lemonCupcakes -= cupcakesLeftatHome;
			int cupcakesPerBox = 3;
			int cupcakeBoxes = lemonCupcakes / cupcakesPerBox; 
			System.out.println("cupcakeBoxes = " + cupcakeBoxes);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
			int breakfastCarrots = 74;
			int carrotEaters = 12;
			int uneatenCarrots = breakfastCarrots % carrotEaters;
			System.out.println("uneatenCarrots = " + uneatenCarrots);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
			int susiesTeddyBears = 98;
			int teddyBearsPerShelf = 7;
			int filledShelves = susiesTeddyBears / teddyBearsPerShelf;
			System.out.println("filledShelves = " + filledShelves);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
			int picsPerAlbum = 20;
			int totalPics = 480;
			int albumsNeeded = totalPics/ picsPerAlbum;
			System.out.println("albumsNeeded = " + albumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
			int joeTradingCards = 94;
			int cardsPerBox = 8;
			int boxesFilled = joeTradingCards/cardsPerBox;
			int cardsInUnfilledBox = 94 % 8;
			System.out.println("There were " + boxesFilled + " boxes filled " +
					cardsInUnfilledBox + " cards in the unfilled box.");

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
			int shelvesRepaired = 10;
			int totalBooks = 210;
			int booksPerShelf = totalBooks/ shelvesRepaired;
			System.out.println("booksPerShelf = " + booksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
			int croissantsBaked = 17;
			int guests = 7;
			int croissantsPerGuest = croissantsBaked/guests;
			System.out.println("croissantsPerGuest  = " + croissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
			double billHourlyRate = 12 * 14/ 2.15;
			double jillHourlyRate = 12 * 14/ 1.90;
			double combinedRate = billHourlyRate + jillHourlyRate;
			double combinedPaintJobFeet = 5 * 12 * 14;
			double combinedPaintJobTime = combinedPaintJobFeet / combinedRate;
			System.out.println("combinedPaintJobTime = " + combinedPaintJobTime);
			double extraLongPaintJobFeet = 623 * 12 * 14;
			double hoursPerDay = 8;
			double extraLongPaintJobDays = extraLongPaintJobFeet/combinedRate/hoursPerDay;
			System.out.println("extraLongPaintJobDays = " + extraLongPaintJobDays);
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
			String firstName = "Samuel";
			String middleInit = "J.";
			String lastName = "Petitti";
			String fullLastNameFirst = lastName + ", "+ firstName + " " + middleInit; 
			System.out.println(fullLastNameFirst);
			

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
			double nycChicagoDistance = 800;
			double trainDistanceTraveled = 537;
			double percentCompleted = trainDistanceTraveled/ nycChicagoDistance * 100;
			System.out.println((int)percentCompleted + "%");
	}

}
