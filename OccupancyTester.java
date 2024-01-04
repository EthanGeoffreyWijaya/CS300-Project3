//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: a descriptive title
// Course: CS 300 Spring 2021
//
// Author: Ethan Geoffrey Wijaya
// Email: egwijaya@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
/**
 * Tests methods from the Person and Room class.
 * 
 * @author Ethan
 *
 */
public class OccupancyTester {

  /**
   * Tester for the Person class and its methods.
   * 
   * @return True if all tests passed.
   */
  public static boolean testPerson() {
    boolean error = false;
    Person human = new Person("human");
    Person individual = new Person("individual");
    Person clone = new Person("human");

    System.out.println("testPerson():");
    // 1) getName() test 1
    if (!human.getName().equals("human")) {
      System.out.println("Error 1| Incorrect name");
      System.out.println("Expected: human");
      System.out.println("Actual: " + human.getName());
      error = true;
    }

    // 2) getName() test 2
    if (!individual.getName().equals("individual")) {
      System.out.println("Error 2| Incorrect name");
      System.out.println("Expected: individual");
      System.out.println("Actual: " + individual.getName());
      error = true;
    }

    // 3) toggleWaiting() test
    human.toggleWaiting();
    if (human.isWaiting()) {
      System.out.println("Error 3| Incorrect waiting value");
      System.out.println("Expected: false\nActual: true");
      error = true;
    }

    // 4) isWaiting() constructor test
    if (!individual.isWaiting()) {
      System.out.println("Error 4| Incorrect waiting value");
      System.out.println("Expected: true\nActual: false");
      error = true;
    }

    // 5) equals() test 1: unequal instances of Person
    if (human.equals(individual)) {
      System.out.println("Error 5| Persons with different names considered equal");
      error = true;
    }

    // 6) equals() test 2: equal instances of Person
    if (!human.equals(clone)) {
      System.out.println("Error 6| Persons with same names considered unequal");
      error = true;
    }

    // 7) equals() test 2: with invalid object
    if (human.equals("human")) {
      System.out.println("Error 7| Person object considered equal with a string");
      error = true;
    }

    if (error) {
      return false;
    }
    System.out.println("All tests passed!");
    return true;

  }

  /**
   * Tester for the Room class' constructor field.
   * 
   * @return True if all tests passed.
   */
  public static boolean testRoomConstructor() {
    Room r = new Room("room1", 5);
    Room r2 = new Room("room2", 7);
    Room r3;
    boolean error = false;

    System.out.println("testRoomConstructor():");
    // 1) Creating a room with the same name
    try {
      r3 = new Room("room1", 8);
      System.out.println("Error 1.1| No exception thrown when creating room of same name");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("Error 1.2| Wrong exception thrown. Should be IllegalArgumentException");
      System.out.println("Exception details: " + e.getMessage());
      error = true;
    }

    // 2) Creating a room with an invalid capacity test 1
    try {
      r3 = new Room("room3", 0);
      System.out.println("Error 2.1| No exception thrown when creating room of capacity 0");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("Error 2.2| Wrong exception thrown. Should be IllegalArgumentException");
      System.out.println("Exception details: " + e.getMessage());
      error = true;
    }

    // 3) Creating a room with an invalid capacity test 2
    try {
      r3 = new Room("room3", -1000);
      System.out.println("Error 3.1| No exception thrown when creating room of capacity -1000");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("Error 3.2| Wrong exception thrown. Should be IllegalArgumentException");
      System.out.println("Exception details: " + e.getMessage());
      error = true;
    }

    // 4) Checking names array
    String[] names = Room.getNames();
    if (names.length != 2 && names[0] != "room1" && names[1] != "room2") {
      System.out.println("Error 4| Names array incorrect");
      System.out.println("Expected: [room1, room2]");
      System.out.print("Actual: [");
      for (int i = 0; i < names.length; i++) {
        System.out.print(names[i]);
        if (i != names.length - 1) {
          System.out.print(", ");
        }
      }
      System.out.println("]");
      error = true;
    }

    if (error) {
      return false;
    }
    System.out.println("All tests passed!");
    return true;
  }

  /**
   * Tester for the accessor methods of the Room class
   * 
   * @return True if all tests passed
   */
  public static boolean testRoomAccessors() {
    Room r1 = new Room("one", 5);
    Room r2 = new Room("two", 8);
    boolean error = false;

    System.out.println("testRoomAccessors():");
    // 1) getName() test 1
    if (r1.getName() != "one") {
      System.out.println("Error 1| Incorrect name");
      System.out.println("Expected: one");
      System.out.println("Actual: " + r1.getName());
      error = true;
    }

    // 2) getName() test 2
    if (r2.getName() != "two") {
      System.out.println("Error 2| Incorrect name");
      System.out.println("Expected: two");
      System.out.println("Actual: " + r2.getName());
      error = true;
    }

    // 3) getOccupancy() test
    if (r1.getOccupancy() != 0) {
      System.out.println("Error 3| Occupancy should be 0 upon Room construction");
      System.out.println("Actual value: " + r1.getOccupancy());
      error = true;
    }

    // 4) getCapacity() test 1
    if (r1.getCapacity() != 5) {
      System.out.println("Error 4| Incorrect room capacity");
      System.out.println("Expected: 5");
      System.out.println("Actual: " + r1.getCapacity());
      error = true;
    }

    // 5) getCapacity() test 2
    if (r2.getCapacity() != 8) {
      System.out.println("Error 5| Incorrect room capacity");
      System.out.println("Expected: 8");
      System.out.println("Actual: " + r2.getCapacity());
      error = true;
    }

    // 6) getCOVIDCapacity() test 1
    if (r1.getCOVIDCapacity() != 3) {
      System.out.println("Error 6| Incorrect COVID capacity");
      System.out.println("Expected: 3");
      System.out.println("Actual: " + r1.getCOVIDCapacity());
      error = true;
    }

    // 7) getCOVIDCapacity() test 2
    if (r2.getCOVIDCapacity() != 4) {
      System.out.println("Error 7| Incorrect COVID capacity");
      System.out.println("Expected: 4");
      System.out.println("Actual: " + r2.getCOVIDCapacity());
      error = true;
    }

    if (error) {
      return false;
    }
    System.out.println("All tests passed!");
    return true;
  }

  /**
   * Tester for the Room class' CheckIn() method
   * 
   * @return True if all tests passed
   */
  public static boolean testRoomCheckIn() {
    Room monsters = new Room("monsters", 10);
    Room aliens = new Room("aliens", 2);
    Person godzilla = new Person("Godzilla");
    boolean error = false;

    System.out.println("testRoomCheckIn():");
    // 1) null input test
    try {
      monsters.checkIn(null);
      System.out.println("Error 1.1| No exception thrown with null checkin");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out
          .println("Error 1.2| Incorrect exception thrown, should be IllegalArgumentException");
      System.out.println("Exception details " + e.getMessage());
      error = true;
    }

    // 2) full COVIDCapacity test
    aliens.checkIn(new Person("Xenomorph"));
    if (aliens.checkIn(new Person("Spock"))) {
      System.out.println("Error 2| Person successfully added to room at full capacity");
      error = true;
    }

    // 3) Successful check in test
    if (!monsters.checkIn(godzilla)) {
      System.out.println("Error 3.1| Person not succesfully checked in");
      error = true;
    }

    if (monsters.getOccupancy() != 1) {
      System.out.println("Error 3.2| Incorrect occupancy");
      System.out.println("Expected: 1");
      System.out.println("Actual: " + monsters.getOccupancy());
      error = true;
    }

    if (godzilla.isWaiting()) {
      System.out.println("Error 3.3| Person still marked as waiting after having checked in");
      error = true;
    }

    // 4) Test for even index ordering
    monsters.checkIn(new Person("King Kong"));
    monsters.checkIn(new Person("The Headless Horseman"));
    monsters.checkIn(new Person("Shrek"));
    monsters.checkIn(new Person("insert member of opposite political party"));
    String expectedNames = "monsters\n===\nGodzilla\n-\nKing Kong\n-\nThe Headless Horseman\n-\n"
        + "Shrek\n-\ninsert member of opposite political party\n-\n";
    String actualNames = monsters.toString();
    if (!expectedNames.equals(actualNames)) {
      System.out.println("Error 4| Persons ordered incorrectly in room");
      System.out.println("Expected: " + expectedNames);
      System.out.println("Actual: " + actualNames);
      error = true;
    }

    // 5) CurrentOccupancy specific test
    if (monsters.getOccupancy() != 5) {
      System.out.println("Error 5| Incorrect occupancy value");
      System.out.println("Expected: 5");
      System.out.println("Actual: " + monsters.getOccupancy());
      error = true;
    }

    // 6) full room test 2
    if (monsters.checkIn(new Person("Freddy Krueger"))) {
      System.out.println("Error 6| Successfully added person to full room");
      error = true;
    }

    // 7) contains() test 1
    if (!monsters.contains(godzilla)) {
      System.out.println("Error 7| Person in room not detected");
      error = true;
    }

    // 8) contains() test 2
    Person kraken = new Person("Kraken");
    if (monsters.contains(kraken)) {
      System.out.println("Error 8| Person not in room detected");
      error = true;
    }

    // 9) checking in the same Person twice
    try {
      monsters.checkIn(godzilla);
      System.out.println("Error 9.1| Exception not thrown when checking person "
          + "into room they are already checked in");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("Error 9.2| Incorect exception thrown for checking in existing person");
      System.out.println("Error details: " + e.getMessage());
      error = true;
    }

    if (error) {
      return false;
    }
    System.out.println("All tests passed!");
    return true;
  }

  /**
   * Tester for the Room class' checkOut() method
   * 
   * @return True if all tests passed
   */
  public static boolean testRoomCheckOut() {
    Room aliens = new Room("cool aliens", 6);
    Person spock = new Person("Spock");
    aliens.checkIn(new Person("Chewbacca"));
    aliens.checkIn(new Person("Orgalorg"));
    aliens.checkIn(spock);
    boolean error = false;

    System.out.println("testRoomCheckout():");
    // 1) test for successful check out
    if (!aliens.checkOut(spock)) {
      System.out.println("Error 1.1| Person not succesfully checked out");
      error = true;
    }

    if (aliens.getOccupancy() != 2) {
      System.out.println("Error 1.2| Incorrect occupancy");
      System.out.println("Expected: 2");
      System.out.println("Actual: " + aliens.getOccupancy());
      error = true;
    }

    if (!spock.isWaiting()) {
      System.out.println("Error 1.3| Waiting not toggled after checkout");
      error = true;
    }

    String expectedNames = "cool aliens\n===\nChewbacca\n-\nOrgalorg\n-\n-\n-\n";
    String actualNames = aliens.toString();
    if (!expectedNames.equals(actualNames)) {
      System.out.println("Error 1.4| Person not removed from room during checkout");
      System.out.println("Expected: " + expectedNames);
      System.out.println("Actual: " + actualNames);
      error = true;
    }

    // 2) test for impossible checkout 1: null value
    try {
      aliens.checkOut(null);
      System.out.println("Error 2.1| no exception thrown for null input");
      error = true;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("Error 2.2| Wrong exception thrown for null input, should be "
          + "IllegalArgumentException");
      error = true;
    }

    // 3) test for impossible checkout 2: person not in room
    Person thanos = new Person("Thanos");
    if (aliens.checkOut(thanos)) {
      System.out.println("Error 3| Successful checkout of person not in room");
      error = true;
    }

    if (error) {
      return false;
    }
    System.out.println("All tests passed!");
    return true;
  }

  /**
   * Tester for the Room class' toString() method
   * 
   * @return True if all tests passed.
   */
  public static boolean testRoomToString() {
    Room alphabet = new Room("alphabet", 4);
    alphabet.checkIn(new Person("A"));
    alphabet.checkIn(new Person("B"));
    String expectedNames = "alphabet\n===\nA\n-\nB\n-\n";
    String actualNames = alphabet.toString();

    System.out.println("testRoomToString():");
    if (!expectedNames.equals(actualNames)) {
      System.out.println("Error| toString() method made incorrect copy");
      System.out.println("Expected:\n" + expectedNames);
      System.out.println("Actual:\n" + actualNames);
      return false;
    }
    System.out.println("All tests passed!");
    return true;
  }

  /**
   * Main method, where all testers are called.
   * 
   * @param args
   */
  public static void main(String[] args) {
    testPerson();
    testRoomConstructor();
    testRoomAccessors();
    testRoomCheckIn();
    testRoomCheckOut();
    testRoomToString();
  }
}


