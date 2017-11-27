package cisc275.group3.utility;

import java.awt.Color;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;

public class Mission {
	private String targetObject;
	private String objectName;
	private int objectNum;
	private int objectNumFinal;// Passed to the remove function, since decreaseNum() always decrements we need to set and not change objectNumFinal
	private boolean doneMission;
	
	public Mission(String o, int num) {
		targetObject = o;
		objectNum = num;
		objectNumFinal = num;
		objectName = "";
		doneMission = false;
	}
	
	public void decreaseNum() {
		objectNum--;
	}

	public String getTargetObject() {
		return targetObject;
	}
	
	public void setTargetObject(String o) {
		targetObject = o;
	}
	
	public int getObjectNum() {
		return objectNum;
	}
	
	public void setObjectNum(int i) {
		objectNum = i;
	}
	
	public String getObjectName() {
		return objectName;
	}
	
	public void setObjectName(String n) {
		objectName = n;
	}

	public boolean isDoneMission() {
		return doneMission;
	}

	public void setDoneMission(boolean doneMission) {
		this.doneMission = doneMission;
	}
	
	public int getTotalObjectNum()
	{
		return objectNumFinal;
	}
	
	public String toString() {
		if (doneMission) {
			return "Completed!";
		}
		
		if (targetObject == null) {
			return "None";
		}
		
		String s = objectNum + " ";
    
		if (targetObject.equals("BetaFish")) {
			if (objectName.equals("")) {
				s += "BetaFish";
			} else {
				s += objectName;
			}
		} else if (targetObject.equals("BetaCrab")) {
			if (objectName.equals("")) {
				s += "BetaCrab";
			} else {
				s += objectName;
			}
		} else if (targetObject.equals("BetaVegetation")) {
			if (objectName.equals("")) {
				s += "BetaVegetation";
			} else {
				s += objectName;
			}
		} else if (targetObject.equals("BetaHeron")) {
			if (objectName.equals("")) {
				s += "BetaHeron";
			} else {
				s += objectName;
			}
		}
		return s;
	}
}
