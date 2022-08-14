import java.util.Arrays;
import java.util.LinkedList;

public class HashEncadenado<K extends String, V extends Integer> implements HashTable<K, V> {
  // Atributos
  private final Object[] valores;
  private int size;
  private final int lenght;

  // Constructores
  public HashEncadenado() {
    this(11);
  }

  public HashEncadenado(int lenght) {
    this.lenght = lenght;
    valores = new LinkedList[this.lenght];
  }

  // Retorna el index para el vector de valores HashAbierto
  private int functionHash(int hashCode) {
    return (hashCode + 1) % lenght;
  }

  // Retorna el numero de clave-valor registrado en la tabla hash.
  public int size() {
    return size;
  }

  // Retorna true si el tamaño de la tabla es cero
  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  // Retorna true Si la tabla contiene una clave determinada.
  public boolean containsKey(K key) { // recibe la key
    if (key != null) {
      int index = functionHash(key.hashCode()); // index de la key ingresada
      LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valores[index];
      if (listInPosition == null) {
        return false; // retorna false si la tabla no contiene la clave determinada
      } else {
        return !listInPosition.isEmpty();
      }
    } else {
      throw new NullPointerException(); // si no existe salta una exepción de NullPointerException
    }
  }

  // Retorna true. Si la tabla contiene uno o mas registros asociados a cierto
  // valor especificado.
  public boolean containsValue(V value) {
    for (Object valor : valores) {
      if (valor != null) {
        LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valor;
        for (Node<K, V> aux : listInPosition) {
          if (value.equals(aux.getValue())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // Retorna el valor el cual corresponde a la clave o null si la tabla no
  // contiene el registro para la clave.
  // Si la key es nula saltará una excepción de NullPointerException.
  public V get(K key) {
    if (key != null) {
      int index = functionHash(key.hashCode());
      LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valores[index];

      if (listInPosition != null) {
        for (Node<K, V> aux : listInPosition) {
          if (key.equals(aux.getKey())) {
            return aux.getValue();
          } else {
            return null;
          }
        }
      } else {
        return null;
      }

    } else {
      throw new NullPointerException();
    }
    return null;
  }

  //
  // Asocia el valor especificado con la clave especificada a la tabla hash
  // Si la tabla tiene un registro previo para la clave,
  // el valor viejo es reemplazado por el nuevo valor ingresado.
  //
  public void put(K key, V value) {
    if (key != null) {
      int index = functionHash(Math.abs(key.hashCode()));
      LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valores[index];
      if (listInPosition != null) { // Para verificar que la posicion este inicializada
        listInPosition.push(new Node<>(key, value));
      } else { // De otro modo, se inicializa la posicion
        LinkedList<Node<K, V>> addListInPosition = new LinkedList<Node<K, V>>();
        addListInPosition.push(new Node<>(key, value));
        valores[index] = addListInPosition;
      }
      size++;

    } else {
      throw new NullPointerException();
    }
  }

  // Elimina el registro de una clave, si la tabla contiene un registro para la
  // clave.
  // y retorna su valor, si la key es nula lanza una exepción de
  // NullPointerException.
  @Override
  public V remove(Object key) {
    if (key != null) {
      int index = functionHash(key.hashCode());

      LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valores[index];

      if (listInPosition != null) {

        for (Node<K, V> aux : listInPosition) {
          if (key.equals(aux.getKey())) {
            listInPosition.remove(aux);
            size--;
            return aux.getValue();
          }
        }
        return null;
      } else {
        return null;
      }

    } else {
      throw new NullPointerException();
    }
  }

  // Elimina todos los registros de la tabla hash
  public void clear() {
    for (Object valor : valores) {
      valor = null;
      this.size = 0;
    }
  }

  // Retorna el codigo hash para TODA la tabla hash.
  public int hashCode() {
    int result = 1;
    if (!this.isEmpty()) {
      for (Object valor : valores) {
        if (valor != null) {
          LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valor;
          if (!listInPosition.isEmpty()) {
            result = result + listInPosition.getFirst().getKey().hashCode();
          }
        }
      }
      return result;
    } else {
      result = result * 17 + lenght;
      result = result * 31 + size;
      result = result * (((valores == null)) ? 0 : Arrays.hashCode(valores));
      return result;
    }
  }

  // Retorna todos los elementos de la tabla hash.
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("HashAbierto = {\n");
    sb.append("\tsize=").append(size).append("\n");
    sb.append("\tlenght=").append(lenght).append("\n");
    ;
    sb.append("\thashCode=").append(this.hashCode()).append("\n");
    sb.append("\telements = {").append("\n");
    for (Object valor : this.valores) {
      if (valor != null) {
        LinkedList<Node<K, V>> listInPosition = (LinkedList<Node<K, V>>) valor;
        if (!listInPosition.isEmpty()) {
          sb.append("\t\t").append(valor.toString()).append("\n");
        }
      }
    }
    sb.append("\t}").append("\n");
    sb.append("}").append("\n");

    return sb.toString();
  }

}