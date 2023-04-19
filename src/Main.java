
public class Main {
    public static void main(String[] args) {

        RWX arq = new RWX();
        //arq.arqFunc();
        arq.setWriteFile("f mantido e esa e uma nova linha");
        arq.readContent();
        //arq.showFiles();
    }
}