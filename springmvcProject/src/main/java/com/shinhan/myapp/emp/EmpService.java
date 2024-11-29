package com.shinhan.myapp.emp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	EmpDAO empDAO;
	
	public List<JobDTO> selectAllJobService() {
		return empDAO.selectAllJob();
	}
	
	public List<EmpDTO> selectAllService() {
		return empDAO.selectAll();
	}
	
	public EmpDTO selectByIdService(int empid) {
		
		return empDAO.selectById(empid);
	}
	
	public List<EmpDTO> selectByDeptIdService(int deptid) {
		
		return empDAO.selectByDeptId(deptid);
	}
	
	public List<EmpDTO> selectByJobIdService(String jobid) {
		
		return empDAO.selectByJobId(jobid);
	}
	
	public List<EmpDTO> selectBySalaryService(double salary) {
		
		return empDAO.selectBySalary(salary);
	}
	
	public List<EmpDTO> selectByConditionService(Map<String,Object> map) {
		
		return empDAO.selectByCondition(map);
	}
	
	// ?ž…? ¥?„œë¹„ìŠ¤
	public int insertService(EmpDTO emp) {
		return empDAO.insert(emp);
	}
	
	// ?ˆ˜? •?„œë¹„ìŠ¤
	public int updateService(EmpDTO emp) {
		return empDAO.update(emp);
	}
	
	// ?‚­? œ?„œë¹„ìŠ¤
	public int deleteService(int empid) {
		return empDAO.delete(empid);
	}
}
