package model;

public class SistemaDeTurnos {
	private Turno head;
	private Turno turnoActual;
	private int size;
	
	public SistemaDeTurnos() {
		size = 0;
	}
	
	public void darTurno(int value) {
		
		if(size<50) {
			Turno node = new Turno(value);
			
			if(head == null) {
				head = node;
				head.setNext(head);
				head.setPrevious(node);
				
				turnoActual = head;
				
				size++;
			} else {
				
				Turno tail = head.getPrevious();
				
				node.setNext(head);
				head.setPrevious(node);
				
				tail.setNext(node);
				node.setPrevious(tail);
				
				size++;
			}
		} else {
			System.out.println("Ha superado la cantidad maxima de turnos.");
		}
	}
	
	public Turno getHead() {
		return head;
	}
	
	
	public void mostrarTurno() {
		if(turnoActual!=null) {
			System.out.print(turnoActual.getValue());
		}
	}
	
	public void pasarTurno() {
		if(turnoActual!=null) {
			turnoActual.call();
				
			if(turnoActual.getTimesCalled()==3) {
				eliminarTurno();
			}
			
			if(turnoActual!=null) {
				turnoActual = turnoActual.getNext();
			}
			
			
		}
	}
	
	public void eliminarTurno() {
		
		if(turnoActual!=null) {
			if(turnoActual==head) {
				if (turnoActual.getNext()==head) {
					head = null;
					turnoActual = null;
					size--;
				}
				else {
					turnoActual.getPrevious().setNext(turnoActual.getNext());
					turnoActual.getNext().setPrevious(turnoActual.getPrevious());
					turnoActual = turnoActual.getNext();
					head = turnoActual;
					size--;
				}
				
			} else {
				turnoActual.getPrevious().setNext(turnoActual.getNext());
				turnoActual.getNext().setPrevious(turnoActual.getPrevious());
				turnoActual = turnoActual.getNext();
				size--;
			}
		}
		
	}
	
	public void print() {
		print(head);
	}
	
	public void print(Turno current) {
		if(current!=null) {
			if(current==head.getPrevious()) {
				System.out.print(current.getValue()+" ");
				return;
			}
			System.out.print(current.getValue()+" ");
			print(current.getNext());
		}
	}

	public int getSize() {
		return size;
	}	
}
