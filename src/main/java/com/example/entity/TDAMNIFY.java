package com.example.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TDAMNIFY")
public class TDAMNIFY implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402436084774899747L;

	public TDAMNIFY(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(precision = 10)
	private Integer id;
	
	@Column(name = "inputTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inputTime;
	
	@Column(name="Tl_tym",length = 200)
	private String Tl_tym;
	
	@Column(name="Tl_spm",length = 200)
	private String Tl_spm;
	
	@Column(name = "Tl_yxq")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tl_yxq;
	
	@Column(name="Tl_pzwh",length = 100)
	private String Tl_pzwh;
	
	@Column(name="Tl_form",length = 50)
	private String Tl_form;
	
	@Column(name="Tl_gg",length = 150)
	private String Tl_gg;
	
	@Column(name="Tl_dw",length = 150)
	private String Tl_dw;
	
	@Column(name="Tl_ph",length = 150)
	private String Tl_ph;
	
	@Column(name="Tl_sccj",length = 150)
	private String Tl_sccj;
	
	@Column(name="Tl_sl",precision=12,scale=2)
	private BigDecimal Tl_sl;

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getTl_tym() {
		return Tl_tym;
	}

	public void setTl_tym(String tl_tym) {
		Tl_tym = tl_tym;
	}

	public String getTl_spm() {
		return Tl_spm;
	}

	public void setTl_spm(String tl_spm) {
		Tl_spm = tl_spm;
	}

	public Date getTl_yxq() {
		return Tl_yxq;
	}

	public void setTl_yxq(Date tl_yxq) {
		Tl_yxq = tl_yxq;
	}

	public String getTl_pzwh() {
		return Tl_pzwh;
	}

	public void setTl_pzwh(String tl_pzwh) {
		Tl_pzwh = tl_pzwh;
	}

	public String getTl_form() {
		return Tl_form;
	}

	public void setTl_form(String tl_form) {
		Tl_form = tl_form;
	}

	public String getTl_gg() {
		return Tl_gg;
	}

	public void setTl_gg(String tl_gg) {
		Tl_gg = tl_gg;
	}

	public String getTl_dw() {
		return Tl_dw;
	}

	public void setTl_dw(String tl_dw) {
		Tl_dw = tl_dw;
	}

	public String getTl_ph() {
		return Tl_ph;
	}

	public void setTl_ph(String tl_ph) {
		Tl_ph = tl_ph;
	}

	public String getTl_sccj() {
		return Tl_sccj;
	}

	public void setTl_sccj(String tl_sccj) {
		Tl_sccj = tl_sccj;
	}

	public BigDecimal getTl_sl() {
		return Tl_sl;
	}

	public void setTl_sl(BigDecimal tl_sl) {
		Tl_sl = tl_sl;
	}

	
}
















