package cisc275.group3.controller;

import java.awt.Component;
import java.util.HashMap;

import cisc275.group3.scene.SceneWetland;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * Contains the controller actions and logic for SceneBay.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics
 * and timing attributes. Those interfaces require the controller
 * to pass an update call to the model on every timer tick, and
 * to update the time every second.
 * <p>
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerBay.java
 * <p>
 * @author Scott 
 * @author Ryan 
 * @author Jon 
 */
public class ControllerWetland extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/backgrounds/wetland_bg.jpg";
  
  /**
	 * Constructor
	 * 
	 * @param w
	 *            int-scene width
	 * @param h
	 *            int-scene height
	 * @param f
	 *            GameWindow-JFrame container
	 * @param cl
	 *            HashMap-associations of scene controllers and layers
	 * @param sceneType
	 *            EnumSceneType-type of scene to be constructed
	 */
  public ControllerWetland(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
    super(w, h, f, cl, sceneType);
  }

  /**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the Wetland.
	 */
  @Override
  protected void createScene() {    
    scene = new SceneWetland("Wetland", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    

    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setName("WetlandLayer");
    
    mainPane.setLayer(viewGame, EnumLayerCode.Wetland.getCode());
    mainPane.add(viewGame, EnumLayerCode.Wetland.getCode());
    
    componentList.put("Wetland", viewGame);
  
   addML();
  }

  /**
   * Connects the Wetland model and Wetland view. So long as the Wetland
   * scene is the active pane, update the model and then pass 
   * the updated scene objects to the view.
   * <p>
   * Overridden from interface LinkDynamics.java
   */
  @Override
  public void update() {
    if (mainPane.getLayer(componentList.get("Wetland")) == EnumLayerCode.MainAll.getCode()) {
      // Update Model
      ((SceneWetland)scene).update();
      viewGame.updatePanel(scene.getSceneItems());
    }
  }

  /**
   * Updates the model's time variable and calls
   * displayTime() to share it with the view.
   * <p>
   * Overridden from interface LinkTime.java
   */
  @Override
  public void updateTime() {
    ((LinkTime)scene).updateTime();
    
    if (mainPane.getLayer(componentList.get("Wetland")) == EnumLayerCode.MainAll.getCode()) {
      displayTime();
    }
  }
  
  /**
   * Displays the model time in the shared time 
   * label.
   * <p>
   * Overridden from interface LinkTime.java
   */
  @Override
  public void displayTime() {
    String sceneTime;
    
    sceneTime = Integer.toString(((SceneWetland)scene).getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
}
