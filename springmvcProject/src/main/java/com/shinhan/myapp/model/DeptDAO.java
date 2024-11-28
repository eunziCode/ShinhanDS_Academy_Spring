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

import net.firstzone.util.DBUtil;

/* @Repository
== @Component + DAO
== <bean id="deptDAO2" class="패키지.DeptDAO"></bean> */

@Repository("deptDAO2")
public class DeptDAO {
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
		// 紐⑤뱺 吏곸썝?쓣 議고쉶?븯湲?
		
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

	// DB?뿉 ?엯?젰
	public int insert(DeptDTO dept) {
		int result = 0;
		
		// Statement?뒗 ?(binding 蹂??닔 吏??썝X) ?넂 PreparedStatement媛? Statement瑜? ?긽?냽諛쏆븘 ?瑜? 吏??썝?븿
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql_insert);
			
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			
			if(dept.getManager_id()==0)
				st.setNull(3, Types.NULL); // ?궗?슜?옄媛? 0?쓣 ?엯?젰?븯硫? null濡? insert
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

		// result媛? 1?씠硫? ?꽦怨?
		return result;
	}

	// ?닔?젙
	public int update(DeptDTO dept) {
		int result = 0;
		
		// Statement?뒗 ?(binding 蹂??닔 吏??썝X) ?넂 PreparedStatement媛? Statement瑜? ?긽?냽諛쏆븘 ?瑜? 吏??썝?븿
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

		// result媛? 1?씠硫? ?꽦怨?
		return result;
	}

	// ?궘?젣
	public int delete(int dept_id) {
		int result = 0;
		
		// Statement?뒗 ?(binding 蹂??닔 吏??썝X) ?넂 PreparedStatement媛? Statement瑜? ?긽?냽諛쏆븘 ?瑜? 吏??썝?븿
		try {
			conn = ds.getConnection();
			
			// ?옄?룞 而ㅻ컠 諛⑹?, ?뵲濡? ?궗?슜?븯吏? ?븡?쑝硫? 湲곕낯?쟻?쑝濡? ?옄?룞 而ㅻ컠?맖
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql_delete);
			st.setInt(1, dept_id);

			result = st.executeUpdate();
			
			conn.commit(); // DB?뿉 諛섏쁺
		} catch (SQLException e) {
			try {
				conn.rollback(); // DB?뿉 ?옉?뾽?븳 ?궡?슜 痍⑥냼
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		// result媛? 1?씠硫? ?꽦怨?
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
