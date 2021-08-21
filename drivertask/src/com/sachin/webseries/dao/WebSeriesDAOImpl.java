package com.sachin.webseries.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sachin.webseries.constant.Genre;
import com.sachin.webseries.constant.StreamedIn;
import com.sachin.webseries.dto.WebSeriesDTO;
import static com.sachin.restaurant.constant.JdbcConnection.*;

public class WebSeriesDAOImpl implements WebSeriesDAO {

	@Override
	public int save(WebSeriesDTO dto) {
		System.out.println(dto);
		Connection tempConnection = null;
		int temp = 0;

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn,w_genre,w_ageLimit)values(?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				temp = rs.getInt(1);
			}
			prepare.setString(1, dto.getName());
			prepare.setInt(2, dto.getNoOfEpisodes());
			prepare.setInt(3, dto.getTotalSeason());
			prepare.setString(4, dto.getStreamedIn().toString());
			prepare.setString(5, dto.getGenre().toString());
			prepare.setInt(6, dto.getAgeLimit());
			prepare.execute();

			connection.commit();
			dto.setId(temp);
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
	public Collection<WebSeriesDTO> saveAll(Collection<WebSeriesDTO> collection) {
		Collection<WebSeriesDTO> list = new ArrayList<WebSeriesDTO>();
		Connection temp = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			temp = connection;

			String query = "insert into webseries(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn,w_genre,w_ageLimit) values (?,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("w_id");
				String name = resultSet.getString("w_name");
				int w_noOfEpisodes = resultSet.getInt("w_noOfEpisodes");
				int w_season = resultSet.getInt("w_totalSeason");
				String w_streamedIn = resultSet.getString("w_+streamedIn");
				String w_gener = resultSet.getString("w_genre");
				int w_ageLimit = resultSet.getInt("w_ageLimit");
				WebSeriesDTO dto1 = new WebSeriesDTO(name, w_noOfEpisodes, w_season, StreamedIn.valueOf(w_streamedIn),
						Genre.valueOf(w_gener), w_ageLimit);
				dto1.setId(id);
				collection.add(dto1);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return collection;
	}

	@Override
	public Collection<WebSeriesDTO> findAll() {
		Collection cl = new ArrayList();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO ws = createValuesFromResultSet(resultSet);
				cl.add(ws);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate) {
		Collection<WebSeriesDTO> list = new ArrayList<WebSeriesDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				WebSeriesDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int total() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select count(w_id) from webseries;";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
			ResultSet result = statement.getResultSet();
			while (result.next()) {
				temp = result.getInt(1);
				System.out.print("total number 0f webseries ");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return temp;
	}

	@Override
	public int findMaxSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries where w_totalSeason = (select max(w_totalSeason) from webseries)";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet set = prepare.getResultSet();
			if (set.next()) {
				temp = set.getInt("w_totalSeason");

				System.out.print("max no of season ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int findMinSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries where w_totalSeason = (select min(w_totalSeason) from webseries)";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet set = prepare.getResultSet();
			if (set.next()) {
				temp = set.getInt("w_totalSeason");

				System.out.print("min no of season ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
			
	}

	@Override
	public Collection<WebSeriesDTO> findAllSortNameDesc() {
		Collection cl = new ArrayList();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries order by w_name desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO ws = createValuesFromResultSet(resultSet);
				cl.add(ws);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate) {
		Optional<WebSeriesDTO> optional=Optional.empty();
		try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String query="select * from webseries";
			PreparedStatement prepare=connection.prepareStatement(query);
			ResultSet result=prepare.executeQuery();
			
			while(result.next()) {
				WebSeriesDTO dto = createValuesFromResultSet(result);
				if(predicate.test(dto)) {
					optional=Optional.of(dto);
					break;
				}
				}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
			
		return optional;
	}

	private WebSeriesDTO createValuesFromResultSet(ResultSet resultSet) throws SQLException {
		int wid = resultSet.getInt("w_id");
		String wname = resultSet.getString("w_name");
		int wepisodes = resultSet.getInt("w_noOfEpisodes");
		int wseason = resultSet.getInt("w_totalSeason");
		String wstreamed = resultSet.getString("w_streamedIn");
		String wgenre = resultSet.getString("w_genre");
		int wage = resultSet.getInt("w_ageLimit");

		WebSeriesDTO ws = new WebSeriesDTO(wname, wepisodes, wseason, StreamedIn.valueOf(wstreamed),
				Genre.valueOf(wgenre), wage);
		ws.setId(wid);
		return ws;
	}

	}
