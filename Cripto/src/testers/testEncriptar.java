package testers;
import crTransfo.*;

public class testEncriptar {

	public static void main(String[] args) {
		String texto="Texto a Encriptar";
		String encriptado=CRTransfo.EncriptaElParametro(texto);
		String desencriptado=CRTransfo.DesEncriptaElParametro(encriptado);
		
		
		System.out.println(texto);
		System.out.println(encriptado);
		System.out.println(desencriptado);
	}

}
