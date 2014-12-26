package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sourceit.lisanets.bean.Guest;

public class GuestDAO {

	public List<Guest> getAll() {
		List<Guest> list = null;

		try (Connection c = ConnectionFactory.getConnection();
				Statement st = c.createStatement()) {

			ResultSet result = st.executeQuery("select * from Guest");
			list = new ArrayList<>();

			while (result.next()) {

				Guest g = new Guest();
				g.setId_guest(result.getInt(1));
				g.setFirst_name(result.getString(2));
				g.setLast_name(result.getString(3));
				g.setPhone(result.getString(4));
				g.setEmail(result.getString(5));
				g.setPassword(result.getString(6));

				list.add(g);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	public void add(Guest g) throws SQLException {

		
			Connection c = ConnectionFactory.getConnection();
			java.sql.PreparedStatement st = c
					.prepareStatement("insert into Guest VALUES (?, ?,?,?, ?, ?) ");

			st.setInt(1, g.getId_guest());
			st.setString(2, g.getFirst_name());
			st.setString(3, g.getLast_name());
			st.setString(4, g.getPhone());
			st.setString(5, g.getEmail());
			st.setString(6, g.getPassword());
			st.execute();
			c.close();
			st.close();
		

	}

	public void delete(int id) {

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("delete from guest where id_guest = ? ")) {

			st.setInt(1, id);
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public Guest getGuest( String email) {
		Guest g = null;

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("SELECT * FROM newhotel.guest where email = ? ")) {

			st.setString(1,email);
			ResultSet result = st.executeQuery();
             g =  new Guest();
			while (result.next()) {

				g.setId_guest(result.getInt(1));
				g.setFirst_name(result.getString(2));
				g.setLast_name(result.getString(3));
				g.setPhone(result.getString(4));
				g.setEmail(result.getString(5));
				g.setPassword(result.getString(6));

				

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return g;
	}
	
	
	
}
