package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.bean.FreeRoom;
import com.sourceit.lisanets.bean.Room;
import com.sourceit.lisanets.exceptions.DataBaseExceprion;
import com.sourceit.lisanets.servlet.ServletController;

public class RoomDAO {
	
	private static final Logger logger = Logger.getLogger(RoomDAO.class);
	
	public List<Room> getAll() {
		List<Room> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.Statement st = c.createStatement()) {
			ResultSet result = st.executeQuery("select * from `Room`");
			list = new ArrayList<Room>();

			while (result.next()) {
				list.add(new Room(result.getInt("room_number"), result
						.getInt("room_type"), result.getInt("max_persons")));

			}
		} catch (SQLException e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}

		return list;
	}

	private void add(Room room) {
		try {
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("insert into `Room` VALUES (?, ?,?) ");

			st.setInt(1, room.getRoomNumber());
			st.setInt(2, room.getRoomType());
			st.setInt(3, room.getMaxPerson());

			st.execute();
			c.close();
			st.close();
		} catch (SQLException e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}
	}

	public List<FreeRoom> getCountFree(String dateIn, String dateOut) {

		List<FreeRoom> listFreeRoom = null;

		try {
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("SELECT count(room.room_number), room_type, max_persons from room where room.room_number not in (SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` <= ? and o.`check-out` >= ?) group by room_type, max_persons");

			st.setString(1, dateOut);
			st.setString(2, dateIn);

			listFreeRoom = new ArrayList<FreeRoom>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FreeRoom fr = new FreeRoom();
				fr.setCount(rs.getInt(1));
				fr.setRoom_type(rs.getInt(2));
				fr.setMax_persons(rs.getInt(3));
				listFreeRoom.add(fr);

			}
			c.close();
			st.close();
		} catch (SQLException e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}
		return listFreeRoom;
	}

	public List<Room> getFreeRoom(String dateIn, String dateOut) {
		List<Room> listRoom = null;
		try (Connection c = ConnectionFactory.getConnection();

				java.sql.PreparedStatement st = c
						.prepareStatement("SELECT *  from room where room.room_number  not in (SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` <= ? and o.`check-out` >= ?) ")) {
			listRoom = new ArrayList<Room>();
			st.setString(1, dateOut);
			st.setString(2, dateIn);
			ResultSet result = st.executeQuery();

			while (result.next()) {
				listRoom.add(new Room(result.getInt("room_number"), result
						.getInt("room_type"), result.getInt("max_persons")));

			}
		} catch (SQLException e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}

		return listRoom;
	}

}
