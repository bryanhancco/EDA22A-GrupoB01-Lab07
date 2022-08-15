public class Node<K, V> {
  K key;
  V value;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  // Setter y Getter de atributos
  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public boolean equals(Node<K, V> obj) {
    return false;
  }

  public String toString() {
    return "[" + "K=" + key + "; V=" + value + "]";
  }
}
