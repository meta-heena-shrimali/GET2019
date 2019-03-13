package Question3;

import java.util.Date;

public class CircularQueue<T> implements Queue<T> {

    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public CircularQueue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        queue = (T[]) new Object[this.size];
    }

    @Override
    public boolean insert(T element) {
        if (!isFull()) {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = element;
            return true;
        } else {
            return false;

        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new AssertionError("Queue is Empty");
        }
        T element = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (front == -1) ? true : false;
    }

    @Override
    public boolean isFull() {
        if ((front == 0 && rear == size - 1) || (front - rear == 1)) {
            return true;
        }
        return false;
    }

    @Override
    public T top(){
        if (!isEmpty()) {
            return queue[front];
        } else {
            throw new AssertionError("Queue is empty");
        }
    }

}
