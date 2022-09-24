package edu.uoc.uocarium.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import edu.uoc.uocarium.model.Animal;
import edu.uoc.uocarium.model.AnimalException;
import edu.uoc.uocarium.model.AnimalStatus;
import edu.uoc.uocarium.model.Corydoras;
import edu.uoc.uocarium.model.Danio;
import edu.uoc.uocarium.model.Food;
import edu.uoc.uocarium.model.Gender;
import edu.uoc.uocarium.model.Item;
import edu.uoc.uocarium.model.ItemException;
import edu.uoc.uocarium.model.Keeper;
import edu.uoc.uocarium.model.Kelp;
import edu.uoc.uocarium.model.Movable;
import edu.uoc.uocarium.model.MovableException;
import edu.uoc.uocarium.model.SubmarineToy;
import edu.uoc.uocarium.model.Tank;
import edu.uoc.uocarium.model.TankException;
import edu.uoc.uocarium.model.Tetra;

public class UOCariumController {

	Database database;
	String tankSelected;
	
	public UOCariumController(String folderName) throws ItemException {
		database = new Database(folderName);
		tankSelected = (database.getTanks().size()!=0)? database.getTanks().get(0).getId():null;
	}
		
	public String getTankSelected() {
		return tankSelected;
	}
	
	public void setTankSelected(String tankSelected) {
		this.tankSelected = tankSelected;
	}

	/**
	 * getTanks
	 * @return tanks
	 * retorna una List dels tanks de database ordenada alfabeticament segons el id
	 */
	public List<Tank> getTanks(){
		List<Tank> tanks = database.getTanks();
		Collections.sort(tanks);	//el mètode sort utilitza el compareTo que hem sobreescrit a Tank
		return tanks;
	}
	
	public Tank getTank(String id) {
		return database.getTank(id);
	}
	
	/**
	 * getMovableItems
	 * Sé que el únic tipus d'Item que no implementa Movable és Kelp
	 * per això el codi del mètode.
	 * @return una List amb els items que implementen la interficie Movable.
	 */
	
	public List<Item> getMovableItems(){
		List<Item> items = database.getItems();
		List<Item> itemsToReturn = new ArrayList<Item>();
		for(Item item : items)	{
			if(!(item instanceof Kelp))	itemsToReturn.add(item);
		}
		return itemsToReturn;			
	}
	
	public List<Item> getItems(){		
		return database.getTank(getTankSelected()).getItems();
	}
	
	/**
	 * addFish
	 * afegeix un Fish nou al tank que retorna getTank
	 * creant els peixos pot ser que llenci aquestes excepcions:
	 * @throws AnimalException
	 * @throws ItemException
	 * @throws MovableException
	 * @throws TankException
	 */
	public void addFish()throws AnimalException, ItemException, MovableException, TankException {
		double aleatori = (int) new Random().nextInt(10);
		double xCoord = new Random().nextDouble()*300;
		double yCoord = new Random().nextDouble()*300;
		boolean gender = new Random().nextBoolean();
		Tank tank = getTank(getTankSelected());
		if(aleatori < 3)	{
			if(gender) tank.addItem(new Danio(yCoord, yCoord, Gender.MALE, 0, 0, 100, null));
			else  tank.addItem(new Danio(xCoord, yCoord, Gender.FEMALE, 0, 0, 100, null));
		}
		else if(aleatori >= 3 && aleatori < 6) {
			if(gender) tank.addItem(new Tetra(yCoord, yCoord, Gender.MALE, 0, 0, 100, null));
			else tank.addItem(new Tetra(yCoord, yCoord, Gender.FEMALE, 0, 0, 100, null));
		}		
		else {
			if(gender) tank.addItem(new Corydoras(yCoord, yCoord, Gender.MALE, 0, 0, 100, null));
			else tank.addItem(new Corydoras(yCoord, yCoord, Gender.FEMALE, 0, 0, 100, null));
		}
	}
	
	
	public SubmarineToy getSubmarineToy() {
		
		Optional<Item> op = database.getTank(getTankSelected()).getItems().stream().filter(p -> p instanceof SubmarineToy).findFirst();
		
		return op.isEmpty()?null:(SubmarineToy) op.get();			
				
	}
	
	public boolean isSubmarineToy() {
		return getSubmarineToy() != null;
	}
	
	/**
	 * toggleSubmarineToy
	 * Afegeix un SubmarineToy al tank que retorna getTank
	 * si ja hi ha un SubmarineToy, l'elimina i afegeig un de nou.
	 * Creant el SubmarineToy pot ser que llenci aquestes excepcions:
	 * @throws TankException
	 * @throws ItemException
	 * @throws MovableException
	 */
	
	public void toggleSubmarineToy() throws TankException, ItemException, MovableException{
		//TODO
		Tank tank = getTank(getTankSelected());
		Item itemToRemove = null;
		for(Item item : getItems())	{
			if(item instanceof SubmarineToy)	{
				itemToRemove = item;
			}
		}
		if(itemToRemove != null)	{
			tank.removeItem(itemToRemove);
			tank.addItem(new SubmarineToy(50, 50, 100, 50, null));
		}
		else	{
			tank.addItem(new SubmarineToy(50, 50, 100, 50, null));
		}
	}
	
	public String getTankInfo() {
		return getTank(getTankSelected()).toString();
	}
	
	/**
	 * removeDeadItems
	 * borra els items morts del tank que retorna el mètode getTank
	 * és casi igual que removeDeadItems de Tank però amb algunes diferencies.
	 * @return una llista amb els items a borrar.
	 */
	
	public List<Item> removeDeadItems(){
		Tank tank = getTank(getTankSelected());
		List<Item> deadItems = new ArrayList<Item>();
		
		//Guardamos en una lista auxiliar los items a borrar
		for(Item item : getItems()) {
			if(item instanceof Animal && ((Animal)item).getStatus() == AnimalStatus.DEAD) {
				deadItems.add(item);
			}
		}
		
		//Borramos los items con "removeItem"
		for(var deadItem : deadItems) {
			try {
				tank.removeItem(deadItem);
			} catch (TankException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deadItems;
	}
	
	public void feed() throws Exception {
		new Food((new Random()).nextInt(Movable.TANK_PANE_WIDTH-10),0,1,1,5,getTank(getTankSelected()));	
		
	}
	
	public List<Keeper> getKeepers(){
		return database.getKeepers();
	}
}
