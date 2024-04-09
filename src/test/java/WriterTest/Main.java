package WriterTest;

import org.model.Writer;

public class Main {
    public static void main(String[] args){
        Writer writer1 = new Writer("Nick","Bats");
        Writer writer2 = new Writer("Ksy", "Kok");
        Writer writer3 = new Writer("Gul'","Gaga");

        System.out.println("Writer 1 id: " + writer1.getUniqueID());
        System.out.println("Writer 2 id: " + writer2.getUniqueID());
        System.out.println("Writer 3 id: " + writer3.getUniqueID());

    }
}

