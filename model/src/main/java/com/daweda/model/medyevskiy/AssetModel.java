package com.daweda.model.medyevskiy;

public class AssetModel {

	private AssetListModel assetListModel;
	private AssetYahooQuoteModel assetYahooQuoteModel;
	private AssetUnitPriceModel assetUnitPriceModel;
	
	//private int decimalsCount;
	
	

	
	
	public AssetModel(AssetListModel assetListModel,
			AssetYahooQuoteModel assetYahooQuoteModel,
			AssetUnitPriceModel assetUnitPriceModel) {
		super();
		this.assetListModel = assetListModel;
		this.assetYahooQuoteModel = assetYahooQuoteModel;
		this.assetUnitPriceModel = assetUnitPriceModel;
		//this.decimalsCount = decimalsCount;
	}



	public AssetModel() {
		super();
	}


	
	/*public int getDecimalsCount() {
		return decimalsCount;
	}



	public void setDecimalsCount(int decimalsCount) {
		this.decimalsCount = decimalsCount;
	}*/



	public AssetListModel getAssetListModel() {
		return assetListModel;
	}

	public void setAssetListModel(AssetListModel assetListModel) {
		this.assetListModel = assetListModel;
	}

	public AssetYahooQuoteModel getAssetYahooQuoteModel() {
		return assetYahooQuoteModel;
	}

	public void setAssetYahooQuoteModel(AssetYahooQuoteModel assetYahooQuoteModel) {
		this.assetYahooQuoteModel = assetYahooQuoteModel;
	}

	public AssetUnitPriceModel getAssetUnitPriceModel() {
		return assetUnitPriceModel;
	}

	public void setAssetUnitPriceModel(AssetUnitPriceModel assetUnitPriceModel) {
		this.assetUnitPriceModel = assetUnitPriceModel;
	}
	
	
}
