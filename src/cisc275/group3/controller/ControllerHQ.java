package cisc275.group3.controller;

import java.awt.Component;
import java.util.HashMap;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;


/**
 * Contains the controller actions and logic for SceneHQ.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics
 * and timing attributes. Those interfaces require the controller
 * to pass an update call to the model on every timer tick, and
 * to update the time every second.
 * <p>
 * @see ControllerScene.java
 * <p>
 * ControllerHQ.java
 * <p>
 * @author Scott
 * @author Jon
 * @author Jolyne
 */
public class ControllerHQ extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = "img/bay_bg_2.jpg";
	  
	public ControllerHQ(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}
	  
	@Override
	protected void createScene(int sceneType) {
		scene = new SceneHQ("HQ", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, sceneType, BG_IMAGE);
	    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
	    

	    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	    viewGame.setName("HQLayer");
	    
	    mainPane.setLayer(viewGame, LayerCode.HQ.getCode());
	    mainPane.add(viewGame, LayerCode.HQ.getCode());
	    
	    componentList.put("HQ", viewGame);
	  
	    addML();
	  }
	
	  @Override
	  protected void addML() {
	  }
	
	  /**
	   * Connects the HQ model and HQ view. So long as the HQ 
	   * scene is the active pane, update the model and then pass 
	   * the updated scene objects to the view.
	   * <p>
	   * Overridden from interface LinkDynamics.java
	   */
	@Override
	  public void update() {
	    if (mainPane.getLayer(componentList.get("HQ")) == LayerCode.MainAll.getCode()) {
	      // Update Model
	      ((SceneHQ)scene).update();
	      viewGame.updatePanel(scene.getSceneItems());
	    }
	  }

	
	/**
	   * Updates the linked time through the SceneHQ. If there
	   * is an active mission, the time is incremented and if
	   * the Mission is turned in, the time is reset, and
	   * mission is scored appropriately
	   */
	@Override
	public void updateTime() {
		if(((SceneHQ)scene).getCurrentMission().isDoneMission() == false){
			  ((SceneHQ)scene).updateTime();	
		  }	    
		  else {
			  if(((SceneHQ)scene).getTime() != 0){
				  ((SceneHQ)scene).missionScore();	
				  ((SceneHQ)scene).resetTime();	
			  }
		  }
	    if (mainPane.getLayer(componentList.get("HQ")) == LayerCode.MainAll.getCode()) {
	      displayTime();
	    }
	    displayScore();		
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
	    
	    sceneTime = Integer.toString(((SceneHQ)scene).getTime());
	    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
	  }
	
	  /**
	   * Displays the model score in the shared score 
	   * label.
	   */
	  public void displayScore() {
		    String sceneScore;
		    
		    sceneScore = Integer.toString(((SceneHQ)scene).getScore());
		    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
		  }
}
