public class Singleton {
    private static Singleton instance;
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){ };
}