package main;

import java.io.*;
import java.util.ArrayList;

import clases.*;
import utilidades.Utilidades;

public class Main {

	public static void main(String[] args) {
		File esc=new File("escuderias.dat");
		File staff=new File("staff.dat");
		ArrayList <Escuderia> e=new ArrayList<>();
		ArrayList <Staff> s=new ArrayList<>();
		int menu=menu();
		
		fillDataFiles(esc,staff);
		fillArrayLists(e,s,esc,staff);
		
		switch (menu) {
		
		case 1:
			showWinEsc(e,s);
			break;
		
		case 2:
			modifyNameEsc(e);
			break;
			
		case 3:
			addMechanic(s);
			break;
			
		case 4:
			visualize(e,s);
			break;
			
		case 0:
			System.out.println("Adios!");
		}
	}
	
	public static int menu() {
		System.out.println("0. Salir");
		System.out.println("1. Mostrar los ganadores por escudería ordenados por carrera");
		System.out.println("2. Modificar nombre de la escudería.");
		System.out.println("3. Insertar mecánico");
		System.out.println("4. Visualizar Staff y Escuderias");
		return Utilidades.leerInt(0,4);
	}

	public static void fillDataFiles(File esc, File staff) {
		ObjectOutputStream oos;
		
		if (!esc.exists()) {
			try {
				oos=new ObjectOutputStream(new FileOutputStream(esc));
				oos.writeObject(new Escuderia(1,"Ferrari"));
				oos.writeObject(new Escuderia(2,"Red Bull"));
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (!staff.exists()) {
			try {
				oos=new ObjectOutputStream(new FileOutputStream(staff));
				ArrayList <Carrera> c1=new ArrayList<>();
				c1.add(new Carrera(1, "Suzuka", false));
				c1.add(new Carrera(2, "Silverstone", true));
				c1.add(new Carrera(3, "Monza", true));
				oos.writeObject(new Piloto(1, "Carlos Sainz", "España", c1));
				ArrayList <Carrera> c2=new ArrayList<>();
				c2.add(new Carrera(1, "Suzuka", true));
				c2.add(new Carrera(2, "Silverstone", false));
				c2.add(new Carrera(3, "Monza", false));
				oos.writeObject(new Piloto(2, "Mark Webber", "Francia", c2));
				oos.writeObject(new Mecanico(1, "Laura", "Finlandia", Puesto.JUNIOR));
				oos.writeObject(new Mecanico(1, "Sara", "Rumania", Puesto.SENIOR));
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void fillArrayLists(ArrayList <Escuderia> es, ArrayList <Staff> st, File esc, File staff) {
		ObjectInputStream ois;
		boolean end=false;
		
		try {
			ois=new ObjectInputStream(new FileInputStream(esc));
			while (!end) {
				try {
					Escuderia e=(Escuderia)ois.readObject();
					es.add(e);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end=true;
				}
			}
			ois.close();
			end=false;
			ois=new ObjectInputStream(new FileInputStream(staff));
			while (!end) {
				try {
					Staff s=(Staff)ois.readObject();
					st.add(s);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end=true;
				}
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void showWinEsc(ArrayList <Escuderia> e, ArrayList <Staff> s) {
		
	}
	
	public static void modifyNameEsc(ArrayList <Escuderia> e) {
		
	}
	
	public static void addMechanic(ArrayList <Staff> s) {
		
	}
	
	public static void visualize(ArrayList <Escuderia> e, ArrayList <Staff> s) {
		System.out.println("ESCUDERIAS");
		for (int i=0;i<e.size();i++) {
			System.out.println(e.get(i).toString());
		}
		System.out.println("STAFF");
		for (int i=0;i<s.size();i++) {
			if (s.get(i) instanceof Piloto) {
				((Piloto)s.get(i)).visualizar();;
			}
			if (s.get(i) instanceof Mecanico) {
				((Mecanico)s.get(i)).visualizar();
			}
		}
	}
}
