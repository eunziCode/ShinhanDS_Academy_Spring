package com.shinhan.myapp.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class DeptDTO2 {
	int dept_id;
	String dept_name;
	int manager_id;
	int location_id;
}
