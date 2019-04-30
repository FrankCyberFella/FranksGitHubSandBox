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
		
		int numberInWoods = 3;
		int numberWhoGoHome = 2;
		int numberOfRemainingRaccoons = numberInWoods - numberWhoGoHome;
		

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int remainingBees = numberOfFlowers - numberOfBees;

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int lonelyPigeons = 1;
		int newPigeons = 1;
		int feastingPigeons = lonelyPigeons + newPigeons;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int fenceOwls = 3;
		int newOwls = 2;
		int sittingOwls = fenceOwls + newOwls;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int remainingBeavers = workingBeavers - swimmingBeavers;
		
		System.out.println("The number of remaining beavers is " + remainingBeavers);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		
		int sittingToucans = 2;
		int newToucans = 1;
		int frootLoopMascots = sittingToucans + newToucans;
		
		System.out.println("The number of total Froot Loops mascots is " + frootLoopMascots);
		

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int moreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts; 

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		
		double valueOfQuarter = .25;
		double valueOfDime = .10;
		double valueOfTwoNickles = .10;
		double mrsHiltsMoney = valueOfQuarter + valueOfDime + valueOfTwoNickles;
		
		System.out.println("Mrs. Hilts money totals " + mrsHiltsMoney);
		

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int briersMuffins = 18;
		int macadamsMuffins = 20;
		int flannerysMuffins = 17;
		int totalMuffins = briersMuffins + macadamsMuffins + flannerysMuffins;
		
		System.out.println("The total number of muffins is " + totalMuffins);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		double yoyoCost = .24;
		double whistleCost = .14;
		double totalCost = yoyoCost + whistleCost;
		
		System.out.println("Mrs. Hilt wasted " + totalCost);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int hiltSnow = 29;
		int brecknockSnow = 17;
		int moreSnowTotal = hiltSnow - brecknockSnow;
		

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int hiltMoney = 10;
		int truckCost = 3;
		int caseCost = 2;
		int moneyLeft = hiltMoney - truckCost - caseCost;

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int startingMarbles = 16;
		int lostMarbles = 7;
		int remainingMarbles = startingMarbles - lostMarbles;

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int startingSeashells = 19;
		int desiredSeashells = 25;
		int totalSeashells = desiredSeashells - startingSeashells;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		
		System.out.println("The number of green balloons is " + greenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int booksOnShelf = 38;
		int addedBooks = 10;
		int totalBooks = booksOnShelf + addedBooks;

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int beeLegs = 6;
		int hiveOfBees = 8;
		int totalLegs = beeLegs * hiveOfBees;
		
		System.out.println("The number of bee legs is " + totalLegs);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		double iceCreamCone = .99;
		double twoIceCreamCones = 2;
		double costOfTwoCones = iceCreamCone * twoIceCreamCones;
		
		System.out.println("The cost of two cones is " + costOfTwoCones);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int currentRocks = 64;
		int totalRocks = 125;
		int neededRocks = totalRocks - currentRocks;

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		
		int hiltsMarbles = 38;
		int goneMarbles = 15;
		int leftOverMarbles = hiltsMarbles - goneMarbles;
		
		System.out.println("The number of left over marbles is " + leftOverMarbles);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int milesDriven = 32;
		int actualMiles = 78;
		int remainingMiles = actualMiles - milesDriven;

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		
		int minutesShovelingSaturday = 90;
		int minutesShovelingSunday = 45;
		int totalMinutesShoveling = minutesShovelingSaturday + minutesShovelingSunday;

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		double hotDogCost = .50;
		int numberOfHotDogs = 6;
		double hiltsCost = hotDogCost * numberOfHotDogs; // numberOfHotDogs could also be written as a double
		
		System.out.println("Mrs Hilt spent a total of " + hiltsCost);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		
		double pencilMoney = .50;
		double pencilCost = .07;
		double totalPencils = pencilMoney / pencilCost;
		
		System.out.println("She can buy " + totalPencils);
		

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		double outOf = 1.00;
		double candyCost = .54;
		double katesChange = outOf - candyCost;
		
		System.out.println("Kate will get back " + katesChange);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int currentTrees = 13;
		int newTrees = 12;
		int totalTrees = currentTrees + newTrees;

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int hoursInADay = 24;
		int numberOfDays = 2;
		int totalHours = hoursInADay * numberOfDays;

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int numberOfCousins = 4;
		int piecesOfGum = 5;
		int totalGum = numberOfCousins * piecesOfGum;

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		double danMoney = 3.00;
		double candyBar = 1.00;
		double remainingCash = danMoney - candyBar;
		
		System.out.println("Dan has this much left: " + remainingCash);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int numberOfBoats = 5;
		int peopleOnBoats = 3;
		int totalPeople = numberOfBoats * peopleOnBoats;

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		
		int totalLegos = 380;
		int lostLegos = 57; // can also be called "painful feet"
		int remainingLegos = totalLegos - lostLegos;

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int bakedMuffins = 35;
		int desiredMuffins = 83;
		int requiredMuffins = desiredMuffins - bakedMuffins;
	

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willysCrayons = 1400;
		int lucysCrayons = 290;
		int moreCrayons = willysCrayons - lucysCrayons;

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int stickersPerPage = 10;
		int numberOfPages = 22;
		int totalStickers = stickersPerPage * numberOfPages;

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int totalCupcakes = 96;
		int childrenForCakes = 8;
		int cakesPerChild = totalCupcakes / childrenForCakes;
		
		System.out.println("Each child gets " + cakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		
		int totalCookies = 47;
		int cookiesPerJar = 6;
		int leftCookies = totalCookies % cookiesPerJar;
		
		System.out.println("This many cookies: " + leftCookies);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int totalCroissants = 59;
		int totalNeighbors = 8;
		int remainingCroissants = totalCroissants % totalNeighbors;
		
		System.out.println("Marian will be left with " + remainingCroissants);
		
		

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int cookiesPerTray = 12;
		int amountOfCookies = 276;
		int traysRequired = amountOfCookies / cookiesPerTray;
		
		System.out.println("She will need this many trays: " + traysRequired);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int oneServing = 12;
		int totalPretzels = 480;
		int ableToPrepare = totalPretzels / oneServing;

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int cupcakesForChildren = 51;
		int cupcakesPerChild = 3;
		int boxesGiven = cupcakesForChildren / cupcakesPerChild;
		
		System.out.println("She gave away " + boxesGiven);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int carrotSticks = 74;
		int carrotEaters = 12;
		int remainingSticks = carrotSticks % carrotEaters;
		
		System.out.println("This many sticks remain: " + remainingSticks);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int totalBears = 98;
		int bearsPerShelf = 7;
		int shelvesFilled = totalBears / bearsPerShelf;
		
		System.out.println(shelvesFilled + " shelves filled");

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int totalPictures = 480;
		int picsPerAlbum = 20;
		int albumsRequired = totalPictures / picsPerAlbum;

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int tradingCards = 94;
		int fullBox = 8;
		int filledBoxes = tradingCards / fullBox;
		int unfilledBox = tradingCards % fullBox;
		
		System.out.println("This many boxes filled: " + filledBoxes);
		System.out.println("Unfilled box contains " + unfilledBox + " cards");

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		
		int numOfBooks = 210;
		int numOfShelves = 10;
		int booksPerShelf = numOfBooks / numOfShelves;

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		int bakedCroissants = 17;
		int numOfGuests = 7;
		int croissantsPerGuest = bakedCroissants / numOfGuests;
		
		System.out.println("Each guest will get " + croissantsPerGuest + " croissants");

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		double billHours = 2.15;
		double jillHours = 1.90;
		double roomSizeTotal = 12.0 * 14.0;
		double billSpeed = roomSizeTotal / billHours;
		double jillSpeed = roomSizeTotal / jillHours;
		double numOfRooms = 5.0;
		double totalSpeed = billSpeed + jillSpeed;
		double finalTime = totalSpeed * numOfRooms;
		
		System.out.println("It will take them this long to paint 5 rooms: " + finalTime);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		
		String firstName = "Jacob ";
		String middleInitial = "L.";
		String lastName = "Searle, ";
		
		
		
		

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		
		double traveledMiles = 537;
		double totalMiles = 800;
		double totalComplete = traveledMiles / totalMiles;
		double completePercentage = totalComplete * 100;
		
		System.out.println("This is the completed percentage: " + completePercentage);
		
		


	}

}
