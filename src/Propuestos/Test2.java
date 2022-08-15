import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {
	
	private static final int size = 10;
	static Scanner scan = new Scanner(System.in);
	static HashEncadenado<String, Integer> hash = new HashEncadenado<>(size); 

    public static void main(String[] args) {
		int opcion;
		System.out.println("MENÚ DE LA APP");
		
		while(true) {
			MenuSB();
			System.out.print("Escoge una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				insert();
				break;
			case 2:
				remove();
				break;
			case 3:
				existVal();
				break;
			case 4:
				mostrar();
				break;
			case 5:
				System.out.println("-------Fin del programa ------");
				System.exit(9);
				break;
			default:
				System.out.println("\nIngrese un número del 1 al 5");
				break;
			}
		}
	}

    public static void MenuSB() {
		StringBuilder men = new StringBuilder();
		men.append("\n1. Agregar \n");
		men.append("2. Borrar\n");
		men.append("3. Buscar clave o valor\n");
		men.append("4. Mostrar tabla\n");
		men.append("5. Salir");
		System.out.println(men.toString());
	}
    
	public static String insertKey() {
		String key = null;
		while(true) {
			System.out.print("\nIngrese la clave: ");
			try {
				key = scan.next();
			}catch (Exception e) {
				System.err.println(e);
				scan.nextLine();
			}if(!key.equals(""))break;
		}return key;
	}

	public static void insert() {
		String key = insertKey();
		int value = insertn("Ingresa un entero");
		hash.put(key, value);
		System.out.println("Agregando <"+ key +" , " + value+ ">" );
	}

	public static void remove() {
		String key = insertKey();
		Object val = null;
		try {
			val = hash.remove(key);
		}catch (Exception e){
			System.err.println(e);
		}
		if(val == null) {
			System.out.println("No se realizo borrado");
		}else{
			System.out.println("Borrando <" + key +", "+ val +">");
		}
	}

	public static void mostrar() {
		System.out.println(hash);
	}

	public static void searchKey() {
		String key = insertKey();
		String rpta = "";

		if(hash.containsKey(key))
			rpta = "SI";
		else
			rpta = "NO";

		System.out.println("La tabla " + rpta +" contiene la clave: "+key);
	}

	public static void searchValue() {
		int valor = insertn("Ingresa el valor a buscar (entero): ");
		String rpta = "";

		if(hash.containsValue(valor))
			rpta = "SI";
		else
			rpta = "NO";

		System.out.println("La tabla " + rpta +" contiene el valor: "+valor);
	}
	public static int insertn(String x) {
		int value = 0;
		while(true) {
			System.out.print(x + ": ");
			try {
				value = scan.nextInt();
			}catch (Exception e) {
				System.err.println(e);
				scan.nextLine();
			}if(value != 0)break;
		}return value;
	}

	public static void existVal() {
		int op = 0;
		System.out.println("\nEscoge una opcion");
		while(op != -1) {
			System.out.println("\t1.- Buscar Clave\n"+"\t2.- Buscar Valor\n"+"\t3.- Atras");
			op = insertn("Ingrese opcion:");

			switch(op) {
			case 1:
				searchKey();
				break;
			case 2:
				searchValue();
				break;
			default:
				System.out.println("\nEscoja 1 o 2");
				break;
			}
		}
	}
}

