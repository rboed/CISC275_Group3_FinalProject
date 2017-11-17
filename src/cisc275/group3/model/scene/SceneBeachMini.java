/*package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.SceneId;

public class SceneBeachMini extends Scene implements ConstructCrab, PropertyTimed {

  public SceneBeachMini(SceneId mani) {
	super(mani);
	
	time = 0;
    if(this.getManifest().getSceneType() == 2) {
        fillScene();	
    }  
  }
  
  *//**
   * Used when SceneId must also be created
   *//* 
  public SceneBeachMini(String n, double x, double y, double w, double h, int sceneType, String bg) {
    this(new SceneId(n, x, y, w, h, sceneType, bg));
  }

  
  *//**
   * Creates three NPC crabs and a Player Crab
   *//*
  @Override
  protected void fillScene() {
    for (int i=1; i<3; i++) {
    	
      // Add NPC Crab
      sceneItems.add(ConstructCrab.constructCrab(
                     5, // depth
                     0, // type
                     0+50, // x location 
                     i*200 + manifest.getStartY() + 10)); // y location
    }
    
    // Player Crab
    sceneItems.add(ConstructCrab.constructCrab(
                   5, // depth
                   1, // type
                   0+50, // x location 
                   600)); // y location    
  }
  
  @Override
  public void update() {
    sceneItems.forEach((crab)->{
      if (crab.getPassport().getId() == 100) {
        ((BetaCrab)crab).move();
      }
    });	
  }
  
  public void update(double dx) {
    sceneItems.forEach((crab)->{
      if (crab.getPassport().getId() == 200) {
	    ((BetaCrab)crab).move(dx);
	  }
	});	 
  }

  @Override
  public int getTime() {
    return time;
  }

  @Override
  public void updateTime() {
    time += 1;
  }
}*/
