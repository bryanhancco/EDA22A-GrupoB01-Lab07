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