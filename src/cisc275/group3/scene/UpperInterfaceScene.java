package cisc275.group3.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;
import cisc275.group3.sceneobjects.ToolObject;

public class UpperInterfaceScene extends Scene {		
	
	protected ArrayList<SceneObject> interface_items;
	protected ArrayList<SceneObject> nav_items;

	public UpperInterfaceScene(int width, String name) {
		super(0, 0, width, INTERFACE_HEIGHT, name);
		this.scene_background_color = Color.darkGray;
	
		nav_items = new ArrayList<SceneObject>();
		this.nav_items.add(new NavObject(5, 5, 100, 30, "HQ"));
		this.nav_items.add(new NavObject(5, 40, 100, 30, "Bay"));
		this.nav_items.add(new NavObject(110, 5, 100, 30, "Beach"));
		this.nav_items.add(new NavObject(110, 40, 100, 30, "Wetlands"));
		this.nav_items.add(new NavObject(215, 7, 100, 60, "Map"));
		this.nav_items.add(new NavObject(1005, 5, 100, 30, "Net"));
		this.nav_items.add(new NavObject(1005, 40, 100, 30, "Camera"));
		this.nav_items.add(new NavObject(895, 5, 100, 30, "Trimmer"));
		this.nav_items.add(new NavObject(895, 40, 100, 30, "Sample"));
		this.nav_items.add(new NavObject(this.scene_width-160, 7, 150, 60, "Inventory" ));
	}

	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void drawScene(Graphics g) {
        g.setColor(this.scene_background_color);
        g.fillRect(0, 0, this.scene_width, INTERFACE_HEIGHT);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 42));
		g.drawString("Estuary Click Adventure!",(this.scene_width/2)-g.getFontMetrics().stringWidth("Estuary Click Adventure!")/2,50);
				
		nav_items.forEach((item)->{
			item.drawItem(g);
		});

    }
	
	public String navClick(int click_x, int click_y) {		
		for (SceneObject nav : nav_items ) {
			if (nav.itemClicked(click_x, click_y)) {
				if (((NavObject)nav).navClick().equals("Net") || ((NavObject)nav).navClick().equals("Camera") 
						|| ((NavObject)nav).navClick().equals("Trimmer") || ((NavObject)nav).navClick().equals("Sample")) 
				{
					if (((NavObject)nav).getColor() == Color.black) {
						((NavObject)nav).setColorFill(Color.green);
						for (SceneObject tmpNav : nav_items ) {
							if ((((NavObject)tmpNav).navClick().equals("Net") || ((NavObject)tmpNav).navClick().equals("Camera")
									|| ((NavObject)tmpNav).navClick().equals("Trimmer") || ((NavObject)tmpNav).navClick().equals("Sample")) 
									&& !((NavObject)tmpNav).navClick().equals(((NavObject)nav).navClick())) {
								((NavObject)tmpNav).setColorFill(Color.black);
							}
						}
					} else {
						((NavObject)nav).setColorFill(Color.black);
					}
				}
				return ((NavObject)nav).navClick();
			}
		}
		
		return null;
	}

}
