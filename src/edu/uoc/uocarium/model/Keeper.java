package edu.uoc.uocarium.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Keeper
 * @author marcp
 *
 */
public class Keeper {
	
	/**
	 * atributs
	 */

	private String id;
	private String name;
	private String surname;
	private List<Tank> tanks;

	
	/**
	 * Constructor amb arguments
	 * @throws KeeperException quan id no comença per 'G' o té més de 5 caracters
	 * @throws NullPointerException quan @param id és null
	 */
	
	public Keeper(String id, String name, String surname) throws NullPointerException, KeeperException	{
		setId(id);
		setName(name);
		setSurname(surname);
		tanks = new ArrayList<Tank>();
	}
	
	/**
	 * Getter de id
	 * @return id de Keeper
	 */
	
	public String getId() {
		return id;
	}
	
	/**
	 * Setter de id
	 * @param id
	 * @throws NullPointerException quan @param id és null
	 * @throws KeeperException
	 */
	
	public void setId(String id) throws NullPointerException, KeeperException {
		if(id == null) throw new NullPointerException();
		else if(id.charAt(0) != 'G') throw new KeeperException(KeeperException.MSG_ERR_ID_STARTS);
		else if(id.length() != 5) throw new KeeperException(KeeperException.MSG_ERR_ID_LENGTH);
		else this.id = id;
	}
	
	/**
	 * Getter de name
	 * @return name de Keeper
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Setter de name
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter de surname
	 * @return surname de Keeper
	 */
	
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Setter de surname
	 * @param surname
	 */
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Getter de l'array de Tanks de Keeper
	 * @return array de Tanks de Keeper
	 * A l'enunciat no ho demanava però m'ha semblat adient fer-lo, també l'utilitzo a addItem de Tank.
	 */
	
	public List<Tank> getTanks()	{
		return tanks;
	}
	
	/**
	 * addTank afegeix un Tank al array de Tanks de Keeper
	 * @param tank
	 * @throws KeeperException si ja té 5 Tanks assignats.
	 */
	
	public void addTank(Tank tank) throws KeeperException	{
		if(tanks.size() == 5) throw new KeeperException(KeeperException.MSG_ERR_NUM_TANKS);
		boolean tankIn = false;
		for(Tank tankfor : tanks)	{
			if(tankfor.getId() == tank.getId()) {
				tankIn = true;
			}
			
		}
		if(!tankIn)	{
			tanks.add(tank);
			for(Item item : tank.getItems())	{
				item.getIdKeeper().add(this.getId());
			}
		}
	}
	
	/**
	 * Override del mètode toString
	 */
	
	@Override
	public String toString()	{
		StringBuilder str = new StringBuilder("[" + getId() + "] ");
		str.append(getSurname() + ", " + getName() + ":");
		for(Tank tank : tanks)	{
			str.append("\n\t" + tank.getName());
		}
		return str.toString();
	}
	
}
