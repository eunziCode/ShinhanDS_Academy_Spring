package com.shinhan.mavenProject.section6;

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
public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
