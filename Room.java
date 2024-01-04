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
import java.util.ArrayList;

/**
 * Class representing a room for Person objects to be checked in and checked out of. Creates
 * instances of Room and saves their name values in a static ArrayList.
 * 
 * @author Ethan
 *
 */
public class Room {
  private static ArrayList<String> names = new ArrayList<>();
  private String name;
  private Person[] occupants;
  private int currentOccupancy;

  /**
   * Takes the names of each room that has been created and added to the names ArrayList and
   * combines them into an array of String
   * 
   * @return a String array containing the names of each room that has been created.
   */
  public static String[] getNames() {
    String[] strArray = new String[names.size()];

    for (int i = 0; i < strArray.length; i++) {
      strArray[i] = names.get(i);
    }

    return strArray;
  }

  /**
   * Room constructor. Throws IllegalArgumentException if a room name has already been created
   * before or an invalid value for capacity is passed into the constructor. Adds the room name into
   * the names ArrayList upon construction.
   * 
   * @param name     String for the name of the room
   * @param capacity int representing the total capacity of the room
   */
  public Room(String name, int capacity) {
    for (int i = 0; i < names.size(); i++) {
      if (name == names.get(i)) {
        throw new IllegalArgumentException("This room name is already in use.");

      }
    }

    if (capacity <= 0) {
      throw new IllegalArgumentException("Invalid room capacity.");

    }

    this.name = name;
    occupants = new Person[capacity];
    currentOccupancy = 0;
    names.add(name);


  }

  /**
   * Gets the name of the room
   * 
   * @return String name of room
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the number of people in the room
   * 
   * @return int for number of Person objects checked in to room
   */
  public int getOccupancy() {
    return currentOccupancy;
  }

  /**
   * Gets the capacity of the Room object under COVID restrictions. Essentially just half of normal
   * capacity.
   * 
   * @return int for half of the total room capacity
   */
  public int getCOVIDCapacity() {
    if (occupants.length % 2 == 0) {
      return occupants.length / 2;
    } else {
      return occupants.length / 2 + 1;
    }
  }

  /**
   * Gets the full capacity of the room
   * 
   * @return int representing total possible room capacity
   */
  public int getCapacity() {
    return occupants.length;
  }

  /**
   * Checks if a specific person is currently checked into a room
   * 
   * @param p Object instance of Person
   * @return true if Person is checked in, false otherwise.
   */
  public boolean contains(Person p) {
    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] != null && occupants[i].equals(p)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Checks a person into a room using COVID protocol, no person can be directly next to another,
   * therefore every person is checked into solely even indexes. In doing so, toggles their waiting
   * status so that isWaiting becomes false, and increases the room's occupancy. Throws an
   * IllegalArgumentException if a null value is passed as argument. Returns true if the person is
   * checked in successfully (if there is enough space)
   * 
   * @param in Instance of object Person to be checked in
   * @return true if check in successful
   */
  public boolean checkIn(Person in) {
    if (in == null) {
      throw new IllegalArgumentException("Null instance of person passed as argument for checkin.");
    }

    if (this.contains(in)) {
      throw new IllegalArgumentException("This person has already been checked in.");
    }

    if (currentOccupancy == this.getCOVIDCapacity()) {
      return false;
    }

    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] == null && occupants[(i != occupants.length - 1) ? i + 1 : 0] == null
          && occupants[(i != 0) ? i - 1 : 0] == null) {
        occupants[i] = in;
        break;
      }
    }
    currentOccupancy++;
    in.toggleWaiting();

    return true;
  }

  /**
   * Checks a specific person out of the room. Takes a Person object as input and searches through
   * the occupants list for a Person object with the same name. Once found, removes them from the
   * array, decrements room occupancy, and sets isWaiting to true. Throws IllegalArgumentException
   * if null object passed as argument. Returns true if person was checked out successfully.
   * 
   * @param out Instance of object Person to be checked out
   * @return True if checkout successful, false otherwise.
   */
  public boolean checkOut(Person out) {
    if (out == null) {
      throw new IllegalArgumentException(
          "Null instance of person passed as argument for checkout.");
    }

    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] != null && occupants[i].equals(out)) {
        out.toggleWaiting();
        currentOccupancy--;
        occupants[i] = null;
        return true;
      }
    }

    return false;
  }

  /**
   * Returns the room and its occupants as a string. The String will be a list with index 0 at the
   * top and the last index at the bottom. Slots occupied by Persons will be represented by their
   * names, and empty slots with a dash ('-').
   * 
   * @return String representing the rooms occupants.
   */
  @Override
  public String toString() {
    String printout = name + "\n===\n";
    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] == null) {
        printout += "-\n";
      } else {
        printout += occupants[i].getName() + "\n";
      }
    }
    return printout;
  }

}
