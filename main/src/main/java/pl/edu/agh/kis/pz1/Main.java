package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.Library;
import pl.edu.agh.kis.pz1.util.Reader;
import pl.edu.agh.kis.pz1.util.Writer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Library lab = new Library();
        Writer writer = new Writer(lab);
        for( int i = 0; i<3;i++)
        {
            writer = new Writer(lab);
            writer.start();
        }

        Reader reader = new Reader(lab);
        for( int i = 0; i<10;i++)
        {
            reader = new Reader(lab);
            reader.start();
        }
    }
}
