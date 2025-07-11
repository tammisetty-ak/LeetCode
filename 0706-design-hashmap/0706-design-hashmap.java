class MyHashMap {

    List<int[]> map;

    public MyHashMap() {    
        map = new LinkedList<int[]>();
    }
    
    public void put(int key, int value) {
        boolean found = false;
        for(int[] item: map) {
            if(item[0] == key) {
                item[1] = value;
                found = true;
            }
        }
        if(!found) {
            int[] newItem = new int[2];
            newItem[0] = key;
            newItem[1] = value;
            map.add(newItem);
        }
    }

    public int get(int key) {
        for(int[] item : map) {
            if(item[0] == key) {
                return item[1];
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        Iterator<int []> iterator = map.iterator();

        while(iterator.hasNext()) {
            int[] item = iterator.next();
            if(item[0] == key) {
                iterator.remove();
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */