package edu.uoc.uocarium.model;

/**
 * Class Danio subclasse de Fish
 * @author marcp
 *
 */

public class Danio extends Fish{
	
	/**
	 * Constructor amb arguments
	 * @param xCoord
	 * @param yCoord
	 * @param gender
	 * @param age
	 * @param speed
	 * @param energy
	 * @param tank
	 * @throws AnimalException Quan age �s negatiu, 
	 * quan energy no est� entr 0 i 100, quan energy �s 0 i es vol modificar
	 *  i quan �s passa del limit d'energy a i posa el limit 
	 * @throws ItemException Quan els valors de length o height s�n negatius.
	 * @throws MovableException Quan speed �s 0 o negatiu i quan thresholdReverse no est� entre 0 i 1
	 */

	public Danio(double xCoord, double yCoord, Gender gender, int age, double speed, int energy,
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, yCoord, "./images/danio/danio", 64, 64, gender, age, 1, 0.2, 0.002, Color.BRONZE, energy, tank);
		
	}
	
	/**
	 * getOxygenConsumption
	 * @return 12
	 */

	@Override
	public int getOxygenConsumption() {
		return 12;
	}
	
	/**
	 * breathe
	 */

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		
	}
	
	/**
     *  Override String method.
     *  @return A String with danio's information.
     **/
	@Override
    public String toString(){
       return super.toString()+ " : Danio\n";
    }

}
