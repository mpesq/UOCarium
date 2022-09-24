package edu.uoc.uocarium.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Class KeeperTest per comprovar el funcionament correcte de Keeper
 * amb Junit
 * 
 */


class KeeperTest {

	/**
	 * testSetId
	 * @throws NullPointerException
	 * @throws KeeperException
	 */
	@Test
	void testSetId() throws NullPointerException, KeeperException {
		/**
		 * Creem una instancia Keeper i fem la comprovació de id amb el mètode assertEquals
		 */
		
		Keeper instance = new Keeper("Geiou", "Marc", "Pesquera");
		assertEquals("Geiou",instance.getId()); 
		
		/**
		 * Creem una instancia NullpointerException i fem una assertEquals per comparar els missatges.
		 */
		
		NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> instance.setId(null));
		assertEquals(null,nullPointerException.getMessage());
		
		/**
		 * Creem instancies de KeeperException i comparem amb assertEquals
		 */
		
		KeeperException keeperException = assertThrows(KeeperException.class, () -> instance.setId("H1223"));
		assertEquals("[ERROR] A keeper's id must start with letter 'G'!!", keeperException.getMessage());
		KeeperException keeperException1 = assertThrows(KeeperException.class, () -> instance.setId("G12235"));
		assertEquals("[ERROR] A keeper's id must have 5 characters!!", keeperException1.getMessage());
	}

	/**
	 * testAddTank
	 * @throws NullPointerException
	 * @throws KeeperException
	 * @throws TankException
	 */
	@Test
	void testAddTank() throws NullPointerException, KeeperException, TankException {
		/**
		 * Creem una instancia Keeper
		 * Creem 5 instancies Tank diferents
		 */
		
		Keeper instance = new Keeper("Geiou", "Marc", "Pesquera");
		Tank tank0 = new Tank("D0", "Tank0", "Default", 300, 300, 300, "tank", 20, 7);
		Tank tank1 = new Tank("D1", "Tank1", "Default", 300, 300, 300, "tank", 20, 7);
		Tank tank2 = new Tank("D2", "Tank2", "Default", 300, 300, 300, "tank", 20, 7);
		Tank tank3 = new Tank("D3", "Tank3", "Default", 300, 300, 300, "tank", 20, 7);
		Tank tank4 = new Tank("D4", "Tank4", "Default", 300, 300, 300, "tank", 20, 7);
		Tank tank5 = new Tank("D5", "Tank5", "Default", 300, 300, 300, "tank", 20, 7);
		
		/**
		 * Fem múltiples addTank a la instancia de Keeper
		 * Fem més de 5 per comprovar que funciona.
		 */
		instance.addTank(tank0);
		instance.addTank(tank1);
		instance.addTank(tank2);
		instance.addTank(tank2);
		instance.addTank(tank2);
		instance.addTank(tank2);
		instance.addTank(tank2);
		instance.addTank(tank3);
		instance.addTank(tank4);
		
		/**
		 * Fem asserEquals per comprovar que són els tanks que hem creat els que estan
		 * dins l'array de Keeper
		 */
		
		assertEquals(instance.getTanks().get(0), tank0);
		assertEquals(instance.getTanks().get(1), tank1);
		assertEquals(instance.getTanks().get(2), tank2);
		assertEquals(instance.getTanks().get(3), tank3);
		assertEquals(instance.getTanks().get(4), tank4);
		
		/**
		 * Creem una instancia KeeperException i comparem els missatges amb assertEquals
		 */
		
		KeeperException keeperException = assertThrows(KeeperException.class, () -> instance.addTank(tank5));
		assertEquals("[ERROR] A keeper cannot take care of more than 5 tanks!!", keeperException.getMessage());
	}


}
