package pl.edu.agh.kis.pz1.util;


import java.util.concurrent.Semaphore;

/**
 * Class representation of Library - Threads Handler
 * @author Jakub Kubicki
 */
public class Library {
    /**
     * Makximum number of Threads in "Library"
     */
    int space_in_library = 5;
    private Semaphore waiters = new Semaphore(20);
    private Semaphore inside = new Semaphore(space_in_library);

    /**
     * Method handling Thread Writer
     */
    public void requestWriter(Thread object) throws InterruptedException {
        waiters.acquire();
        System.out.println("Writer " + object.getName().substring(7) + " waits...");
        for(int i = 0; i< space_in_library; i++) {
            inside.acquire();
        }


        Thread.sleep(500);

        waiters.release();
        System.out.println("Writer " + object.getName().substring(7) + " writes...");
        for(int i = 0; i< space_in_library; i++)
        {
            inside.release();
        }
        System.out.println("Writer " + object.getName().substring(7) + " published new BOOK");
    }

    /**
     * Method handling Thread Reader
     */
    public void requestReader(Thread object) throws InterruptedException {
        waiters.acquire();
        System.out.println("Reader " + object.getName().substring(7) + " is waiting...");

        inside.acquire();
        Thread.sleep(500);

        waiters.release();
        System.out.println("Reader " + object.getName().substring(7) + " is reading...");

        inside.release();
        System.out.println("Reader " + object.getName().substring(7) + " finished :D");

    }

}
