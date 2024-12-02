package com.shinhan.myapp.model;

import java.util.List;

import com.shinhan.myapp.vo.DeptDTO;

public interface DeptDAOInterface {
	public List<DeptDTO> selectAll();

	public DeptDTO selectById(int dept_id);

	public int insert(DeptDTO dept);

	public int update(DeptDTO dept);

	public int delete(int dept_id);
}
