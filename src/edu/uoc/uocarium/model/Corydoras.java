package edu.uoc.uocarium.model;

/**
 * Class Corydoras subclasse de Fish
 * @author marcp
 *
 */

public class Corydoras extends Fish {

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
	
	public Corydoras(double xCoord, double yCoord, Gender gender, int age, double speed, int energy,
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, yCoord, "./images/corydoras/corydoras", 64, 64, gender, age, 0.1, 0.5, 0.001, Color.BLUE, energy, tank);
		
	}
	
	/**
	 * getOxygenConsumption
	 * @return 18
	 */
	
	@Override
	public int getOxygenConsumption() {
		return 18;
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
     *  @return A String with corydora's information.
     **/
	
	@Override
    public String toString(){
       return super.toString()+ " : Corydoras\n";
    }

}
