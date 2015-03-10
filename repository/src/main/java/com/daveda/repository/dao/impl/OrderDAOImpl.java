//package com.daveda.repository.dao.impl;
//
//import com.daveda.repository.dao.AccountDAO;
//import com.daveda.repository.dao.DealDAO;
//import com.daveda.repository.dao.OrderDAO;
//import com.daveda.repository.dao.StatusDAO;
//import com.daveda.repository.dao.UserDAO;
//import com.daweda.model.entity.Account;
//import com.daweda.model.entity.Deal;
//import com.daweda.model.entity.Status;
//import com.daweda.model.entity.TradeOrder;
//import com.daweda.model.entity.User;
//import org.apache.felix.scr.annotations.Component;
//import org.apache.felix.scr.annotations.Reference;
//import org.apache.felix.scr.annotations.Service;
//
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Component(immediate = true)
//public class OrderDAOImpl extends AbstractDAOImpl<TradeOrder> implements
//        OrderDAO {
//
//	@Reference
//	private DealDAO dealDao;
//	@Reference
//	private StatusDAO statusDao;
//	@Reference
//	private AccountDAO accountDao;
//	@Reference
//	private UserDAO userDao;
//
//	private static final int UNIT_COST = 25;
//	private static final int UNIT_FEE = 1;
//	private static final int ORDER_WIN_RAISE_INDEX = 2;
//
//	private static final String CLOSED_STATUS_NAME = "closed";
//	private static final String PENDING_STATUS_NAME = "pending";
//	private static final String OPENED_STATUS_NAME = "opened";
//	private static final String SELL_POSITION_NAME = "Sell";
//	private static final String BUY_POSITION_NAME = "Buy";
//	private Status closedStatus;
//	private Status pendingStatus;
//	private Status openedStatus;
//
//	private static final String FIND_BY_POSITION = "SELECT o FROM TradeOrder o WHERE o.position = :p";
//
//	private static final String FIND_BY_STATUS = "SELECT o FROM TradeOrder o WHERE o.status = :s";
//
//	private static final String FIND_BY_USER = "SELECT o FROM TradeOrder o WHERE o.user = :u";
//
//	private static final String FIND_BY_ASSET_STATUS = "SELECT o FROM TradeOrder o WHERE o.assetName = :assetName AND o.status = :status";
//
//	private static final String FIND_CURRENT_BY_USER = "SELECT o FROM TradeOrder o WHERE o.user = :user AND NOT o.status = :status";
//
//	private static final String FIND_CLOSED_BY_USER = "SELECT o FROM TradeOrder o WHERE o.user = :user AND o.status = :status";
//
//	private static final String FIND_CLOSED_BY_USER_LAST_MONTH = "SELECT o FROM TradeOrder o "
//			+ "WHERE o.user = :user AND o.status = :status AND o.expiryTime > :date ORDER BY o.expiryTime";
//
//	private static final String FIND_CURRENT_BY_USER_ASSET = "SELECT o FROM TradeOrder o "
//			+ "WHERE o.user = :user AND NOT o.status = :status AND o.assetName = :assetName";
//
//	private static final String FIND_CLOSED_BY_USER_ASSET = "SELECT o FROM TradeOrder o "
//			+ "WHERE o.user = :user AND o.status = :status  AND o.assetName = :assetName";
//
//	private static final String FIND_CLOSED_BY_USER_ASSET_LAST_MONTH = "SELECT o FROM TradeOrder o "
//			+ "WHERE o.user = :user AND o.status = :status  AND o.assetName = :assetName AND o.expiryTime > :date "
//			+ "ORDER BY o.expiryTime";
//
//	private static final String FIND_BY_PRICE = "SELECT o FROM TradeOrder o WHERE o.price = :p "
//			+ "ORDER BY o.startTime DESC";
//
//	private static final String FIND_UNITS_AMOUNT_BY_PRICE = "SELECT SUM(o.pendingUnits) "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName AND "
//			+ "o.price = :price AND o.position = :position";
//
//	private static final String FIND_UNITS_AMOUNT_FOR_USER_BY_ASSET = "SELECT SUM(o.openedUnits) "   //check not pending status
//			+ "FROM TradeOrder o WHERE o.assetName = :assetName AND user = :user";
//
//	private static final String FIND_UNIQUE_PRICES_FOR_ASSET_SELL = "SELECT DISTINCT o.price "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position ORDER BY o.price";
//
//	private static final String FIND_UNIQUE_PRICES_FOR_ASSET_BUY = "SELECT DISTINCT o.price "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position ORDER BY o.price desc";
//
//	private static final String FIND_UNIQUE_PRICES_FOR_ASSET_POSITION = "SELECT DISTINCT o.price "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position";
//
//	private static final String FIND_CURRENT = "SELECT o FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status";
//
//	private static final String FIND_CURRENT_BY_ASSET = "SELECT o FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName";
//
//	private static final String FIND_PENDING_BY_ASSET_POSITION_PRICE_LESS = "SELECT o FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND position = :position AND price <= :price";
//
//	private static final String FIND_PENDING_BY_ASSET_POSITION_PRICE_ABOVE = "SELECT o FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND position = :position AND price >= :price";
//
//	private static final String FIND_CURRENT_BY_ASSET_PARTIAL = "SELECT NEW "
//			+ "TradeOrder(o.price, o.startTime, o.position) "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName ORDER BY o.startTime";
//
//	private static final String FIND_ORDERS_PENDING_BY_USER_FOR_MANAGING = "SELECT NEW "
//			+ "TradeOrder(o.idOrder, o.assetName, o.position, o.pendingUnits, "
//			+ "o.price, o.expiryTime, o.startTime, o.profit, o.marketPrice) "
//			+ "FROM TradeOrder o WHERE "
//			+ "o.user = :user AND o.status = :status AND o.startTime BETWEEN :startDate AND :endDate";
//
//	private static final String FIND_ORDERS_OPENED_BY_USER_FOR_MANAGING = "SELECT NEW "
//			+ "TradeOrder(o.idOrder, o.assetName, o.position, o.openedUnits, "
//			+ "o.price, o.expiryTime, o.startTime, o.profit, o.marketPrice) "
//			+ "FROM TradeOrder o WHERE "
//			+ "o.user = :user AND NOT o.status = :status AND o.startTime BETWEEN :startDate AND :endDate";
//
//	private static final String FIND_ORDERS_CLOSED_BY_USER_FOR_MANAGING = "SELECT NEW "
//			+ "TradeOrder(o.idOrder, o.assetName, o.position, o.openedUnits, "
//			+ "o.price, o.expiryTime, o.startTime, o.profit, o.marketPrice) "
//			+ "FROM TradeOrder o WHERE "
//			+ "o.user = :user AND o.status = :status AND o.startTime BETWEEN :startDate AND :endDate";
//
//	// private static final String FIND_CURRENT_BY_PRICE_ASSET_POSITION =
//	// "SELECT o FROM TradeOrder o WHERE "
//	// + "o.status = :status AND o.assetName = :assetName AND "
//	// +
//	// "o.price = :price AND o.position = :position ORDER BY o.startTime DESC, o.pendingUnits DESC";
//
//	private static final String FIND_CURRENT_BY_PRICE_ASSET_POSITION = "SELECT o FROM TradeOrder o WHERE o.status = :status AND o.position = "
//			+ "(SELECT MAX(a.sum), a.pos FROM "
//			+ "(SELECT SUM(order2.pendingUnits) sum, 'Sell' as pos FROM TradeOrder o WHERE WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.price = :price AND o.position = 'Sell' "
//			+ " UNION "
//			+ " SELECT SUM(order2.pendingUnits) sum, 'Buy' as pos FROM TradeOrder o WHERE WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.price = :price AND o.position = 'Buy') a "
//			+ ") b ON o.position = b.pos ORDER BY o.startTime DESC, o.pendingUnits DESC";
//
//	private static final String FIND_CURRENT_BY_PRICE_ASSET_POSITIONNNNNNNNNNNNNNNNNNN = "SELECT o FROM "
//			+ "(SELECT o FROM TradeOrder o WHERE o.status = :status AND o.assetName = :assetName AND o.price = :price) o "
//			+ "INNER JOIN "
//			+ "(SELECT MAX(a.sum), a.pos FROM "
//			+ "(SELECT SUM(order2.pendingUnits) sum, 'Sell' as pos FROM TradeOrder o WHERE WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.price = :price AND o.position = 'Sell' "
//			+ " UNION "
//			+ " SELECT SUM(order2.pendingUnits) sum, 'Buy' as pos FROM TradeOrder o WHERE WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.price = :price AND o.position = 'Buy') a "
//			+ ") b ON o.position = b.pos ORDER BY o.startTime DESC, o.pendingUnits DESC";
//
//	private static final String FIND_CURRENT_BY_PRICE_ASSET_POSITION_NATIVE = "SELECT f.id_order, f.start_time, f.expiry_time, f.price, f.opened_units, "
//			+ "f.pending_units, f.asset_name, f.position, f.status_id, f.user_id "
//			+ "FROM ( "
//			+ "SELECT * "
//			+ "FROM trade_order "
//			+ "WHERE status_id = :status AND asset_name = :assetName AND price = :price "
//			+ ") f "
//			+ "INNER JOIN ( "
//			+ "SELECT a.position FROM ( "
//			+ "SELECT SUM(pending_units) sum, 'Sell' as position "
//			+ "FROM trade_order "
//			+ "WHERE status_id = :status AND asset_name = :assetName AND price = :price AND position = 'Sell' "
//			+ "UNION "
//			+ "SELECT SUM(pending_units) sum, 'Buy' as position "
//			+ "FROM trade_order "
//			+ "WHERE status_id = :status AND asset_name = :assetName AND price = :price AND position = 'Buy' "
//			+ ") a ORDER BY a.sum DESC LIMIT 1 "
//			+ ") b ON f.position = b.position AND NOT f.pending_units = 0 ORDER BY f.start_time, f.opened_units DESC";
//
////	private static final String FIND_CURRENT_BY_PRICE_ABOVE_SELL_LESS_BUY_ASSET_POSITION_NATIVE = "SELECT f.id_order, f.start_time, f.expiry_time, f.price, f.opened_units, "
////			+ "f.pending_units, f.asset_name, f.position, f.status_id, f.user_id "
////			+ "FROM ( "
////			+ "SELECT * "
////			+ "FROM trade_order "
////			+ "WHERE status_id = :status AND asset_name = :assetName AND price = :price "					////DOES not work!!!!!!!!!!!!!!!!!!
////			+ ") f "
////			+ "INNER JOIN ( "
////			+ "SELECT a.position FROM ( "
////			+ "SELECT SUM(pending_units) sum, '"+SELL_POSITION_NAME+"' as position "
////			+ "FROM trade_order "
////			+ "WHERE status_id = :status AND asset_name = :assetName AND price >= :price AND position = '"+SELL_POSITION_NAME+"' "
////			+ "UNION "
////			+ "SELECT SUM(pending_units) sum, '"+BUY_POSITION_NAME+"' as position "
////			+ "FROM trade_order "
////			+ "WHERE status_id = :status AND asset_name = :assetName AND price <= :price AND position = '"+BUY_POSITION_NAME+"' "
////			+ ") a ORDER BY a.sum DESC LIMIT 1 "
////			+ ") b ON f.position = b.position AND NOT f.pending_units = 0 ORDER BY f.start_time, f.opened_units DESC";
//
//	private static final String FIND_POSITION_WHERE_MAX_PENDING_UNITS_FOR_ASSET_BY_PRICE_NATIVE = "SELECT a.position FROM ("
//			+ "SELECT SUM(pending_units) sum, '"+SELL_POSITION_NAME+"' as position "
//			+ "FROM mutopiadb.trade_order "
//			+ "WHERE status_id = :status AND asset_name = :assetName AND price >= :price AND position = '"+SELL_POSITION_NAME+"' "
//			+ "UNION "
//			+ "SELECT SUM(pending_units) sum, '"+BUY_POSITION_NAME+"' as position "
//			+ "FROM mutopiadb.trade_order "
//			+ "WHERE status_id = :status AND asset_name = :assetName AND price <= :price AND position = '"+BUY_POSITION_NAME+"' "
//			+ ") a ORDER BY a.sum DESC LIMIT 1";
//
//	// SELECT *
//	// FROM
//	// (
//	// SELECT *
//	// FROM mutopiadb.trade_order
//	// WHERE asset_name = 'USD' AND price = 5.3
//	// ) f
//	// INNER JOIN
//	// (
//	// select MAX(a.sum), a.position from (
//	// SELECT SUM(pending_units) sum, 'Sell' as position
//	// FROM mutopiadb.trade_order
//	// WHERE asset_name = 'USD' AND price = 5.3 AND position = 'Sell'
//	// UNION
//	// SELECT SUM(pending_units) sum, 'Buy' as position
//	// FROM mutopiadb.trade_order
//	// WHERE asset_name = 'USD' AND price = 5.3 AND position = 'Buy' ) a
//	// ) b ON f.position = b.position
//
//	private static final String IS_SAME_PRICE_EXISTS = "SELECT o FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.price = :price";
//
//	private static final String IS_SAME_LOWER_PRICE_EXISTS = "SELECT o FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.price >= :price";
//
//	private static final String IS_SAME_HIGHER_PRICE_EXISTS = "SELECT o FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.price <= :price";
//
//	private static final String FIND_UNITS_AMOUNT_BY_POSITION = "SELECT SUM(o.pendingUnits)+SUM(o.openedUnits) "
//			+ "FROM TradeOrder o WHERE "
//			+ "NOT o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position";
//
//	private static final String FIND_MAX_PRICE_BY_ASSET_POSITION = "SELECT MAX(o.price) "
//			+ "FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position";
//
//
//	private static final String FIND_MIN_PRICE_BY_ASSET_POSITION = "SELECT MIN(o.price) "
//			+ "FROM TradeOrder o WHERE "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position";
//
//	private static final String FIND_PENDING_UNITS_BY_ASSET_POSITION_PRICE = "SELECT SUM(o.pendingUnits) "
//			+ "FROM TradeOrder o WHERE o.price = :price AND "
//			+ "o.status = :status AND o.assetName = :assetName AND "
//			+ "o.position = :position";
//
//	private static final String FIND_STATUS_BY_NAME = "SELECT s FROM Status s WHERE s.name = :name";
//
//	public OrderDAOImpl() {
//		super(TradeOrder.class);
//	}
//
//	@Override
//	public long insert(TradeOrder tradeOrder) {
//		TradeOrder o = tradeOrder;
//		create(o);
//		if (o != null) {
//			return o.getIdOrder();
//		}
//		return 0;
//	}
//
//	@Override
//	public List<TradeOrder> findByPosition(String position) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_BY_POSITION,
//				TradeOrder.class);
//		tq.setParameter("p", position);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findByStatus(Status status) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_BY_STATUS,
//                TradeOrder.class);
//		tq.setParameter("s", status);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findByUser(User user) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_BY_USER,
//                TradeOrder.class);
//		tq.setParameter("u", user);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findPendingByUserForManaging(User user, Date startDate, Date endDate) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_ORDERS_PENDING_BY_USER_FOR_MANAGING,
//                TradeOrder.class);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("startDate", startDate);
//		tq.setParameter("endDate", endDate);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findOpenedByUserForManaging(User user, Date startDate, Date endDate) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_ORDERS_OPENED_BY_USER_FOR_MANAGING,
//                TradeOrder.class);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("startDate", startDate);
//		tq.setParameter("endDate", endDate);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findClosedByUserForManaging(User user, Date startDate, Date endDate) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_ORDERS_CLOSED_BY_USER_FOR_MANAGING,
//                TradeOrder.class);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("startDate", startDate);
//		tq.setParameter("endDate", endDate);
//		return tq.getResultList();
//	}
//
//
//
//	@Override
//	public List<TradeOrder> findByPrice(double price) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_BY_PRICE,
//                TradeOrder.class);
//		tq.setParameter("p", price);
//		return tq.getResultList();
//	}
//
//	@Override
//	public int findUnitsAmountByPrice(String assetName, double price,
//			String position) {
//		TypedQuery<Long> tq = entityManager.createQuery(FIND_UNITS_AMOUNT_BY_PRICE,
//                Long.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("price", price);
//		tq.setParameter("position", position);
//		try {
//			Long l = tq.getSingleResult();
//			return l.intValue();
//		} catch (NullPointerException e) {
//			return 0;
//		}
//	}
//
//	@Override
//	public List<Double> findUniquePricesForAssetAndPosition(String assetName,
//			String position) {
//		TypedQuery<Double> tq = entityManager.createQuery(
//                FIND_UNIQUE_PRICES_FOR_ASSET_POSITION, Double.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<Double> findUniquePricesForAssetSell(String assetName) {
//		TypedQuery<Double> tq = entityManager.createQuery(
//                FIND_UNIQUE_PRICES_FOR_ASSET_SELL, Double.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", SELL_POSITION_NAME);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<Double> findUniquePricesForAssetBuy(String assetName) {
//		TypedQuery<Double> tq = entityManager.createQuery(
//                FIND_UNIQUE_PRICES_FOR_ASSET_BUY, Double.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", BUY_POSITION_NAME);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentOrders() {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CURRENT,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentOrdersByAssetName(String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CURRENT_BY_ASSET,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findPendingOrdersByAssetPositionPriceSellLessBuyAbove(String assetName, String position, double price) {
//		TypedQuery<TradeOrder> tq = null;
//		if (position != null && position.equals(SELL_POSITION_NAME)) {
//			tq = entityManager.createQuery(FIND_PENDING_BY_ASSET_POSITION_PRICE_LESS,
//                    TradeOrder.class);
//		} else if(position != null) {
//			tq = entityManager.createQuery(FIND_PENDING_BY_ASSET_POSITION_PRICE_ABOVE,
//                    TradeOrder.class);
//		} else {
//			return null;
//		}
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		tq.setParameter("price", price);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentOrdersByAssetForChart(String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CURRENT_BY_ASSET_PARTIAL,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentOrdersByPriceForAssetAndPosition(
//			String assetName, double price) {
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//
//		Query q = entityManager.createNativeQuery(
//                FIND_CURRENT_BY_PRICE_ASSET_POSITION_NATIVE, TradeOrder.class);
//		try {
//			q.setParameter("status", pendingStatus.getIdStatus());
//		} catch (NullPointerException e) {
//			return null;
//		}
//		q.setParameter("assetName", assetName);
//		q.setParameter("price", price);
//
//		List<TradeOrder> resultList = q.getResultList();
//		return resultList;
//	}
//
//	@Override
//	public String findPositionWhereMaxPendingUnitsForAssetByPrice(String assetName, double price) {
//		Query q = entityManager.createNativeQuery(FIND_POSITION_WHERE_MAX_PENDING_UNITS_FOR_ASSET_BY_PRICE_NATIVE);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		q.setParameter("status", pendingStatus);
//		q.setParameter("assetName", assetName);
//		q.setParameter("price", price);
//		try {
//			String position = (String) q.getSingleResult();
//			return position;
//		} catch (NullPointerException e) {
//			return "";
//		}
//	}
//
//	@Override
//	public boolean isSamePriceExist(double price) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(IS_SAME_PRICE_EXISTS,
//                TradeOrder.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("price", price);
//		List<TradeOrder> tradeOrders = tq.getResultList();
//		if (tradeOrders.isEmpty() || tradeOrders == null) {
//			return false;
//		}
//		return true;
//	}
//
//	//@Override
//	public boolean isSameLowerPriceExists(double price, String assetName, String position) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(IS_SAME_LOWER_PRICE_EXISTS,
//                TradeOrder.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		tq.setParameter("price", price);
//		List<TradeOrder> tradeOrders = tq.getResultList();
//		if (tradeOrders.isEmpty() || tradeOrders == null) {
//			return false;
//		}
//		return true;
//	}
//
//	//@Override
//	public boolean isSameHigherPriceExists(double price, String assetName, String position) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(IS_SAME_HIGHER_PRICE_EXISTS,
//                TradeOrder.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		tq.setParameter("price", price);
//		List<TradeOrder> tradeOrders = tq.getResultList();
//		if (tradeOrders.isEmpty() || tradeOrders == null) {
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public int findUnitsAmountByPosition(String assetName, String position) {
//		TypedQuery<Long> tq = entityManager.createQuery(FIND_UNITS_AMOUNT_BY_POSITION,
//                Long.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		try {
//			Long l = tq.getSingleResult();
//			return l.intValue();
//		} catch (NullPointerException e) {
//			return 0;
//		}
//	}
//
//	@Override
//	public int getPendingUnitsAmountForAssetTopPrice(String assetName, String position){
//		double price = 0.0;
//		if(position.equalsIgnoreCase(SELL_POSITION_NAME)){
//			price = findMinPriceByPositionForAsset(position, assetName);
//		} else if(position.equalsIgnoreCase(BUY_POSITION_NAME)){
//			price = findMaxPriceByPositionForAsset(position, assetName);
//		}
//		TypedQuery<Long> tq = entityManager.createQuery(
//                FIND_PENDING_UNITS_BY_ASSET_POSITION_PRICE, Long.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("price", price);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		long f = 0; //hardcode!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		try {
//			f = tq.getSingleResult();
//			return (int) f;
//		} catch (NullPointerException e) {
//			return 0;
//		}
//	}
//
//
//	@Override
//	public double findMaxPriceByPositionForAsset(String position,
//			String assetName) {
//		TypedQuery<Double> tq = entityManager.createQuery(
//                FIND_MAX_PRICE_BY_ASSET_POSITION, Double.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		try {
//			return tq.getSingleResult();
//		} catch (NullPointerException e) {
//			return 0.0;
//		}
//	}
//
//	@Override
//	public double findMinPriceByPositionForAsset(String position,
//			String assetName) {
//		TypedQuery<Double> tq = entityManager.createQuery(
//                FIND_MIN_PRICE_BY_ASSET_POSITION, Double.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		tq.setParameter("position", position);
//		try {
//			return tq.getSingleResult();
//		} catch (NullPointerException e) {
//			return 0.0;
//		}
//	}
//
//	@Override
//	public boolean updateOrder(TradeOrder tradeOrder) {
//		TradeOrder o = update(tradeOrder);
//		if (o == null) {
//			return false;
//		}
//		return true;
//	}
//
//	private Status findStatusByName(String name) {
//		TypedQuery<Status> tq = entityManager.createQuery(FIND_STATUS_BY_NAME,
//                Status.class);
//		tq.setParameter("name", name);
//		return tq.getSingleResult();
//	}
//
//	@Override
//	public boolean addOrderFullCover(TradeOrder newOrder) throws Exception{
//		try{
//			Account account = newOrder.getUser().getAccount();
//			if (account != null && account.getBalance() < (newOrder.getPendingUnits()*UNIT_COST + newOrder.getPendingUnits()*UNIT_FEE)) {
//				throw new Exception("No enough money!");
//			}
//
////			if (newOrder.getPosition().equals(SELL_POSITION_NAME)
////					&& !isSameHigherPriceExists(newOrder.getPrice(), newOrder.getAssetName(), newOrder.getPosition())) {
////				insert(newOrder);
////				// Update Opened and Pending positions for account
////				account.setPendingPositions(account.getPendingPositions()+newOrder.getPendingUnits());
////				account.setBalance(account.getBalance()
////						- newOrder.getPendingUnits()*UNIT_COST - newOrder.getPendingUnits()*UNIT_FEE);
////				accountDao.update(account);
////				return true;
////			} else if(newOrder.getPosition().equals(BUY_POSITION_NAME)
////					&& !isSameLowerPriceExists(newOrder.getPrice(),newOrder.getAssetName(),newOrder.getPosition())){
////				insert(newOrder);
////				// Update Opened and Pending positions for account
////				account.setPendingPositions(account.getPendingPositions()+newOrder.getPendingUnits());
////				account.setBalance(account.getBalance()
////						- newOrder.getPendingUnits()*UNIT_COST - newOrder.getPendingUnits()*UNIT_FEE);
////				accountDao.update(account);
////				return true;
////			}    									//////May be useLess!!!!!!!!!!!!!!!!!!
//
//
//			List<TradeOrder> pendingOrders = null;
////			System.out.println("NEW!!!!!!!!!!!!!!!!! "+ newOrder);
//
//			if(newOrder.getPosition().equals(BUY_POSITION_NAME)){
//				pendingOrders =
//						findPendingOrdersByAssetPositionPriceSellLessBuyAbove(newOrder.getAssetName(),
//						SELL_POSITION_NAME, newOrder.getPrice());
//			} else {
//				pendingOrders =
//						findPendingOrdersByAssetPositionPriceSellLessBuyAbove(newOrder.getAssetName(),
//						BUY_POSITION_NAME, newOrder.getPrice());
//			}
//			/*System.out.println("******************************************");
//			for(TradeOrder o: pendingOrders){
//				System.out.println(o);
//			}
//			System.out.println("******************************************");*/
//			if (insert(newOrder) == 0) {
//				throw new Exception("Failed to insert new order!");
//			}
//
//			account.setBalance((int)account.getBalance()
//					- newOrder.getPendingUnits()*UNIT_COST - newOrder.getPendingUnits()*UNIT_FEE);
//			account.setPendingPositions(account.getPendingPositions()
//					+ newOrder.getPendingUnits());
//			accountDao.update(account);
//
//			if (pendingOrders == null || pendingOrders.isEmpty()) {
//				return true;
//			} else {
//				coverOrders(newOrder,   //Iterate collection, exchange units while newOrder has pending units
//						pendingOrders);
//			}
//			return true;
//		} catch(Exception e){
//			throw e;
//		}
//
//	}
//	@Override
//	public void coverOrders(TradeOrder newOrder,
//			List<TradeOrder> pendingOrders) throws Exception {
//		TradeOrder actualAfterCalculation = newOrder;
//		User bot = userDao.findUserByToken(MutopiaScheduler.getBotToken());
//		for (TradeOrder currentOrder : pendingOrders) {
//			if(currentOrder.getUser().getId() == newOrder.getUser().getId() && currentOrder.getUser().getId() != bot.getId()){    ///To ignore newOrder owner's orders
//				continue;
//			}
//			actualAfterCalculation = makeDeal(currentOrder,
//					actualAfterCalculation);
//			if (actualAfterCalculation == null
//					|| !actualAfterCalculation.getPosition().equals(newOrder.getPosition())) {
//				return;
//			} else { // //if calculateUnits returned newOrder
//				continue;
//			}
//		}
//		update(actualAfterCalculation); // if newOrder has more
//										// pending units then in
//										// iterated collection
//	}
//
//	private TradeOrder makeDeal(TradeOrder currentOrder,
//			TradeOrder newOrder) throws Exception {
//		Account currentOrderAccount = currentOrder.getUser().getAccount();
//		Account newOrderAccount = newOrder.getUser().getAccount();
//
//		if (currentOrder.getPendingUnits() >= newOrder.getPendingUnits()) {
//			System.out.println("C>=N");
//			int dealUnitsAmount = newOrder.getPendingUnits();
//
//			exchangeUnits(currentOrder, newOrder);
//			openedStatus = statusDao.findByName(OPENED_STATUS_NAME);
//			if(openedStatus != null){
//				newOrder.setStatus(openedStatus);
//				if(currentOrder.getPendingUnits() == newOrder.getPendingUnits()){
//					currentOrder.setStatus(openedStatus);
//				}
//			} else {
//				throw new Exception("Failed to insert new order!");
//			}
//
//			System.out.println("newOrder: " + newOrder);
//			System.out.println("currentOrder: " + currentOrder);
//
//			if (!updateOrder(currentOrder) | !updateOrder(newOrder)) {
//				throw new Exception("Failed to insert new order!");
//			}
//
//			// Update Opened and Pending positions for accounts
//			currentOrderAccount = accountDao.findOne(currentOrderAccount.getIdAccount());
//			newOrderAccount = accountDao.findOne(newOrderAccount.getIdAccount());
//			updateAccountPositions(currentOrderAccount, dealUnitsAmount);
//			updateAccountPositions(newOrderAccount, dealUnitsAmount);
//
//
//			//dealDao.create(buildDeal(dealUnitsAmount, currentOrder, newOrder, currentOrder.getPrice()));
//			dealDao.create(buildDeal(dealUnitsAmount, currentOrder, newOrder));
//
////			Deal deal = new Deal(new Timestamp(new Date().getTime()),
////					dealUnitsAmount, currentOrder, newOrder);
////			deal.setPrice(currentOrder.getPrice());
////
////			dealDao.create(deal);
////
////			if (deal == null)
////				System.out.println("Exception while inserting new deal");
//
//			if(currentOrder.getPendingUnits() == newOrder.getPendingUnits()){
//				return null;
//			} else {
//				return currentOrder;
//			}
//		} else {
//			System.out.println("C<N");
//			int dealUnitsAmount = currentOrder.getPendingUnits();
////			int difference = newOrder.getPendingUnits()
////					- currentOrder.getPendingUnits();
////			System.out.println("Diff = " + difference);
//
//			exchangeUnits(newOrder, currentOrder);
//
////			currentOrder.setOpenedUnits(currentOrder.getOpenedUnits()
////					+ currentOrder.getPendingUnits());
////			currentOrder.setPendingUnits(0);
////
////			newOrder.setOpenedUnits(newOrder.getOpenedUnits()
////					+ newOrder.getPendingUnits() - difference);
////			newOrder.setPendingUnits(difference);
//			openedStatus = statusDao.findByName(OPENED_STATUS_NAME);
//			if(openedStatus != null){
//				currentOrder.setStatus(openedStatus);
//			} else {
//				throw new Exception("Failed to insert new order!");
//			}
//
//			System.out.println("newOrder: " + newOrder);
//			System.out.println("currentOrder: " + currentOrder);
//
//			if (!updateOrder(currentOrder)) {
//				throw new Exception();
//			}
//
//			// Update Opened and Pending positions for accounts
//			currentOrderAccount = accountDao.findOne(currentOrderAccount.getIdAccount());
//			newOrderAccount = accountDao.findOne(newOrderAccount.getIdAccount());
//			updateAccountPositions(currentOrderAccount, dealUnitsAmount);
//			updateAccountPositions(newOrderAccount, dealUnitsAmount);
//
//
////			Deal deal = new Deal(new Timestamp(new Date().getTime()),
////					dealUnitsAmount, newOrder, currentOrder);
////			deal.setPrice(currentOrder.getPrice());
//
//			//dealDao.create(buildDeal(dealUnitsAmount, newOrder, currentOrder, currentOrder.getPrice()));
//			dealDao.create(buildDeal(dealUnitsAmount, newOrder, currentOrder));
//
//			return newOrder;
//		}
//
//	}
//
//	private Deal buildDeal(int units, TradeOrder coverOrder, TradeOrder coveredOrder, double dealPrice){
//		Deal deal = new Deal();
//		deal.setDealTime(new Timestamp(new Date().getTime()));
//		deal.setUnits(units);
//		deal.setCoverOrder(coverOrder);
//		deal.setCoveredOrder(coveredOrder);
//		deal.setPrice(dealPrice);
//		return deal;
//	}
//
//	private Deal buildDeal(int units, TradeOrder coverOrder, TradeOrder coveredOrder){
//		Deal deal = new Deal();
//		deal.setDealTime(new Timestamp(new Date().getTime()));
//		deal.setUnits(units);
//		deal.setCoverOrder(coverOrder);
//		deal.setCoveredOrder(coveredOrder);
//		return deal;
//	}
//
//	@Override
//	public boolean addOrder(TradeOrder newOrder) throws Exception {
//		System.out.println("IN!");
//		try {
//			// Update account balance
//			Account account = newOrder.getUser().getAccount();
//			System.out.println("Account before: " + account);
//			if (account.getBalance() < newOrder.getPendingUnits()*UNIT_COST + newOrder.getPendingUnits()*UNIT_FEE) {
//				System.out.println("No Enough MONEY! ");
//				throw new Exception("No enough money!");
//			}
//
//			if (!isSamePriceExist(newOrder.getPrice())) {
//				insert(newOrder);
//				// Update Opened and Pending positions for account
//				account.setPendingPositions(account.getPendingPositions()+newOrder.getPendingUnits());
//				account.setBalance((int)account.getBalance()
//						- newOrder.getPendingUnits()*UNIT_COST - newOrder.getPendingUnits()*UNIT_FEE);
//				accountDao.update(account);
//				return true;
//			}
//
//			List<TradeOrder> pendingOrders = new LinkedList<TradeOrder>();
//			pendingOrders = findCurrentOrdersByPriceForAssetAndPosition(
//					newOrder.getAssetName(), newOrder.getPrice());
//
//			if (insert(newOrder) == 0) {
//				System.out.println("Exception while inserting new ORDER");
//				throw new Exception();
//			}
//			System.out.println("Inserted : " + newOrder);
//
//			account.setBalance((int)account.getBalance()
//					- newOrder.getPendingUnits()*UNIT_COST - newOrder.getPendingUnits()*UNIT_FEE);
//			account.setPendingPositions(account.getPendingPositions()
//					+ newOrder.getPendingUnits());
//			accountDao.update(account);
//
//			System.out.println("!!!Opened: "+account.getOpenPositions());
//			System.out.println("!!!Pending: "+account.getPendingPositions());
//
//			if (pendingOrders == null || pendingOrders.isEmpty()) {
//				return true;
//			} else {
//				calculateQueue(pendingOrders.get(0).getPosition(), newOrder,
//						pendingOrders);
//			}
//
//			// if (sellQueuPendingUnits > buyQueuPendingUnits) {
//			// System.out.println("S>B");
//			// calculateQueue("Sell", newOrder, sellIterator,
//			// currentIteratorSellOrder);
//			// } else if (sellQueuPendingUnits < buyQueuPendingUnits) {
//			// System.out.println("S<B");
//			// calculateQueue("Buy", newOrder, buyIterator,
//			// currentIteratorBuyOrder);
//			// } else { // if (sellQueuPendingUnits == buyQueuPendingUnits){
//			// System.out.println("S=B");
//			// update(newOrder);
//			// }
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	private void calculateQueue(String position, TradeOrder newOrder,
//			List<TradeOrder> pendingOrders) throws Exception {
//		if (newOrder.getPosition().equals(position)) { // if new order added to
//														// iterated collection
//			update(newOrder);
//		} else { // if new order added to collection where pending=0
//			TradeOrder actualAfterCalculation = newOrder;
//
//			//
//			for (TradeOrder currentOrder : pendingOrders) {
//				actualAfterCalculation = calculateUnits(currentOrder,
//						actualAfterCalculation);
//				if (actualAfterCalculation == null
//						|| actualAfterCalculation.getPosition()
//								.equals(position)) {
//					return;
//				} else { // //if calculateUnits returned newOrder
//					continue;
//				}
//			}
//			update(actualAfterCalculation); // if newOrder has more
//											// pending units then in
//											// iterated collection
//		}
//	}
//
//	private void exchangeUnits(TradeOrder morePendingUnitsOrder,
//			TradeOrder lessPendingUnitsOrder) {
//		morePendingUnitsOrder.setPendingUnits(morePendingUnitsOrder
//				.getPendingUnits() - lessPendingUnitsOrder.getPendingUnits());
//		morePendingUnitsOrder.setOpenedUnits(morePendingUnitsOrder
//				.getOpenedUnits() + lessPendingUnitsOrder.getPendingUnits());
//		lessPendingUnitsOrder.setOpenedUnits(lessPendingUnitsOrder
//				.getOpenedUnits() + lessPendingUnitsOrder.getPendingUnits());
//		lessPendingUnitsOrder.setPendingUnits(0);
//	}
//
//	private void updateAccountPositions(Account account, int dealUnitsAmount) {
//		System.out.println("Open positions1: "+account.getOpenPositions());
//		account.setOpenPositions(account.getOpenPositions() + dealUnitsAmount); //May be dealUnitsAmount*UNIT_COST
//		System.out.println("Open positions2: "+account.getOpenPositions());
//		System.out.println("Pending positions1: "+account.getPendingPositions());
//		account.setPendingPositions(account.getPendingPositions()				//May be dealUnitsAmount*UNIT_COST
//				- dealUnitsAmount);
//		System.out.println("Pending positions2: "+account.getPendingPositions());
//		accountDao.update(account);
//	}
//
//	private TradeOrder calculateUnits(TradeOrder currentOrder,
//			TradeOrder newOrder) throws Exception {
//		Account currentOrderAccount = currentOrder.getUser().getAccount();
//		Account newOrderAccount = newOrder.getUser().getAccount();
//
//		if (currentOrder.getPendingUnits() > newOrder.getPendingUnits()) {
//			System.out.println("C>N");
//			int dealUnitsAmount = newOrder.getPendingUnits();
//
//			exchangeUnits(currentOrder, newOrder);
//
//			newOrder.setStatus(statusDao.findByName(OPENED_STATUS_NAME)); // Handle
//																			// Exception!!!!!
//			System.out.println("newOrder: " + newOrder.getOpenedUnits() + " "
//					+ newOrder.getPendingUnits());
//			System.out.println("currentOrder: " + currentOrder.getOpenedUnits()
//					+ " " + currentOrder.getPendingUnits());
//
//			if (!updateOrder(currentOrder) | !updateOrder(newOrder)) {
//				throw new Exception();
//			}
//
//			// Update Opened and Pending positions for accounts
//			currentOrderAccount = accountDao.findOne(currentOrderAccount.getIdAccount());
//			newOrderAccount = accountDao.findOne(newOrderAccount.getIdAccount());
//			updateAccountPositions(currentOrderAccount, dealUnitsAmount);
//			updateAccountPositions(newOrderAccount, dealUnitsAmount);
//
//
//			Deal deal = new Deal(new Timestamp(new Date().getTime()),
//					dealUnitsAmount, currentOrder, newOrder);
//
//			dealDao.create(deal);
//
//			if (deal == null)
//				System.out.println("Exception while inserting new deal");
//
//			return currentOrder;
//		} else if (currentOrder.getPendingUnits() == newOrder.getPendingUnits()) {
//			System.out.println("C=N");
//			int dealUnitsAmount = newOrder.getPendingUnits();
//
//			exchangeUnits(currentOrder, newOrder);
//
//			newOrder.setStatus(statusDao.findByName(OPENED_STATUS_NAME)); // Handle
//																			// Exception!!!!!
//			System.out.println("newOrder: " + newOrder.getOpenedUnits() + " "
//					+ newOrder.getPendingUnits());
//			System.out.println("currentOrder: " + currentOrder.getOpenedUnits()
//					+ " " + currentOrder.getPendingUnits());
//
//			if (!updateOrder(currentOrder) | !updateOrder(newOrder)) {
//				throw new Exception();
//			}
//
//			// Update Opened and Pending positions for accounts
//			currentOrderAccount = accountDao.findOne(currentOrderAccount.getIdAccount());
//			newOrderAccount = accountDao.findOne(newOrderAccount.getIdAccount());
//			updateAccountPositions(currentOrderAccount, dealUnitsAmount);
//			updateAccountPositions(newOrderAccount, dealUnitsAmount);
//
//			Deal deal = new Deal(new Timestamp(new Date().getTime()),
//					dealUnitsAmount, currentOrder, newOrder);
//			dealDao.create(deal);
//			if (deal == null) {
//				System.out.println("Exception while inserting new deal;");
//			}
//
//			return null;
//		} else {
//			System.out.println("C<N");
//			int dealUnitsAmount = currentOrder.getPendingUnits();
//			int difference = newOrder.getPendingUnits()
//					- currentOrder.getPendingUnits();
//			System.out.println("Diff = " + difference);
//			currentOrder.setOpenedUnits(currentOrder.getOpenedUnits()
//					+ currentOrder.getPendingUnits());
//			currentOrder.setPendingUnits(0);
//
//			newOrder.setOpenedUnits(newOrder.getOpenedUnits()
//					+ newOrder.getPendingUnits() - difference);
//			newOrder.setPendingUnits(difference);
//
//			currentOrder.setStatus(statusDao.findByName(OPENED_STATUS_NAME)); // Handle
//																				// Exception!!!!!
//			System.out.println("newOrder: " + newOrder.getOpenedUnits() + " "
//					+ newOrder.getPendingUnits());
//			System.out.println("currentOrder: " + currentOrder.getOpenedUnits()
//					+ " " + currentOrder.getPendingUnits());
//
//			if (!updateOrder(currentOrder)) {
//				throw new Exception();
//			}
//
//			// Update Opened and Pending positions for accounts
//			currentOrderAccount = accountDao.findOne(currentOrderAccount.getIdAccount());
//			newOrderAccount = accountDao.findOne(newOrderAccount.getIdAccount());
//			updateAccountPositions(currentOrderAccount, dealUnitsAmount);
//			updateAccountPositions(newOrderAccount, dealUnitsAmount);
//
//
//			Deal deal = new Deal(new Timestamp(new Date().getTime()),
//					dealUnitsAmount, newOrder, currentOrder);
//
//			dealDao.create(deal);
//			if (deal == null)
//				System.out.println("Exception while inserting new deal;");
//
//			return newOrder;
//		}
//
//	}
//
////	@Override
////	public void endTimeIntervalByDeal(String assetName, double newPrice) throws Exception {
////		try{
////			Map<Long, Integer> closingOrders = new HashMap<Long, Integer>();
////			List<Deal> currentDeals = dealDao.findCurrentByAsset(assetName);
////			closedStatus = findStatusByName(CLOSED_STATUS_NAME);
////			if(currentDeals == null || currentDeals.isEmpty()){
////				return;
////			}
////			for (Deal currentDeal : currentDeals) {
////				TradeOrder coverOrder = currentDeal.getCoverOrder();
////				TradeOrder coveredOrder = currentDeal.getCoveredOrder();
////
////				switch (coverOrder.getPosition()) {
////				case SELL_POSITION_NAME:
////					if (newPrice < currentDeal.getPrice()) {
////						processDeal(coverOrder, coveredOrder, currentDeal,
////								newPrice, closingOrders);
////					} else if (newPrice > currentDeal.getPrice()) {
////						processDeal(coveredOrder, coverOrder, currentDeal,
////								newPrice, closingOrders);
////					} else {
////						processDealWhenEqualPrices(coverOrder,coveredOrder,currentDeal,
////								closedStatus,newPrice,closingOrders);
////					}
////					break;
////				case BUY_POSITION_NAME:
////					if (newPrice < currentDeal.getPrice()) {
////						processDeal(coveredOrder, coverOrder, currentDeal,
////								newPrice, closingOrders);
////					} else if (newPrice > currentDeal.getPrice()) {
////						processDeal(coverOrder, coveredOrder, currentDeal,
////								newPrice, closingOrders);
////					} else {
////						processDealWhenEqualPrices(coverOrder,coveredOrder,currentDeal,
////								closedStatus,newPrice,closingOrders);
////					}
////					break;
////				}
////			}
////			processPendingOrders(assetName, closedStatus,newPrice);
////		}catch(Exception e){
////			throw e;
////		}
////	}
//
//	@Override
//	public void endTimeIntervalByDeal(String assetName, double newPrice) throws Exception {
//		try{
//			Map<Long, Integer> closingOrders = new HashMap<Long, Integer>();
//			List<Deal> currentDeals = dealDao.findCurrentByAsset(assetName);
//			closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//
//			for (Deal currentDeal : currentDeals) {
//				TradeOrder coverOrder = currentDeal.getCoverOrder();
//				TradeOrder coveredOrder = currentDeal.getCoveredOrder();
//
//				switch (coverOrder.getPosition()) {
//				case SELL_POSITION_NAME:
//
//					if(newPrice == coverOrder.getPrice()){
//						coverOrder = processOrderWhenEqualPrices(coverOrder,currentDeal,
//								closedStatus,newPrice,closingOrders);
//					}
//					if(newPrice == coveredOrder.getPrice()){
//						coveredOrder = processOrderWhenEqualPrices(coveredOrder,currentDeal,
//								closedStatus,newPrice,closingOrders);
//					}
//
//					if (newPrice < coverOrder.getPrice()) {
//						processDeal(coverOrder, coveredOrder, currentDeal,
//								newPrice, closingOrders);
//					} else if (newPrice > coveredOrder.getPrice()) {
//						processDeal(coveredOrder, coverOrder, currentDeal,
//								newPrice, closingOrders);
//					} else {
////						if(coverOrder.getStatus().getIdStatus() != closedStatus.getIdStatus()){
////							processLosingOrder(coverOrder,  currentDeal, closedStatus,
////									newPrice, closingOrders);
////						}
////
////						if(coveredOrder.getStatus().getIdStatus() != closedStatus.getIdStatus()){
////							processLosingOrder(coverOrder,  currentDeal, closedStatus,
////									newPrice, closingOrders);
////						}
//						closeOrderByDeal(coverOrder, closedStatus, newPrice, currentDeal, closingOrders);
//						closeOrderByDeal(coveredOrder, closedStatus, newPrice, currentDeal, closingOrders);
//						closeDeal(currentDeal);
//					}
//					break;
//				case BUY_POSITION_NAME:
//					if(newPrice == coverOrder.getPrice()){
//						coverOrder = processOrderWhenEqualPrices(coverOrder,currentDeal,
//								closedStatus,newPrice,closingOrders);
//					}
//					if(newPrice == coveredOrder.getPrice()){
//						coveredOrder = processOrderWhenEqualPrices(coveredOrder,currentDeal,
//								closedStatus,newPrice,closingOrders);
//					}
//
//					if (newPrice > coverOrder.getPrice()) {
//						processDeal(coverOrder, coveredOrder, currentDeal,
//								newPrice, closingOrders);
//					} else if (newPrice < coveredOrder.getPrice()) {
//						processDeal(coveredOrder, coverOrder, currentDeal,
//								newPrice, closingOrders);
//					} else {
////						if(coverOrder.getStatus().getIdStatus() != closedStatus.getIdStatus()){
////							processLosingOrder(coverOrder,  currentDeal, closedStatus,
////									newPrice, closingOrders);
////						}
////
////						if(coveredOrder.getStatus().getIdStatus() != closedStatus.getIdStatus()){
////							processLosingOrder(coveredOrder,  currentDeal, closedStatus,
////									newPrice, closingOrders);
////						}
//						closeOrderByDeal(coverOrder, closedStatus, newPrice, currentDeal, closingOrders);
//						closeOrderByDeal(coveredOrder, closedStatus, newPrice, currentDeal, closingOrders);
//						closeDeal(currentDeal);
//					}
//					break;
//				}
//			}
//			processPendingOrders(assetName, closedStatus,newPrice);
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	private void processPendingOrders(String assetName, Status closedStatus, double newPrice) throws Exception{
//		try{
//			List<TradeOrder> pendingOrders = findPendingByAsset(assetName);
//			for(TradeOrder currentOrder:pendingOrders){
//				refillAccount(currentOrder.getUser().getAccount(), currentOrder.getPendingUnits());
//				cancelOrder(currentOrder, closedStatus, newPrice);
//			}
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	private void processDealWhenEqualPrices(TradeOrder coverOrder, TradeOrder coveredOrder,
//			Deal currentDeal, Status status, double newPrice, Map<Long, Integer> closingOrders) throws Exception{
//		try{
//			refillAccount(coverOrder.getUser().getAccount(), currentDeal.getUnits());
//			closeOrderByDeal(coverOrder, status, newPrice, currentDeal, closingOrders);
//
//			refillAccount(coveredOrder.getUser().getAccount(), currentDeal.getUnits());
//			closeOrderByDeal(coveredOrder, status, newPrice, currentDeal, closingOrders);
//
//			closeDeal(currentDeal);
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	private TradeOrder processOrderWhenEqualPrices(TradeOrder order, Deal currentDeal, Status closedStatus,
//			double newPrice, Map<Long, Integer> closingOrders) throws Exception{
//		try{
//			order.setProfit(false);
//			refillAccount(order.getUser().getAccount(), currentDeal.getUnits());
//			order.setMarketPrice(newPrice);
////			closeOrderByDeal(order, closedStatus, newPrice, currentDeal, closingOrders);
//			return order;
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	private void processLosingOrder(TradeOrder losingOrder, Deal currentDeal, Status closedStatus,
//			double newPrice, Map<Long, Integer> closingOrders) throws Exception{
//		try{
//			losingOrder.setProfit(false);
//			closeOrderByDeal(losingOrder, closedStatus, newPrice, currentDeal, closingOrders);
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	private void processDeal(TradeOrder winningOrder, TradeOrder losingOrder, Deal currentDeal,
//			double newPrice, Map<Long, Integer> closingOrders) throws Exception{
//		try{
//			//Close order which won
//			fundAccount(winningOrder.getUser().getAccount(), currentDeal.getUnits());
//			winningOrder.setProfit(true);
//			winningOrder.setMarketPrice(newPrice);
//			closeOrderByDeal(winningOrder, closedStatus, newPrice, currentDeal, closingOrders);
//			//Close order which failed
//			losingOrder.setProfit(false);
//			losingOrder.setMarketPrice(newPrice);
//			closeOrderByDeal(losingOrder, closedStatus, newPrice, currentDeal, closingOrders);
//			closeDeal(currentDeal);
//		} catch(Exception e) {
//			throw e;
//		}
//	}
//
//	private void closeDeal(Deal deal) {
//		deal.setExpired(true);
//		dealDao.update(deal);
//	}
//
//	private void closeOrderByDeal(TradeOrder order, Status closedStatus, double newPrice, Deal currentDeal, Map<Long, Integer> closingOrders) {
//		Integer openedUnitsCounter = closingOrders.get(order.getIdOrder());
//		if(openedUnitsCounter != null){
//			closingOrders.put(order.getIdOrder(), openedUnitsCounter + currentDeal.getUnits());
//		} else {
//			closingOrders.put(order.getIdOrder(), currentDeal.getUnits());
//		}
//		order.setMarketPrice(newPrice);
//		Account account = order.getUser().getAccount();
//		account.setOpenPositions(account.getOpenPositions() - currentDeal.getUnits());
//
//		if(closingOrders.get(order.getIdOrder()) >= order.getOpenedUnits() && order.getPendingUnits() == 0){				/////MUST BE == (not >=)!!!!!!!!!!!
//			order.setStatus(closedStatus);
//			order.setMarketPrice(newPrice);
//			account.setClosedPositions(account.getClosedPositions() + order.getOpenedUnits());
//		}
//		update(order);
//		//Edit account data
//		accountDao.update(account);
//	}
//
//	@Override
//	public void endTimeInterval(String assetName, double newPrice) {
//		List<TradeOrder> currentOrders = findCurrentOrdersByAssetName(assetName);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//
//		Account ownerAccount = null;
//
//		for (TradeOrder currentOrder : currentOrders) {
//			ownerAccount = new Account();
//			switch (currentOrder.getStatus().getName()) {
//			case OPENED_STATUS_NAME:
//				switch (currentOrder.getPosition()) {
//				case SELL_POSITION_NAME:
//					ownerAccount = currentOrder.getUser().getAccount();
//					if (currentOrder.getPrice() > newPrice) {
//						fundAccount(ownerAccount, currentOrder.getOpenedUnits());
//						currentOrder.setProfit(true);
//						closeOrder(currentOrder, closedStatus, newPrice);
//					} else {
//						currentOrder.setProfit(false);
//						closeOrder(currentOrder, closedStatus, newPrice);
//					}
//					break;
//				case BUY_POSITION_NAME:
//					ownerAccount = currentOrder.getUser().getAccount();
//					if (currentOrder.getPrice() < newPrice) {
//						fundAccount(ownerAccount, currentOrder.getOpenedUnits());
//						currentOrder.setProfit(true);
//						closeOrder(currentOrder, closedStatus, newPrice);
//					} else {
//						currentOrder.setProfit(false);
//						closeOrder(currentOrder, closedStatus, newPrice);
//					}
//					break;
//				}
//				break;
//			case PENDING_STATUS_NAME:
//				ownerAccount = currentOrder.getUser().getAccount();
//				if (currentOrder.getOpenedUnits() == 0) {
//					refillAccount(ownerAccount,
//							currentOrder.getPendingUnits());
//					cancelOrder(currentOrder, closedStatus, newPrice);
//				} else {
//					switch (currentOrder.getPosition()) {
//					case SELL_POSITION_NAME:
//						ownerAccount = currentOrder.getUser().getAccount();
//						if (currentOrder.getPrice() > newPrice) {
//							fundAccount(ownerAccount,
//									currentOrder.getOpenedUnits());
//							currentOrder.setProfit(true);
//							refillAccount(ownerAccount,
//									currentOrder.getPendingUnits());
//							closeOrder(currentOrder, closedStatus, newPrice);
//						} else {
//							refillAccount(ownerAccount,
//									currentOrder.getPendingUnits());
//							currentOrder.setProfit(false);
//							closeOrder(currentOrder, closedStatus, newPrice);
//						}
//						break;
//					case BUY_POSITION_NAME:
//						ownerAccount = currentOrder.getUser().getAccount();
//						if (currentOrder.getPrice() < newPrice) {
//							fundAccount(ownerAccount,
//									currentOrder.getOpenedUnits());
//							currentOrder.setProfit(true);
//							refillAccount(ownerAccount,
//									currentOrder.getPendingUnits());
//							closeOrder(currentOrder, closedStatus, newPrice);
//						} else {
//							refillAccount(ownerAccount,
//									currentOrder.getPendingUnits());
//							currentOrder.setProfit(false);
//							closeOrder(currentOrder, closedStatus, newPrice);
//						}
//						break;
//					}
//				}
//				break;
//			}
//		}
//	}
//
//	private void refillAccount(Account ownerAccount, int units) {
//		ownerAccount.setBalance((int)ownerAccount.getBalance() + units * UNIT_COST);
//		accountDao.update(ownerAccount);
//	}
//
//
//
//	private void fundAccount(Account ownerAccount, int units) {
//		ownerAccount.setBalance((int)ownerAccount.getBalance() + units * UNIT_COST * ORDER_WIN_RAISE_INDEX);
//		accountDao.update(ownerAccount);
//	}
//
//	private void closeOrder(TradeOrder order, Status closedStatus, double newPrice) {
//		order.setStatus(closedStatus);
//		order.setMarketPrice(newPrice);
//		update(order);
//
//		//Edit account data
//		Account account = order.getUser().getAccount();
//		account.setClosedPositions(account.getClosedPositions() + order.getOpenedUnits());
//		account.setOpenPositions(account.getOpenPositions() - order.getOpenedUnits());
//		account.setPendingPositions(account.getPendingPositions() - order.getPendingUnits());
//
//		accountDao.update(account);
//	}
//
//	private void cancelOrder(TradeOrder order, Status closedStatus, double newPrice) {
//		Account account = order.getUser().getAccount();
//		account.setClosedPositions(account.getClosedPositions() + order.getOpenedUnits());
//		account.setPendingPositions(account.getPendingPositions() - order.getPendingUnits());
//		accountDao.update(account);
//		order.setStatus(closedStatus);
//		order.setMarketPrice(newPrice);
//		update(order);
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentByUser(User user) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CURRENT_BY_USER,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findClosedByUser(User user) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CLOSED_BY_USER,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findCurrentForUserByAsset(User user, String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CURRENT_BY_USER_ASSET,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("assetName", assetName);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findClosedForUserByAsset(User user, String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CLOSED_BY_USER_ASSET,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("assetName", assetName);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findClosedForUserForLastMonth(User user) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CLOSED_BY_USER_LAST_MONTH,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		Date date = new Date();
//		if(date.getMonth() == 0){
//			date.setMonth(11);
//			date.setYear(date.getYear()-1);;
//		} else {
//			date.setMonth(date.getMonth()-1);
//		}
//		tq.setParameter("date", date);
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<TradeOrder> findClosedForUserByAssetForLastMonth(User user, String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_CLOSED_BY_USER_ASSET_LAST_MONTH,
//                TradeOrder.class);
//		closedStatus = findStatusByName(CLOSED_STATUS_NAME);
//		tq.setParameter("status", closedStatus);
//		tq.setParameter("user", user);
//		tq.setParameter("assetName", assetName);
//		Date date = new Date();
//		if(date.getMonth() == 0){
//			date.setMonth(11);
//			date.setYear(date.getYear()-1);;
//		} else {
//			date.setMonth(date.getMonth()-1);
//		}
//		tq.setParameter("date", date);
//		return tq.getResultList();
//	}
//
//	@Override
//	public long getUnitsAmountForUserByAsset(User user, String assetName) {
//		TypedQuery<Long> tq = entityManager.createQuery(FIND_UNITS_AMOUNT_FOR_USER_BY_ASSET,
//                Long.class);
//		tq.setParameter("user", user);
//		tq.setParameter("assetName", assetName);
//		try{
//			return tq.getSingleResult();
//		}catch(NullPointerException e){
//			return 0;
//		}
//	}
//
//	@Override
//	public List<TradeOrder> findPendingByAsset(String assetName) {
//		TypedQuery<TradeOrder> tq = entityManager.createQuery(FIND_BY_ASSET_STATUS,
//                TradeOrder.class);
//		pendingStatus = findStatusByName(PENDING_STATUS_NAME);
//		tq.setParameter("status", pendingStatus);
//		tq.setParameter("assetName", assetName);
//		return tq.getResultList();
//	}
//
//
//
//}
