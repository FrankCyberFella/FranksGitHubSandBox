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
		int numberOfRacoonsPlaying = 3;
		int numberOfRacoonsLeaving = 2;
		int numberOfRacoonsLeft = numberOfRacoonsPlaying - numberOfRacoonsLeaving;
		
		System.out.println(numberOfRacoonsLeft + " raccoons left");
		
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int differenceBetweenBeesAndFlowers = numberOfFlowers - numberOfBees;
				
		System.out.println(differenceBetweenBeesAndFlowers + " less bees than flowers");
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfLonelyPigeons = 1;
		int numberOfHungryPigeons = 1;
		int totalNumberOfPigeons = numberOfLonelyPigeons + numberOfHungryPigeons;
		
		System.out.println(totalNumberOfPigeons + " pigeons are eating breadcrumbs");
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwlsSitting = 3;
		int numberOfOwlsJoining = 2;
		int totalNumberOfOwls = numberOfOwlsSitting + numberOfOwlsJoining;
		
		System.out.println(totalNumberOfOwls + " owls are sitting on the fence");
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int numberOfBeavers = 2;
		numberOfBeavers -= 1;
		
		System.out.println(numberOfBeavers + " beavers are still working on their home");
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numberOfToucans = 2;
		numberOfToucans += 1;
		
		System.out.println(numberOfToucans + " toucans sitting on a tree limb");
		
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int moreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts;
		
		System.out.println(moreSquirrelsThanNuts + " more squirrels than nuts");
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int quarterAmount = 25;
		int dimeAmount = 10;
		int nickelAmount = 5;
		int totalAmountOfMoneyFound = quarterAmount + dimeAmount + (nickelAmount * 2);
		
		System.out.println(totalAmountOfMoneyFound + " cents");
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int briersMuffinsBaked = 18;
		int mcadamsMuffinsBaked = 20;
		int flannerysMuffinsBaked = 17;
		int totalMuffinsBaked = briersMuffinsBaked + mcadamsMuffinsBaked + flannerysMuffinsBaked;
		
		System.out.println(totalMuffinsBaked + " muffins in all");
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int costOfYoyo = 24;
		int costOfWhistle = 14;
		int totalAmountSpentOnToys = costOfYoyo + costOfWhistle;
		
		System.out.println(totalAmountSpentOnToys + " cents");
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int amountOfKrispieTreats = 5; 
		int amountOfLargeMarshmallows = 8;
		int amountOfMiniMarshmallows = 10;
		int totalAmountOfMarshmallows = amountOfLargeMarshmallows + amountOfMiniMarshmallows;
		
		System.out.println(totalAmountOfMarshmallows + " marshmallows");
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int houseInchesOfSnow = 29;
		int schoolInchesOfSnow = 17;
		int moreSnowAtHiltsHouse = houseInchesOfSnow - schoolInchesOfSnow;
		
		System.out.println(moreSnowAtHiltsHouse + " inches");
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int hiltsStartingMoney = 10;
		int costOfToyTruck = 3;
		int costOfPencilCase = 2;
		int hiltsMoneyAfterPurchase = hiltsStartingMoney - (costOfToyTruck + costOfPencilCase);
		
		System.out.println(hiltsMoneyAfterPurchase + " dollars");
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshStartingMarblesAmount = 16;
		int joshAmountOfMarblesLost = 7;
		int joshEndingMarblesAmount = joshStartingMarblesAmount - joshAmountOfMarblesLost;
		
		System.out.println(joshEndingMarblesAmount + " marbles");
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashellAmountWanted = 25;
		seashellAmountWanted -= 19;
		
		System.out.println(seashellAmountWanted + " seashells");
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalAmountOfBalloons = 17;
		int amountOfRedBalloons = 8;
		int amountOfGreenBalloons = totalAmountOfBalloons - amountOfRedBalloons;
		
		System.out.println(amountOfGreenBalloons + " balloons");
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int amountOfBooksStartingOnShelf = 38;
		int amountOfBooksPlacedOnShelf = 10;
		int totalNumberOfBooksOnShelf = amountOfBooksStartingOnShelf + amountOfBooksPlacedOnShelf;
		
		System.out.println(totalNumberOfBooksOnShelf + " books");
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfBeeLegs = 6;
		numberOfBeeLegs *= 8;
		
		System.out.println(numberOfBeeLegs + " legs");
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfIceCream = 0.99;
		costOfIceCream *= 2.0;
		
		System.out.println(costOfIceCream);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int amountOfRocksGoal = 125;
		int amountOfRocksCurrentlyHas = 64;
		int amountOfRocksNeeded = amountOfRocksGoal - amountOfRocksCurrentlyHas;
		
		System.out.println(amountOfRocksNeeded + " rocks needed");
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int startingAmountOfMarbles = 38;
		int amountOfMarblesLost = 15;
		int amountOfMarblesLeft = startingAmountOfMarbles - amountOfMarblesLost;
		
		System.out.println(amountOfMarblesLeft + " marbles left");
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesDrivenToGas = 32;
		int milesToConcert = 78;
		int milesLeftToDrive = milesToConcert - milesDrivenToGas;
		
		System.out.println(milesLeftToDrive + " miles left to drive");
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int hoursSaturdayMorning = 90;
		int hoursSaturdayAfternoon = 45;
		int totalTimeShoveling = hoursSaturdayMorning + hoursSaturdayAfternoon;
		
		System.out.println(totalTimeShoveling + " minutes");
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double costOfHotdog = 0.50;
		costOfHotdog *= 6.0;
		
		System.out.println(costOfHotdog + " dolalrs");
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int amountOfHiltsMoney = 50;
		int costOfPencil = 7;
		int pencilsCanPurchase = amountOfHiltsMoney / costOfPencil;
		
		System.out.println(pencilsCanPurchase + " pencils");
		
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfliesSeen = 33;
		int totalOrangeButterflies = 20;
		int totalRedButterflies = totalButterfliesSeen - totalOrangeButterflies;
		
		System.out.println(totalRedButterflies + " butterflies were red");
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		int kateStartingMoney = 100;
		int costOfCandy = 54;
		int changeToKate = kateStartingMoney - costOfCandy;
		
		System.out.println(changeToKate + " cents");
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int amountOfTrees = 13;
		amountOfTrees += 12;
		
		System.out.println(amountOfTrees + " trees");
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInADay = 24;
		int daysTillGrandma = 2;
		int hoursTillGrandma = hoursInADay * daysTillGrandma;
		
		System.out.println(hoursTillGrandma + " hours");
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousins = 4;
		int piecesOfGum = 5;
		int totalGumNeeded = numberOfCousins * piecesOfGum;
		
		System.out.println(totalGumNeeded + " pieces of gum needed");
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danStartingMoney = 3.00;
		double amountOfCandyBar = 1.00;
		double danEndingMoney = danStartingMoney - amountOfCandyBar;
		
		System.out.println(danEndingMoney + " dollars");
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoats = 5;
		int peoplePerBoat = 3;
		int totalNumberOfPeople = numberOfBoats * peoplePerBoat;
		
		System.out.println(totalNumberOfPeople + " people");
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int startingLegoAmount = 380;
		int legosLost = 57;
		int legosLeft = startingLegoAmount - legosLost;
		
		System.out.println(legosLeft + " legos left");
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int currentMuffinsBaked = 35;
		int muffinsBakedGoal = 83;
		int muffinsStillNeeded = muffinsBakedGoal - currentMuffinsBaked;
		
		System.out.println(muffinsStillNeeded + " muffins still needed to bake");
		/*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayonAmount = 1400;
		int lucyCrayonAmount = 290;
		int willysAmountMore = willyCrayonAmount - lucyCrayonAmount;
		
		System.out.println("Will has " + willysAmountMore + " more crayons");
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int numberOfPages = 22;
		int totalNumberOfStickers = stickersPerPage * numberOfPages;
		
		System.out.println(totalNumberOfStickers + " stickers");
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalChildren = 8;
		int cupcakesPerChild = totalCupcakes / totalChildren;
		
		System.out.println(cupcakesPerChild + " cupcakes per child");
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int amountOfCookiesMade = 47;
		int amountCookiesInJar = 6;
		int cookiesNotInJar = amountOfCookiesMade % amountCookiesInJar;
		
		System.out.println(cookiesNotInJar + " will not be placed in a jar");
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int amountCroissantPrepared = 59;
		int amountPerNeighbor = 8;
		int croissantsLeft = amountCroissantPrepared % amountPerNeighbor;
		
		System.out.println(croissantsLeft + " croissants left with Marian");
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int amountOfCookiesOnTray = 12;
		int cookiesBakedGoal = 276;
		int amountOfTraysNeeded = cookiesBakedGoal / amountOfCookiesOnTray;
		
		System.out.println(amountOfTraysNeeded + " trays will need to be prepared");
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzelsMade = 480;
		int pretzelServing = 12;
		int totalPretzelServings = pretzelsMade / pretzelServing;
		
		System.out.println(totalPretzelServings + " pretzel servings prepared");
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int totalLemonCupcakes = 53;
		int numberCupcakesPerBox = 3;
		int numberOfBoxesGiven = totalLemonCupcakes / numberCupcakesPerBox;
		
		System.out.println(numberOfBoxesGiven + " boxes were given away");
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int numberOfCarrotSticks = 74;
		int numberPeopleServed = 12;
		int totalCarrotSticksLeft = numberOfCarrotSticks % numberPeopleServed;
		
		System.out.println(totalCarrotSticksLeft + " carrot sticks were uneaten");
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int bearsPerShelf = 7;
		int totalShelvesFilled = totalTeddyBears / bearsPerShelf;
		
		System.out.println(totalShelvesFilled + " shelves will be filled");
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPictures = 480;
		int picturesPerAlbum = 20;
		int totalAlbumsNeeded = totalPictures / picturesPerAlbum;
		
		System.out.println(totalAlbumsNeeded + " albums are needed");
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalTradingCards = 94;
		int cardsPerBox = 8;
		int boxesFilled = totalTradingCards / cardsPerBox;
		int cardsInUnfilledBox = totalTradingCards % cardsPerBox;
		
		System.out.println(boxesFilled + " boxes are filled and " + cardsInUnfilledBox + " are in the unfilled box");
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooks = 210;
		int numberOfShelves = 10;
		int booksPerShelf = totalBooks / numberOfShelves;
		
		System.out.println(booksPerShelf + " books per shelf");
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croissantsBaked =  17;
		int guestsServed = 7;
		int amountPerGuest = croissantsBaked / guestsServed;
		
		System.out.println("Each guest will have " + amountPerGuest + " croissants");
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
