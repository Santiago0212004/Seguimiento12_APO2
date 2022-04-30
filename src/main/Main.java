package main;

import java.util.Scanner;

import model.SistemaDeTurnos;

public class Main {
	static SistemaDeTurnos sistema  = new SistemaDeTurnos();
	
	public static void main(String[] args) {
		
		int operation = menu();
		
		while(operation!=0) {
			switch(operation) {
				case 1:
					darTurno();
					System.out.println("\nLista de turnos: "); 
					sistema.print();
					break;
				case 2:
					mostrarTurnoActual();
					break;
				case 3:
					pasarTurnoActual();
					System.out.println("\nLista de turnos: "); 
					sistema.print();
					break;
				case 4:
					eliminarTurnoActual();
					System.out.println("\nLista de turnos: "); 
					sistema.print();
					break;
			}
			
			operation = menu();
		}
	}
	
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\nSeleccione la acción que desea ejecutar: ");
		System.out.println("\n(1) Dar turno.");
		System.out.println("\n(2) Mostrar turno actual.");
		System.out.println("\n(3) Pasar turno.");
		System.out.println("\n(4) Eliminar turno.");
		System.out.println("\n(0) Salir.");
		
		int option = sc.nextInt();
		
		while(option<0 || option>4) {
			System.out.println("ERROR: Escriba una opcion valida:");
			option = sc.nextInt();
		}
		
		return option;	
	}
	
	public static void darTurno() {
		if(sistema.getHead()!=null) {
			sistema.darTurno(sistema.getHead().getPrevious().getValue() + 1);
		} else {
			sistema.darTurno(1);
		}
		
	}
	
	public static void mostrarTurnoActual() {
		System.out.print("Turno actual: "); sistema.mostrarTurno();
	}
	
	public static void pasarTurnoActual() {
		sistema.pasarTurno();
	}
	
	public static void eliminarTurnoActual() {
		sistema.eliminarTurno();
	}

}
