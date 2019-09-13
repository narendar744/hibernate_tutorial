package com.hibernate5.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="instructor")
@Getter
@Setter
@ToString(exclude = {"course","instructor_detail"})
@NoArgsConstructor
public class Instructor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private  Instructor_detail  instructor_detail;
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="instructor",
			cascade= {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List<Course> course;
	public Instructor(String firstName, String lastName, String email,
			Instructor_detail instructor_detail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructor_detail = instructor_detail;
	}

	public void add(Course  tempCourse) {
		if(tempCourse==null) {
			course= new ArrayList<>();
			course.add(tempCourse);
		}
		tempCourse.setInstructor(this);
	}

}
