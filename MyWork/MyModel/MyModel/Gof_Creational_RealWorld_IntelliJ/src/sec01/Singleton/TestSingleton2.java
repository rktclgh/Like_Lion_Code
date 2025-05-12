package sec01.Singleton;


import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//Java Api 싱글톤 확인
public class TestSingleton2 {
    public static void main(String[] args) {
   //new 연산자를 사용하지 않고 객체가 정적으로 생성한 메소드를 호출
        Runtime run = Runtime.getRuntime();

        try {
            run.exec("mspaint.exe");
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        LogManager res = LogManager.getLogManager();
        Logger res_logger = res.getLogger("com.sec01.singleton.Logger");




    }
}
