package cisc275.group3.model.sceneobject;

import cisc275.group3.utility.ObjectId;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Abstraction of base level scene object properties and methods. Subclasses 
 * are created to extend unique functionality. Interfaces are created to extend
 * shared functionality.
 * <p>
 * Style changed in an attempt to more uniform and easier to read. See source
 * below.
 * <p>
 * SceneObject.java
 * 
 * @param	passport	type class to hold immutable properties
 * @param	location	current location stored as a 2D point
 * @param	randGen		RNG, mostly for subclasses
 * 
 * Style Changes
 * https://google.github.io/styleguide/javaguide.html 
 * http://www.oracle.com/technetwork/articles/java/index-137868.html # javadoc
 * 
 * Code Changes
 * https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html  # when to use this
 * https://docs.oracle.com/javase/tutorial/uiswing/index.html  # swing tutorial
 * http://www.badlogicgames.com/wordpress/?p=2668 # general design
 */
public abstract class SceneObject implements Comparable<SceneObject> {
  protected ObjectId passport;
  protected Point2D.Double location;
  protected Random randGen = new Random();

  public SceneObject(ObjectId id, double x, double y) {
	passport = id;
    location = new Point2D.Double(x,y);
  }

  /**
   * Sort by depth
   */
  public int compareTo(SceneObject other_item) {
    Integer myDepth = this.passport.getDepth();
    Integer urDepth = other_item.passport.getDepth();
    
	return myDepth.compareTo(urDepth);
  }

  /**
   * prints object properties
   */
  @Override
  public String toString() {
    String outString = "\nShort Name: " + Character.toString(passport.getName().charAt(0))
                      +"\nFull Name: " + passport.getName()
                      +"\nType ID: " + passport.getId()
                      +"\nImage File : " + passport.getImageFile()
                      +"\nWidth: " + passport.getWidth()
                      +"\nHeight: " + passport.getHeight()
                      +"\nLocation: " + location;
    return outString;
  }
  
  /**
   * @return passport	returns passport object
   */
  public ObjectId getPassport() {
	  return passport;
  }
  
  /**
   * @return location	returns object location
   */
  public Point2D.Double getLocation() {
	  return location;
  }
 }