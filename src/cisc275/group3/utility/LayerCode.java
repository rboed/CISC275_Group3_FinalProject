package cisc275.group3.utility;

/**
 * Defines layer/depth codes for the main JLayeredPane.
 * <p>
 * @author Scott
 */
public enum LayerCode {
  MainTop(20),
  Mission(12), MapButton(11), MapOverlay(10), MainMap(9), // Layers for Map + Game Only
  ToolsButton(8), ToolsOverlay(7), MainMapTools(5), // Layers for Map + Tools + Game
  TimeLabel(4), MainMapToolsTime(3), // Layers for Map + Tools + Time + Game 
  ScoreLabel(2), MissionLabel(1), MainAll(0), // Layers for Time + Score + Game with all the fixins
  Bay(-2), Beach(-3), BeachMini(-4), HQ(-6), Inventory(-7), // "Hidden" Layers
  Map(-9), Title(30), Tools(-11), Wetland(-13),  // "Hidden" Layers
  InventoryButton(13), InventoryOverlay(14);

  private final int code;
  
  LayerCode(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
