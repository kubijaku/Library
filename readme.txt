1.
 a) Class Reader is implementation of Reared extends Thread
- Class Writer is implementation of Writer extends Thread
- Class Library is implementation of Library - class handling threads Reader and Writer;
there can be maximum 5 readers or 1 writer inside the library in the same time
- in Main class objects Library, Readers and Writers are being created and started

b) Running program available through terminal by running java jar file from Library/main/target/

c) other important information included in javadoc file generated in javadoc/apidocs

d) Responses from server: Each element ( reader or writer ) sends information about actual state:
- "Reader ( number ) is waiting..." - means that this reader is in Queue - the thread occupy one place in Semaphore waiters
- "Reader ( number ) is reading..." - means that this reader is in Library - the thread occupy one place in Semaphore inside
- "Reader ( number ) finished :D" - means that this Reader release Library - the thread release one place in Semaphore inside and sleep for specific time; after that it log "bye" and start again

- "Writer ( number ) waits..." - means that this Writer is in Queue - the thread occupy one place in Semaphore waiters
- "Writer ( number ) writes..." - means that this Writer is in Library - the thread occupy the whole place in Semaphore inside
- "Writer ( number ) published new BOOK" - means that this Writer release Library - the thread release Semaphore inside and sleep for specific time; after that it log "bye" and start again

