package edu.uoc.uocarium.model;

/**
 * Class KeeperException
 * @author marcp
 *
 */

public class KeeperException extends Exception {
	
	/**
	 * Atributs de KeeperException que són els misstatges d'excepció
	 */

	public final static String MSG_ERR_ID_STARTS = "[ERROR] A keeper's id must start with letter 'G'!!";	
	public final static String MSG_ERR_ID_LENGTH = "[ERROR] A keeper's id must have 5 characters!!";	
	public final static String MSG_ERR_NUM_TANKS = "[ERROR] A keeper cannot take care of more than 5 tanks!!";	

	/**
	 * Constructor per defecte de KeeperException
	 */
	
	public KeeperException() {
		super();
	}
	
	/**
	 * Constructor amb arguments de KeeperException
	 */
	
	public KeeperException(String msg) {
		super(msg);
	}

}
