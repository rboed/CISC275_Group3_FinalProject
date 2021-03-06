package cisc275.group3.testing;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.Test;

import cisc275.group3.scene.Scene;
import cisc275.group3.scene.SceneBay;
import cisc275.group3.scene.SceneBeach;
import cisc275.group3.scene.SceneBeachMini;
import cisc275.group3.scene.SceneWetland;
import cisc275.group3.sceneobject.ToolCage;
import cisc275.group3.sceneobject.ToolCamera;
import cisc275.group3.sceneobject.ToolNet;
import cisc275.group3.sceneobject.ToolTrimmer;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.Mission;

/**
 * A series of methods to test common/shared 
 * functionality across all dynamic scenes.
 * @author Scott
 */
public class AbstractSceneTests implements ConstructCrab, ConstructFish, ConstructVegetation {
  // Scene Dimensions
  private static final int SCENE_WIDTH = 1280;
  private static final int SCENE_HEIGHT = 720;
  
  // Object Locations
  private static final int[] FISH_LOC_1 = {0,0};
  private static final int[] FISH_LOC_2 = {100, 0};
  private static final int[] FISH_LOC_3 = {200,0};
  private static final int[] CRAB_LOC_1 = {300, 0};
  private static final int[] CRAB_LOC_2 = {400, 0};
  private static final int[] CRAB_LOC_3 = {0, 300};
  private static final int[] CRAB_LOC_4 = {100, 300};
  private static final int[] WEED_LOC_1 = {200, 300};
  private static final int[] HERON_LOC_1 = {300, 300};
  private static final int[] HERON_LOC_2 = {400, 300};
  private static final int[] HERON_LOC_3 = {0, 600};
  private static final int[] HERON_LOC_4 = {100, 600};
  
  // List of concrete scenes 
  // that extend abstract scene
  private static HashMap<String, Scene> testList;
  
  /**
   * Create a set of scenes to test before
   * any tests are run
   */
  @BeforeClass
  public static void sceneSetup() {
	  testList = new HashMap<String, Scene>();
	  
	  testList.put("Bay", new SceneBay("Bay Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", EnumSceneType.EMPTY));
	  testList.put("Beach", new SceneBeach("Beach Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/beach_bg.jpg", EnumSceneType.EMPTY));
	  testList.put("BeachMini", new SceneBeachMini("Beach Mini Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/beach_bg.jpg", EnumSceneType.EMPTY));
	  testList.put("Wetland", new SceneWetland("Wetland Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/wetland_bg.jpg", EnumSceneType.EMPTY));
	  
	  baySetup();
	  beachSetup();
	  beachMiniSetup();
	  wetlandSetup();
  }  
  
  /**
   * Test manifest (SceneId) objects are 
   * created correctly
   */
  @Test
  public void testManifests() {
    System.out.println("  Testing Manifests");
    
    System.out.println("    Bay Manifest");
    assertEquals("BG Image = img/bay_bg_1.png", "img/bay_bg_1.png", testList.get("Bay").getManifest().getBG());
    assertEquals("Name = Bay Test", "Bay Test", testList.get("Bay").getManifest().getName());
    assertEquals("Initial X = 0", 0, testList.get("Bay").getManifest().getStartX(), 1);
    assertEquals("Initial Y = 0", 0, testList.get("Bay").getManifest().getStartY(), 1);
    assertEquals("Width = " + SCENE_WIDTH, SCENE_WIDTH, testList.get("Bay").getManifest().getWidth(), 1);
    assertEquals("Height = " + SCENE_HEIGHT, SCENE_HEIGHT, testList.get("Bay").getManifest().getHeight(), 1);
    assertEquals("Scene Type = EnumSceneType.EMPTY", EnumSceneType.EMPTY, testList.get("Bay").getManifest().getSceneType());
    
    System.out.println("    Beach Manifest");
    assertEquals("BG Image = img/beach_bg.jpg", "img/beach_bg.jpg", testList.get("Beach").getManifest().getBG());
    assertEquals("Name = Beach Test", "Beach Test", testList.get("Beach").getManifest().getName());
    assertEquals("Initial X = 0", 0, testList.get("Beach").getManifest().getStartX(), 1);
    assertEquals("Initial Y = 0", 0, testList.get("Beach").getManifest().getStartY(), 1);
    assertEquals("Width = " + SCENE_WIDTH, SCENE_WIDTH, testList.get("Beach").getManifest().getWidth(), 1);
    assertEquals("Height = " + SCENE_HEIGHT, SCENE_HEIGHT, testList.get("Beach").getManifest().getHeight(), 1);
    assertEquals("Scene Type = EnumSceneType.EMPTY", EnumSceneType.EMPTY, testList.get("Beach").getManifest().getSceneType());
     
    System.out.println("    Beach Mini Manifest");
    assertEquals("BG Image = img/beach_bg.jpg", "img/beach_bg.jpg", testList.get("BeachMini").getManifest().getBG());
    assertEquals("Name = Beach Mini Test", "Beach Mini Test", testList.get("BeachMini").getManifest().getName());
    assertEquals("Initial X = 0", 0, testList.get("BeachMini").getManifest().getStartX(), 1);
    assertEquals("Initial Y = 0", 0, testList.get("BeachMini").getManifest().getStartY(), 1);
    assertEquals("Width = " + SCENE_WIDTH, SCENE_WIDTH, testList.get("BeachMini").getManifest().getWidth(), 1);
    assertEquals("Height = " + SCENE_HEIGHT, SCENE_HEIGHT, testList.get("BeachMini").getManifest().getHeight(), 1);
    assertEquals("Scene Type = EnumSceneType.EMPTY", EnumSceneType.EMPTY, testList.get("BeachMini").getManifest().getSceneType());
    
    System.out.println("    Wetland Manifest");
    assertEquals("BG Image = img/wetland_bg.jpg", "img/wetland_bg.jpg", testList.get("Wetland").getManifest().getBG());
    assertEquals("Name = Wetland Test", "Wetland Test", testList.get("Wetland").getManifest().getName());
    assertEquals("Initial X = 0", 0, testList.get("Wetland").getManifest().getStartX(), 1);
    assertEquals("Initial Y = 0", 0, testList.get("Wetland").getManifest().getStartY(), 1);
    assertEquals("Width = " + SCENE_WIDTH, SCENE_WIDTH, testList.get("Wetland").getManifest().getWidth(), 1);
    assertEquals("Height = " + SCENE_HEIGHT, SCENE_HEIGHT, testList.get("Wetland").getManifest().getHeight(), 1);
    assertEquals("Scene Type = EnumSceneType.EMPTY", EnumSceneType.EMPTY, testList.get("Wetland").getManifest().getSceneType());
  }
  
  /**
   * Tests processClick() by setting tools and
   * clicking in the appropriate areas.
   */
  @Test
  public void testProcessClick() { 
    int co = 40; // click offset
    
    System.out.println("  Testing Click");
    
    // Null Tool
    Scene.setCurrentTool(null);
    System.out.println("    Null Tool");
    assertEquals("Click: Null on Fish in Bay", false, testList.get("Bay").basicClick(FISH_LOC_1[0]+co, FISH_LOC_1[1]+co));
    assertEquals("Click: Null on Crab in Beach", false, testList.get("Beach").basicClick(CRAB_LOC_1[0]+co, CRAB_LOC_1[1]+co));
    assertEquals("Click: Null on Vegetation in Wetland", false, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Null on Heron in Wetland", false, testList.get("Wetland").basicClick(HERON_LOC_1[0]+co, HERON_LOC_1[1]+co));
    
    // Net Tool
    Scene.setCurrentTool(new ToolNet());
    System.out.println("    Net Tool");
    assertEquals("Click: Net on Fish in Bay", true, testList.get("Bay").basicClick(FISH_LOC_1[0]+co, FISH_LOC_1[1]+co));
    assertEquals("Click: Net on Crab in Beach", false, testList.get("Beach").basicClick(CRAB_LOC_1[0]+co, CRAB_LOC_1[1]+co));
    assertEquals("Click: Net on Vegetation in Wetland", false, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Net on Heron in Wetland", false, testList.get("Wetland").basicClick(HERON_LOC_1[0]+co, HERON_LOC_1[1]+co));
    
    // Camera Tool
    Scene.setCurrentTool(new ToolCamera());
    System.out.println("    Camera Tool");
    assertEquals("Click: Camera on Fish in Bay", false, testList.get("Bay").basicClick(FISH_LOC_2[0]+co, FISH_LOC_2[1]+co));
    assertEquals("Click: Camera on Crab in Beach", false, testList.get("Beach").basicClick(CRAB_LOC_1[0]+co, CRAB_LOC_1[1]+co));
    assertEquals("Click: Camera on Vegetation in Wetland", false, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Camera on Heron in Wetland", true, testList.get("Wetland").basicClick(HERON_LOC_1[0]+co, HERON_LOC_1[1]+co));
    
    // Cage Tool
    Scene.setCurrentTool(new ToolCage());
    System.out.println("    Cage Tool");
    assertEquals("Click: Cage on Fish in Bay", false, testList.get("Bay").basicClick(FISH_LOC_2[0]+co, FISH_LOC_2[1]+co));
    assertEquals("Click: Cage on Crab in Beach", true, testList.get("Beach").basicClick(CRAB_LOC_1[0]+co, CRAB_LOC_1[1]+co));
    assertEquals("Click: Cage on Vegetation in Wetland", false, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Cage on Heron in Wetland", false, testList.get("Wetland").basicClick(HERON_LOC_2[0]+co, HERON_LOC_2[1]+co));
    
    // Trimmer Tool
    Scene.setCurrentTool(new ToolTrimmer());
    System.out.println("    Trimmer Tool");
    assertEquals("Click: Trimmer on Fish in Bay", false, testList.get("Bay").basicClick(FISH_LOC_2[0]+co, FISH_LOC_2[1]+co));
    assertEquals("Click: Trimmer on Crab in Beach", false, testList.get("Beach").basicClick(CRAB_LOC_2[0]+co, CRAB_LOC_2[1]+co));
    assertEquals("Click: Trimmer on Vegetation in Wetland", true, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Trimmer on Vegetation in Wetland", true, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Trimmer on Vegetation in Wetland", true, testList.get("Wetland").basicClick(WEED_LOC_1[0]+co, WEED_LOC_1[1]+co));
    assertEquals("Click: Trimmer on Heron in Wetland", false, testList.get("Wetland").basicClick(HERON_LOC_2[0]+co, HERON_LOC_2[1]+co));
  }
  
  /**
   * Tests updatable variables: score, time
   */
  @Test
  public void testUpdates() {
    System.out.println("  Testing Score and Time Updates");
    
    testList.get("Beach").updateScore();
    testList.get("Wetland").updateTime();
    
    
    testList.forEach((k,v)->{
      System.out.println("    Update Testing " + k);      
      assertEquals("Score = 1", 1, v.getScore());
      assertEquals("Time = 99", 99, v.getTime());
    });
    
    testList.get("BeachMini").missionScore();
    testList.get("Bay").resetTime();
    
    testList.forEach((k,v)->{
      System.out.println("    Final Testing " + k);  
      assertEquals("Mission Score = 100", 100, v.getScore());
      assertEquals("Reset Time = 0", 0, v.getTime());
    });
  }
  
  /**
   * Tests the static variables: tool, mission,
   * fact. Ensures all scenes point to the same
   * variable.
   */
  @Test
  @SuppressWarnings("static-access")
  public void testStaticVariables() {
    System.out.println("  Testing Static Variables");
    testList.forEach((k,v)->{
      System.out.println("    Testing " + k);
      assertEquals("Current Tool = null", null, Scene.getCurrentTool()); 
      //assertEquals("Current Mission = Completed!", "Completed!", Scene.getCurrentMission());
      assertEquals("Set Done Mission = true", true, Scene.getCurrentMission().isDoneMission());
      assertEquals("Current Fact = ", "", Scene.getCurrentFact());
    });
    
    // Update Static Variables
    testList.get("Bay").setCurrentMission(new Mission(null, -1));
    testList.get("Bay").setCurrentTool(new ToolCamera());
    testList.get("Bay").setCurrentFact("HI!");
    
    // Test Statics Pairwise
    System.out.println("  Testing All Scenes Using Static");
    
    System.out.println("    Bay == Beach");
    assertEquals("Bay.Score == Beach.Score", true,
    		testList.get("Bay").getScore() == testList.get("Beach").getScore());
    assertEquals("Bay.Time == Beach.Time", true,
    		testList.get("Bay").getTime() == testList.get("Beach").getTime());
    assertEquals("Bay.Mission == Beach.Mission", true,
    		testList.get("Bay").getCurrentMission() == testList.get("Beach").getCurrentMission());
    assertEquals("Bay.Tool == Beach.Tool", true, 
    		testList.get("Bay").getCurrentTool() == testList.get("Beach").getCurrentTool());
    assertEquals("Bay.Fact == Beach.Fact", true,
    		testList.get("Bay").getCurrentFact() == testList.get("Beach").getCurrentFact());
    
    System.out.println("    Beach == BeachMini");
    assertEquals("Beach.Score == BeachMini.Score", true,
    		testList.get("Beach").getScore() == testList.get("BeachMini").getScore());
    assertEquals("Beach.Time == BeachMini.Time", true,
    		testList.get("Beach").getTime() == testList.get("BeachMini").getTime());
    assertEquals("Beach.Mission == BeachMini.Mission", true,
    		testList.get("Beach").getCurrentMission() == testList.get("BeachMini").getCurrentMission());
    assertEquals("Beach.Tool == BeachMini.Tool", true, 
    		testList.get("Beach").getCurrentTool() == testList.get("BeachMini").getCurrentTool());
    assertEquals("Beach.Fact == BeachMini.Fact", true,
    		testList.get("Beach").getCurrentFact() == testList.get("BeachMini").getCurrentFact());
    
    System.out.println("    BeachMini == Wetland");
    assertEquals("BeachMini.Score == Wetland.Score", true,
    		testList.get("BeachMini").getScore() == testList.get("Wetland").getScore());
    assertEquals("BeachMini.Time == Wetland.Time", true,
    		testList.get("BeachMini").getTime() == testList.get("Wetland").getTime());
    assertEquals("BeachMini.Mission == Wetland.Mission", true,
    		testList.get("BeachMini").getCurrentMission() == testList.get("Wetland").getCurrentMission());
    assertEquals("BeachMini.Tool == Wetland.Tool", true, 
    		testList.get("BeachMini").getCurrentTool() == testList.get("Wetland").getCurrentTool());
    assertEquals("BeachMini.Fact == Wetland.Fact", true,
    		testList.get("BeachMini").getCurrentFact() == testList.get("Wetland").getCurrentFact());
  }
  
  /**
   * Initial setup for bay scene.
   */
  private static void baySetup() {
    testList.get("Bay").getSceneItems().add(ConstructFish.constructLeftFish(-5, 0, FISH_LOC_1[0], FISH_LOC_1[1]));
    testList.get("Bay").getSceneItems().add(ConstructFish.constructRightFish(5, 1, FISH_LOC_2[0], FISH_LOC_2[1]));
    testList.get("Bay").getSceneItems().add(ConstructFish.constructRightFish(5, 2, FISH_LOC_3[0], FISH_LOC_3[1]));
    
    System.out.println("## Created Scene ##" + testList.get("Bay").toString() + "\n");
  }
  
  /**
   * Initial setup for beach scene.
   */
  private static void beachSetup() {
    testList.get("Beach").getSceneItems().add(ConstructCrab.constructLeftCrab(-5, 0, CRAB_LOC_1[0], CRAB_LOC_1[1]));
    testList.get("Beach").getSceneItems().add(ConstructCrab.constructRightCrab(5, 1, CRAB_LOC_2[0], CRAB_LOC_2[1]));
    
    System.out.println("## Created Scene ##" + testList.get("Beach").toString() + "\n");
  }
  
  /**
   * Initial setup for beach minigame.
   */
  private static void beachMiniSetup() {
    testList.get("BeachMini").getSceneItems().add(ConstructCrab.constructRightCrab(5, 1, CRAB_LOC_3[0], CRAB_LOC_3[1]));
    testList.get("BeachMini").getSceneItems().add(ConstructCrab.constructCrab(5, 1, CRAB_LOC_4[0], CRAB_LOC_4[1]));
    
    System.out.println("## Created Scene ##" + testList.get("BeachMini").toString() + "\n");
  }
  
  /**
   * Initial setup for wetland scene.
   */
  private static void wetlandSetup() {
    // Weed
    testList.get("Wetland").getSceneItems().add(ConstructVegetation.constructVegetation(5, 2, WEED_LOC_1[0], WEED_LOC_1[1]));
    
    // Right Heron
    testList.get("Wetland").getSceneItems().add(ConstructHeron.constructRightHeron(5, 0, HERON_LOC_1[0], HERON_LOC_1[1], true, true));
    testList.get("Wetland").getSceneItems().add(ConstructHeron.constructRightHeron(5, 1, HERON_LOC_2[0], HERON_LOC_2[1], false, true));
    
    // Left Heron
    testList.get("Wetland").getSceneItems().add(ConstructHeron.constructLeftHeron(5, 0, HERON_LOC_3[0], HERON_LOC_3[1], true, false));
    testList.get("Wetland").getSceneItems().add(ConstructHeron.constructLeftHeron(5, 1, HERON_LOC_4[0], HERON_LOC_4[1], false, false));
    
    System.out.println("## Created Scene ##" + testList.get("Wetland").toString() + "\n");
  }
}
