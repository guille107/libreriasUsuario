package archivoLogg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class EscribirLogg {
	private Path archivo;
	private String textoAEscribir;
	
	public EscribirLogg(String texto, Path Fila) {
		
		this.archivo = Fila;
		if(!archivo.toFile().exists()) {
			try {
				Files.createFile(archivo);
			} catch (IOException e) {
				System.out.println("No se pudo crear: " + archivo);
			}
			
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String lineaRecibida = texto;
		this.textoAEscribir= "[".concat(LocalDateTime.now().format(formato)).concat("] ").concat(lineaRecibida);
		System.out.println(textoAEscribir+ " en el archivo : " + archivo );
		try {
			Files.write(archivo, textoAEscribir.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
			Files.write(archivo,System.lineSeparator().getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("No se pudo escribir " + textoAEscribir + " en el archivo: " + archivo);
		}

		
	}
}
