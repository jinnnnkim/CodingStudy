package kr.co.loginDB;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class MemberDAO {

	//DB연결
	private Connection con;
	private PreparedStatement pst;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//멤버 조회
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<>();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "SELECT * FROM t_joinMember order by regDate desc";
			System.out.println(query);
			
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				Date regDate = rs.getDate("regDate");
				
				MemberVO memberVO = new MemberVO();
				
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setTel(tel);
				memberVO.setRegDate(regDate);
				
				list.add(memberVO);
				//설정된 MemberVO 객체를 ArrayList에 저장
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
		//멤버 추가
		public void addMember(MemberVO memberVO) {
			
			try {
				con = dataFactory.getConnection();
				
				String id = memberVO.getId();
				String pwd = memberVO.getPwd();
				String name = memberVO.getName();
				String tel =memberVO.getTel();
				
				
				String query ="insert into t_joinmember (id,pwd,name,tel) values (?,?,?,?)";
				System.out.println("prepareStatement : " + query);
				
				pst = con.prepareStatement(query);
				
				pst.setString(1, id);
				pst.setString(2, pwd);
				pst.setString(3, name);
				pst.setString(4, tel);
				
				pst.executeUpdate();	//회원 정보 테이블에 추가함.
				pst.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
	
