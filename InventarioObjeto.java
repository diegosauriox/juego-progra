import java.util.ArrayList;
import java.util.Scanner;

public class InventarioObjeto {
	private static Scanner sca = new Scanner(System.in);

	public static void agregarObjeto(ArrayList<ObjetoEquipable> objetos) {
		if (objetos.size() < 10) {
			objetos.add(new ObjetoEquipable());
		} else {
			System.out.println("Usted no puede tener mas objetos");
		}
		
	}

	public static void quitarObjeto(ArrayList<ObjetoEquipable> objetos) {
		if(objetos.size()==0) {
			System.out.println("no existen objetos para eliminar");
		}else {
			mostrarListaObjetos(objetos);
			System.out.println("elija el numero del objeto que quiera eliminar");
			int num = sca.nextInt();
			System.out.println("ha eliminado el objeto:");
			objetos.get(num-1).mostrar();
			objetos.remove(num - 1);
		}
	}

	public static void filtrarObjeto(ArrayList<ObjetoEquipable> objetos) {
		if(objetos.size()==0) {
			System.out.println("No posee objetos en el inventario");
		}else {
		int cont=0;
		System.out.println("Por cual rango desea filtrar?");
		int rango = sca.nextInt();
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getRangoEstrellas() == rango) {
				objetos.get(i).mostrar();
				System.out.println("--------------------------------------------------");
				cont++;	
			}
			}
		if(cont==0) {
			System.out.println("no existen objetos del rango buscado");
		    }
		
		
	    }
	}

	public static void mostrarObjetos(ArrayList<ObjetoEquipable> objetos) {
		if (objetos.size() == 0) {
			System.out.println(" no posee objetos en el inventario");
		} else {
			for (int i = 0; i < objetos.size(); i++) {
				objetos.get(i).mostrar();
				System.out.println("----------------------------------------------------------------------------");
			}
		}
	}
	
	public static void mostrarListaObjetos(ArrayList<ObjetoEquipable> objetos) {
		String datosObjeto = null;
		for (int i = 0; i < objetos.size(); i++) {
			datosObjeto = objetos.get(i).getTipo() + " - " + objetos.get(i).getAtributo() + " - " + objetos.get(i).getMejoraTotal() + " - " 
					+ objetos.get(i).getRango() + " - " + objetos.get(i).getRangoEstrellas();
			System.out.println(i+1 +". " + datosObjeto);
		}
	}
}
