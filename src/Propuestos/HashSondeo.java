package Propuestos;

public class HashSondeo<K, V>{
  private final int INITIAL_SIZE;
  private Node<K, V> [] entries;

  public HashSondeo (int INITIAL_SIZE) {
    this.INITIAL_SIZE = INITIAL_SIZE;
    entries = new Node [INITIAL_SIZE];
  }

  public V get(K key){
    return this.entries[searchCollisionLinearSounding(key.hashCode() % INITIAL_SIZE, key)].getValue();
  }

  public int hashCode(){
    int hashCode = 0;
    for (Node entry : this.entries){
      if (!(entry == null)){
        hashCode += entry.getKey().hashCode();
      }
    }
    return hashCode;
  }

  public int size(){
    int counter = 0;
    for (Node entry : this.entries){
      if (!(entry == null))
        counter++;
    }
    return counter;
  }

  public String toString(){
    String str = "";
    str += "[";
    for (Node entry : this.entries){
      if (!(entry == null))
        str += entry;
    }
    str += "]";
    return str;
  }

  public boolean containsKey(Object key){
    return false;
  }

  public void put(K key, V value){
    if (containsKey(key)){
      System.out.println("La clave ya fue insertada");
      return;
    }
    Node<K,V> newNode = new Node<K,V>(key, value);
    this.entries[fixCollisionLinearSounding(key.hashCode() % INITIAL_SIZE)] = newNode;
  }

  private int fixCollisionLinearSounding (int position){
    if (!(this.entries[position] == null)){
      return fixCollisionLinearSounding((position + 1) % INITIAL_SIZE);
    }
    return position;
  }

  private int searchCollisionLinearSounding (int position, K key){
    if (!(this.entries[position].getKey().equals(key))){
      return searchCollisionLinearSounding((position + 1) % INITIAL_SIZE, key);
    }
    return position;
  }
}