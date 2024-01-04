//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    a descriptive title
// Course:   CS 300 Spring 2021
//
// Author:   Ethan Geoffrey Wijaya
// Email:    egwijaya@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class represents and creates instances of a person to be checked in into the Room class.
 * @author Ethan
 *
 */
public class Person {
  private String name;
  private boolean isWaiting;
  
  /**
   * Constructor for instance of class Person
   * @param name String for name of the person
   */
  public Person (String name) {
    this.name = name;
    isWaiting = true;
  }
  
  /**
   * Accessor for the name value of an instance of Person
   * @return String name
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Accessor for the isWaiting value of an instance of Person
   * @return boolean isWaiting
   */
  public boolean isWaiting() {
    return isWaiting;
  }
  
  /**
   * Alters the isWaiting value to its opposite. If it is true, sets to false and vice versa.
   */
  public void toggleWaiting() {
    if (isWaiting) {
      isWaiting = false;
    } else {
      isWaiting = true;
    }
  }
  
  /**
   * Compares two instances of Person and if both instances have the same name String, return true.
   * Returns false otherwise.
   * 
   * @return Boolean representing whether two instance names are equal
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person)o).name);
    }
    return false;
  }
}
