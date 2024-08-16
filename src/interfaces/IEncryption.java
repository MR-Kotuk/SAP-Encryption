package interfaces;

public interface IEncryption {
    public void main();
    public void input();

    public String encryption(String text, int key);
    public int generateKey();
}