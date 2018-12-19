package Main;

public class ActivationQueue {

    private static final int MAX_METHOD_REQUEST = 100;
    private final MethodRequest<String >[] requestQueue;
    private int tail;
    private int head;
    private int count;

    public ActivationQueue() {
        this.requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    public synchronized void putRequest(MethodRequest<String> request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized MethodRequest<String> takeRequst() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        MethodRequest<String> requst = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return requst;
    }
}
