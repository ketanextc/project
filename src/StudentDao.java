

public class StudentDao {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Found");
			con = DriverManager.getConnection("jdbc:mysql://192.168.100.26:3306/group015","group015","welcome");
			System.out.println("Connection Established");
			
			
		}catch (Exception e) {
		System.out.println(e);
		}		
		return con;
	}
	public static int save(Student s) throws SQLException
	{
		Connection con= StudentDao.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into prn (prn,oop,java,awp)  values (?,?,?,?)");
		pstmt.setInt(1, s.getPrn());
		pstmt.setInt(2, s.getOop());
		pstmt.setInt(3, s.getJava());
		pstmt.setInt(4, s.getAwp());
		 int ans=pstmt.executeUpdate();
		
		return ans;
	}
	
	public static int Update(String ss) throws SQLException
	{
		Student s=new Student();
		Connection con= StudentDao.getConnection();
		System.out.println("The Print On Update Dao --> "+s);
		//int x=Integer.parseInt(s.trim());
		PreparedStatement pstmt=con.prepareStatement("UPDATE crud "+"SET ename=?,epass=?,email=?,country=?"+" WHERE id=");
		
		pstmt.setInt(1, s.getPrn());
		pstmt.setInt(2, s.getOop());
		pstmt.setInt(3, s.getJava());
		pstmt.setInt(4, s.getAwp());
		 int ans=pstmt.executeUpdate();
		System.out.println("The ID is in integer Empdao---> ");
		return ans;
	}
		
		
	public static boolean validate(Student e) throws SQLException {
		
		Connection con = StudentDao.getConnection();
		PreparedStatement pstmt= con.prepareStatement("select * from prn where id=?");
		pstmt.setInt(1, e.getPrn());
		//pstmt.setString(2, e.getOop());
		
		ResultSet rs=pstmt.executeQuery();
		boolean status=rs.next();
		
		return status;
	}
	public static int check(Student s) throws SQLException {
		Connection con = StudentDao.getConnection();
		PreparedStatement pstmt= con.prepareStatement("select  from prn where empname= ?"+" and emppwd=?");
		return 0;
	
	}
	
	
	
	
}
