package clases;

public class Ganadores {
	private int code;
	private String piloto;
	private String escuderia;
	private String carrera;
	
	public Ganadores(int code, String piloto, String escuderia, String carrera) {
		this.code = code;
		this.piloto = piloto;
		this.escuderia = escuderia;
		this.carrera = carrera;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Ganadores [Codigo: "+code+", Piloto: "+piloto+", Escuderia: "+escuderia+", Carrera: "+carrera+"]";
	}
}
