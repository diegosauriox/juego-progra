import java.util.ArrayList;
import java.util.Scanner;

public class InventarioLuchadores extends Inventario {
	private static Scanner sca = new Scanner(System.in);
	
    @Override
	public static void agregar(ArrayList<Luchador> luchadores) {
		if (luchadores.size() == 0) {
			luchadores.add(new Luchador());
		}
		if (luchadores.size() < 26) {
			luchadores.add(new Luchador());
		} else {
			System.out.println("Usted no puede crear mas luchadres");
		}
	}
    
	public static void mostrarCantidad(ArrayList<Luchador> luchadores) {
		if (luchadores.size() == 0) {
			luchadores.add(new Luchador());
		}
		System.out.println("Posees "+luchadores.size()+ " luchadores en tu equipo");
	}

	public static void eliminarLuchador(ArrayList<Luchador> luchadores) {
		if (luchadores.size() == 0) {
			luchadores.add(new Luchador());
		}
		for (int i = 0; i < luchadores.size(); i++) {
			System.out.println(i+1 +". "+luchadores.get(i).getNombre());
		}
		System.out.println("elija el numero del luchador que desee eliminar");
		int numero = sca.nextInt();
        String nombre=luchadores.get(numero-1).getNombre();
		luchadores.remove(numero - 1);
		System.out.println("Has eliminado a "+nombre);
	}

	public static void filtrarLuchadores(ArrayList<Luchador> luchadores) {
		String filtro;
		if (luchadores.size() == 0) {
			luchadores.add(new Luchador());
		}
		System.out.println("Filtrar por rango o por faccion?");
		filtro = sca.nextLine();
		if (filtro.equals("rango")) {
			rangoPedido(luchadores);
		} else if (filtro.equals("faccion")) {
			faccionPedida(luchadores);
		} else {
			System.out.println("debe elejir entre rango o faccion");
		}
	}

	public static void faccionPedida(ArrayList<Luchador> luchadores) {
	    int cont=0;
		System.out.println("elija la faccion que desea filtrar");
		String faccion = sca.nextLine();
		for (int i = 0; i < luchadores.size(); i++) {
			if (luchadores.get(i).getFaccion().equals(faccion)) {
				System.out.println(i+1+" "+luchadores.get(i).getNombre());
				cont ++;
			}
			}
		if (cont==0) {
			System.out.println("no existen luchadores de la faccion buscada");
		}
	}
 
	public static void rangoPedido(ArrayList<Luchador> luchadores) {
		int cont=0;
		System.out.println("elija el rango que desea filtrar");
		int rango = sca.nextInt();
		for (int i = 0; i < luchadores.size(); i++) {
			if (luchadores.get(i).getRango() == rango) {
				System.out.println(i+1+" "+luchadores.get(i).getNombre());
				cont ++;
			}
			}
		if (cont==0) {
			System.out.println("no existen luchadores del rango buscado");
		}
	}

	public static void mostrarLuchadores(ArrayList<Luchador> luchadores) {
		mostrarListaLuchadores(luchadores);
		System.out.println("Elija el numero de un luchador");
		int num= sca.nextInt();
		luchadores.get(num-1).mostrar();
		}
	
	
	public static void mostrarListaLuchadores(ArrayList<Luchador> luchadores) {
		if (luchadores.size() == 0) {
			luchadores.add(new Luchador());
		}
		for (int i = 0; i < luchadores.size(); i++) {
			System.out.println(i+1 +". "+luchadores.get(i).getNombre());
		}
	}

}
