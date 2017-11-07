package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneLayer;
import cisc275.group3.view.SceneView;

/**
 * Contains the controller actions and logic for SceneBay.java.
 */
public class ControllerBay extends ControllerScene implements LinkDynamics, LinkTime {
  
  public ControllerBay(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {
    scene = new SceneBay("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, "img/bay_bg_1.jpg", true, true);
    sceneLayer = new SceneLayer(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), Color.BLUE, scene.getManifest().getBG());
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, sceneLayer, 
        ((SceneBay)scene).getScore(), ((SceneBay)scene).getTime());
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setDoubleBuffered(true);
    sceneView.setName("BayLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Bay.getCode());
    mainPane.add(sceneView, LayerCode.Bay.getCode());
    
    componentList.put("Bay", sceneView);
  
    addML();
    addMapMenuButton();
  }

  @Override
  protected void addML() {
    sceneLayer.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if ( scene.processClick(e.getX(), e.getY()) ) {
            ((SceneBay)scene).updateScore();
            sceneView.updateScore(((SceneBay)scene).getScore());
          }
        }
      }
    });
  }
  
  /**
   * Connects the Bay model and Bay view. So long as the Bay 
   * scene is the active pane, update the model and then pass 
   * the updated scene objects to the view.
   * <p>
   * Overriden from interface LinkDynamics.java
   */
  @Override
  public void update() {
    if (mainPane.getLayer(componentList.get("Bay")) == LayerCode.Main.getCode()) {
      ((SceneBay)scene).update();
      sceneLayer.updatePanel(scene.getSceneItems());
    }
  }
  
  /**
   * Updates the model's time variable and shares it with
   * the view.
   * <p>
   * Overridden from interface LinkTime.java
   */
  public void updateTime() {
    ((SceneBay)scene).updateTime();
    sceneView.updateTime(((SceneBay)scene).getTime());
  }
}
