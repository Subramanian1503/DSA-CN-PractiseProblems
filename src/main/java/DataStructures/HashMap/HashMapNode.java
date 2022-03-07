package DataStructures.HashMap;

public class HashMapNode <K, V>{

    protected K key;

    protected V value;

    protected HashMapNode<K, V> next;

    public HashMapNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
