class HashTable<K, V> {
    private static final int SIZE = 10;
    private final HashEntry[] entries = new HashEntry[SIZE];

    //Not an inner class, top-level class and do not need an instance of enclosing class.
    //Can be declared public, protected, default, private
    //Can access only the static members of the outer class.
    private static class HashEntry<K, V> {

        K key;
        V value;

        HashEntry<K, V> next;

        HashEntry(K k, V v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashEntry{" + "key=" + key + ", value=" + value + ", next=" + next + '}';
        }

    }

    public V put(K key, V value) {

        int hash = getHash(key);

        final HashEntry hashEntry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        } else {
            HashEntry currentEntry = entries[hash];

            while (currentEntry != null) {
                if (currentEntry.key.equals(key)) {
                    currentEntry.value = value;
                    return (V) currentEntry;
                } else {
                    currentEntry = currentEntry.next;
                }
            }
            
            currentEntry.next = hashEntry;
        }
        return (V) hashEntry;
    }

    public V get(K key) {

        int hash = getHash(key);

        if (entries[hash] != null) {
            HashEntry currentEntry = entries[hash];

            while (currentEntry != null) {

                if (currentEntry.key.equals(key)) {
                    return (V) currentEntry.value;
                }

                currentEntry = currentEntry.next;
            }
        }

        return null;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public int getKeyEntriesCount(K key) {
        int count = 1;
        int hash = getHash(key);

        HashEntry<K, V> currentEntry = entries[hash];
        if (currentEntry == null) {
            return 0;       // No entries found.
        }

        while (Objects.nonNull(currentEntry.next)) {
            currentEntry = currentEntry.next;
            count++;
        }

        return count;
    }
}
