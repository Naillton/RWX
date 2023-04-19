package Contato;

import java.io.*;

public class Contato {
    private String nome;
    private int numero;
    private final File meuFile = new File("C:\\Users\\junio\\Documents\\Contatos.txt");
    private FileWriter writeFile = null;
    private BufferedWriter bfWrite = null;
    private FileReader readFile = null;
    private BufferedReader bfRead = null;

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void getAllContact(){
        if (meuFile.exists() && meuFile.canRead()) {
            try {
                 readFile = new FileReader(meuFile);
                 bfRead = new BufferedReader(readFile);

                 String content = bfRead.readLine();
                 System.out.println("MEUS CONTATOS");
                 System.out.println("--------------------------");
                 while (content != null) {
                     System.out.println(content);
                     content = bfRead.readLine();
                 }
                 System.out.println("--------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.closedRead();
            }
        }
    }

    public void insertContactFiles() {
        try {
            if (!meuFile.exists()) {
                meuFile.createNewFile();
            }
            writeFile = new FileWriter(meuFile, true);
            bfWrite = new BufferedWriter(writeFile);
            bfWrite.write("Nome: "+ this.getNome());
            bfWrite.write(" Numero: "+ this.getNumero()+"\n");
            bfWrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.closedWrite();
        }
    }

    private void closedWrite() {
        try {
            writeFile.close();
            bfWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closedRead() {
        try {
            readFile.close();
            bfRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
