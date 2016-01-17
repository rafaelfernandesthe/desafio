package br.com.teste.lesson1.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.teste.lesson1.entity.AppCommonUtils;
import br.com.teste.lesson1.entity.Kill;
import br.com.teste.lesson1.entity.Stage;

public class Application extends AppCommonUtils {
	static Pattern p;
	static Matcher m;

	// A partir de um input de um arquivo de log do formato acima, montar o
	// ranking de cada partida, com a quantidade assassinatos e a quantidade de
	// mortes de cada jogador;

	public static void main( String[] args ) throws IOException, ParseException {

		String filePath = "C:\\Users\\rfernandes\\opt\\MENSAGERIA_OPT\\lesson1\\game.log";
		String regexStartStage = "(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}) - New match (.+)has started";
		String regexKill = "(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}) - (.+) killed (.+) (using|by) (.+)";
		String regexEndStage = "(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}) - Match (.+) has ended";

		File log = new File( filePath );

		if ( !log.exists() )
			inputError( "Caminho de arquivo inválido" );

		InputStreamReader readerStream = new InputStreamReader( new FileInputStream( log ) );
		BufferedReader reader = new BufferedReader( readerStream );
		while ( reader.ready() ) {
			String line = reader.readLine();
			// inputLog( line );
			findStartStage( regexStartStage, line );
			findKill( regexKill, line );
			findEndStage( regexEndStage, line );
		}
	}

	private static Stage findStartStage( String regexStart, String line ) throws ParseException {
		p = Pattern.compile( regexStart );
		m = p.matcher( line );
		if ( m.find() ) {
			Stage stage = new Stage();
			stage.setDate( getDefaultFormatDate().parse( m.group( 1 ) ) );
			stage.setName( m.group( 2 ) );
			inputLog( stage.toString() );
			return stage;
		}
		return null;
	}

	private static Kill findKill( String regexStart, String line ) throws ParseException {
		p = Pattern.compile( regexStart );
		m = p.matcher( line );
		if ( m.find() ) {
			Kill kill = new Kill();
			kill.setDate( getDefaultFormatDate().parse( m.group( 1 ) ) );
			kill.setKiller( m.group( 2 ) );
			kill.setHasDead( m.group( 3 ) );
			if ( "using".equals( m.group( 4 ) ) )
				kill.setArm( m.group( 5 ) );
			else if ( "by".equals( m.group( 4 ) ) )
				kill.setSite( m.group( 5 ) );
			inputLog( kill.toString() );
			return kill;
		}
		return null;
	}

	private static Stage findEndStage( String regexStart, String line ) throws ParseException {
		p = Pattern.compile( regexStart );
		m = p.matcher( line );
		if ( m.find() ) {
			Stage stage = new Stage();
			stage.setDate( getDefaultFormatDate().parse( m.group( 1 ) ) );
			stage.setName( m.group( 2 ) );
			stage.setEnded( true );
			inputLog( stage.toString() );
			return stage;
		}
		return null;
	}

}
