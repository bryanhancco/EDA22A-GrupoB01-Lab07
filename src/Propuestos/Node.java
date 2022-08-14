package Propuestos;

public class Node<K, V> {
  //Atributos
  private K key;
  private V value;
  
  //Constructor
  public Node(K key, V value) {
      this.key = key;
      this.value = value;
  }
  
  //Setter y Getter
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
			return this.key.equals(obj.getKey());
  }

  @Override
  public String toString() {
      return "<" + "key= " + key +", value= " + value + ">";
  }

}
