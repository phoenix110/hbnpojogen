package com.nxsystems.nxpay.wallet.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.nxsystems.nxpay.wallet.model.Account;
import com.nxsystems.nxpay.wallet.model.Role;
import com.nxsystems.nxpay.wallet.model.iface.IClient;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: client.
 * @author autogenerated
 */

@Entity
@Table(name = "client", catalog = "postgres", schema = "wallet")
public class Client implements Cloneable, Serializable, IPojoGenEntity, IClient {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559017109L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Set<Account> accounts = new HashSet<Account>();

	/** Field mapping. */
	private String apiKey;
	/** Field mapping. */
	private Set<Role> roles = new HashSet<Role>();

	/** Field mapping. */
	private Integer id = 0; // init for hibernate bug workaround
	/** Field mapping. */
	private String name;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Client() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Client(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param apiKey String object;
	 * @param id Integer object;
	 * @param name String object;
	 */
	public Client(String apiKey, Integer id, String name) {

		this.apiKey = apiKey;
		this.id = id;
		this.name = name;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Client.class;
	}
 

    /**
     * Return the value associated with the column: account.
	 * @return A Set&lt;Account&gt; object (this.account)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "client"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Account> getAccounts() {
		return this.accounts;
		
	}
	
	/**
	 * Adds a bi-directional link of type Account to the accounts set.
	 * @param account item to add
	 */
	public void addAccount(Account account) {
		account.setClient(this);
		this.accounts.add(account);
	}

  
    /**  
     * Set the value related to the column: account.
	 * @param account the account value you wish to set
	 */
	public void setAccounts(final Set<Account> account) {
		this.accounts = account;
	}

    /**
     * Return the value associated with the column: apiKey.
	 * @return A String object (this.apiKey)
	 */
	@Basic( optional = false )
	@Column( name = "api_key", nullable = false, length = 2147483647  )
	public String getApiKey() {
		return this.apiKey;
		
	}
	

  
    /**  
     * Set the value related to the column: apiKey.
	 * @param apiKey the apiKey value you wish to set
	 */
	public void setApiKey(final String apiKey) {
		this.apiKey = apiKey;
	}

    /**
     * Return the value associated with the column: role.
	 * @return A Set&lt;Role&gt; object (this.role)
	 */
	@ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }  )
	@JoinTable(
		name = "client_role",
		catalog = "postgres",
		schema = "wallet",
		joinColumns = {@JoinColumn(name = "client_id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	public Set<Role> getRoles() {
		return this.roles;
		
	}
	
	/**
	 * Adds a bi-directional link of type Role to the set.
	 * 
	 * @param role item to add
	 */
	public void addRole(Role role) {
		role.getClients().add(this);
		this.roles.add(role);
	}

  
    /**  
     * Set the value related to the column: role.
	 * @param role the role value you wish to set
	 */
	public void setRoles(final Set<Role> role) {
		this.roles = role;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdGenerator")
	@Basic( optional = false )
	@Column( name = "id", nullable = false  )
	@SequenceGenerator(name="clientIdGenerator", sequenceName="postgres.wallet.client_id_seq")
	public Integer getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 2147483647  )
	public String getName() {
		return this.name;
		
	}
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Client clone() throws CloneNotSupportedException {
		
        final Client copy = (Client)super.clone();

		if (this.getAccounts() != null) {
			copy.getAccounts().addAll(this.getAccounts());
		}
		copy.setApiKey(this.getApiKey());
		if (this.getRoles() != null) {
			copy.getRoles().addAll(this.getRoles());
		}
		copy.setId(this.getId());
		copy.setName(this.getName());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("apiKey: " + this.getApiKey() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Client that; 
		try {
			that = (Client) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getApiKey() == null) && (that.getApiKey() == null)) || (getApiKey() != null && getApiKey().equals(that.getApiKey())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Integer newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0) {
							newHashCode = getId();
						} else {

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode;
	}
	

	
}
