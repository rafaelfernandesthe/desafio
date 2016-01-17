package br.com.teste.lesson1.entity;

import java.util.Date;

public class Kill {
	private String killer;

	private String hasDead;

	private String arm;

	private Date date;

	private String site;

	public String getKiller() {
		return killer;
	}

	public void setKiller( String killer ) {
		this.killer = killer;
	}

	public String getHasDead() {
		return hasDead;
	}

	public void setHasDead( String hasDead ) {
		this.hasDead = hasDead;
	}

	public String getArm() {
		return arm;
	}

	public void setArm( String arm ) {
		this.arm = arm;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	public String getSite() {
		return site;
	}

	public void setSite( String site ) {
		this.site = site;
	}

	@Override
	public String toString() {
		String event = "usando";
		String alt = arm;
		if ( site != null ) {
			event = "no local";
			alt = site;
		}
		return AppCommonUtils.getLine() + String.format( "Data %s %s Matou %s %s %s", AppCommonUtils.getDefaultFormatDate().format( date ), killer, hasDead, event, alt );
	}

}
