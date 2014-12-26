package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sourceit.lisanets.bean.FreeRoom;
import com.sourceit.lisanets.bean.Room;

public class RoomDAO {
	
	
	public List<Room> getAll() {
		List<Room> list = null;
		try (Connection c = ConnectionFactory.getConnection();
				java.sql.Statement st = c.createStatement()) {
			ResultSet result = st.executeQuery("select * from `Room`");
			list = new ArrayList<Room>();

			while (result.next()) {
				list.add(new Room(result.getInt("room_number"), result.getInt("room_type"), result.getInt("max_persons")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
}

  private void add(Room r){
	try {
		Connection c = ConnectionFactory.getConnection();
		java.sql.PreparedStatement st = c
				.prepareStatement("insert into `Room` VALUES (?, ?,?) ");

		st.setInt(1, r.getRoom_number());
		st.setInt(2, r.getRoom_type());
		st.setInt(3, r.getMax_persons());
		
		st.execute();
		c.close();
		st.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }

  public List<FreeRoom> getCountFree(String in, String out ) {
	  
	  
	  List<FreeRoom> list = null;
		
	  try {
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("SELECT count(room.room_number), room_type, max_persons from room where room.room_number not in (SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` <= ? and o.`check-out` >= ?) group by room_type, max_persons");

			st.setString(1, out);
			st.setString(2, in);
				
	      list = new ArrayList<FreeRoom>();
			ResultSet rs = st.executeQuery();
			while(rs.next()){
			FreeRoom fr = new FreeRoom();
				fr.setCount(rs.getInt(1));
				fr.setRoom_type(rs.getInt(2));
				fr.setMax_persons(rs.getInt(3));
				list.add(fr);
				
			}
			c.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
}
	  
    
  public List<Room> getFreeRoom(String in, String out) {
		List<Room> list = null;
		try (Connection c = ConnectionFactory.getConnection();
			
			java.sql.PreparedStatement st = c.prepareStatement("SELECT *  from room where room.room_number  not in (SELECT o.room_number FROM `order` o join room r on o.room_number = r.room_number where o.status <> 'closed' and o.`check-in` <= ? and o.`check-out` >= ?) ")) {
			list = new ArrayList<Room>();
			st.setString(1, out);
			st.setString(2, in);
			ResultSet result = st.executeQuery();
			
			
			while (result.next()) {
				list.add(new Room(result.getInt("room_number"), result.getInt("room_type"), result.getInt("max_persons")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
}
	  
  }



