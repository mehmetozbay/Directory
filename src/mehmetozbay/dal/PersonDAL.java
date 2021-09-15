package mehmetozbay.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mehmetozbay.contract.Person;
import mehmetozbay.core.CoreHelper;
import mehmetozbay.interfaces.DALInterfaces;

public class PersonDAL extends CoreHelper implements DALInterfaces<Person> {
	Statement statement = null;
	Connection connection = null;
	ResultSet rs = null;

	@Override
	public boolean insert(Person entity) throws SQLException {
		connection = getConnection();
		statement = connection.createStatement();
		boolean key = false;
		// INSERT INTO DIRECTORY VALUES(directory_seq.nextVal, 'Mehmet',
		// 'Ozbay','23232323', 'aligmail.com','lippstadt');
		String query = "INSERT INTO DIRECTORY VALUES(directory_seq.nextVal,'" + entity.getName() + "','"
				+ entity.getSurName() + "','" + entity.getTel() + "','" + entity.getEmail() + "'," + "'"
				+ entity.getAdress() + "')";
		try {

			statement.executeUpdate(query);

			key = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}
		return key;

	}

	@Override
	public List<Person> getAll() throws SQLException {

		ArrayList<Person> list = new ArrayList<>();
		connection = getConnection();
		String query = "select * from directory";
		Person person;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("tel"),
						rs.getString("email"), rs.getString("adress"));
				list.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				connection.close();
				statement.close();
				rs.close();
			}

		return list;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		connection = getConnection();
		String query = "delete  from directory where id=" + id;
		try {
			statement= connection.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
			statement.close();
		}

	}

	@Override
	public boolean update(Person entity) throws SQLException {

		connection = getConnection();
		String query = "update directory set name='" + entity.getName() + "', " + "surname='" + entity.getSurName() + "'," + " tel= '"
				+ entity.getTel() + "'," + " email= '" + entity.getEmail() + "'," + " adress= '" + entity.getAdress()
				+ "' where id = " + entity.getId();
		
		try {
			statement= connection.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
			statement.close();
		}

	}

	@Override
	public List<Person> getBySearch(String searchText) throws SQLException {
		ArrayList<Person> list = new ArrayList<>();
		connection = getConnection();
		
		
	
		String query = "select * from directory where lower(name) like '%"+searchText.toLowerCase() +"%' or lower(surname) like '%"+searchText.toLowerCase() +"%'"
				+ " or lower(tel) like '%"+searchText.toLowerCase() +"%'"
						+ "or lower(email) like '%"+searchText.toLowerCase() +"%'"
								+ "or lower(adress) like '%"+searchText.toLowerCase() +"%'";
		
		Person person;
		try {
			statement = connection.createStatement();
			
			rs = statement.executeQuery(query);
			while (rs.next()) {
				person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("tel"),
						rs.getString("email"), rs.getString("adress"));
				list.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
			rs.close();
		}
		return list;
	}

}
