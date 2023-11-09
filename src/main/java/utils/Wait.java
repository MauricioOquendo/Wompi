package utils;

public class Wait {

    public static void forMilliseconds(long millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
