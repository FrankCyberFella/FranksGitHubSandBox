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
		int numberRaccoonsAtDinner = 2;
		int numberOfRemainingRaccoons = numberOfRaccoons - numberRaccoonsAtDinner;
		System.out.println("number of raccoons still in the woods is " + numberOfRemainingRaccoons);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberBeesLessThanNumberFlowers = numberOfFlowers - numberOfBees;
		System.out.println("number of bees less than number of flowers is " + numberBeesLessThanNumberFlowers);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int pigeon1 = 1;
		int pigeon2 = 1;
		int pigeons = pigeon1 + pigeon2;
		System.out.println("number of pigeons eating is " + pigeons);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsAlreadyOnFence = 3;
		int owlsNewToFence = 2;
		int sumOwls = owlsAlreadyOnFence + owlsNewToFence;
		System.out.println("Total number of owls on fence is " + sumOwls);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int totalNumberBeavers = 2;
		int numberBeaversLeftToSwim = 1;
		int numberBeaversRemainingAtHome = totalNumberBeavers - numberBeaversLeftToSwim;
		System.out.println("number of beavers remaining at home " + numberBeaversRemainingAtHome);
		
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int initialToucans = 2;
		int additionalToucans = 1;
		int sumToucans = initialToucans + additionalToucans;
		System.out.println("Total number of Toucans on tree limb is " + sumToucans);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int totalSquirrelsInTree = 4;
		int totalNutsInTree = 2;
		int numberOfSquirrelsGreaterThanNumberOfNuts = totalSquirrelsInTree - totalNutsInTree;
		System.out.println("number of squirrels greater than the number of nuts in the tree is " + numberOfSquirrelsGreaterThanNumberOfNuts);
		
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int sumCoins = quarter + dime + (2 * nickel);
		System.out.println("Mrs. Hilt has " + sumCoins + " cents");
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierClassMuffins = 18;
		int macadamsClassMuffins = 20;
		int flanneryClassMuffins = 17;
		int sumFirstGradeMuffins = brierClassMuffins + macadamsClassMuffins + flanneryClassMuffins;
		System.out.println("First Grade baked " + sumFirstGradeMuffins + " muffins");
		
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int costYoyo = 24;
		int costWhistle = 14;
		int sumTwoToys = costYoyo + costWhistle;
		System.out.println("Total cost for two toys is " + sumTwoToys + " cents");
			
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallow = 8;
		int miniMarshmallow = 10;
		int totalMarshmallow = largeMarshmallow + miniMarshmallow;
		System.out.println("Mrs. Hilt used " + totalMarshmallow + " marshmallows");
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowAtHiltHouse = 29;
		int snowAtBrecknockSchool = 17;
		int amountOfSnowGreaterAtHiltHouseThanBrecknockSchool = snowAtHiltHouse - snowAtBrecknockSchool;
		System.out.println("Mrs. Hilt had " + amountOfSnowGreaterAtHiltHouseThanBrecknockSchool + " inches more than Brecknock School");
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int hiltTotalMoney = 10;
		int costToyTruck = 3;
		int costPencilCase = 2;
		int hiltMoneyRemaining = hiltTotalMoney - (costToyTruck + costPencilCase);
		System.out.println("Mrs. Hilt has " + hiltMoneyRemaining + " dollars remaining");
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int collectionMarbles = 16;
		int lostMarbles = 7;
		int remainingMarbles = collectionMarbles - lostMarbles;
		System.out.println("Josh has " + remainingMarbles + " marbles left");
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int desiredCollection = 25;
		int meganShells = 19;
		int shellsNeeded = desiredCollection - meganShells;
		System.out.println("Megan needs " + shellsNeeded + " more shells to have 25 shells in her collection");
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8; 
		int greenBalloons = totalBalloons - redBalloons;
		System.out.println("Brad has " + greenBalloons + " green balloons");
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialBooksOnShelf = 38;
		int booksAddedToShelf = 10;
		int sumBooksOnShelf = initialBooksOnShelf + booksAddedToShelf;
		System.out.println("Total number of books on the shelf is " + sumBooksOnShelf);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsPerBee = 6;
		int groupOfBees = 8;
		int totalLegsInGroupOfBees = legsPerBee * groupOfBees;
		System.out.println("A group of 8 bees have a total of " + totalLegsInGroupOfBees + " legs");
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costIceCreamCone = 0.99;
		double costTwoIceCreamCones = costIceCreamCone *2;
		System.out.println("Two ice cream cones cost $" + costTwoIceCreamCones);
			
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocksNeeded = 125;
		int hiltRocks = 64;
		int rocksNeededCompleteBorder = totalRocksNeeded - hiltRocks;
		System.out.println("Mrs. Hilt needs " + rocksNeededCompleteBorder + " more rocks to complete the border");
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hiltMarbles = 38;
		int marblesSheLost = 15;
		int marblesStillPresent = hiltMarbles - marblesSheLost;
		System.out.println("Mrs. Hilt has " + marblesStillPresent + " marbles left");
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMilesToConcert = 78;
		int milesDrivenWhenStoppedForGas = 32;
		int milesLeftToDriveAfterGettingGas = totalMilesToConcert - milesDrivenWhenStoppedForGas;
		System.out.println("Mrs. Hilt and her sister have " + milesLeftToDriveAfterGettingGas + " miles left to drive");
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int timeShovelingMorning = 90;
		int timeShovelingAfternoon = 45;
		int totalTimeShoveling = timeShovelingMorning + timeShovelingAfternoon;
		System.out.println("Mrs. Hilt spent " + totalTimeShoveling + " minutes shoveling snow");
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double numberHotDogsPurchased = 6.00;
		double costOfHotDog = 0.50;
		double totalCostAllHotDogs = numberHotDogsPurchased * costOfHotDog;
		System.out.println("Mrs. Hilt paid $" + totalCostAllHotDogs);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hiltMoney = 50;
		int costPencil = 7;
		int numberPencilsCanPurchaseWithHiltMoney = hiltMoney / costPencil;
		System.out.println("Mrs. Hilt can buy " + numberPencilsCanPurchaseWithHiltMoney + " pencils with the money she has");
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int butterfliesSeen = 33;
		int orangeButterflies = 20;
		int redButterflies = butterfliesSeen - orangeButterflies;
		System.out.println("There were " + redButterflies + " red butterflies");
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		int costCandy = 54;
		int moneyTendered = 100;
		int changeDueKate = moneyTendered - costCandy;
		System.out.println("Kate should get " + changeDueKate + " cents back");
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int numberTreesPresent = 13;
		int numberTreesToAdd = 12;
		int sumTrees = numberTreesPresent + numberTreesToAdd;
		System.out.println("Mark will have " + sumTrees + " trees");
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysUntilGrandma = 2;
		int hoursInADay = 24;
		int hoursUntilGrandma = daysUntilGrandma * hoursInADay;
		System.out.println("Joy will see her Grandma in " + hoursUntilGrandma + " hours");
		
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberCousins = 4;
		int piecesOfGumToEachCousin = 5;
		int numberPiecesGumNeeded = numberCousins * piecesOfGumToEachCousin;
		System.out.println("Kim will need " + numberPiecesGumNeeded + " pieces of gum");
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danMoney = 3.0;
		double costCandyBar = 1.0;
		double remainingMoneyForDan = danMoney - costCandyBar;
		System.out.println("Dan has $" + remainingMoneyForDan + " left");
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberBoatsInLake = 5;
		int numberPeopleOnEachBoat = 3;
		int numberPeopleOnBoatsOnTheLake = numberBoatsInLake * numberPeopleOnEachBoat;
		System.out.println("number of people on boats on the lake is " + numberPeopleOnBoatsOnTheLake);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenLegos = 380;
		int lostLegos = 57;
		int remainingLegos = ellenLegos - lostLegos;
		System.out.println("Ellen has " + remainingLegos + " legos remaining");
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int desiredMuffs = 83;
		int bakedMuffs = 35;
		int muffsNeeded = desiredMuffs - bakedMuffs;
		System.out.println("Arthur must bake " + muffsNeeded + " more muffins");
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int numberWillyCrayonsGreaterThanLucyCrayons = willyCrayons - lucyCrayons;
		System.out.println("Willy has " + numberWillyCrayonsGreaterThanLucyCrayons + " more crayons than Lucy");
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numberPagesStickers = 22;
		int numberStickersPerPage = 10;
		int totalStickers = numberPagesStickers * numberStickersPerPage;
		System.out.println("We have " + totalStickers + " stickers altogether");
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalKids = 8;
		int cupcakesPerKid = totalCupcakes / totalKids;
		System.out.println("Each person will get " + cupcakesPerKid + " cupcakes");
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalCookies = 47;
		int cookiesPerJar = 6;
		int cookiesNotPlacedInJars = totalCookies % cookiesPerJar;
		System.out.println(cookiesNotPlacedInJars + " cookies not placed in jars");
		
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int totalNeighbors = 8;
		int croissantsLeftWithMarian = totalCroissants % totalNeighbors;
		System.out.println("Marian will have " + croissantsLeftWithMarian + " croissants");
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int desiredCookies = 276;
		int cookiesPerTray = 12;
		int traysNeeded = desiredCookies / cookiesPerTray;
		System.out.println("Marian will need " + traysNeeded + " trays");
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int servingSize = 12;
		int totalServings = totalPretzels / servingSize;
		System.out.println(totalServings + " pretzels");
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int allCupcakes = 53;
		int cupcakesLeftHome = 2;
		int cupcakesPerBox = 3;
		int boxesGivenAway = (allCupcakes - cupcakesLeftHome) / cupcakesPerBox;
		System.out.println(boxesGivenAway + " boxes");
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int totalCarrots = 74;
		int totalCarrotEaters = 12;
		int uneatenCarrots = totalCarrots % totalCarrotEaters;
		System.out.println(uneatenCarrots + " sticks");
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddies = 98;
		int maxBearsPerShelf = 7;
		int numberShelvesNeeded = totalTeddies / maxBearsPerShelf;
		System.out.println(numberShelvesNeeded + " shelves");
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPics = 480;
		int picsPerAlbum = 20;
		int albumsNeeded = totalPics / picsPerAlbum;
		System.out.println(albumsNeeded + " albums");
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalTradingCards = 94;
		int maxCardsPerBox = 8;
		int numberFullBoxes = totalTradingCards / maxCardsPerBox;
		int numberCardsUnfilledBox = totalTradingCards % maxCardsPerBox;
		System.out.println(numberFullBoxes + " boxes, " + numberCardsUnfilledBox + " cards");
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooks = 210;
		int totalShelves = 10;
		int booksPerShelf = totalBooks / totalShelves;
		System.out.println(booksPerShelf + " books");
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int bakedCroissants = 17;
		int numberOfGuests = 7;
		int croissantsPerGuest = bakedCroissants / numberOfGuests;
		System.out.println(croissantsPerGuest + " croissants");
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		double roomSize = 12 * 14;
		double billPaintTime = 2.15;
		double jillPaintTime = 1.90;
		double billSquareFeetPaintedPerHour = roomSize / billPaintTime;
		double jillSquareFeetPaintedPerHour = roomSize / jillPaintTime;
		double combinedPaintersHourlyRate = billSquareFeetPaintedPerHour + jillSquareFeetPaintedPerHour;
		double timeToPaint5RoomSize = (roomSize * 5.0) / combinedPaintersHourlyRate;
		System.out.println(timeToPaint5RoomSize + " hours");
		double workHoursPerDay = 8;
		double daysToPaint623RoomSize = ((roomSize * 623) / combinedPaintersHourlyRate) / workHoursPerDay;
		System.out.println(daysToPaint623RoomSize + " days");
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String lastName = "Southwood, ";
		String firstName = "Adam ";
		String middleInitial = "J.";
		String fullName = lastName + firstName + middleInitial;
		System.out.println(fullName);
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		double totalDistance = 800;
		double distanceAlreadyTravelled = 537;
		double percentCompleted = (distanceAlreadyTravelled / totalDistance) * 100;
		System.out.println(percentCompleted + "%");
		int integerVal = (int) percentCompleted;
		System.out.println(integerVal + "%");
			

	}

}
