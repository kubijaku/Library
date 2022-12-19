package pl.edu.agh.kis.pz1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class representation of Writer - {@code @extends} Thread;
 * Writer occupy the whole space in Library ( Library needs to be empty for Writer to be able to get in )
 * @author Jakub Kubicki
 */
public class Writer extends Thread {
    Library library;


    /**
     * Variable used to Print exceptions
     */
    public static final Logger logger = LoggerFactory.getLogger(Writer.class);


    public Writer(Library lab){ library = lab;}

    /**
     * Method run - Overrides run() method
     * implementation of permanent getting the Writer in and out the Library with 3 sec break <p>
     * Prints logger.info("bye") after each "cycle" of getting in and out
     */
    @Override
    public void run() {
        while(true)
        {
            try {
                library.requestWriter(this);
            } catch (InterruptedException e) {
                logger.warn(String.valueOf(e));
                Thread.currentThread().interrupt();
            }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.warn(String.valueOf(e));
                    Thread.currentThread().interrupt();
                }
            logger.info("bye");
        }
    }
}
