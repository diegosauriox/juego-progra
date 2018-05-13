
public class Dados {
	private int caras8;
	private int caras6;

	public int getCaras8() {
		return caras8;
	}

	public void setCaras8(int caras8) {
		this.caras8 = caras8;
	}

	public int getCaras6() {
		return caras6;
	}

	public void setCaras6(int caras6) {
		this.caras6 = caras6;
	}

	public Dados() {
		this.caras8 = dado8();
		this.caras6 = dado6();
	}

	public int dado8() {
		int numero = (int) (Math.random() * 8 + 1);
		return numero;
	}

	public int dado6() {
		int numero = (int) (Math.random() * 6 + 1);
		return numero;
	}
}
