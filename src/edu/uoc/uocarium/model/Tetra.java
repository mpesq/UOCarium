package edu.uoc.uocarium.model;

/**
 * Class Tetra subclasse de Fish
 * @author marcp
 *
 */

public class Tetra extends Fish {
	
	/**
	 * Constructor amb arguments
	 * @param xCoord
	 * @param yCoord
	 * @param gender
	 * @param age
	 * @param speed
	 * @param energy
	 * @param tank
	 * @throws AnimalException Quan age és negatiu, 
	 * quan energy no està entr 0 i 100, quan energy és 0 i es vol modificar
	 *  i quan és passa del limit d'energy a i posa el limit 
	 * @throws ItemException Quan els valors de length o height són negatius.
	 * @throws MovableException Quan speed és 0 o negatiu i quan thresholdReverse no està entre 0 i 1
	 */

	public Tetra(double xCoord, double yCoord, Gender gender, int age, double speed, int energy,
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, yCoord, "./images/tetra/tetra", 64, 64, gender, age, 0.5, 0.3, 0.002, Color.RED, energy, tank);
		
	}
	
	/**
	 * getOxygenConsumption
	 * @return 10
	 */

	@Override
	public int getOxygenConsumption() {
		return 10;
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
     *  @return A String with tetra's information.
     **/
	
	@Override
    public String toString(){
       return super.toString()+ " : Tetra\n";
    }

}
