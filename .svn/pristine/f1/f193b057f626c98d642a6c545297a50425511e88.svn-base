package com.daweda.services;

import com.daweda.model.AlternativeTradeArenaRecord;
import com.daweda.model.Statistics;
import com.daweda.model.StatisticsBarsChart;
import com.daweda.model.TradeArenaRecord;
import com.daweda.model.entity.Status;
import com.daweda.model.entity.TradeOrder;
import com.daweda.model.entity.User;

import java.util.Date;
import java.util.List;

/**
* Created by elena on 20.02.15.
*/
public interface OrderService {

    public long insert(TradeOrder tradeOrder);

    public List<TradeOrder> findByPosition(String position);

    public List<TradeOrder> findByStatus(Status status);

    public List<TradeOrder> findByUser(User user);

    public List<TradeOrder> findByPrice(double price);

    public List<Double> findUniquePricesForAssetAndPosition(String assetName,
                                                            String position);
     //Returns
    public List<List<TradeArenaRecord>> loadTradeArenaTable(String assetName);

    public List<TradeOrder> findCurrentOrders();

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

    List<TradeOrder> findCurrentOrdersByAssetName(String assetName);

    List<TradeOrder> findPendingByUserForManaging(User user, Date startDate, Date endDate);

    List<TradeOrder> findOpenedByUserForManaging(User user, Date startDate, Date endDate);

    List<TradeOrder> findClosedByUserForManaging(User user, Date startDate,
                                                 Date endDate);

    List<TradeOrder> findCurrentByUser(User user);

    List<TradeOrder> findClosedByUser(User user);

    Statistics getStatisticsForUserByAsset(User user, String assetName);

    int getAcountProfitAndLoseForUser(User user);

    int getLiveProfitAndLoseForUser(User user);

    List<TradeOrder> findClosedForUserByAsset(User user, String assetName);

    List<TradeOrder> findCurrentForUserByAsset(User user, String assetName);

    Statistics getStatisticsForUser(User user);

    List<TradeOrder> findClosedForUserByAssetForLastMonth(User user,
                                                          String assetName);

    List<TradeOrder> findClosedForUserForLastMonth(User user);

    List<StatisticsBarsChart> getStatisticsForBarsChart(User user);

    List<StatisticsBarsChart> getStatisticsForBarsChart(User user, String assetName);


    int getPendingUnitsAmountForAssetTopPrice(String assetName, String position);

    long getUnitsAmountForUserByAsset(User user, String assetName);

    List<Double> findUniquePricesForAssetSell(String assetName);

    List<Double> findUniquePricesForAssetBuy(String assetName);

    List<AlternativeTradeArenaRecord> loadAlternativeTradeArenaTable(
            String assetName);

    String findPositionWhereMaxPendingUnitsForAssetByPrice(String assetName, double price);

    boolean addOrderFullCover(TradeOrder newOrder) throws Exception;

    List<TradeOrder> findPendingOrdersByAssetPositionPriceSellLessBuyAbove(
            String assetName, String position, double price);

    void endTimeIntervalByDeal(String assetName, double newPrice) throws Exception;

    void coverOrders(TradeOrder newOrder, List<TradeOrder> pendingOrders)
            throws Exception;
}
