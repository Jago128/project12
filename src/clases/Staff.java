package clases;

import java.io.Serializable;

public abstract class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int code;
	protected String name;
	protected String country;

	public Staff(int code, String name, String country) {
		this.code = code;
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Staff [Nombre: "+name+", Pais: "+country+", Codigo:" +code;
	}
	
	public abstract void visualizar();
}
