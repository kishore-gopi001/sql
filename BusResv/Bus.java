package BusResv;
import java.util.*;
import java.sql.*;

public class Bus {
	private int busNo;
	private boolean ac;
	private int capacity;
	
	
	Bus(int no,boolean ac,int cap){
		this.busNo = no;
		this.ac = ac;
		this.capacity = cap;
	}

	public static void addBusInfo() throws SQLException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter your bus id");
		int id = sc.nextInt();
		System.out.println(" did your bus contains ac"+"\n" +"if yes enter true else false");
		boolean ac = sc.nextBoolean();
		System.out.println(" enter the capacity of your bus");
		int capacity =  sc.nextInt();

		String query = "Insert into bus values(?,?,?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setBoolean(2, ac);
		pst.setInt(3, capacity);
		pst.executeUpdate();
	}
	
	public int getBusNo(){ //accessors
		return busNo;
	}
	
	public boolean isAc(){
		return ac;
	}
	public int getCapacity(){ //accessor method
		return capacity;
	}
	
	public void setAc(boolean val) { //mutators
		ac = val;
	}
	
	public void setCapacity(int cap) { //mutator
		capacity = cap;
	}
	
}
