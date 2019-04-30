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
		int raccoonsPlaying = 3;
		int raccoonsEating = 2;
		int raccoonsStillPlaying = raccoonsPlaying-raccoonsEating;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numFlowers = 5;
		int numBeesForFlowers = 3;
		int beelessFlowers=numFlowers-numBeesForFlowers;
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numLonelyPigeons = 1;
		int numNewPigeons = 1;
		int totalPigeons = numLonelyPigeons+numNewPigeons;
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numFirstOwls=3;
		int numNewOwls=2;
		int owlsOnFence=numFirstOwls+numNewOwls;
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int workingBeavers=2;
		int slackingBeavers=1;
		int beaversActuallyWorking=workingBeavers-slackingBeavers;
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int firstToucans=2;
		int newToucans=1;
		int totalToucans=firstToucans+newToucans;
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsInTree=4;
		int nutsInTree=2;
		int nutShortage=squirrelsInTree-nutsInTree;
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int quarterValueCents=25;
		int dimeValueCents=10;
		int nickelValueCents=5;
		int quarterQuantity=1;
		int dimeQuantity=1;
		int nickelQuantity=2;
		int moneyFoundInCents=quarterValueCents*quarterQuantity+dimeValueCents*dimeQuantity+nickelValueCents*nickelQuantity;

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierMuffins=18;
		int macAdamsMuffins=20;
		int flanneryMuffins=17;
		int firstGradeMuffins=brierMuffins+macAdamsMuffins+flanneryMuffins;
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int yoyoCostCents=24;
		int whistleCostCents=14;
		int totalToyCostCents=yoyoCostCents+whistleCostCents;
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numKrispieTreats=5;//since it never says "each" I will assume this value is irrelevant
		int numLargeMallows=8;
		int numMiniMallows=10;
		int totalMallows=numLargeMallows+numMiniMallows;
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesSnowAtHilts=29;
		int inchesSnowAtBrecknock=17;
		int diffSnow=inchesSnowAtHilts-inchesSnowAtBrecknock;
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int hiltStartingCashDollars=10;
		int toyTruckCostDollars=3;
		int pencilCaseCostDollars=2;
		int hiltRemainingCashDollars=hiltStartingCashDollars-toyTruckCostDollars-pencilCaseCostDollars;
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initJoshMarbles = 16;
		int joshLostMarbles=7;
		int finalJoshMarbles=initJoshMarbles-joshLostMarbles;
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int targetNumSeashells=25;
		int startingNumSeashells=19;
		int requiredSeashells=targetNumSeashells-startingNumSeashells;
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBradBalloons=17;
		int redBradBalloons=8;
		int greenBradBalloons=totalBradBalloons-redBradBalloons;
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initShelfBooks=38;
		int addedBooks=10;
		int finalShelfBooks=initShelfBooks+addedBooks;
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsPerBee=6;
		int numBeesWithLegs=8;
		int totalBeeLegs=legsPerBee*numBeesWithLegs;
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double coneCostDollars = 0.99;
		int numCones = 2;
		double totalConeCost= coneCostDollars*numCones;
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int targetHiltRock=125;
		int currentHiltRock=64;
		int requiredHiltRock=targetHiltRock-currentHiltRock;
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int initHiltMarbles=38;
		int lostHiltMarbles=15;
		int finalHiltMarbles=initHiltMarbles-lostHiltMarbles;
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalHiltDistanceMiles=78;
		int currentHiltMiles=32;
		int remainingHiltMiles=totalHiltDistanceMiles-currentHiltMiles;
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minutesPerHour=60;
		int hiltSatMornShovelMins=1*minutesPerHour+30;
		int hiltSatAftShovelMins=45;
		int hiltSatTotalShovelMins=hiltSatMornShovelMins+hiltSatAftShovelMins;
		int hiltSatTotalShovelHrs=hiltSatTotalShovelMins/minutesPerHour;
		int hiltSatTotalShovelMinsRemainder=hiltSatTotalShovelMins%minutesPerHour;
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hiltNumHotDog=6;
		double hiltHotDogCostDollars=0.5;
		double hiltTotalHotDogCostDollars=hiltNumHotDog*hiltHotDogCostDollars;
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hiltBudgetForPencilsCents=50;
		int hiltPencilCostCents=7;
		int hiltAffordPencils=hiltBudgetForPencilsCents/hiltPencilCostCents;
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int hiltTotalButterfliesSeen=33;
		int hiltOrangeButterfliesSeen=20;
		int hiltRedButterfliesSeen=hiltTotalButterfliesSeen-hiltOrangeButterfliesSeen;
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kateCandyPayment=1.00;
		double kateCandyCost=0.54;
		double kateCandyChange=kateCandyPayment-kateCandyCost;
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int initMarkTrees=13;
		int newMarkTrees=12;
		int totalMarkTrees=initMarkTrees+newMarkTrees;
		//System.out.println("JL checked to here");
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursPerDay=24;
		int joyDaysUntilGrandma=2;
		int joyHoursUntilGrandma=hoursPerDay*joyDaysUntilGrandma;
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimNumCousins=4;
		int kimGumPerCousin=5;
		int kimGumRequired=kimNumCousins*kimGumPerCousin;
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danCandyBudget=3.00;
		double danCandyCost=1.00;
		double danCandyChange=danCandyBudget-danCandyCost;
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsOnLake=5;
		int peoplePerBoat=3;
		int peopleOnLake=boatsOnLake*peoplePerBoat;
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int initEllenLegos=380;
		int lostEllenLegos=57;
		int finalEllenLegos=initEllenLegos-lostEllenLegos;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int targetArthurMuffins=83;
		int currentArthurMuffins=35;
		int remainingArthurMuffins=targetArthurMuffins-currentArthurMuffins;
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int numWillyCrayons=1400;
		int numLucyCrayons=290;
		int moreCrayons=numWillyCrayons-numLucyCrayons;
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage=10;
		int pagesOfStickers=22;
		int totalStickersOnPages=stickersPerPage*pagesOfStickers;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakesToShare=96;
		int childrenSharingCupcakes=8;
		int cupcakesPerChild=totalCupcakesToShare/childrenSharingCupcakes;
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalGingerbreadCookies=47;
		int gingerbreadCookiesPerJar=6;
		int remainderGingerbreadCookies=totalGingerbreadCookies%gingerbreadCookiesPerJar;
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsForNeighbors=59;
		int neighborsGettingCroissants=8;
		int remainderCroissants=croissantsForNeighbors%neighborsGettingCroissants;
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesPerTray=12;
		int cookiesPerBatch=276;
		int traysNeededEachBatch=cookiesPerBatch/cookiesPerTray;//but only because I'm certain there's no remainder, and I'd manually add one if there was
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int numMarianPretzel=480;
		int pretzelsPerServing=12;
		int servingsofMarianPretzel=numMarianPretzel/pretzelsPerServing;
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupcakesBaked=53;
		int lemonCupcakesLeftHome=2;
		int lemonCupcakesPerBox=3;
		int lemonCupcakeBoxesForOrphans=(lemonCupcakesBaked-lemonCupcakesLeftHome)/lemonCupcakesPerBox;
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten? Assuming everyone eats what they were served.
        */
		int susieMomCarrotsServed=74;
		int peopleEatingMomsCarrots=12;
		int remainingMomsCarrots=susieMomCarrotsServed%peopleEatingMomsCarrots;
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int susieSisterTeddies=98;
		int susieTeddiesPerShelf=7;
		int susieFullTeddyShelves=susieSisterTeddies/susieTeddiesPerShelf;
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int susiesMomTotalPics=480;
		int susiesMomPicsPerAlbum=20;
		int susiesMomAlbumsNeeded=susiesMomTotalPics/susiesMomPicsPerAlbum;
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int joesTotalCards=94;
		int joesCardsPerBox=8;
		int joesFullCardBoxes=joesTotalCards/joesCardsPerBox;
		int joesCardsInUnfilledBox=joesTotalCards%joesCardsPerBox;
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int susieFatherBooks=210;
		int susieFatherRepairedShelves=10;
		int susieFatherBooksPerShelf=susieFatherBooks/susieFatherRepairedShelves;
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int numCristinaCroissants=17;
		int numCristinaGuests=7;
		int cristinaCroissantsPerGuest=numCristinaCroissants/numCristinaGuests;
        /*
            CHALLENGE PROBLEMS
        */
		//System.out.println("JL Check to here");
        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		double billRoomsPerHr = (1/2.15);
		double jillRoomsPerHr = (1/1.9);
		double combinedJBRoomsPerHr = billRoomsPerHr+jillRoomsPerHr;
		double combined5RoomsHrs = 5*(1/combinedJBRoomsPerHr);
		double combined623RoomsHrs = 623*(1/combinedJBRoomsPerHr);
		int paintWorkHoursPerDay=8;
		double combined623RoomsDays = combined623RoomsHrs/paintWorkHoursPerDay;
		//System.out.println("JL Check to here");
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String firstName = "Jason";
		String middleInitial = "R";
		String lastName = "Lawrie";
		String fullNameConcatenated=lastName+", "+firstName+" "+middleInitial+".";
		System.out.println(fullNameConcatenated);
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		double totalNYtoChiDistance = 800;
		double trainCurrentTravel = 537;
		double percentTrainTraveled=trainCurrentTravel/totalNYtoChiDistance;
		System.out.println(percentTrainTraveled);
		int castTrainTraveledInt = (int)(percentTrainTraveled*100);
		System.out.println(castTrainTraveledInt+"%");
		//System.out.print("on line one");
		//System.out.print("still on line one");
		//System.out.println();
		
	}

}
