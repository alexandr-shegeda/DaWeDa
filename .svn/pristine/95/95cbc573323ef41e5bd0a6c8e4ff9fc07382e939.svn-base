package com.daweda.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	private long id;

	@Column(name="email", nullable=false, length=128)
	private String email;

	@Column(name="is_activated")
	private boolean isActivated;

    //change password allowed
	@Column(name="is_change_pwd_allowed")
	private boolean isChangePwdAllowed;

    //is manually created password or system generated
	@Column(name="is_user_password")
	private boolean isUserPassword;

	@Column(name="password", nullable=false, length=20)
	private String password;

	@Column(name="token", length=128)
	private String token;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinColumn(name="account_id", nullable=false)
	private Account account;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinColumn(name="user_details_id", nullable=false)
	private UserDetails userDetails;

//	//bi-directional many-to-one association to Order
//	@OneToMany(mappedBy="user")
//	private List<TradeOrder> tradeOrders;

	public User() {
	}
	
	public User(String email, boolean isActivated,
			String password, boolean isUserPassword, String token, boolean isChangePwdAllowed, UserDetails userDetails, Account account) {
		super();		
		this.email = email;
		this.isActivated = isActivated;
		this.password = password;
		this.isUserPassword = isUserPassword;
		this.token = token;
		this.isChangePwdAllowed = isChangePwdAllowed;
		this.userDetails = userDetails;
		this.account = account;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActivated() {
		return this.isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean getIsChangePwdAllowed() {
		return this.isChangePwdAllowed;
	}

	public void setIsChangePwdAllowed(boolean isChangePwdAllowed) {
		this.isChangePwdAllowed = isChangePwdAllowed;
	}

	public boolean getIsUserPassword() {
		return this.isUserPassword;
	}

	public void setIsUserPassword(boolean isUserPassword) {
		this.isUserPassword = isUserPassword;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}