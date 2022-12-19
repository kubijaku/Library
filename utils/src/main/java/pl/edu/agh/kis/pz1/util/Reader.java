package pl.edu.agh.kis.pz1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representation of Reader - {@code @extends} Thread;
 * Reader occupy one space in Library
 * @author Jakub Kubicki
 */
public class Reader extends Thread {
    Library library;


    public Reader(Library lab){ library = lab;}

    /**
     * Variable used to Print exceptions
     */
    public static final Logger logger = LoggerFactory.getLogger(Reader.class);

    /**
     * Method run - Overrides run() method
     * implementation of permanent getting the Reader in and out the Library with 3 sec break <p>
     * Prints logger.info("bye") after each "cycle" of getting in and out
     */
    @Override
    public void run() {
        while(true)
        {
            try {
                library.requestReader(this);
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

