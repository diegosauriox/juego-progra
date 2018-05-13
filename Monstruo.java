import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Monstruo extends Personaje{

	private ArrayList<ObjetoEquipable> listaObjetosDropeables = new ArrayList<ObjetoEquipable>();
	public Monstruo() {
		this.hp = valorHp();
		this.atk = valorAtk();
		this.def = valorDef();
		this.spd = valorSpd();
		this.faccion = faccion();
		crearObjetoDropeable();
	}

	private static int valorAtk() {
		int valor;
		valor = (1000 + (int) (Math.random() * 500 + 1));
		return valor;
	}

	private static int valorDef() {
		int valor;
		valor = (5 + (int) (Math.random() * 20 + 1));
		return valor;
	}

	private static int valorHp() {
		int valor;
		valor = (3500 + (int) (Math.random() * 500 + 1));
		return valor;
	}

	private static int valorSpd() {
		int valor;
		valor = (10 + (int) (Math.random() * 90 + 1));
		return valor;
	}

	private void crearObjetoDropeable() {
		ObjetoEquipable objeto1 = new ObjetoEquipable(1);
		ObjetoEquipable objeto2 = new ObjetoEquipable(3);
		ObjetoEquipable objeto3 = new ObjetoEquipable(5);
		this.listaObjetosDropeables.add(objeto1);
		this.listaObjetosDropeables.add(objeto2);
		this.listaObjetosDropeables.add(objeto3);
	}

	public  ArrayList<ObjetoEquipable> dropear(ArrayList<ObjetoEquipable>listaObjetos) {
		Scanner sca=new Scanner(System.in);
		System.out.println("****DROOOOOOP****");
		int porcentaje = (int) (Math.random() * 10 + 1);
		if (porcentaje <= 6) {
			this.listaObjetosDropeables.get(0).mostrar();
			if(listaObjetos.size()==9) {
				System.out.println("tiene el inventario lleno, no puede agregar mas objetos");
			}else{
	        System.out.println("Desea agregar este objeto al inventario?");
	        String respuesta=sca.nextLine();
	        if(respuesta.equals("si")) {
	        	listaObjetos.add(listaObjetosDropeables.get(0));
	        }else if(respuesta.equals("no")) {
	        	System.out.println("no se ha agregado el objeto");
	        }
			}
		} else if (porcentaje <= 9) {
			this.listaObjetosDropeables.get(1).mostrar();
			System.out.println("Desea agregar este objeto al inventario?");
			if(listaObjetos.size()==9) {
				System.out.println("tiene el inventario lleno, no puede agregar mas objetos");
			}else{
	        System.out.println("Desea agregar este objeto al inventario?");
	        String respuesta=sca.nextLine();
	        if(respuesta.equals("si")) {
	        	listaObjetos.add(listaObjetosDropeables.get(1));
	        }else if(respuesta.equals("no")) {
	        	System.out.println("no se ha agregado el objeto");
	        }
			}
		} else if (porcentaje == 10) {
			this.listaObjetosDropeables.get(2).mostrar();
			if(listaObjetos.size()==9) {
			System.out.println("tiene el inventario lleno, no puede agregar mas objetos");
		}else{
			System.out.println("Desea agregar este objeto al inventario?");
	        String respuesta=sca.nextLine();
	        if(respuesta.equals("si")) {
	        	listaObjetos.add(listaObjetosDropeables.get(2));
	        }else if(respuesta.equals("no")) {
	        	System.out.println("no se ha agregado el objeto");
	        }
		}
		
	}
		return listaObjetos;
	}

	private static String faccion() {
		Random rnd = new Random();
		String faccion;
		String[] elementos = { "Fuego", "Agua", "Planta" };
		faccion = elementos[rnd.nextInt(elementos.length)];
		return faccion;
	}

	public ArrayList<ObjetoEquipable> getListaObjetosDropeables() {
		return listaObjetosDropeables;
	}

	public void setListaObjetosDropeables(
			ArrayList<ObjetoEquipable> listaObjetosDropeables) {
		this.listaObjetosDropeables = listaObjetosDropeables;
	}
	
	@Override
	public String toString(){
		return "HP/ATK/DEF/SPD/FACCION - " + this.getHp()+"/"+this.getAtk()+"/"+ this.getDef()+"/"+ this.getSpd()+"/"+ this.getFaccion();
	}
	
}
