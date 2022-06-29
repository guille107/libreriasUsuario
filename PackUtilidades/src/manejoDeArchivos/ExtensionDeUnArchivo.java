package manejoDeArchivos;

import java.nio.file.Path;

public class ExtensionDeUnArchivo {
	
	public static String getExtension(Path fila) {
		String extension = "";
		String nombreArchivo = fila.getFileName().toString();

		int i = nombreArchivo.lastIndexOf('.');
		if (i > 0) {
		    extension = nombreArchivo.substring(i+1);
		}
		return extension;
	}
}
