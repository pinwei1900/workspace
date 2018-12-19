package Main;

//功能的具体实现
public class Servant implements ActiveObject {

    public Result<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = fillchar;
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return new RealResult<String >(new String(buffer));
    }

    public void dispalyString(String string) {
        try{
            System.out.println("displayString :" + string);
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
