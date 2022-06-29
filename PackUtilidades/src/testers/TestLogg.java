package testers;


import java.nio.file.Path;
import java.nio.file.Paths;

import archivoLogg.EscribirLogg;

public class TestLogg {
	static Path path = Paths.get("C:\\Logg.txt");
	
	public static void main (String[ ] args) {

			new EscribirLogg("ww5",path );
			new EscribirLogg("ww6",path );
			new EscribirLogg("ww7",path );
		
	}
	
}
