package com.fr.adaming.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	@Getter
	private int id;
	@Getter
	private String fullname;

}
