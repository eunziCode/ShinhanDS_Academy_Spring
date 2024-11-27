package com.shinhan.mavenProject.section8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/* @Service 
== @Component + service
== <bean id="deptService class="패키지.DeptService"></bean> */

@Service
public class DeptService {
//	DeptDAO deptDAO = new DeptDAO(); ▶ 기존에는 생성했지만 DeptDAO에서 생성했기때문에 불필요
	
	@Autowired // ref(Type이 같으면 자동으로 Injection)
	DeptDAO deptDAO;

	public List<DeptDTO> selectAllService() {
		System.out.println("-------------------selectAllService-------------------");
		return deptDAO.selectAll();
	}

	public DeptDTO selectByIdService(int dept_id) {

		return deptDAO.selectById(dept_id);
	}

	// 입력서비스
	public int insertService(DeptDTO emp) {
		return deptDAO.insert(emp);
	}

	// 수정서비스
	public int updateService(DeptDTO emp) {
		return deptDAO.update(emp);
	}

	// 삭제서비스
	public int deleteService(int dept_id) {
		return deptDAO.delete(dept_id);
	}
}
