package testers;
import crTransfo.*;

public class testEncriptar {

	public static void main(String[] args) {
		String texto="Tafupanl$$TW2021 ";
		String encriptado=CRTransfo.EncriptaElParametro(texto);
		String desencriptado=CRTransfo.DesEncriptaElParametro(encriptado);
		
		
		System.out.println(texto);
		System.out.println(encriptado);
	}

}
