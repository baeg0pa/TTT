package com.smhrd.entity;

import java.time.LocalDate;
import java.time.OffsetTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 자동 증가 ID 사용
	@Column(name="sche_idx")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tr_id", referencedColumnName = "tr_id", nullable = false)
	private Trainer trainer;
	
	@Column(name="sche_title")
	private String title;
	
	@Column(name="sche_content")
	private String description;
	

	@Column(name="st_dt")
	private LocalDate startDate;
	
	@Column(name="st_tm")
	private OffsetTime startTime;
	

	@Column(name="ed_dt")
	private LocalDate endDate;
	
	@Column(name="ed_tm")
	private OffsetTime endTime;

	@Column(name="sche_color")	
	private String color;
	
	@Column(name="sche_status")
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
	private User user;

}
