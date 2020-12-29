
package kata7.view;

public interface BlockDisplay {
    public static final int size = 100;
    
    public void paintBlock(int x, int y);
    
    void on(Moved moved);
    
    public interface Moved {
        void to(int x, int y);
    }
}
