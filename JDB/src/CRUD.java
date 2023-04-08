import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	void insert() {
		String user = "Umesh";
		String pass = "1345";
		String insert = "insert into user (username,password) values(?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = GetConnection.getConnnection().prepareStatement(insert);
			// preparedStatement.setInt(1, 7);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			int i = preparedStatement.executeUpdate();
			System.out.println(i + " Record Inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void delete() {
		String no = "7";
		String delet = "delete from user where userNo="+ no;
		try {
			PreparedStatement preparedStatement = GetConnection.getConnnection().prepareStatement(delet);
			int i = preparedStatement.executeUpdate();
			System.out.println(i + " Record deleted Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void updatePassword() {
		String user = "Dheeraj";
		String pass="Dhiru";
		String upda = "update user set password = \""+pass+"\""+"where userName =\""+user+"\"";
		try {
			PreparedStatement preparedStatement = GetConnection.getConnnection().prepareStatement(upda);
			int i =preparedStatement.executeUpdate();
			System.out.println(i + " Record Updted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	void drop() {
		String drop = "drop table user";
		try {
			Statement statement = GetConnection.getConnnection().createStatement();
			statement.executeUpdate(drop);
			System.out.println("Table dropped sucessfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void truncate() {
		String trunc = "truncate table user";
		try {
			PreparedStatement preparedStatement = GetConnection.getConnnection().prepareStatement(trunc);
			preparedStatement.execute();
			System.out.println("Table Truncated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void create() {
		String tablename = "user";
		String column1 = "userNo";
		String column2 = "userName";
		String column3 = "password";
		String prim = "userNo";
		// String create_table = " create table user ";
		String create = "Create table " + tablename + " (" + column1 + " int Auto_increment ," + column2
				+ " varchar(200) ," + column3 + " varchar(200) ," + "primary key( " + prim + ")" + ")";
		try {
			Statement statement = GetConnection.getConnnection().createStatement();
			statement.executeUpdate(create);
			System.out.println(" Table created Successfuly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 void show() {
	String show = "Select * from user";
	try {
		PreparedStatement preparedStatement= GetConnection.getConnnection().prepareStatement(show);
		ResultSet resultSet =  preparedStatement.executeQuery();
		System.out.println("UserNo  "+"UserName  "+"Password  ");
		while(resultSet.next()){
			System.out.print(resultSet.getInt(1)+"        ");
			System.out.print(resultSet.getString(2)+"     ");
			System.out.print(resultSet.getString(3)+"     ");
			System.out.println();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}
	public static void main(String[] args) {
		CRUD crud = new CRUD();
		crud.insert();
//		 crud.delete();
		// crud.drop();
		// crud.create();
		// crud.truncate();
//		crud.updatePassword();
		crud.show();

	}
}
