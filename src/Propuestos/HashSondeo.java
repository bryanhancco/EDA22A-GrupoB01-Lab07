package Propuestos;

public class HashSondeo <K extends Comparable<K>, V extends Comparable<V>> {
	private final int INITIAL_SIZE;
	private Node<K, V>[] entries;

	public HashSondeo() {
		this(11);
	}
	public HashSondeo(int len) {
		this.INITIAL_SIZE = len;
		this.entries = (Node<K, V>[]) new Node[len];
	}

  public int size() {
    int counter = 0;
    for (Node entry : this.entries){
    	if (!(entry == null))
       	counter++;
    }
   	return counter;
	}

  public boolean isEmpty() {
		return size() == 0;
	}

  public boolean containsKey(K key) {
		if (key == null || isEmpty())
			throw new NullPointerException();
		int index = functionHash(key.hashCode());
		int c = index;
		do {
			c = functionHash(c);
			if (this.entries[c].getKey().equals(key))
				return true;
			c++;
		} while(c != index);
		return false;
	}

  public boolean containsValue(V value) {
		if (value == null || isEmpty())
			throw new NullPointerException();
		for (Node<K, V> node : this.entries)
			if (node.getValue().equals(value))
				return true;
		return false;
	}

  public V get(K key) {
   	return this.entries[searchCollisionLinearSounding(key.hashCode() % INITIAL_SIZE, key)].getValue();
	}

  public void put(K key, V value) {
   	if (containsKey(key)){
     	System.out.println("La clave ya fue insertada");
    	return;
  	}
  	Node<K,V> newNode = new Node<K,V>(key, value);
  	this.entries[fixCollisionLinearSounding(key.hashCode() % INITIAL_SIZE)] = newNode;
	}

  public Integer remove(K key) {
		if (key == null || isEmpty())
			throw new NullPointerException();
		int index = functionHash(key.hashCode());
		int c = index;
		do {
			c = functionHash(c);
			if (this.entries[c].getKey().equals(key)) {
				this.entries[c] = null;
				return c;
			}
			c++;
		} while(c != index);
		return null;
	}

  public void clear() {
		for (Node<K, V> node : this.entries) {
			if (node == null) continue;
			node = null;
		}
	}

	public int functionHash(int hashCode) {
		return (hashCode) % this.entries.length;
	}

  public int hashCode() {
   	int hashCode = 0;
  	for (Node entry : this.entries){
    	if (!(entry == null)){
      	hashCode += entry.getKey().hashCode();
     	}
  	}
    return hashCode;
	}

  public String toString() {
    String str = "";
    str += "[";
    for (Node entry : this.entries){
      if (!(entry == null))
        str += entry;
    }
    str += "]";
    return str;
	}

  private int fixCollisionLinearSounding(int position){
    if (!(this.entries[position] == null))
      return fixCollisionLinearSounding((position + 1) % INITIAL_SIZE);
    return position;
  }

  private int searchCollisionLinearSounding(int position, K key){
    if (!(this.entries[position].getKey().equals(key)))
      return searchCollisionLinearSounding((position + 1) % INITIAL_SIZE, key);
    return position;
  }
}
