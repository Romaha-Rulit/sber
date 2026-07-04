public class LinkedList<T> {
    private Node<T> root;
    private int size;
    private int maxSize;
    
    public LinkedList() {
        this(Integer.MAX_VALUE);
    }
    
    public LinkedList(int maxSize) {
        if (maxSize < 0) throw new IllegalArgumentException("maxSize не может быть отрицательным");
        this.maxSize = maxSize;
        this.size = 0;
    }
    
    public void add(T element) {
        if (size >= maxSize) {
            throw new IllegalStateException("Список переполнен. Максимальный размер: " + maxSize);
        }
        
        if (root == null) {
            root = new Node<>(element);
        } else {
            Node<T> last = root;
            while (last.next != null) last = last.next;
            last.next = new Node<>(element);
        }
        size++;
    }
    
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        if (size >= maxSize) {
            throw new IllegalStateException("Список переполнен. Максимальный размер: " + maxSize);
        }
        
        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.next = root;
            root = newNode;
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> newNode = new Node<>(element);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        return getNode(index).value;
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        
        T removed;
        if (index == 0) {
            removed = root.value;
            root = root.next;
        } else {
            Node<T> prev = getNode(index - 1);
            removed = prev.next.value;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }
    
    public int size() {
        return size;
    }
    
    private Node<T> getNode(int index) {
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    @Override
    public String toString() {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = root;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
