package Main;

//打印线程调用方法
public class DisplayClientThread extends Thread {

    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; true; i++) {
                String string = Thread.currentThread().getName() + " " + i;
                activeObject.dispalyString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
        }
    }
}
