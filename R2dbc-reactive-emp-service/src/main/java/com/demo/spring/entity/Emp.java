package com.demo.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("EMP")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Emp {
	@Id
	@Column("empno")
	private int empId;

	@Column("name")
	private String empName;

	@Column("address")
	private String city;

	@Column("salary")
	private double salary;

	
}
