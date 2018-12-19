package Main;

//打印数据请求
public class DispalyStringRequest extends MethodRequest<String> {

    private final String string;

    protected DispalyStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }

    public void execute() {
        servant.dispalyString(string);
    }
}
