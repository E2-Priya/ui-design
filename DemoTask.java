import java.sql.*;

public class DemoTask {
	static final String DB_URL = "jdbc:mysql://localhost/picdb?&useSSL=false";
	static final String USER = "pic";
	static final String PASS = "picadmin";
	static final String QUERY = "SELECT * FROM carousel_config";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("carousel_config_id"));
				System.out.print(", Model id: " + rs.getInt("model_id"));
				System.out.print(", Start Time: " + rs.getString("start_time"));
				System.out.println(", End Time: " + rs.getString("end_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}