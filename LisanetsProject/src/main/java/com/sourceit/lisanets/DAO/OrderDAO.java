package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sourceit.lisanets.bean.Order;

public class OrderDAO {
	private static int increment = getIncrement();

	public List<Order> getAll() {
		List<Order> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.Statement st = c.createStatement()) {
			ResultSet result = st.executeQuery("select * from `Order`");
			list = new ArrayList<Order>();

			while (result.next()) {
				Order o = new Order();
				o.setOrder_id(result.getInt("order_id"));
				o.setId_guest(result.getInt("guest_id"));
				o.setCheck_in(result.getString("check-in"));
				o.setCheck_out(result.getString("check-out"));
				o.setRoom_number(result.getInt("room_number"));
				o.setStatus(result.getString("status"));
				list.add(o);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void add(Order o) {

		try {
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("insert into `Order` VALUES (0,?, ?,?,?, ?, ?) ");

			st.setInt(1, getOrder_id(o.getId_guest()));
			st.setInt(2, o.getId_guest());
			st.setString(3, o.getCheck_in());
			st.setString(4, o.getCheck_out());
			st.setInt(5, o.getRoom_number());
			st.setString(6, o.getStatus());

			st.execute();
			c.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("delete from `Order` where order_id = ? ")) {

			st.setInt(1, id);
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		increment++;
		return increment;
	}

	private boolean checkOrder(Order o) {
		List<Integer> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				PreparedStatement st = c
						.prepareStatement("SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` < ? and o.`check-out` >= ?")) {
			st.setString(1, o.getCheck_out());
			st.setString(2, o.getCheck_in());
			list = new ArrayList<Integer>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			if (list.contains(o.getRoom_number()))
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}

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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return result;
	}

}
