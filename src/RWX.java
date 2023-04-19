import java.io.*;
import java.util.Objects;

public class RWX {
    private File meufile =  new File("C:\\Users\\junio\\Documents\\Ola.txt");
    private File meuDiretorio = new File("C:\\Users\\junio");
    private FileReader readArq = null;
    private BufferedReader bufferedRead = null;
    private FileWriter writeFile;
    private BufferedWriter bufferWrite;
    // também usado para ter uma formatação de texto em bytes
    //private PrintWriter pw;
    public void arqFunc() {
        System.out.println("O arquivo existe ? "+ meufile.exists());
        System.out.println("Podemos ler o arquivo ? "+ meufile.canRead());
        System.out.println("Podemos executar ? "+ meufile.canExecute());
        System.out.println("Podemos escrever no arquivo ? "+ meufile.canWrite());
        System.out.println("Podemos deletar o arquivo ? "+ meufile.delete());
    }

    public void readContent() {
        if (meufile.exists()) {
            try {
                readArq = new FileReader(meufile);
                bufferedRead = new BufferedReader(readArq);

                String conteudo = bufferedRead.readLine();

                while(conteudo != null) {
                    System.out.println(conteudo);
                    conteudo = bufferedRead.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.closeObj(readArq, bufferedRead);
            }
        }
    }

    private void closeObj(FileReader file, BufferedReader buffer) {
        try {
            file.close();
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWriteFile(String escrita) {
        if (meufile.exists() && meufile.canWrite()) {
            try {

                //pw = new PrintWriter(meufile);
                //pw.write(escrita)
                // usando o segundo parametro append, conseguimos manter o texto antigo
                // adcionando o novo texto em uma nova linha
                writeFile = new FileWriter(meufile, true);
                bufferWrite = new BufferedWriter(writeFile);
                bufferWrite.write(escrita);
                bufferWrite.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.closeWrite(writeFile, bufferWrite);
            }
        }
    }
    //, FileWriter write, BufferedWriter bfWrite
    public void closeWrite(FileWriter write, BufferedWriter bfWrite) {
        try {
            write.close();
            bfWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFiles() {
        if (meuDiretorio.isDirectory() && meuDiretorio.canRead()) {
            for (File f : Objects.requireNonNull(meuDiretorio.listFiles())) {
                System.out.println(f.getName());
            }
        }
    }
}
