//package com.daweda.services;
//
//import com.daveda.repository.dao.OrderDAO;
//import com.daweda.model.AlternativeTradeArenaRecord;
//import com.daweda.model.StatisticsBarsChart;
//import com.daweda.model.TradeArenaRecord;
//import com.daweda.model.WinsLoses;
//import com.daweda.model.entity.Status;
//import com.daweda.model.entity.TradeOrder;
//import com.daweda.model.entity.User;
//import org.apache.felix.scr.annotations.Reference;
//import org.apache.felix.scr.annotations.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
//* Created by elena on 20.02.15.
//*/
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    @Reference
//    private OrderDAO dao;
//
//    private static final String SELL_POSITION_NAME = "Sell";
//    private static final String BUY_POSITION_NAME = "Buy";
//
//    private static final int UNIT_COST = 25;
//    private static final int UNIT_FEE = 1;
//
//    public OrderServiceImpl(OrderDAO dao) {
//
//        this.dao = dao;
//    }
//
//    @Override
//    public List<List<TradeArenaRecord>> loadTradeArenaTable(String assetName) {
//        List<TradeArenaRecord> sellRecords = new LinkedList<TradeArenaRecord>();
//        List<TradeArenaRecord> buyRecords = new LinkedList<TradeArenaRecord>();
//        for (Double price : findUniquePricesForAssetAndPosition(assetName,
//                SELL_POSITION_NAME)) {
//            int unitsAmount = findUnitsAmountByPrice(assetName, price, SELL_POSITION_NAME);
//            TradeArenaRecord rec = new TradeArenaRecord(SELL_POSITION_NAME, unitsAmount,
//                    price);
//            if(rec.getUnits() != 0){
//                sellRecords.add(rec);
//            }
//        }
//        for (Double price : findUniquePricesForAssetAndPosition(assetName,
//                BUY_POSITION_NAME)) {
//            int unitsAmount = findUnitsAmountByPrice(assetName, price, BUY_POSITION_NAME);
//            TradeArenaRecord rec = new TradeArenaRecord(BUY_POSITION_NAME, unitsAmount,
//                    price);
//            if(rec.getUnits() != 0){
//                buyRecords.add(rec);
//            }
//        }
//        List<List<TradeArenaRecord>> tradeArenaTable = new LinkedList<List<TradeArenaRecord>>();
//        tradeArenaTable.add(sellRecords);
//        tradeArenaTable.add(buyRecords);
//        return tradeArenaTable;
//    }
//
//    @Override
//    public List<AlternativeTradeArenaRecord> loadAlternativeTradeArenaTable(String assetName) {
//        List<TradeArenaRecord> sellRecords = new ArrayList<TradeArenaRecord>();
//        List<TradeArenaRecord> buyRecords = new ArrayList<TradeArenaRecord>();
//        for (Double price : findUniquePricesForAssetSell(assetName)) {
//            int unitsAmount = findUnitsAmountByPrice(assetName, price, SELL_POSITION_NAME);
//            TradeArenaRecord rec = new TradeArenaRecord(SELL_POSITION_NAME, unitsAmount,
//                    price);
//            if(rec.getUnits() != 0){
//                sellRecords.add(rec);
//            }
//        }
//        for (Double price : findUniquePricesForAssetBuy(assetName)) {
//            int unitsAmount = findUnitsAmountByPrice(assetName, price, BUY_POSITION_NAME);
//            TradeArenaRecord rec = new TradeArenaRecord(BUY_POSITION_NAME, unitsAmount,
//                    price);
//            if(rec.getUnits() != 0){
//                buyRecords.add(rec);
//            }
//        }
//        List<AlternativeTradeArenaRecord> alternativeTradeArenaTable = new LinkedList<AlternativeTradeArenaRecord>();
//        int length = sellRecords.size() > buyRecords.size() ? sellRecords.size() : buyRecords.size();
//        for(int i = 0; i<length; i++){
//            AlternativeTradeArenaRecord record = new AlternativeTradeArenaRecord();
//            if(sellRecords.size() > i){
//                System.out.println("Sell");
//                record.setUnitsSell(sellRecords.get(i).getUnits());
//                record.setPriceSell(sellRecords.get(i).getPrice());
//            }
//            if(buyRecords.size() > i){
//                System.out.println("Buy");
//                record.setUnitsBuy(buyRecords.get(i).getUnits());
//                record.setPriceBuy(buyRecords.get(i).getPrice());
//            }
//            alternativeTradeArenaTable.add(record);
//        }
//        return alternativeTradeArenaTable;
//    }
//
//
//    @Override
//    public int getPendingUnitsAmountForAssetTopPrice(String assetName, String position) {
//        return dao.getPendingUnitsAmountForAssetTopPrice(assetName, position);
//    }
//
//
//    @Override
//    public long insert(TradeOrder tradeOrder) {
//        return dao.insert(tradeOrder);
//    }
//
//    @Override
//    public List<TradeOrder> findByPosition(String position) {
//        return dao.findByPosition(position);
//    }
//
//    @Override
//    public List<TradeOrder> findByStatus(Status status) {
//        return dao.findByStatus(status);
//    }
//
//    @Override
//    public List<TradeOrder> findByUser(User user) {
//        return dao.findByUser(user);
//    }
//
//    @Override
//    public List<TradeOrder> findByPrice(double price) {
//        return dao.findByPrice(price);
//    }
//
//    @Override
//    public List<Double> findUniquePricesForAssetAndPosition(String assetName,
//                                                            String position) {
//        return dao.findUniquePricesForAssetAndPosition(assetName, position);
//    }
//
//    @Override
//    public List<TradeOrder> findCurrentOrders() {
//        return dao.findCurrentOrders();
//    }
//
//    @Override
//    public boolean isSamePriceExist(double price) {
//        return dao.isSamePriceExist(price);
//    }
//
//    @Override
//    public int findUnitsAmountByPosition(String assetName, String position) {
//        return dao.findUnitsAmountByPosition(assetName, position);
//    }
//
//    @Override
//    public double findMaxPriceByPositionForAsset(String position,
//                                                 String assetName) {
//        return dao.findMaxPriceByPositionForAsset(position, assetName);
//    }
//
//    @Override
//    public double findMinPriceByPositionForAsset(String position,
//                                                 String assetName) {
//        return dao.findMinPriceByPositionForAsset(position, assetName);
//    }
//
//    @Override
//    public boolean updateOrder(TradeOrder tradeOrder) {
//        return dao.updateOrder(tradeOrder);
//    }
//
//    @Override
//    public int findUnitsAmountByPrice(String assetName, double price,
//                                      String position) {
//        return dao.findUnitsAmountByPrice(assetName, price, position);
//    }
//
//    @Override
//    public List<TradeOrder> findCurrentOrdersByPriceForAssetAndPosition(
//            String assetName, double price) {
//        return dao.findCurrentOrdersByPriceForAssetAndPosition(assetName,
//                price);
//    }
//
//    @Override
//    protected Dao<TradeOrder> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class/*, isolation = Isolation.READ_COMMITTED*/)
//    public boolean addOrder(TradeOrder order) throws Exception {
//        return dao.addOrder(order);
//    }
//
//    @Override
//    @Transactional()
//    public void endTimeInterval(String assetName, double newPrice) {
//        dao.endTimeInterval(assetName, newPrice);
//    }
//
//
//    @Override
//    public List<TradeOrder> findCurrentOrdersByAssetForChart(String assetName) {
//        return dao.findCurrentOrdersByAssetForChart(assetName);
//    }
//
//
//    @Override
//    public List<TradeOrder> findCurrentOrdersByAssetName(String assetName) {
//        return dao.findCurrentOrdersByAssetName(assetName);
//    }
//
//    @Override
//    public List<TradeOrder> findPendingByUserForManaging(User user, Date startDate, Date endDate) {
//        return dao.findPendingByUserForManaging(user, startDate, endDate);
//    }
//
//    @Override
//    public List<TradeOrder> findOpenedByUserForManaging(User user, Date startDate, Date endDate) {
//        return dao.findOpenedByUserForManaging(user, startDate, endDate);
//    }
//
//    @Override
//    public List<TradeOrder> findClosedByUserForManaging(User user, Date startDate,
//                                                        Date endDate) {
//        return dao.findClosedByUserForManaging(user, startDate, endDate);
//    }
//
//
//    @Override
//    public int getLiveProfitAndLoseForUser(User user){
//        MutopiaScheduler mutopiaScheduler = ApplicationContextProvider.getContext().getBean("MutopiaScheduler", MutopiaScheduler.class);
//        List<TradeOrder> currentOrders = findCurrentByUser(user);
//        Map<String, Double> livePrices = mutopiaScheduler.getAssetYahooRealPriceMap();
//
//        int profitsAmount = 0;
//        int losesAmount = 0;
//
//        for(TradeOrder o: currentOrders){
//            if(o.getPosition().equals(SELL_POSITION_NAME)){
//                if(o.getPrice() > livePrices.get(o.getAssetName())){    //if new price fall as predicted
//                    profitsAmount = profitsAmount + o.getOpenedUnits();
//                } else if(o.getPrice() != livePrices.get(o.getAssetName())){
//                    losesAmount = losesAmount + o.getOpenedUnits();
//                }
//            } else {
//                if(o.getPrice() < livePrices.get(o.getAssetName())){    //if new price rose as predicted
//                    profitsAmount = profitsAmount + o.getOpenedUnits();
//                } else if(o.getPrice() != livePrices.get(o.getAssetName())){
//                    losesAmount = losesAmount + o.getOpenedUnits();
//                }
//            }
//        }
//
//        return (profitsAmount - losesAmount)*UNIT_COST;
//    }
//
//    @Override
//    public int getAcountProfitAndLoseForUser(User user){
//        MutopiaScheduler mutopiaScheduler = ApplicationContextProvider.getContext().getBean("MutopiaScheduler", MutopiaScheduler.class);
//        List<TradeOrder> orders = findByUser(user);
//        Map<String, Double> livePrices = mutopiaScheduler.getAssetYahooRealPriceMap();
//
//        int profitsAmount = 0;
//        int losesAmount = 0;
//
//        for(TradeOrder o: orders){
//            if(!o.getStatus().getName().equalsIgnoreCase("closed")){
//                if(o.getPosition().equals(SELL_POSITION_NAME)){
//                    if(o.getPrice() > livePrices.get(o.getAssetName())){    //if new price fall as predicted
//                        profitsAmount = profitsAmount + o.getOpenedUnits();
//                    } else {
//                        losesAmount = losesAmount + o.getOpenedUnits();
//                    }
//                } else {
//                    if(o.getPrice() < livePrices.get(o.getAssetName())){    //if new price rose as predicted
//                        profitsAmount = profitsAmount + o.getOpenedUnits();
//                    } else {
//                        losesAmount = losesAmount + o.getOpenedUnits();
//                    }
//                }
//            } else {
//                if(o.isProfit()){                                       ///if NullPointer then check addOrder. Cancelling totally pending orders
//                    profitsAmount = profitsAmount + o.getOpenedUnits();
//                } else {
//                    losesAmount = losesAmount + o.getOpenedUnits();
//                }
//            }
//        }
//        return (profitsAmount - losesAmount)*UNIT_COST;
//    }
//
//    @Override
//    public Statistics getStatisticsForUserByAsset(User user, String assetName){
//        MutopiaScheduler mutopiaScheduler = ApplicationContextProvider.getContext().getBean("MutopiaScheduler", MutopiaScheduler.class);
//        List<TradeOrder> currentOrders = findCurrentForUserByAsset(user,assetName);
//        List<TradeOrder> closedOrders = findClosedForUserByAsset(user,assetName);
//        Map<String, Double> livePrices = mutopiaScheduler.getAssetYahooRealPriceMap();
//
//        return calculateStatistics(currentOrders, closedOrders, livePrices);
//    }
//
//    @Override
//    public Statistics getStatisticsForUser(User user){
//        MutopiaScheduler mutopiaScheduler = ApplicationContextProvider.getContext().getBean("MutopiaScheduler", MutopiaScheduler.class);
//        List<TradeOrder> currentOrders = findCurrentByUser(user);
//        List<TradeOrder> closedOrders = findClosedByUser(user);
//        Map<String, Double> livePrices = mutopiaScheduler.getAssetYahooRealPriceMap();
//
//        return calculateStatistics(currentOrders, closedOrders, livePrices);
//    }
//
//    private Statistics calculateStatistics(List<TradeOrder> currentOrders,
//                                           List<TradeOrder> closedOrders, Map<String, Double> livePrices){
//        Statistics stat = new Statistics();
//
//        int profitsAmount = 0;
//        int losesAmount = 0;
//        int totalTrades = 0;
//
//        for(TradeOrder o: currentOrders){
//            totalTrades += o.getOpenedUnits();
//            if (o.getPosition().equals(SELL_POSITION_NAME)) {
//                if (o.getPrice() > livePrices.get(o.getAssetName())) { // if new price fall as predicted
//                    profitsAmount += o.getOpenedUnits();
//                } else {
//                    losesAmount += o.getOpenedUnits();
//                }
//            } else {
//                if (o.getPrice() < livePrices.get(o.getAssetName())) { // if new price rose as predicted
//                    profitsAmount += o.getOpenedUnits();
//                } else {
//                    losesAmount += o.getOpenedUnits();
//                }
//            }
//
//        }
//
//        stat.setOpenPL((profitsAmount - losesAmount)*UNIT_COST);
//        stat.setWinsAmount(profitsAmount);
//        stat.setLosesAmount(losesAmount);
//        profitsAmount = 0;
//        losesAmount = 0;
//
//        for(TradeOrder o: closedOrders){
//            totalTrades += o.getOpenedUnits();
//            if(o.isProfit()){
//                profitsAmount += o.getOpenedUnits();
//            } else {
//                losesAmount += o.getOpenedUnits();
//            }
//        }
//
//        stat.setClosedPL((profitsAmount - losesAmount)*UNIT_COST);
//        stat.setTotalTrades(totalTrades);
//        stat.setWinsAmount(stat.getWinsAmount() + profitsAmount);
//        stat.setLosesAmount(stat.getLosesAmount() + losesAmount);
//
//        return stat;
//    }
//
//
//
//
//    @Override
//    public List<TradeOrder> findCurrentByUser(User user) {
//        return dao.findCurrentByUser(user);
//    }
//
//    @Override
//    public List<TradeOrder> findClosedByUser(User user) {
//        return dao.findClosedByUser(user);
//    }
//
//    @Override
//    public List<TradeOrder> findClosedForUserByAsset(User user, String assetName) {
//        return dao.findClosedForUserByAsset(user, assetName);
//    }
//
//    @Override
//    public List<TradeOrder> findCurrentForUserByAsset(User user, String assetName) {
//        return dao.findCurrentForUserByAsset(user, assetName);
//    }
//
//    @Override
//    public List<TradeOrder> findClosedForUserByAssetForLastMonth(User user,
//                                                                 String assetName) {
//        return dao.findClosedForUserByAssetForLastMonth(user, assetName);
//    }
//
//    @Override
//    public List<TradeOrder> findClosedForUserForLastMonth(User user) {
//        return dao.findClosedForUserForLastMonth(user);
//    }
//
//    @Override
//    public List<StatisticsBarsChart> getStatisticsForBarsChart(User user, String assetName){
//        List<TradeOrder> orders = findClosedForUserByAssetForLastMonth(user, assetName);
//        return iterateOrdersForBarsChart(orders);
//    }
//
//    @Override
//    public List<StatisticsBarsChart> getStatisticsForBarsChart(User user){
//        List<TradeOrder> orders = findClosedForUserForLastMonth(user);
//        return iterateOrdersForBarsChart(orders);
//    }
//
//    private List<StatisticsBarsChart> iterateOrdersForBarsChart(List<TradeOrder> orders){
//        List<StatisticsBarsChart> model = new LinkedList();
//        Map<Date, WinsLoses> datesMap = new LinkedHashMap<Date, WinsLoses>();
//
//        for(TradeOrder o: orders){
//            System.out.println("Order "+o.getIdOrder());
//            WinsLoses wl = datesMap.get(o.getExpiryTime());
//            if(wl != null){
//                if(o.isProfit()){
//                    wl.setWinsAmount(wl.getWinsAmount()+o.getOpenedUnits());
//                } else {
//                    wl.setLosesAmount(wl.getLosesAmount()+o.getOpenedUnits());
//                }
//                datesMap.put(o.getExpiryTime(), wl);
//            } else {
//                wl = new WinsLoses();
//                if(o.isProfit()){
//                    wl.setWinsAmount(o.getOpenedUnits());
//                } else {
//                    wl.setLosesAmount(o.getOpenedUnits());
//                }
//                datesMap.put(o.getExpiryTime(), wl);
//            }
//        }
//
//        for (Map.Entry entry : datesMap.entrySet()) {
//            StatisticsBarsChart statisticsBarsChart = new StatisticsBarsChart();
//            Date expTime = (Date)entry.getKey();
//            WinsLoses wl = (WinsLoses) entry.getValue();
//            statisticsBarsChart.setExpiryTime(expTime.getTime());
//            statisticsBarsChart.setLosesAmount(wl.getLosesAmount());
//            statisticsBarsChart.setWinsAmount(wl.getWinsAmount());
//            model.add(statisticsBarsChart);
//        }
//
//        return model;
//    }
//
//    @Override
//    public long getUnitsAmountForUserByAsset(User user, String assetName) {
//        return dao.getUnitsAmountForUserByAsset(user, assetName);
//    }
//
//    @Override
//    public List<Double> findUniquePricesForAssetSell(String assetName) {
//        return dao.findUniquePricesForAssetSell(assetName);
//    }
//
//    @Override
//    public List<Double> findUniquePricesForAssetBuy(String assetName) {
//        return dao.findUniquePricesForAssetBuy(assetName);
//    }
//
//    @Override
//    public String findPositionWhereMaxPendingUnitsForAssetByPrice(String assetName, double price){
//        return dao.findPositionWhereMaxPendingUnitsForAssetByPrice(assetName, price);
//    }
//
//    @Override
//    public boolean addOrderFullCover(TradeOrder newOrder) throws Exception {
//        return dao.addOrderFullCover(newOrder);
//    }
//
//    @Override
//    public List<TradeOrder> findPendingOrdersByAssetPositionPriceSellLessBuyAbove(
//            String assetName, String position, double price) {
//        return dao.findPendingOrdersByAssetPositionPriceSellLessBuyAbove(assetName, position, price);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class/*, isolation = Isolation.READ_COMMITTED*/)
//    public void endTimeIntervalByDeal(String assetName, double newPrice)
//            throws Exception {
//        dao.endTimeIntervalByDeal(assetName, newPrice);
//    }
//
//    @Override
//    public void coverOrders(TradeOrder newOrder, List<TradeOrder> pendingOrders)
//            throws Exception {
//        dao.coverOrders(newOrder, pendingOrders);
//    }
//}
//
