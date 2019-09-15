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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Course")
@Data
@NoArgsConstructor

public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinTable(
			name="course_student",joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			
			)
	
	
	private List<Student> students;
	public Course(String title) {
		super();
		this.title = title;
	}
	
	public void addReview(Review theReview) {
		if(reviews==null) {
			reviews= new ArrayList<>();
		}
		reviews.add(theReview);
		
	}
	public void addStudent(Student theStudent) {
		
		if(students==null) {
			students= new ArrayList<>();
			
		}
		
		students.add(theStudent);
		
		
		
	}

}
