package com.daweda.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asset database table.
 * 
 */
@Entity
@Table(name="asset")
@NamedQuery(name="Asset.findAll", query="SELECT a FROM Asset a")
public class Asset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_asset", unique=true, nullable=false)
	private long idAsset;

    //abbreviation of asset
	@Column(nullable=false, length=10)
	private String abbr;

	@Column(name="is_active", nullable=false)
	private boolean isActive;

    //long variant of abbr (abbreviation)
	@Column(nullable=false, length=128)
	private String name;

	@Column(length=45)
	private String priority;

	//bi-directional many-to-one association to AssetPrice
	@OneToMany(mappedBy="asset")
	private List<AssetPrice> assetPrices;

	public Asset() {
	}

	public long getIdAsset() {
		return this.idAsset;
	}

	public void setIdAsset(long idAsset) {
		this.idAsset = idAsset;
	}

	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public List<AssetPrice> getAssetPrices() {
		return this.assetPrices;
	}

	public void setAssetPrices(List<AssetPrice> assetPrices) {
		this.assetPrices = assetPrices;
	}

	public AssetPrice addAssetPrice(AssetPrice assetPrice) {
		getAssetPrices().add(assetPrice);
		assetPrice.setAsset(this);

		return assetPrice;
	}

	public AssetPrice removeAssetPrice(AssetPrice assetPrice) {
		getAssetPrices().remove(assetPrice);
		assetPrice.setAsset(null);

		return assetPrice;
	}

}