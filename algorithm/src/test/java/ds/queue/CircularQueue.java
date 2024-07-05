package ds.queue;

public class CircularQueue {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        // 入队操作
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // 队列已满，尝试再入队应失败
        System.out.println(queue.enqueue(6));  // 输出 false

        // 出队操作
        System.out.println(queue.dequeue());  // 输出 1
        System.out.println(queue.dequeue());  // 输出 2

        // 队列状态
        System.out.println("Size: " + queue.size());  // 输出 Size: 3
        System.out.println("Empty: " + queue.isEmpty());  // 输出 Empty: false
        System.out.println("Full: " + queue.isFull());  // 输出 Full: false
    }

    private int front;       // 队列头部指针
    private int rear;        // 队列尾部指针
    private final int capacity;    // 队列容量
    private int count;       // 当前队列中的元素数量
    private final int[] elements;  // 存储队列元素的数组

    // 构造函数，初始化循环队列
    public CircularQueue(int size) {
        capacity = size;
        elements = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    // 入队操作
    public boolean enqueue(int item) {
        if (count == capacity) {  // 队列已满
            return false;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        count++;
        return true;
    }

    // 出队操作
    public int dequeue() {
        if (isEmpty()) {  // 队列为空
            throw new IllegalStateException("Queue is empty");
        }
        int item = elements[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return count == capacity;
    }

    // 返回队列中的元素数量
    public int size() {
        return count;
    }
}