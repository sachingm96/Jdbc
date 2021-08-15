package com.sachin.customer.dao;

import static com.sachin.restaurant.constant.JdbcConnection.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sachin.customer.constant.Education;
import com.sachin.customer.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		System.out.println(dto);
		Connection tempConnection = null;
		int temp = 0;

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet rs = prepare.getGeneratedKeys();
			prepare.setString(1, dto.getName());
			prepare.setString(2, dto.getFrom());
			prepare.setString(3, dto.getTo());
			prepare.setString(4, dto.getAddress());
			prepare.setBoolean(5, dto.isMarried());
			prepare.setInt(6, dto.getPassportNo());
			prepare.setString(7, dto.getEdu().toString());
			if (rs.next()) {
				temp = rs.getInt(1);
			}
			System.out.println(temp);
			dto.setId(temp);
			prepare.execute();
			connection.commit();
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return temp;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			collection.forEach(dto -> {
				try {
					prepare.setString(1, dto.getName());
					prepare.setString(2, dto.getFrom());
					prepare.setString(3, dto.getTo());
					prepare.setString(4, dto.getAddress());
					prepare.setBoolean(5, dto.isMarried());
					prepare.setInt(6, dto.getPassportNo());
					prepare.setString(7, dto.getEdu().toString());
					prepare.execute();
					System.out.println(dto);
				} catch (Exception e) {
				}
			});
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("c_id");
				CustomerDTO dto = createValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from customer order by c_name desc";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	private CustomerDTO createValuesFromResultSet(ResultSet result) throws SQLException {
		int id = result.getInt("c_id");
		String name = result.getString("c_name");
		String from = result.getString("c_from");
		String to = result.getString("c_to");
		String address = result.getString("c_address");
		Boolean married = result.getBoolean("c_married");
		int passportNo = result.getInt("c_passportNo");
		String education = result.getString("c_education");
		CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo, Education.valueOf(education));
		dto.setId(id);
		return dto;
	}

	@Override
	public int total() {
		int total = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT count(c_name) from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				total = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
