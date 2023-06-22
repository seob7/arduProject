package com.microrobot.arduProject.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.microrobot.arduProject.dto.dataDTO;

public class dataDAO {
	private static String dburl = "jdbc:mysql://localhost:3306/temphumid?serverTimezone=Asia/Seoul&useSSL=true";
	private static String dbuser = "root";   //mruser
	private static String dbpasswd = "03630";  //mr123
	
	//온습도 데이터 SELECT
	public dataDTO getTemp_Humid_Data() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //mysql 8 version > com.mysql.cj.jdbc.Driver  현재는 mysql5 버젼을 사용하므로 cj 제거
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
		
		ResultSet rs = null;
        
		String sql = "SELECT * FROM temp_humid_data ORDER BY id DESC LIMIT 1";
		dataDTO data = new dataDTO();
        try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
        	
        	rs = ps.executeQuery();

			if(rs.next()) {
				data.setTemp(rs.getDouble("temp"));
				data.setHumid(rs.getDouble("humid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;	
	}
}
