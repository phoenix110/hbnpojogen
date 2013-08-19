package com.nxsystems.nxpay;

import org.junit.Assert;
import org.junit.Test;


import com.nxsystems.nxpay.wallet.model.*;
import com.nxsystems.nxpay.wallet.model.factories.*;
import com.nxsystems.nxpay.wallet.service.data.DataLayerWallet;
import com.nxsystems.nxpay.wallet.service.data.DataLayerWalletImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

/** Hibernate tester.
* @author autogenerated
*/
@SuppressWarnings("cast")
@ContextConfiguration(locations = { "/beans.database.xml" } )
@RunWith(SpringJUnit4ClassRunner.class)
public class DAOIntegrationTest {
		


	
	/**
	 * Hibernate test case for table: postgres.wallet.account.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testAccount() throws CloneNotSupportedException {

	 	DataLayerWallet dataLayerWallet = DataLayerWalletImpl.getInstance();
		Account account = WalletDataPoolFactory.getAccount();
		dataLayerWallet.saveOrUpdate(account);

		Integer accountId = account.getId();
		Account copy = account.clone();
		dataLayerWallet.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerWallet.evict(account); 		 

		account = dataLayerWallet.getAccount(accountId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		// null equals check
		Assert.assertFalse(copy.equals(null));
		
		Assert.assertEquals(copy.getBalance(), account.getBalance());
		Assert.assertEquals(copy.getNumber(), account.getNumber());
		// tests for coverage completeness
		Assert.assertFalse(account.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		// symmetric equality check
		Assert.assertEquals(copy.clone(), copy);
		// reflexive equality check
		Assert.assertEquals(copy, copy);
		// hashcode on identical object should return same number
		Assert.assertEquals(account.hashCode(), copy.hashCode());  
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}
	/**
	 * Hibernate test case for table: postgres.wallet.client.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testClient() throws CloneNotSupportedException {

	 	DataLayerWallet dataLayerWallet = DataLayerWalletImpl.getInstance();
		Client client = WalletDataPoolFactory.getClient();
		dataLayerWallet.saveOrUpdate(client);

		Integer clientId = client.getId();
		Client copy = client.clone();
		dataLayerWallet.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerWallet.evict(client); 		 

		client = dataLayerWallet.getClient(clientId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		// null equals check
		Assert.assertFalse(copy.equals(null));
		
		Assert.assertEquals(copy.getApiKey(), client.getApiKey());
		Assert.assertTrue(copy.getRoles().equals(client.getRoles()));
		Assert.assertEquals(copy.getName(), client.getName());
		// tests for coverage completeness
		Assert.assertFalse(client.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		// symmetric equality check
		Assert.assertEquals(copy.clone(), copy);
		// reflexive equality check
		Assert.assertEquals(copy, copy);
		// hashcode on identical object should return same number
		Assert.assertEquals(client.hashCode(), copy.hashCode());  
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}
	/**
	 * Hibernate test case for table: postgres.wallet.role.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testRole() throws CloneNotSupportedException {

	 	DataLayerWallet dataLayerWallet = DataLayerWalletImpl.getInstance();
		Role role = WalletDataPoolFactory.getRole();
		dataLayerWallet.saveOrUpdate(role);

		Integer roleId = role.getId();
		Role copy = role.clone();
		dataLayerWallet.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerWallet.evict(role); 		 

		role = dataLayerWallet.getRole(roleId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		// null equals check
		Assert.assertFalse(copy.equals(null));
		
		Assert.assertTrue(copy.getClients().equals(role.getClients()));
		Assert.assertEquals(copy.getDescription(), role.getDescription());
		Assert.assertEquals(copy.getName(), role.getName());
		// tests for coverage completeness
		Assert.assertFalse(role.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		// symmetric equality check
		Assert.assertEquals(copy.clone(), copy);
		// reflexive equality check
		Assert.assertEquals(copy, copy);
		// hashcode on identical object should return same number
		Assert.assertEquals(role.hashCode(), copy.hashCode());  
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}



}

