package Propuestos;

public class HashSondeo<K, V>{
  private final int INITIAL_SIZE;
  private Node<K, V> [] entries;

  public HashSondeo (int INITIAL_SIZE) {
    this.INITIAL_SIZE = INITIAL_SIZE;
    entries = new Node [INITIAL_SIZE];
  }

  private int fixCollisionLinearSounding (int position){
    if (!(this.entries[position] == null)){
      return fixCollisionLinearSounding((position + 1) % INITIAL_SIZE);
    }
    return position;
  }
}