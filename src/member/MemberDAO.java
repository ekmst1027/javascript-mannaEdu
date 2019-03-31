package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DB;

public class MemberDAO {
	public String login(MemberVO vo) {
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConn();
			String sql = "SELECT * FROM member WHERE userid=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {	// 결과셋이 존재하면, 로그인 성공
				result = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		
		return result;
	}
}
