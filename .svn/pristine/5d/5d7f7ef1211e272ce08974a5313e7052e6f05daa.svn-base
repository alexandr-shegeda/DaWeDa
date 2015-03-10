package com.daweda.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the asset_price database table.
 * 
 */
@Entity
@Table(name="asset_price")
@NamedQuery(name="AssetPrice.findAll", query="SELECT a FROM AssetPrice a")
public class AssetPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_asset_price", unique=true, nullable=false)
	private long idAssetPrice;

	@Column(nullable=false)
	private float price;

	@Column(nullable=false)
	private Timestamp time;

    //remove bidirectional mapping
	//bi-directional many-to-one association to Asset
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="asset_id", nullable=false)
	private Asset asset;

	public AssetPrice() {
	}

	public long getIdAssetPrice() {
		return this.idAssetPrice;
	}

	public void setIdAssetPrice(long idAssetPrice) {
		this.idAssetPrice = idAssetPrice;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Asset getAsset() {
		return this.asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

}