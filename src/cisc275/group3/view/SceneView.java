package cisc275.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Takes in an underlying JPanel and overlays the
 * user interface via JLayeredPanes. There are 
 * different constructors that accommodate different
 * layer requirements.
 * <p>
 * SceneView.java
 * <p>
 * @author Scott
 */
@SuppressWarnings("serial")
public class SceneView extends JPanel {
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  private final SceneLayer SCENE_LAYER;
  
  private JButton mapButton;
  private JButton toolButton;
  private JLabel timeLabel;
  private JLabel scoreLabel;
  private JLayeredPane layeredPane;
  private JToolBar lowerLeftBar;
  private JToolBar scoreBar;
  private JToolBar toolBar;
  private int score;
  private int time;
  
  /**
   * Constructor for untimed and unscored models that still
   * require an interface menu.
   * @param w		int-width
   * @param h		int-height
   * @param panel	JPanel-panel background layer
   */
  public SceneView(int w, int h, JPanel panel) {
    super();
    this.setDoubleBuffered(true);
    
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    SCENE_LAYER = null;
    
    panel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    createLowerLeftBar();
    createToolbox();
 
    layeredPane = new JLayeredPane();
    layeredPane.setDoubleBuffered(true);
    layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(lowerLeftBar, JLayeredPane.MODAL_LAYER);
    layeredPane.add(toolBar, JLayeredPane.MODAL_LAYER);
    layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    add(layeredPane);
  }
  
  /**
   * Constructor for timed, but unscored models
   * @param w	int-width
   * @param h	int-height
   * @param sl	SceneLayer-background
   * @param t	int-time
   */
  public SceneView(int w, int h, SceneLayer sl, int t) {
    super();
    this.setDoubleBuffered(true);
    
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    SCENE_LAYER = sl;
	    
    time = t;
	    
    SCENE_LAYER.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    createLowerLeftBar();
    createToolbox();
	  
    layeredPane = new JLayeredPane();
    this.setDoubleBuffered(true);
    layeredPane.add(sl, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(lowerLeftBar, JLayeredPane.MODAL_LAYER);
    layeredPane.add(toolBar, JLayeredPane.MODAL_LAYER);
    layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    add(layeredPane);
  }
  
  /**
   * Constructor for both timed and scored models
   * @param w	int-width
   * @param h	int-height
   * @param sl	SceneLayer-background
   * @param s	int-score
   * @param t	int-time
   */
  public SceneView(int w, int h, SceneLayer sl, int s, int t) {
    super();
    this.setDoubleBuffered(true);
    
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    SCENE_LAYER = sl;
    
    score = s;
    time = t;
    SCENE_LAYER.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    createLowerLeftBar();
    createScoreBar();
    createToolbox();
  
    layeredPane = new JLayeredPane();
    layeredPane.setDoubleBuffered(true);
    layeredPane.add(sl, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(lowerLeftBar, JLayeredPane.MODAL_LAYER);
    layeredPane.add(scoreBar, JLayeredPane.MODAL_LAYER);
    layeredPane.add(toolBar, JLayeredPane.MODAL_LAYER);
    layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    add(layeredPane);
  }
  
  /**
   * Creates and places the score bar in the lower right
   * corner of the game window. The score is displayed
   * with a JLabel and an ImageIcon used as a decorator.
   */
  private void createScoreBar() {
    scoreLabel = new JLabel(Integer.toString(score),
    		                new ImageIcon("img/coins_icon.png"),
    		                JLabel.CENTER);
    scoreLabel.setFont(new Font("Roboto", Font.BOLD, 36));
    scoreLabel.setForeground(Color.black);
    scoreLabel.setFocusable(false);
    scoreLabel.setSize(200, 75);
    
    scoreBar = new JToolBar() {
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = scoreBar.getSize();
        g.drawImage((new ImageIcon("img/coins_bg.png")).getImage(), 0, 0, size.width, size.height, this);
      }
    };
    scoreBar.add(scoreLabel);
    scoreBar.setOpaque(false);
    scoreBar.setFloatable(false);
    scoreBar.setSize(150, 80);
    scoreBar.setBorder(null);
    scoreBar.setLocation(SCREEN_WIDTH-200, SCREEN_HEIGHT-90);
  }
  
  /**
   * Creates and places the lower left bar consisting of
   * the time and map JButtons. The map JButton toggles
   * whether the map layer is visible. The time is displayed
   * via a JLabel.
   */
  private void createLowerLeftBar() {
    mapButton = new JButton();
    mapButton.setBorderPainted(false);
    mapButton.setBorder(null);
    mapButton.setMargin(new Insets(0, 0, 0, 0));
    mapButton.setContentAreaFilled(false);
    mapButton.setIcon(new ImageIcon("img/map_icon.png"));
    mapButton.setRolloverIcon(new ImageIcon("img/map_icon_invert.png"));
    mapButton.setSize(75, 75);
	    
    timeLabel = new JLabel(Integer.toString(time), 
                           new ImageIcon("img/clock_icon.png"), 
                           JLabel.CENTER);
    timeLabel.setFont(new Font("Roboto", Font.BOLD, 36));
    timeLabel.setForeground(Color.black);
    timeLabel.setFocusable(false);
    timeLabel.setSize(200, 75);
	    
    lowerLeftBar = new JToolBar(){
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = lowerLeftBar.getSize();
        g.drawImage((new ImageIcon("img/upper_left_bg.png")).getImage(), 0, 0, size.width, size.height, this);
      }
    };
    lowerLeftBar.add(mapButton);
    lowerLeftBar.add(Box.createHorizontalGlue());
    lowerLeftBar.add(timeLabel);
    lowerLeftBar.setOpaque(false);
    lowerLeftBar.setFloatable(false);
    lowerLeftBar.setSize(250, 80);
    lowerLeftBar.setBorder(null);
    lowerLeftBar.setLocation(30, SCREEN_HEIGHT-90);
  }
 
  /**
   * Creates and places toolbox in the upper
   * right corner of the game window. Utilizes
   * a JButton with a background image to toggle
   * whether the toolbox is visible. 
   */
  private void createToolbox() {
    toolButton = new JButton();
    toolButton.setBorderPainted(false);
    toolButton.setBorder(null);
    toolButton.setMargin(new Insets(0, 0, 0, 0));
    toolButton.setContentAreaFilled(false);
    toolButton.setIcon(new ImageIcon("img/toolbox_menu.png"));
    toolButton.setRolloverIcon(new ImageIcon("img/toolbox_menu_invert.png"));
    toolButton.setSize(107, 40);
		    	    
    toolBar = new JToolBar();
    toolBar.add(toolButton);
    toolBar.setOpaque(false);
    toolBar.setFloatable(false);
    toolBar.setSize(107, 40);
    toolBar.setBorder(null);
    toolBar.setLocation(1100, 0);
  }
  
  /**
   * Updates the score label to the current score.
   * @param s	int-current score
   */
  public void updateScore(int s) {
    scoreLabel.setText(Integer.toString(s));
  }
  
  /**
   * Updates the time to the current time.
   * @param t int-current time
   */
  public void updateTime(int t) {
	  timeLabel.setText(Integer.toString(t));
  }
  
  /**
   * Returns pointer to the map button. Allows the 
   * controller to create the button action
   * @return the map JButton
   */
  public JButton getMapButton() {
    return mapButton;
  }
  
  /**
   * Returns pointer to the tool button. Allows the 
   * controller to create the button action
   * @return the tool JButton
   */
  public JButton getToolButton() {
    return toolButton;
  }
}
