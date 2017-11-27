package cisc275.group3.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cisc275.group3.model.scene.SceneInventory;
import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

/**
 * The Tools controller is responsible for both the "model" and
 * control of the toolbox. 
 * <p>
 * The toolbox augments the mouse and sets a "click type" that
 * can be checked against the object type to determine compatibility.
 * Because there is no underlying model, the controller implements
 * the corresponding logic.
 * <p>
 * ControllerTool.java
 * <p>
 * @author Scott 
 * @author Jolyne 
 */
public class ControllerInventory extends ControllerScene {

  private JPanel inventoryPanel;
  private ImageIcon inventoryBg;
  private static ArrayList<SceneObject> sceneFillItems = new ArrayList<SceneObject>();
  
  private static double inventory_x = 0;
  private static double inventory_y = 0;
  private static double inventory_y_max = 0;
  
  
  public ControllerInventory(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
	    super(w, h, f, cl, sceneType);
	    inventoryBg = new ImageIcon("img/inventory_menu.png");
  }
  
  @Override
  protected void createScene(int sceneType) {
	  
    scene = new SceneInventory("Inventory", 0, 0, 300, 300, 3, "img/inventory_menu_small.png");
    viewGame = new ViewGame(300, 300, scene.getSceneItems(), scene.getManifest().getBG());
	    

    viewGame.setBounds(100, 0, 300, 300);
    viewGame.setName("InventoryLayer");

    mainPane.setLayer(viewGame, LayerCode.Inventory.getCode());
    mainPane.add(viewGame, LayerCode.Inventory.getCode());
    componentList.put("Inventory", viewGame);
  }
  
  public static void addItem(SceneObject tmp)
  {
    // Add Item
	  if (tmp instanceof BetaFish)
	  {
		  if(tmp.getPassport().getHeight() > inventory_y_max)
		  {
			  inventory_y_max = tmp.getPassport().getHeight();
		  }
		  if(inventory_x + tmp.getPassport().getWidth() > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y_max;
			  inventory_y_max = 0;
		  }
		  sceneFillItems.add(new BetaFish(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
		  inventory_x = inventory_x + tmp.getPassport().getWidth();	
	  }
	  
	  else if (tmp instanceof BetaCrab)
	  {
		  if(tmp.getPassport().getHeight() > inventory_y_max)
		  {
			  inventory_y_max = tmp.getPassport().getHeight();
		  }
		  if(inventory_x + tmp.getPassport().getWidth() > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y_max;
			  inventory_y_max = 0;
		  }
		  sceneFillItems.add(new BetaCrab(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
		  inventory_x = inventory_x + tmp.getPassport().getWidth();
	  }
	  
	  else if (tmp instanceof BetaHeron)
	  {
		  if(tmp.getPassport().getHeight() > inventory_y_max)
		  {
			  inventory_y_max = tmp.getPassport().getHeight();
		  }
		  if(inventory_x + tmp.getPassport().getWidth() > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y_max;
			  inventory_y_max = 0;
		  }
		  sceneFillItems.add(new BetaHeron(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
		  inventory_x = inventory_x + tmp.getPassport().getWidth();
	  }
	  
  }
  
  //Takes a type of sceneObject and removes the amount of that particular object you want to remove from the inventory 
  public static void removeItem(String tmp) //SceneObject tmp , int count
  {
	  //int found_count = 0;
  
	  for (Iterator<SceneObject> iterator = sceneFillItems.iterator(); iterator.hasNext();) {     
	      SceneObject sceneItem = iterator.next();
	      
	      //System.out.println(sceneItem.getShortName() + " " + tmp.getShortName() + " " + found_count+ " " + count);
	      if(sceneItem.getPassport().getName() == tmp) // && found_count < count
	      {
	    	  iterator.remove();
	      }
	  }

	  //now basically redraw the inventory
	 
	  
	   ArrayList<SceneObject> tmp_list = new ArrayList<SceneObject>();
	   
	  for (SceneObject tmp_object : sceneFillItems)
	  {
		  tmp_list.add(tmp_object);
	  }
	  sceneFillItems.clear();
	  inventory_x = 0;
	  inventory_y = 0;
	  for(SceneObject tmp_object : tmp_list)
	  {
		  addItem(tmp_object);
	  }
	  tmp_list.clear();
	  
	  
  }
  
  public static ArrayList<SceneObject> getSceneItems()
  {
	  return sceneFillItems;
  }
 
  public void update()
  {
	  inventoryPanel.repaint();
	  mainPane.repaint();
	  
  }

  
  }