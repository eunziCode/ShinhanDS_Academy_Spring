package com.shinhan.mavenProject.section6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component // Bean과 같은 의미
@Repository // @Component + DAO 와 같은 의미
			// @Repository와 같은 의미 ▶ <bean id="deptDAO" class="패키지.DeptDAO">
public class DeptDAO {
	@Autowired // Type이 같으면 자동으로 Injection
	DataSource ds;
	
	String sql_selectAll = "select * from departments order by department_id";
	String sql_selectById = "select * from departments where department_id=?";
	String sql_insert = "insert into departments values(?,?,?,?)";
	String sql_update = "update departments set"+
						"department_name=?,"+
						"manager_id=?,"+
						"location_id=?"+
						"where department_id=?";
	String sql_delete = "delete from departments where department_id=?";
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	public List<DeptDTO> selectAll() {
		// 모든 직원을 조회하기
		
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();

		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_selectAll);
			rs = st.executeQuery();

			while (rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return deptlist;
	}

	public DeptDTO selectById(int dept_id) {
		DeptDTO dept = null;

		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_selectById);
			st.setInt(1, dept_id);
			rs = st.executeQuery();

			if (rs.next()) {
				dept = makeDept(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return dept;
	}

	// DB에 입력
	public int insert(DeptDTO dept) {
		int result = 0;
		
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_insert);
			
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			
			if(dept.getManager_id()==0)
				st.setNull(3, Types.NULL); // 사용자가 0을 입력하면 null로 insert
			else
				st.setInt(3, dept.getManager_id());
			
			st.setInt(4, dept.getLocation_id());

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		// result가 1이면 성공
		return result;
	}

	// 수정
	public int update(DeptDTO dept) {
		int result = 0;
		
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_update);
			
			st.setInt(4, dept.getDepartment_id());
			st.setString(1, dept.getDepartment_name());
			st.setInt(2, dept.getManager_id());
			st.setInt(3, dept.getLocation_id());

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		// result가 1이면 성공
		return result;
	}

	// 삭제
	public int delete(int dept_id) {
		int result = 0;
		
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			conn = ds.getConnection();
			
			// 자동 커밋 방지, 따로 사용하지 않으면 기본적으로 자동 커밋됨
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql_delete);
			st.setInt(1, dept_id);

			result = st.executeUpdate();
			
			conn.commit(); // DB에 반영
		} catch (SQLException e) {
			try {
				conn.rollback(); // DB에 작업한 내용 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		// result가 1이면 성공
		return result;
	}

	private static DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();

		dept.setDepartment_id(rs.getInt("department_id"));
		dept.setDepartment_name(rs.getString("department_name"));
		dept.setManager_id(rs.getInt("manager_id"));
		dept.setLocation_id(rs.getInt("location_id"));

		return dept;
	}
}
