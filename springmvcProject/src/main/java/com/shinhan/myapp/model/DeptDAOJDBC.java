package com.shinhan.myapp.model;

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

import com.shinhan.myapp.vo.DeptDTO;

import lombok.extern.slf4j.Slf4j;
import net.firstzone.util.DBUtil;

/* @Repository
== @Component + DAO
== <bean id="deptDAO2" class="패키지.DeptDAO"></bean> */

@Slf4j
@Repository("deptDAO2")
public class DeptDAOJDBC implements DeptDAOInterface {
	// @Autowired : Type이 같으면 자동으로 Injection (IOC, DI)
	@Autowired 
	DataSource ds;
	
	String sql_selectAll = "select * from departments order by department_id";
	String sql_selectById = "select * from departments where department_id=?";
	String sql_insert = "insert into departments values(?,?,?,?)";
	String sql_update = "update departments set "+
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

		log.info("dept조회건수(JDBC):" + deptlist.size());
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

	public int insert(DeptDTO dept) {
		int result = 0;

		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_insert);
			
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			
			if(dept.getManager_id()==0)
				st.setNull(3, Types.NULL); 
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

		return result;
	}

	public int update(DeptDTO dept) {
		int result = 0;
		
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

		return result;
	}

	public int delete(int dept_id) {
		int result = 0;

		try {
			conn = ds.getConnection();
			
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql_delete);
			st.setInt(1, dept_id);

			result = st.executeUpdate();
			
			conn.commit(); 
		} catch (SQLException e) {
			try {
				conn.rollback(); 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

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
