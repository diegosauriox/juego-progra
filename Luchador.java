import java.util.Random;

public class Luchador extends Personaje{
	private String nombre;
	private int rango;
	private ObjetoEquipable objetoEquipable;
	private boolean isObjetoEquipado = false;

	public int getRango() {
		return this.rango;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setEstrellas(int rango) {
		this.rango = rango;
	}

	public void setNombre(String nom) {
		this.nombre = nom;
	}

	public Luchador() {
		this.rango = rango();
		this.nombre = nombres();
		this.atk = valorAtk(this.rango);
		this.hp = valorHp(this.rango);
		this.def = valorDef(this.rango);

		this.spd = valorSpd(this.rango);
		this.faccion = faccion();
	}

	private static int rango() {
		int[] stars = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4,
				4, 5 };
		Random rnd = new Random();
		int estrellas;
		estrellas = stars[rnd.nextInt(stars.length)];
		return estrellas;
	}

	private static int valorAtk(int rango) {
		int valor;
		valor = rango * (20 + (int) (Math.random() * 50 + 1));
		return valor;
	}

	private static int valorDef(int rango) {
		int valor;
		valor = rango * (5 + (int) (Math.random() * 20 + 1));
		return valor;
	}

	private static int valorHp(int rango) {
		int valor;
		valor = rango * (200 + (int) (Math.random() * 300 + 1));
		return valor;
	}

	private static int valorSpd(int rango) {
		int valor;
		valor = rango * (10 + (int) (Math.random() * 90 + 1));
		return valor;
	}

	private static String nombres() {
		String name;
		Random rnd = new Random();
		String[] nombres = { "Diego", "Victor", "Fernando", "Nicolas",
				"Mauricio", "Mauro", "Marcelo", "Aliwen", "Cristobal",
				"Francisco", "Jose", "Javiera", "Neshat", "Niki", "Fernanda",
				"Felipe", "Maria", "Daniela", "Romina" };
		name = nombres[rnd.nextInt(nombres.length)];
		return name;
	}

	private static String faccion() {
		Random rnd = new Random();
		String faccion;
		String[] elementos = { "Fuego", "Agua", "Planta" };
		faccion = elementos[rnd.nextInt(elementos.length)];
		return faccion;

	}

	public void mostrar() {
		System.out.println("el nombre es " + getNombre());
		System.out.println("el ataque es " + getAtk());
		System.out.println("la defensa es " + getDef());
		System.out.println("el velocidad es " + getSpd());
		System.out.println("la vida es " + getHp());
		System.out.println("el rango es " + getRango());
		System.out.println("su faccion es " + getFaccion());

	}

	public ObjetoEquipable getObjetoEquipable() {
		return objetoEquipable;
	}

	public boolean setObjetoEquipable(ObjetoEquipable objetoEquipable) {
		if(!isObjetoEquipado){
			this.objetoEquipable = objetoEquipable;
			if(objetoEquipable.getAtributo().equals("atk")){
				this.atk = this.atk + objetoEquipable.getMejoraTotal();
			} else if(objetoEquipable.getAtributo().equals("def")){
				this.def = this.def + objetoEquipable.getMejoraTotal();
			} else if(objetoEquipable.getAtributo().equals("hp")){
				this.hp = this.hp + objetoEquipable.getMejoraTotal();
			} else if(objetoEquipable.getAtributo().equals("spd")){
				this.spd = this.spd + objetoEquipable.getMejoraTotal();
			}
			this.isObjetoEquipado = true;
			return true;
		} else {
			System.out.println("El luchador ya posee un objeto equipado");
			return false;
		}
	}

}
