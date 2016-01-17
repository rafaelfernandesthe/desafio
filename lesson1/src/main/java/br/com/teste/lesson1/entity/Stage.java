package br.com.teste.lesson1.entity;

import java.util.Date;

public class Stage {

	private String name;

	private Date date;

	private boolean ended;

	public Stage() {
		ended = false;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded( boolean ended ) {
		this.ended = ended;
	}

	@Override
	public String toString() {
		String event = "Início";
		if ( isEnded() )
			event = "Fim";
		return AppCommonUtils.getLine() + String.format( "Data:%s %s da Partida:%s\n", AppCommonUtils.getDefaultFormatDate().format( date ), event, name );
	}

}
