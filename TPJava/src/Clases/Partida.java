package Clases;

public class Partida {
	private String dniBlanco;
	private String dniNegro;
	private String turno;
	
	public Partida(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		dniBlanco=string;
		dniNegro=string2;
		turno=string3;
	}
	public String getDniBlanco() {
		return dniBlanco;
	}
	public void setDniBlanco(String dniBlanco) {
		this.dniBlanco = dniBlanco;
	}
	public String getDniNegro() {
		return dniNegro;
	}
	public void setDniNegro(String dniNegro) {
		this.dniNegro = dniNegro;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}

}
