package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.bean.Order;
import com.sourceit.lisanets.exceptions.DataBaseException;
import com.sourceit.lisanets.servlet.ServletController;

public class OrderDAO {
	private static int increment = getIncrement();

	private static final Logger logger = Logger.getLogger(OrderDAO.class);

	public List<Order> getAll() {
		List<Order> listOrders = null;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.Statement st = c.createStatement()) {
			ResultSet result = st.executeQuery("select * from `Order`");
			listOrders = new ArrayList<Order>();

			while (result.next()) {
				Order order = new Order();
				order.setOrderId(result.getInt("order_id"));
				order.setGuestId(result.getInt("guest_id"));
				order.setCheckIn(result.getString("check-in"));
				order.setCheckOut(result.getString("check-out"));
				order.setRoomNumber(result.getInt("room_number"));
				order.setStatus(result.getString("status"));
				listOrders.add(order);

			}
		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}

		return listOrders;
	}

	public void add(Order o) {

		try {
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("insert into `Order` VALUES (0,?, ?,?,?, ?, ?) ");

			st.setInt(1, getOrder_id(o.getGuestId()));
			st.setInt(2, o.getGuestId());
			st.setString(3, o.getCheckIn());
			st.setString(4, o.getCheckOut());
			st.setInt(5, o.getRoomNumber());
			st.setString(6, o.getStatus());

			st.execute();
			c.close();
			st.close();
			logger.info("order was added:" + o.toString());
		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}

	}

	public void delete(int id) {

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("delete from `Order` where order_id = ? ")) {

			st.setInt(1, id);
			st.execute();

		} catch (Exception e) {
			logger.error(e);
			throw new DataBaseException(e);
		}

	}

	private int getOrder_id(int id) {

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("SELECT * from `order` where status = 'new' and guest_id = ? ")) {
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next())
				return rs.getInt("order_id");
		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
		increment++;
		return increment;
	}

	private boolean checkOrder(Order order) {
		List<Integer> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				PreparedStatement st = c
						.prepareStatement("SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` < ? and o.`check-out` >= ?")) {
			st.setString(1, order.getCheckOut());
			st.setString(2, order.getCheckIn());
			list = new ArrayList<Integer>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			if (list.contains(order.getRoomNumber()))
				return false;

		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
		return true;
	}

	public void changeStatus() {
		List<Integer> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				PreparedStatement st = c
						.prepareStatement("select `key` from `order`where `check-out` <= current_date()");
				PreparedStatement st2 = c
						.prepareStatement("update `order` as a set `status` = 'closed' where `key` = ? ")

		) {

			list = new ArrayList<Integer>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			for (Integer i : list) {
				st2.setInt(1, i);
				st2.execute();
			}

		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
		logger.info("statuses was update");
	}

	public void changeStatus(int guest_id) {
		List<Integer> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				PreparedStatement st = c
						.prepareStatement("select `key` from `order` where guest_id = ? and `status` = 'new'");
				PreparedStatement st2 = c
						.prepareStatement("update `order` as a set `status` = 'processing' where `key` = ? ")

		) {

			list = new ArrayList<Integer>();
			st.setInt(1, guest_id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			for (Integer i : list) {
				st2.setInt(1, i);
				st2.execute();
			}

		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
	}

	private static int getIncrement() {
		int result = 0;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.Statement st = c.createStatement()) {
			ResultSet rs = st
					.executeQuery("SELECT max(order_id) FROM newhotel.`order`");
			rs.next();
			result = rs.getInt(1);

		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
		return result;
	}

	public Integer getIDBook(int id) {
		Integer result = 0;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("SELECT * from `order` where status = 'new' and guest_id = ? ")) {
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			rs.next();
			result = rs.getInt("order_id");
		} catch (SQLException e) {
			logger.error(e);
			throw new DataBaseException(e);
		}
		return result;
	}

}
