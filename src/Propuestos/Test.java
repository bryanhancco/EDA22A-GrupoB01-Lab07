public class Test {
    public static void main(String[] args) {
    	//Creamos una tabla hash e ingresamos datos
        HashEncadenado<String, Integer> hash = new HashEncadenado<String, Integer>();
        hash.put("a", 1);
        hash.put("b", 2);
        hash.put("c", 3);
        hash.put("d", 4);
        hash.put("e", 5);
        hash.put("f", 6);
        hash.put("g", 7);
        hash.put("h", 8);
        hash.put("i", 9);
        hash.put("j", 10);
        hash.put("k", 11);
        hash.put("l", 12);
        hash.put("m", 13);
        hash.put("n", 14);
        hash.put("o", 15);
        hash.put("p", 16);
        hash.put("q", 17);
        hash.put("r", 18);
        hash.put("s", 19);
        hash.put("t", 20);
        hash.put("u", 21);
        hash.put("v", 22);
        hash.put("w", 23);
        hash.put("x", 24);
        hash.put("y", 25);
        hash.put("z", 26);

        System.out.println(hash.toString());
        //casos de busqueda
        System.out.println("¿la tabla hash está vacía?\n" +  hash.isEmpty());
        System.out.println("¿Se encuentra la clave 'w'?\n" + hash.containsKey("w"));
        System.out.println("¿Se encuentra la clave 'g'?\n" + hash.containsKey("g"));
        System.out.println("¿Se encuentra el valor '10'?\n" + hash.containsValue(10));
        System.out.println("Removiendo la clave t" + hash.remove("t"));
        System.out.println(hash.toString());
        System.out.println("Tamaño actual de la tabla hash: "+hash.size());
        System.out.println("Vemos que el tamaño se redujo en 1");
    }
}