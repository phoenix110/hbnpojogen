package com.nxsystems.nxpay.wallet.model.iface;
import com.nxsystems.nxpay.wallet.model.Account;
import com.nxsystems.nxpay.wallet.model.Role;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: client.
 * @author autogenerated
 */

public interface IClient {



    /**
     * Return the value associated with the column: account.
	 * @return A Set&lt;Account&gt; object (this.account)
	 */
	Set<Account> getAccounts();
	
	/**
	 * Adds a bi-directional link of type Account to the accounts set.
	 * @param account item to add
	 */
	void addAccount(Account account);

  
    /**  
     * Set the value related to the column: account.
	 * @param account the account value you wish to set
	 */
	void setAccounts(final Set<Account> account);

    /**
     * Return the value associated with the column: apiKey.
	 * @return A String object (this.apiKey)
	 */
	String getApiKey();
	

  
    /**  
     * Set the value related to the column: apiKey.
	 * @param apiKey the apiKey value you wish to set
	 */
	void setApiKey(final String apiKey);

    /**
     * Return the value associated with the column: role.
	 * @return A Set&lt;Role&gt; object (this.role)
	 */
	Set<Role> getRoles();
	
	/**
	 * Adds a bi-directional link of type Role to the set.
	 * @param role item to add
	 */
	void addRole(Role role);

  
    /**  
     * Set the value related to the column: role.
	 * @param role the role value you wish to set
	 */
	void setRoles(final Set<Role> role);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	String getName();
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	void setName(final String name);

	// end of interface
}