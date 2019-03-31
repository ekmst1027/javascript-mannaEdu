package keyword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DB;

public class KeywordDAO {
	// 레쿠드 추가
	public void insert(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			String sql = "INSERT INTO keywords VALUES (?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> list(String keyword) {
		List<String> items = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConn();	// db 접속
			String sql = "SELECT * FROM keywords WHERE keyword like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");	// 사용자가 입력한 키워드
			rs = pstmt.executeQuery();	// sql 실행, 결과셋이 rs에 리턴됨
			// 레코드가 존재하면 true
			while(rs.next()) {
				items.add(rs.getString("keyword"));	// 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
}
