package com.sec01.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// Dept -> Emp -> Dept -> 무한 루프 하는 것을 방지 
//@ToString(exclude = "emps")//emps 에 해당하는 문자열은 출력을 막는다 -> private List<Emp> emp ; 
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	@OneToMany(mappedBy = "dept")
	
	@ToString.Exclude
	private List<Emp> emps;
}