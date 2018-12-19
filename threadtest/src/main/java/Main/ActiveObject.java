package Main;


import Main.Result;

/**
 * 主动对象，两个方法，一个是创建字符串，另一个是打印字符串
 */
public interface ActiveObject {

    public abstract Result<String> makeString(int count, char fillchar);

    public abstract void dispalyString(String string);
}
