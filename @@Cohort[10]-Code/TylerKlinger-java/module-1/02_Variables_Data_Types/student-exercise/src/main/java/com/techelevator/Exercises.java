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
		System.out.println("The remaining number of birds is: " + remainingNumberOfBirds);
		

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
		int numberOfRaccoonsEating = 2;
		int numberOfRaccoonsPlaying = numberOfRaccoons - numberOfRaccoonsEating;

		System.out.println("The number of raccoons left is " + numberOfRaccoonsPlaying);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int moreFlowers = numberOfFlowers - numberOfBees;
		
		System.out.println("There are " + moreFlowers + " more flowers than bees.");

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int pigeon1 = 1;
		int pigeon2 = 1;
		int totalPigeons = pigeon1 + pigeon2;
		
		System.out.println("The number of pigeons is " + totalPigeons);

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int owlsSitting = 3; 
		int owlsJoining = 2;
		int owlsOnFence = owlsSitting + owlsJoining;
		
		System.out.println("The number of owls is " + owlsOnFence );

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int beavers = 2;
		int beaversSwimming = 1;
		int beaversWorking = beavers - beaversSwimming;
		
		System.out.println("The number of beavers working is " + beaversWorking );

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		
		int toucans = 2;
		int toucansJoining = 1;
		int totalToucans = toucans - toucansJoining;
		
		System.out.println("The number of toucans is " + totalToucans);

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int squirrels = 4;
		int nuts = 2;
		int moreSquirrels = squirrels - nuts;
		
		System.out.println("The number of squirrels is " + moreSquirrels);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		
		int dime = 10;
		int nickels = 5;
		int quarter = 25;
		int moneyFound = dime + quarter + (nickels * 2);
		
		System.out.println("The amount of money found is " + moneyFound + " cents");
        
		/*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int mrsBrier = 18;
		int mrsMacAdam = 20;
		int mrsFlannery = 17; 
		int muffinsBaked = mrsBrier + mrsMacAdam + mrsFlannery;
		
		System.out.println("The number of muffins baked is " + muffinsBaked );

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		int yoyoCost = 24;
		int whistleCost = 14;
		int twoToysCost = yoyoCost + whistleCost;
		
		System.out.println("The total cost is " + twoToysCost + " cents");

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;
		
		System.out.println("The number of marshmallows is " + totalMarshmallows);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int mrsHiltSnow = 29;
		int brecknockSnow = 17;
		int moreSnow = mrsHiltSnow - brecknockSnow;
		
		System.out.println("Mrs. Hilt had " + moreSnow + " more inches" );

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int mrsHiltMoney = 10;
		int moneyOnTruck = 3;
		int moneyOnCase = 2;
		int moneyLeft = mrsHiltMoney - moneyOnTruck - moneyOnCase;
		
		System.out.println("The amount of money left is " + moneyLeft + " dollars" );

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int marblesCollection = 16;
		int marblesLost = 7;
		int marblesLeft = marblesCollection - marblesLost;
		
		System.out.println("The number of marbles left is " + marblesLeft );

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int seashells = 19;
		int seashellsDesired = 25;
		int seashellsNeeded = seashellsDesired - seashells;
		
		System.out.println("The number of seashells needed is " + seashellsNeeded );

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int balloons = 17;
		int redBalloons = 8;
		int greenBalloons = balloons - redBalloons;
		
		System.out.println("The number of green balloons is " + greenBalloons );
	

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int books = 38;
		int booksAdded = 10;
		int booksOnShelf = books + booksAdded; 
		
		System.out.println("The number of books is " + booksOnShelf );

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int beeLegs = 6;
		int bees = 8;
		int totalBeeLegs = beeLegs * bees;
		
		System.out.println("The number of total legs is " + totalBeeLegs );

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		int coneCost = 99;
		int numberOfCones = 2;
		int totalConeCost = coneCost * numberOfCones;
		
		System.out.println("The cost of cones is " + totalConeCost + " cents" );

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int rocks = 64;
		int rocksDesired = 125;
		int rocksNeeded = rocksDesired - rocks;
		
		System.out.println("The number of rocks needed is " + rocksNeeded );

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		
		int marbles = 38;
		int marblesGone = 15;
		int marblesRemaining = marbles - marblesGone;
		
		System.out.println("The number of marbles is " + marblesRemaining );

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int milesDriven = 32;
		int milesAway = 78;
		int milesLeft = milesAway - milesDriven;
		
		System.out.println("The number of miles left is " + milesLeft );

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		
		int minutesInMorning = 90;
		int minutesInAfternoon = 45;
		int totalTimeSpent = minutesInMorning + minutesInAfternoon;
		
		System.out.println("The total time spent is " + totalTimeSpent + " minutes" );

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		int hotDogs = 6;
		int hotDogCost = 50;
		int totalSpentOnHotDogs = hotDogs * hotDogCost;
		
		System.out.println("The total cost of hot dogs is " + totalSpentOnHotDogs + " cents" );

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		int centsOwned = 50;
		int pencilCost = 7;
		int pencilsCanBuy = centsOwned /pencilCost;
		
		System.out.println("The number of pencils she can buy is " + pencilsCanBuy );

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int butterflies = 33; 
		int orangeButterflies = 20;
		int redButterflies = butterflies - orangeButterflies;
		
		System.out.println("The number of red butterflies is " + redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		int kateMoney = 100;
		int candyCost = 54;
		int changeReturned = kateMoney - candyCost;
		
		System.out.println("The amount of change returned is " + changeReturned + " cents" );

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int treesInYard = 13;
		int treesToPlant = 12;
		int totalTrees = treesInYard + treesToPlant;
		
		System.out.println("The number of trees is " + totalTrees );

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int hoursInDay = 24;
		int daysUntilSeeGrandma = 2;
		int hoursUntilSeeGrandma = hoursInDay * daysUntilSeeGrandma;
		
		System.out.println("The number of hours is " + hoursUntilSeeGrandma );

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int cousins = 4;
		int gum = 5;
		int gumNeeded = cousins * gum;
		
		System.out.println("The amount of gum needed is " + gumNeeded + " pieces" );

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		int danMoney = 300;
		int candyBarCost = 100;
		int danMoneyLeft = danMoney - candyBarCost;
		
		System.out.println("The amount of money left is " + danMoneyLeft + " cents" );

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int boats = 5;
		int people = 3;
		int peopleOnBoats = boats * people;
		
		System.out.println("The number of people is " + peopleOnBoats);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		
		int legos = 380;
		int legosLost = 57;
		int legosLeft = legos - legosLost;
	
		System.out.println("The number of legos left is " + legosLeft );

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int muffins = 35;
		int muffinsDesired = 83;
		int muffinsToBake = muffinsDesired - muffins;
		
		System.out.println("The number of muffins to bake is " + muffinsToBake );

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int moreCrayons = willyCrayons - lucyCrayons;
		
		System.out.println("The difference in crayons is " + moreCrayons );

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int stickers = 10;
		int pages = 22;
		int stickersOnPages = stickers * pages;
		
		System.out.println("The number of stickers on pages is " + stickersOnPages );

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int cupcakes = 96;
		int children = 8;
		int cupcakesForEach = cupcakes /children;
		
		System.out.println("The number of cupcakes for each is " + cupcakesForEach );

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		
		int cookies = 47;
		int cookiesInJar = 6;
		int cookiesNotInJar = cookies % cookiesInJar;
		
		System.out.println("The number of cookies not in jars is " + cookiesNotInJar );

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int croissants = 59;
		int neighbors = 8;
		int croissantsLeft = croissants % neighbors;
		
		System.out.println("The number of croissants left is " + croissantsLeft );

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int oatmealCookies = 276;
		int cookiesOnTrays = 12;
		int trays = oatmealCookies /cookiesOnTrays;
		
		System.out.println("The number of trays needed is " + trays );

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int pretzels = 480;
		int serving = 12;
		int servingsPrepared = pretzels /serving;
		
		System.out.println("The number of servings prepared is " + servingsPrepared );

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int lemonCupcakes = 53;
		int cupcakesRemaining = 2;
		int cupcakesInBox = 3;
		int cupcakesGiven = (lemonCupcakes - cupcakesRemaining) /cupcakesInBox;
		
		System.out.println("The number of boxes given away is " + cupcakesGiven );

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int carrotSticks = 74;
		int peopleServed = 12;
		int carrotSticksLeft = carrotSticks % peopleServed;
		
		System.out.println("The number of carrot sticks uneaten is " + carrotSticksLeft );

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int teddyBears = 98;
		int bearsOnShelves = 7;
		int shelvesFilled = teddyBears /bearsOnShelves;
		
		System.out.println("The number of shelves filled is " + shelvesFilled );

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int pictures = 480;
		int picturesInAlbum = 20;
		int albumsNeeded = pictures /picturesInAlbum;
		
		System.out.println("The number of albums needed is " + albumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int tradingCards = 94;
		int cardsInBox = 8;
		int unfilledBox = tradingCards % cardsInBox;
		int boxesFilled = (tradingCards - unfilledBox) /cardsInBox;
				
				System.out.println("The number of boxes filled is " + boxesFilled + " and the unfilled box contains " + unfilledBox + " cards" );

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
				
				int susieBooks = 210;
				int shelves = 10;
				int booksOnShelves = susieBooks /shelves;
				
				System.out.println("The number of books on each shelf is " + booksOnShelves );

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
				
				int croissantsMade = 17;
				int guests = 7;
				int croissantsLeftover = croissantsMade % guests;
				int croissantsForEach = (croissantsMade - croissantsLeftover) /guests;
				
				System.out.println("The number of croissants for each is " + croissantsForEach + ", leaving " + croissantsLeftover + " leftover" );

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
				
				int hourlyRateBill = 135;
				int hourlyRateJill = 114;
				int combinedRates = hourlyRateBill + hourlyRateJill; //249
				int feetLength = 12;
				int feetWidth = 14;
				int totalFeet = feetLength * feetWidth;
				int rooms = 5;
				int timeToPaint = (rooms * totalFeet) /combinedRates;
				
				System.out.println("The amount of time is " + timeToPaint + " hours" );
				
				int rooms2 = 623;
				int hoursPerDay = 24;
				int hoursWorked = hoursPerDay /3;
				int roomsPerDay = hoursWorked * timeToPaint;
				int totalTime = rooms2 /roomsPerDay;
				
				System.out.println("The number of days to complete is " + totalTime );

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
