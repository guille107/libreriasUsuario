package control;

import java.awt.Toolkit;
import java.nio.file.Paths;

public class Constantes {
	
	public static final  String CARPETA_DE_SISTEMA=Paths.get("").toAbsolutePath().toString()+"\\";

	
	public static final  String IMG_USUARIO=CARPETA_DE_SISTEMA+"Contenidos\\users.png";
	
	public static final  String IMG_Login_1_200x200=CARPETA_DE_SISTEMA+"Contenidos\\Login_1_200x200.png";
	
	public static final  String ICONO_FRAME=CARPETA_DE_SISTEMA+"Contenidos\\codBarra.png";
	
	public static final  String IMG_COD_BARRA=CARPETA_DE_SISTEMA+"Contenidos\\lblCodBarra.png";
	
	public static final  String TITULO_FRAME="Login";
	
	public static final  String VERSION="1.0";
	
	
	public static final  int ANCHO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final  int ALTO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final String NOM_BASE_DE_DATOS="tafubd";
	
	public static final String NOMBRE_BD="tafubd";
	public static final String ARCHIVO_DE_CONFIG_BD=Paths.get("").toAbsolutePath().toString()+"\\" +"BDs.conf";
}
