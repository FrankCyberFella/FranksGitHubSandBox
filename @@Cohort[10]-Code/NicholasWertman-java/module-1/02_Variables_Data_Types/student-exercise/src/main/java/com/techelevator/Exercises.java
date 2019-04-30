package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		int birdsInBranch = 4;
		int birdsThatFlyAway = 1;
		int birdsLeftOnBranch = birdsInBranch - birdsThatFlyAway;
		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

		

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		
		int totalBirds = 6;
		int totalNests = 3;
		int birdsLeftWithoutNest = totalBirds - totalNests;
		
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int raccoonsInWoods = 3;
		int raccoonsAtDinner = 2;
		int raccoonsLeftInWoods = raccoonsInWoods - raccoonsAtDinner;
		
		System.out.println("raccoonsLeftInWoods is " + raccoonsLeftInWoods);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int flowers = 5;
		int bees = 3;
		int extraFlowers = flowers - bees;
		
		System.out.println("extraFlowers is " + extraFlowers);
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int pigeonEatingCrumbs = 1;
		int pigeonThatJoins = 1;
		int totalPigeons = pigeonEatingCrumbs + pigeonThatJoins;
		
		System.out.println("totalPigeons is " + totalPigeons);
		
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int owlsOnFence = 3;
		int owlsThatJoin = 2;
		int totalOwls = owlsOnFence + owlsThatJoin;
		
		System.out.println("totalOwls is " + totalOwls);
		
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int stillWorkingBeavers = workingBeavers - swimmingBeavers;
		
		System.out.println("stillWorkingBeavers is " + stillWorkingBeavers);
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansInTree = 2;
		int toucansThatJoin = 1;
		int totalToucans = toucansInTree + toucansThatJoin;
		
		System.out.println("totalToucans is " + totalToucans);
		
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrels = 4;
		int nuts = 2;
		int extraSquirrels = squirrels - nuts;
		
		System.out.println("extraSquirrels is " + extraSquirrels);
		
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double moneyFound = quarter + dime + nickel + nickel;
		
		System.out.println("moneyFound is " + moneyFound);
		
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int mrsBriersClass = 18;
		int mrsMacAdamsClass = 20;
		int mrsFlannerysClass = 17;
		int totalMuffinsMade = mrsBriersClass + mrsMacAdamsClass + mrsFlannerysClass;
		
		System.out.println("totalMuffinsMade is " + totalMuffinsMade);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyo = 0.24;
		double whistle = 0.14;
		double totalMoneySpent = yoyo + whistle;
		
		System.out.println("totalMoneySpent is " + totalMoneySpent);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int riceKrispieTreats = 5;
		int largeMarshmellows = 8;
		int miniMarshmellows = 10;
		int totalMarshmellows = largeMarshmellows + miniMarshmellows;
		
		System.out.println("totalMarshmellows is " + totalMarshmellows);
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
	
		int snowAtHiltsHouse = 29;
		int snowAtBrecknock = 17;
		int additionalSnowAtHiltsHouse = snowAtHiltsHouse - snowAtBrecknock;
		
		System.out.println("additionalSnowAtHiltsHouse is " + additionalSnowAtHiltsHouse);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		double mrsHiltsMoney = 10.00;
		double toyTruck = 3.00;
		double pencil = 2.00;
		double moneyLeft = mrsHiltsMoney - toyTruck - pencil;
		
		System.out.println("moneyLeft is " + moneyLeft);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int marbleCollection = 16;
		int marblesLost = 7;
		int marblesLeft = marbleCollection - marblesLost;
		
		System.out.println("marblesLeft is " + marblesLeft);
		
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int megansSeashells = 19;
		int seashellsWanted = 25;
		int seashellsNeeded = seashellsWanted - megansSeashells;
		
		System.out.println("seashells needed is " + seashellsNeeded);
		
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int bradsBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = bradsBalloons - redBalloons;
		
		System.out.println("greenballoons is " + greenBalloons);
		
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksOnShelf = 38;
		int addedBooks = 10;
		int totalBooks = booksOnShelf + addedBooks;
		
		System.out.println("totalBooks is " + totalBooks);
		
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int legs = 6;
		int totalBees = 8;
		int totalLegs = legs * totalBees;
		
		System.out.println("totalLegs is " + totalLegs);
		
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double iceCream = 0.99;
		int totalCones = 2;
		double totalCost = iceCream * totalCones;
		
		System.out.println("totalCost is " + totalCost);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int rocksDesired = 125;
		int rocksMrsHiltHas = 64;
		int rocksNeeded = rocksDesired - rocksMrsHiltHas;
		
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int mrsHiltMarbles = 38;
		int marblesSheLost = 15;
		int marblesSheHasLeft = mrsHiltMarbles - marblesSheLost;
		
		System.out.println("marblesSheHasLeft is " + marblesSheHasLeft);
		
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int mrsHiltTrip = 78;
		int mrsHiltFirstStop = 32;
		int milesLeft = mrsHiltTrip - mrsHiltFirstStop;
		
		System.out.println("milesLeft is " + milesLeft);
		
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int saturdayMorningShovel = 90;
		int saturdayAfternoonShovel = 45;
		int totalShovelTime = saturdayMorningShovel + saturdayAfternoonShovel;
		
		System.out.println("totalShovelTime is " + totalShovelTime);
		
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int hotDogs = 6;
		double hotDogPrice = 0.50;
		double totalHotDogSum = hotDogs * hotDogPrice;
		
		System.out.println("totalHotDogSum is " + totalHotDogSum);	
		
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		double mrsHiltStartingMoney = 0.50;
		double costOfPencil = 0.07;
		double pencilsSheCanBuy = mrsHiltStartingMoney / costOfPencil;
		
		System.out.println("pencilsSheCanBuy is " + pencilsSheCanBuy);
		
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		
		System.out.println("redButterflies is " + redButterflies);
		
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double moneyGiven = 1.00;
		double candyCost = 0.54;
		double changeBack = moneyGiven - candyCost;
		
		System.out.println("changeBack is " + changeBack);
		
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int treesBeforePlanting = 13;
		int treesHePlants = 12;
		int treesInBackyard = treesBeforePlanting + treesHePlants;
		
		System.out.println("treesInBackyard is " + treesInBackyard);
		
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int hoursInDay = 24;
		int joySeesGrandma = hoursInDay + hoursInDay;
		
		System.out.println("joySeesGrandma in " + joySeesGrandma);
		
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int kimsCousins = 4;
		int gumPerKid = 5;
		int gumNeeded = kimsCousins * gumPerKid;
		
		System.out.println("gumNeeded is " + gumNeeded);
		
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double danStartingMoney = 3.00;
		double candyBar = 1.00;
		double dansRemainingMoney = danStartingMoney - candyBar;
		
		System.out.println("dansRemainingMoney is " + dansRemainingMoney);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsOnLake = 5;
		int peopleOnBoats = 3;
		int sumPeopleOnLake = boatsOnLake * peopleOnBoats;
		
		System.out.println("sumPeopleOnLake is " + sumPeopleOnLake);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int ellensLegos = 380;
		int lostLegos = 57;
		int ellensRemainingLegos = ellensLegos - lostLegos;
		
		System.out.println("ellensRemainingLegos is " + ellensRemainingLegos);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int bakedMuffins = 35;
		int desiredMuffins = 83;
		int muffinsLeftToBake = desiredMuffins - bakedMuffins;
		
		System.out.println("muffinsLeftToBake is " + muffinsLeftToBake);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willysCrayons = 1400;
		int lucysCrayons = 290;
		int willysExtraCrayons = willysCrayons - lucysCrayons;
		
		System.out.println("willysExtraCrayons is " + willysExtraCrayons);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersOnPage = 10;
		int pagesOfStickers = 22;
		int totalStickers = stickersOnPage * pagesOfStickers;
		
		System.out.println("totalStickers is " + totalStickers);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int totalCupcakes = 96;
		int totalChildren = 8;
		int cupcakesPerChild = totalCupcakes / totalChildren;
		
		System.out.println("cupcakesPerChild is " + cupcakesPerChild);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int cookiesMade = 47;
		int glassJars = 6;
		int cookiesLeftover = cookiesMade % glassJars;
		
		System.out.println("cookiesLeftover is " + cookiesLeftover);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int croissants = 59;
		int neighbors = 8;
		int leftoverCroissants = croissants % neighbors;
		
		System.out.println("leftoverCroissants is " + leftoverCroissants);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int desiredCookies = 276;
		int cookiesPerTray = 12;
		int traysNeeded = desiredCookies / cookiesPerTray;
		
		System.out.println("traysNeeded is " + traysNeeded);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int biteSizedPretzels = 480;
		int oneServing = 12;
		int totalServings = biteSizedPretzels / oneServing;
		
		System.out.println("totalServings is " + totalServings);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakes = 53;
		int cupcakesLeftAtHome = 2;
		int cupcakesInBox = 3;
		int boxesGivenAway = (lemonCupcakes - cupcakesLeftAtHome) / cupcakesInBox;
		
		System.out.println("boxesGivenAway is " + boxesGivenAway);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int breakfastCarrots = 74;
		int peopleEatingCarrots = 12;
		int carrotSticksLeft = breakfastCarrots % peopleEatingCarrots;
		
		System.out.println("carrotSticksLeft is " + carrotSticksLeft);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalBears = 98;
		int bearsPerShelf = 7;
		int filledShelves = totalBears / bearsPerShelf;
		
		System.out.println("filledShelves is " + filledShelves);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int picturesInAlbum = 20;
		int totalPictures = 480;
		int albumsNeeded = totalPictures / picturesInAlbum;
		
		System.out.println("albumsNeeded is " + albumsNeeded);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int tradingCards = 94;
		int cardsPerBox = 8;
		int filledBoxes = tradingCards / cardsPerBox;
		int unfilledBox = tradingCards % cardsPerBox;
		
		System.out.println("filledBoxes is " + filledBoxes);
		System.out.println("unfilledBox is " + unfilledBox);
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int booksInTotal = 210;
		int totalShelves = 10;
		int booksPerShelf = booksInTotal / totalShelves;
		
		System.out.println("booksPerShelf is " + booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		int bakedCroissants = 17;
		int totalGuests = 7;
		int croissantsPerGuest = bakedCroissants / totalGuests;
		
		
		System.out.println("croissantsPerGuest is " + croissantsPerGuest);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

		
		
		
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
