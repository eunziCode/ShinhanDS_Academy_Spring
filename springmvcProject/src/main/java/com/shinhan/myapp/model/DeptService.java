package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.myapp.vo.DeptDTO;

/* @Service 
== @Component + service
== <bean id="deptService class="ÆÐÅ°Áö.DeptService"></bean> */

@Service
public class DeptService {

	@Autowired
	DeptDAO deptDAO;

	public List<DeptDTO> selectAllService() {
		return deptDAO.selectAll();
	}

	public DeptDTO selectByIdService(int dept_id) {

		return deptDAO.selectById(dept_id);
	}

	public int insertService(DeptDTO emp) {
		return deptDAO.insert(emp);
	}

	public int updateService(DeptDTO emp) {
		return deptDAO.update(emp);
	}

	public int deleteService(int dept_id) {
		return deptDAO.delete(dept_id);
	}
}
