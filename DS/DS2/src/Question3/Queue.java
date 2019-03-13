package Question3;

public interface Queue<T> {

    public boolean insert(T object);

    public T remove();

    public boolean isEmpty();

    public boolean isFull();

    public T top();
}
