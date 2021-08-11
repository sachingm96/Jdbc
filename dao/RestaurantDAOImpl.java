package com.sachin.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import static com.sachin.restaurant.constant.JdbcConnection.*;

import com.sachin.restaurant.constant.RestaurantType;
import com.sachin.restaurant.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int save(RestaurantDTO dto) {
		int aiId = 0;
		System.out.println("Saved DTO into DAO");
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "INSERT INTO restaurant(r_name,r_location,r_specialFood,r_best,r_type) VALUES('"
					+ dto.getName() + "','" + dto.getLocation() + "'," + "'" + dto.getSpecialFood() + "',"
					+ dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
			}
			connection.commit();
			dto.setId(aiId);
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return aiId;
	}

	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM restaurant WHERE r_name = '" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String resName = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String special = resultSet.getString("r_specialFood");
				boolean best = resultSet.getBoolean("r_best");
				String type = resultSet.getString("r_type");
				System.out.println("Find By Name");
				RestaurantDTO dto = new RestaurantDTO(resName, location, special, best, RestaurantType.valueOf(type));
				dto.setId(id);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<RestaurantDTO> findByType(RestaurantType type) {
		Collection<RestaurantDTO> collection = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM restaurant WHERE r_type = '" + type + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String name = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String special = resultSet.getString("r_specialFood");
				boolean best = resultSet.getBoolean("r_best");
				String resType = resultSet.getString("r_type");
				System.out.println("Find By Type " + type);
				RestaurantDTO dto = new RestaurantDTO(name, location, special, best, RestaurantType.valueOf(resType));
				dto.setId(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public boolean updateTypeByName(RestaurantType newType, String givenName) {
		System.out.println("Update type by name : ");
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connection.setAutoCommit(false);
			String query = "UPDATE restaurant SET r_type = '" + newType + "'" + "WHERE r_name = '" + givenName
					+ "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByTypeAndName(RestaurantType type, String name) {
		System.out.println("Delete by type and name : ");
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connection.setAutoCommit(false);
			String query = "DELETE FROM restaurant WHERE r_type = '" + type + "' AND r_name = '" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
