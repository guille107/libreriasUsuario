package testers;

public class testIGU {

	public static void main(String[] args) {

		testIGUBusca igu = new testIGUBusca();
		String id="";

		while(igu.isShowing() &&  id.length()<1) 
			
			id = igu.getlblIDLocaliProvi();

	System.out.println("ID = " + id);	
	}

}
