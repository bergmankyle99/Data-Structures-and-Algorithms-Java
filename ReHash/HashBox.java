
public class HashBox<K, V> {

    final private int hash_table_size = 5;
    public int count = 0;
    LinkedListNode[] hashTable = new LinkedListNode[hash_table_size];
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;

    public V get(K k) {

        int hash = Math.abs(k.hashCode()) % hash_table_size;

        if (hash == 0) {
            return gotoidx(hash, count1, k);
        }
        if (hash == 1) {
            return gotoidx(hash, count2, k);

        }
        if (hash == 2) {
            return gotoidx(hash, count3, k);

        }
        if (hash == 3) {
            return gotoidx(hash, count4, k);

        }
        if (hash == 4) {
            return gotoidx(hash, count5, k);
        }

        return (V) "Nothing";

    }

    public V put(K k, V v) {
        LinkedListNode<K, V> node = new LinkedListNode<K, V>();
        int hash = Math.abs(k.hashCode()) % hash_table_size;
        node.key = k;
        node.v = v;
        //System.out.println("hash: "+hash);
        if (hashTable[hash] == null) {
            addAfterNull(node, hash);
        } else {
            addFirst(k, v, hash);
        }
        if (hash == 0) {
            count1++;
        }
        if (hash == 1) {
            count2++;
        }
        if (hash == 2) {
            count3++;
        }
        if (hash == 3) {
            count4++;
        }
        if (hash == 4) {
            count5++;
        }

        count++;

        return (V) hashTable[hash].next.v;
    }

    public V remove(K key) {
        int hash = Math.abs(key.hashCode()) % hash_table_size;
        LinkedListNode<K, V> node = new LinkedListNode<K, V>();
        if (hash == 0) {
            V v = gotoidx(hash, count1, key);
            node = hashTable[hash].next.next;
            hashTable[hash] = hashTable[hash].next;
            hashTable[hash].next = node;
            count1--;
            return v;
        }
        if (hash == 1) {
            V v = gotoidx(hash, count2, key);
            hashTable[hash] = hashTable[hash].next;
            count2--;
            return v;
        }
        if (hash == 2) {
            V v = gotoidx(hash, count3, key);
            hashTable[hash] = hashTable[hash].next;
            count3--;

            return v;
        }
        if (hash == 3) {
            V v = gotoidx(hash, count4, key);
            hashTable[hash] = hashTable[hash].next;
            count4--;
            return v;
        }
        if (hash == 4) {
            V v = gotoidx(hash, count5, key);
            hashTable[hash] = hashTable[hash].next;
            count5--;
            return v;
        }
        count--;
        return (V) "Nothing";
    }

    public LinkedListNode addAfterNull(LinkedListNode node, int hash) {
        LinkedListNode<K, V> node2 = new LinkedListNode<K, V>();
        hashTable[hash] = node;
        hashTable[hash].next = node2;
       
        return hashTable[hash];
    }

    public LinkedListNode addFirst(K k, V v, int hash) {
        LinkedListNode<K, V> node = hashTable[hash];
        node.key = k;
        node.v = v;
        K key = (K) hashTable[hash].key;
        V val = (V) hashTable[hash].v;
        node.next = hashTable[hash];
        node.next.key = key;
        node.next.v = val;
        hashTable[hash] = node;
        hashTable[hash].key = k;
        hashTable[hash].v = v;
        
        return hashTable[hash];

    }

    private V gotoidx(int hash, int count, K k) {
        LinkedListNode<K, V> current = hashTable[hash];
        K key = (K) hashTable[hash].key;
        V v = (V) hashTable[hash].v;
        current.v = v;
        current.key = key;
        for (int i = 0; i < count; i++) {
            if (current.key == k) {
                System.out.println(current.v);
                return current.v;
            } else {
                current = current.next;
                current.v = v;
                current.key = key;
                System.out.println(current.v);
            }
        }
        return current.v;
    }

    private LinkedListNode gotoidx(int hash, int count) {
        LinkedListNode<K, V> current = hashTable[hash];
        K key = (K) hashTable[hash].key;
        V v = (V) hashTable[hash].v;
        current.v = v;
        current.key = key;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }
        current.v = v;
        current.key = key;
        return current;
    }

    public void List() {
        for (int i = 0; i < 5; i++) {
            System.out.print("#" + i + ":\t");
            if (hashTable[i] == null) {
                System.out.println("null");
            } else {
                if (i == 0) {
                    for (int j = 0; j < count1; j++) {
                        System.out.print("<" + gotoidx(i, j).key + ", " + gotoidx(i, j).v + ">");
                    }

                }
                if (i == 1) {
                    for (int j = 0; j < count2; j++) {
                        System.out.print("<" + gotoidx(i, j).key + ", " + gotoidx(i, j).v + ">");
                    }
                }
                if (i == 2) {
                    for (int j = 0; j < count3; j++) {
                        System.out.print("<" + gotoidx(i, j).key + ", " + gotoidx(i,j).v + ">");
                    }
                    
                }

                if (i == 3) {
                    for (int j = 0; j < count4; j++) {
                        System.out.print("<" + gotoidx(i, j).key + ", " + gotoidx(i, j).v + ">");
                    }
                    
                }

                if (i == 4) {
                    for (int j = 0; j < count5; j++) {
                        System.out.print("<" + gotoidx(i,j).key + ", " + gotoidx(i, j).v + ">");
                    }
                    
                }
                System.out.println();
            }

        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
