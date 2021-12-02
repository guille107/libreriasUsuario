package fechaYhora;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ConvertirFechasYHoras {
	
	public static Timestamp convertirLocalDTaSQLTimespamp(LocalDateTime fehcaHora) {

		return Timestamp.valueOf(fehcaHora);
		
	}

}
