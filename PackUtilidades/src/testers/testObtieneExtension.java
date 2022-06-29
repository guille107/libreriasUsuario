package testers;

import java.nio.file.Path;
import java.nio.file.Paths;

import manejoDeArchivos.ExtensionDeUnArchivo;

public class testObtieneExtension {

	public static void main(String[] args) {
		Path fila = Paths.get("S:\\archivosexportados\\clie 2-6-22.xlsx");
		
			System.out.println(ExtensionDeUnArchivo.getExtension(fila ));
		
	}

}
