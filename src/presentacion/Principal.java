package presentacion;

import java.util.Scanner;

import logica.Banco;
import logica.Cuenta;

public class Principal {
	private Banco banco;

	public Principal() {
		this.banco = new Banco();
		this.menu();

	}

	public static void main(String[] args) {
		new Principal();
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			try {
				System.out.println("Seleccione:");
				System.out.println("0. Salir");
				System.out.println("1. Crear Cliente");
				System.out.println("2. Crear Cuenta");
				System.out.println("3. Imprimir Clientes");
				System.out.println("4. Imprimir Cuentas");
				System.out.println("5. Alamcenar en archivo de texto plano");
				System.out.println("6. Cargar desde archivo de texto plano");
				op = sc.nextInt();
				if(op == 1) {
					this.crearCliente(sc);				
				}else if(op == 2) {
					this.creaCuenta(sc);
				}else if(op == 3) {
					this.imprimirClientes();
				}else if(op == 4) {
					this.imprimirCuentas();
				}else if(op == 5) {
					this.almacenar();
				}else if(op == 6) {
					this.cargar();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}while(op != 0);

		sc.close();

	}

	private void cargar() {
		this.banco.cargar();
		
	}

	private void almacenar() {
		this.banco.almacenar();		
	}

	private void imprimirCuentas() {
		System.out.println("Num\tSaldo\tTipo\tCliente");
		for(Cuenta cuenta : this.banco.getCuentas()) {
			System.out.println(cuenta);
		}
	}

	private void imprimirClientes() {
		System.out.println("Id\tNombre\tApellido");
		for(Integer id : this.banco.getClientes().keySet()) {
			System.out.println(this.banco.getClientes());
		}
	}

	private void creaCuenta(Scanner sc) throws Exception {
		System.out.println("Numero:");
		int numero = sc.nextInt();
		System.out.println("Saldo:");
		int saldo = sc.nextInt();
		System.out.println("Tipo:");
		String tipo = sc.next();
		System.out.println("Id Cliente:");
		int idCliente = sc.nextInt();
		this.banco.crearCuenta(numero, saldo, tipo, idCliente);
	}

	private void crearCliente(Scanner sc) throws Exception {
		System.out.println("Id:");
		int id = sc.nextInt();
		System.out.println("nombre:");
		String nombre = sc.next();
		System.out.println("apellido:");
		String apellido = sc.next();
		this.banco.crearCliente(id, nombre, apellido);
	}




}
