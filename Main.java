import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sca = new Scanner(System.in);
	
	private static ArrayList<ObjetoEquipable> listaObjetos = new ArrayList<ObjetoEquipable>();
	private static ArrayList<Luchador> listaLuchadores = new ArrayList<Luchador>();

	public static void main(String[] args) {
		menuPrincipal();
	}
	public static void menuPrincipal(){
		int opcion;
		System.out.println("Bienvenido a Dragones y Calabozos");
		do {
			System.out.println("");
			System.out.println("opcion 1: menu guerrero");
			System.out.println("opcion 2: Batalla");
			System.out.println("opcion 0: Salir");
			System.out.println("");
			System.out.println("");
		    opcion = sca.nextInt();
			if (opcion == 1) {
				menuGuerrero();
			} else if (opcion == 2) {
				menuBatalla();
			}
		} while (opcion != 0);
	}

	public static void menuGuerrero() {
		int opcion;
		do {
			System.out.println("");
			System.out.println("");
			System.out.println("opcion 1: Agregar luchador");
			System.out.println("opcion 2: Mostrar cantidad Luchadores");
			System.out.println("opcion 3: Eliminar luchador");
			System.out.println("opcion 4: Filtrar luchador");
			System.out.println("opcion 5: Mostrar luchadores");
			System.out.println("opcion 6: Mostrar Objetos");
			System.out.println("opcion 7: Agregar Objetos");
			System.out.println("opcion 8: equipar objeto");
			System.out.println("opcion 9: Quitar objetos");
			System.out.println("opcion 10: filtrar objetos");
			System.out.println("opcion 0: Salir");
			System.out.println("");
			System.out.println("");
			opcion = sca.nextInt();
			if (opcion == 1) {
				InventarioLuchadores.agregarLuchadores(listaLuchadores);
			} else if (opcion == 2) {
				InventarioLuchadores.mostrarCantidad(listaLuchadores);
			} else if (opcion == 3) {
				InventarioLuchadores.eliminarLuchador(listaLuchadores);
			} else if (opcion == 4) {
				InventarioLuchadores.filtrarLuchadores(listaLuchadores);
			} else if (opcion == 5) {
				InventarioLuchadores.mostrarLuchadores(listaLuchadores);
			} else if (opcion == 6) {
				InventarioObjeto.mostrarObjetos(listaObjetos);
			} else if (opcion == 7) {
				InventarioObjeto.agregarObjeto(listaObjetos);
			} else if (opcion == 8) {
				if (listaObjetos.size()!=0){
					InventarioObjeto.mostrarListaObjetos(listaObjetos);
				System.out.println("Elija el numero del objeto que quiere seleccionar");
				int idObjeto = sca.nextInt();
				ObjetoEquipable objetoSeleccionado = listaObjetos.get(idObjeto-1);
				
				InventarioLuchadores.mostrarListaLuchadores(listaLuchadores);
				System.out.println("Elija el numero del luchador que quiere seleccionar");
				int idLuchador = sca.nextInt();
				boolean respuestaEquipacion = listaLuchadores.get(idLuchador-1).setObjetoEquipable(objetoSeleccionado);
				if(respuestaEquipacion){
					listaObjetos.remove(idObjeto-1);
				}
				}else {
					System.out.println("no tiene objetos para equipar");
				}
			} else if (opcion == 9) {
				InventarioObjeto.quitarObjeto(listaObjetos);
			} else if (opcion == 10) {
				InventarioObjeto.filtrarObjeto(listaObjetos);
			}
		} while (opcion != 0);
	}

	public static void menuBatalla() {
		Batalla batalla = new Batalla();
		Monstruo monstruo = new Monstruo();
		listaLuchadores=batalla.pelear(listaLuchadores, monstruo,listaObjetos);
		System.out.println("****************************************************************");
		menuPrincipal();
	}
}
