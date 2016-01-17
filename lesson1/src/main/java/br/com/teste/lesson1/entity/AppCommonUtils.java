package br.com.teste.lesson1.entity;

import java.text.SimpleDateFormat;

public class AppCommonUtils {

	public static SimpleDateFormat getDefaultFormatDate() {
		return new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
	}

	public static String getLine() {
		return "--------------------------\n";
	}

	private static void inputLog( boolean isError, String message ) {
		if ( isError )
			System.err.println( message );
		else
			System.out.println( message );
	}

	public static void inputLog( String message ) {
		inputLog( false, message );
	}

	public static void inputError( String message ) {
		inputLog( true, message );
	}

}
