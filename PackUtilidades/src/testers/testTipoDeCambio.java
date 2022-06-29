package testers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import monedas.modTipoDeCambio;

public class testTipoDeCambio {

	public static void main(String[] args) {
/**		LocalDateTime fechaPrueba;
		
		for(int a = 1; a<50 ; a=a+5) {
		
			modTipoDeCambio modTC = new modTipoDeCambio(LocalDateTime.now().minusDays(a));
			double comprador = modTC.getPrecioOficialComprador();
			double vendedor = modTC.getPrecioOficialVendedor();
		
			System.out.println("Tipo de cambio para la fecha " + LocalDateTime.now().minusDays(a).toLocalDate());
			System.out.println("Tipo Vendedor: $ " + vendedor);
			System.out.println("Tipo Comprador: $ " + comprador);
			}
		
	
**/
	
		System.out.println(new modTipoDeCambio().getTipoCambioOficialVendedorUltimaCotizacionDelMes(2,2022));
		
	}

}
