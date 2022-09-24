package edu.uoc.uocarium.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;

public abstract class Item extends ImageView{

	private static int nextId = 0;
	private double xCoord, yCoord; //location
	private double length, height; // define size of item
	protected String spriteImage;
	private Tank tank;
	private List<String> idKeeper;
	
	protected Item(double xCoord, double yCoord, String spriteImage, double length, double height, Tank tank) throws ItemException {
		setId("I"+nextId); 
		nextId++;
		
		setLocation(xCoord,yCoord);
		setSpriteImage(spriteImage);		
		setLength(length);
		setHeight(height);		
//		setEnergy(energy);
		setTank(tank);
		idKeeper = new ArrayList<String>();		//Array de id de cuidadors que té el item

	}

	/**
	 * Set this item's location.
	 * 
	 * @param xCoord the column coordinate.
	 * @param yCoord the row coordinate.
	 */
	public void setLocation(double xCoord, double yCoord) {
		setTranslateX(getXCoord());
		setTranslateY(getYCoord());
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public double getXCoord() {
		return xCoord;
	}
	
	public double getYCoord() {
		return yCoord;
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) throws ItemException{
		if(length<=0) {
			throw new ItemException(ItemException.MSG_ERR_LENGTH_VALUE);
		}
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws ItemException{
		if(height<=0) {
			throw new ItemException(ItemException.MSG_ERR_HEIGHT_VALUE);
		}
		this.height = height;
	}
		
	public void setSpriteImage(String spriteImage) {
		setImage(new Image("file:"+spriteImage));
		this.spriteImage = spriteImage;
	}
	
	public String getSpriteImage() {		
		return spriteImage;
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank){
		if(tank!=null) {
			if(!tank.getItems().contains(this)) {
					tank.getItems().add(this);
			}
		}
		
		if(this.tank!=null && this.tank!=tank) {
			try{
				this.tank.removeItem(this);
			}catch(Exception e) {
				//removeItem: El item no existe ya en el tanque
			}
		}
				
		this.tank = tank;
	}
	 /**
	  * getIdKeeper
	  * @return llista de referencies de cuidadors que té l'item
	  */
	
	public List<String> getIdKeeper() {
		return idKeeper;
	}
	
	/**
	 * setIdKeeper
	 * afegeix a l'array de referències de cuidadors de l'item la referència
	 * passada per paràmetre
	 */
	
	public void setIdKeeper(String idKeeper)	{
		getIdKeeper().add(idKeeper);
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("(" + getXCoord() +",  "+ getYCoord() +") ");
		/*
		str.append(getId() + " ");
		str.append(getLength() + " ");
		str.append(getHeight() + " ");
		str.append((getTank()!=null)?getTank().getName():"No tank");
		*/
		return str.toString();
	}


}
