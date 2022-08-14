public class Node<K, V> {
  K key;
  V value;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public String toString() {
    return "[" + "K=" + key + "; V=" + value + "]";
  }
}
