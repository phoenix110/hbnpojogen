package com.nxsystems.nxpay.wallet.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.nxsystems.nxpay.wallet.model.iface.IAccount;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: account.
 * @author autogenerated
 */

@Entity
@Table(name = "account", catalog = "postgres", schema = "wallet")
public class Account implements Cloneable, Serializable, IPojoGenEntity, IAccount {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559017110L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private java.math.BigDecimal balance;
	/** Field mapping. */
	private Client client;
	/** Field mapping. */
	private Integer id = 0; // init for hibernate bug workaround
	/** Field mapping. */
	private String number;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Account() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Account(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param balance java.math.BigDecimal object;
	 * @param client Client object;
	 * @param id Integer object;
	 * @param number String object;
	 */
	public Account(java.math.BigDecimal balance, Client client, Integer id, 					
			String number) {

		this.balance = balance;
		this.client = client;
		this.id = id;
		this.number = number;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Account.class;
	}
 

    /**
     * Return the value associated with the column: balance.
	 * @return A java.math.BigDecimal object (this.balance)
	 */
	@Basic( optional = false )
	@Column( nullable = false  )
	public java.math.BigDecimal getBalance() {
		return this.balance;
		
	}
	

  
    /**  
     * Set the value related to the column: balance.
	 * @param balance the balance value you wish to set
	 */
	public void setBalance(final java.math.BigDecimal balance) {
		this.balance = balance;
	}

    /**
     * Return the value associated with the column: client.
	 * @return A Client object (this.client)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "client_id", nullable = false )
	public Client getClient() {
		return this.client;
		
	}
	

  
    /**  
     * Set the value related to the column: client.
	 * @param client the client value you wish to set
	 */
	public void setClient(final Client client) {
		this.client = client;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountIdGenerator")
	@Basic( optional = false )
	@Column( name = "id", nullable = false  )
	@SequenceGenerator(name="accountIdGenerator", sequenceName="postgres.wallet.account_id_seq")
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
     * Return the value associated with the column: number.
	 * @return A String object (this.number)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 16  )
	public String getNumber() {
		return this.number;
		
	}
	

  
    /**  
     * Set the value related to the column: number.
	 * @param number the number value you wish to set
	 */
	public void setNumber(final String number) {
		this.number = number;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Account clone() throws CloneNotSupportedException {
		
        final Account copy = (Account)super.clone();

		copy.setBalance(this.getBalance());
		copy.setClient(this.getClient());
		copy.setId(this.getId());
		copy.setNumber(this.getNumber());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("balance: " + this.getBalance() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("number: " + this.getNumber());
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
		
		final Account that; 
		try {
			that = (Account) proxyThat;
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
		result = result && (((getBalance() == null) && (that.getBalance() == null)) || (getBalance() != null && getBalance().equals(that.getBalance())));
		result = result && (((getClient() == null) && (that.getClient() == null)) || (getClient() != null && getClient().getId().equals(that.getClient().getId())));	
		result = result && (((getNumber() == null) && (that.getNumber() == null)) || (getNumber() != null && getNumber().equals(that.getNumber())));
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
