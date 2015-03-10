package com.daveda.repository.dao;

import com.daweda.model.entity.Status;
import com.daweda.model.entity.TradeOrder;
import com.daweda.model.entity.User;

import java.util.Date;
import java.util.List;

public interface OrderDAO extends AbstractDAO<TradeOrder>{

	public long insert(TradeOrder tradeOrder);

	public List<TradeOrder> findByPosition(String position);

	public List<TradeOrder> findByStatus(Status status);

	public List<TradeOrder> findByUser(User user);

	public List<TradeOrder> findByPrice(double price);

	public List<Double> findUniquePricesForAssetAndPosition(String assetName,
                                                            String position);

	public List<TradeOrder> findCurrentOrders();
	
	public List<TradeOrder> findCurrentOrdersByAssetName(String assetName);
	
	
	public boolean isSamePriceExist(double price);

	public int findUnitsAmountByPosition(String assetName, String position);

	public double findMaxPriceByPositionForAsset(String position, String assetName);
	
	public double findMinPriceByPositionForAsset(String position, String assetName);

	public boolean updateOrder(TradeOrder tradeOrder);

	int findUnitsAmountByPrice(String assetName, double price, String position);

	List<TradeOrder> findCurrentOrdersByPriceForAssetAndPosition(String assetName,
                                                                 double price);
	
	boolean addOrder(TradeOrder newOrder) throws Exception;

	void endTimeInterval(String assetName, double newPrice);
	
	List<TradeOrder> findCurrentOrdersByAssetForChart(String assetName);
	
	List<TradeOrder> findPendingByUserForManaging(User user, Date startDate, Date endDate);
	
	List<TradeOrder> findOpenedByUserForManaging(User user, Date startDate, Date endDate);
	
	List<TradeOrder> findClosedByUserForManaging(User user, Date startDate,
                                                 Date endDate);
	
	List<TradeOrder> findCurrentByUser(User user);
	
	List<TradeOrder> findClosedByUser(User user);

	List<TradeOrder> findClosedForUserByAsset(User user, String assetName);

	List<TradeOrder> findCurrentForUserByAsset(User user, String assetName);

	List<TradeOrder> findClosedForUserByAssetForLastMonth(User user,
                                                          String assetName);

	List<TradeOrder> findClosedForUserForLastMonth(User user);

	int getPendingUnitsAmountForAssetTopPrice(String assetName, String position);
	
	long getUnitsAmountForUserByAsset(User user, String assetName);

	List<Double> findUniquePricesForAssetSell(String assetName);

	List<Double> findUniquePricesForAssetBuy(String assetName);

	String findPositionWhereMaxPendingUnitsForAssetByPrice(String assetName,
                                                           double price);

	boolean addOrderFullCover(TradeOrder newOrder) throws Exception;

	List<TradeOrder> findPendingOrdersByAssetPositionPriceSellLessBuyAbove(String assetName, String position, double price);

	void endTimeIntervalByDeal(String assetName, double newPrice) throws Exception;
	
	List<TradeOrder> findPendingByAsset(String assetName);

	void coverOrders(TradeOrder newOrder, List<TradeOrder> pendingOrders)
			throws Exception;
}
