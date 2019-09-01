package com.hibernate5.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="instructor_detail")
@Data
public class Instructor_detail {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtube_channel;
	
	@Column(name="hobby")
	private String hobby;
	

	@OneToOne(mappedBy="instructor_detail", cascade= {CascadeType.DETACH,
														CascadeType.MERGE,
														CascadeType.PERSIST
														,CascadeType.REFRESH})
	private Instructor instructor;
	
	
	public Instructor_detail(){}
	public Instructor_detail(String youtube_channel, String hobby) {
		super();
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

}
