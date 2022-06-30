class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        ((Thread) producer.getThread()).start();
        ((Thread) consumer.getThread()).start();

        System.out.println("Press Control-C to stop.");
    }
}

class SharedResource {
    int i;
    boolean flag;

    public synchronized void put(int i) {
        while (flag == true) {
            try {
                // calling thread to give up the monitor and sleep until another thread enters the same monitor and calls notify() or notifyAll().
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.i = i;
        flag = true;
        System.out.println("Put: " + i);
        // wakes up the thread that called wait() on the same object. notifyAll() wakes up all the threads that called wait() on the same object and one of the thread will be granted access.
        notify();
    }

    public synchronized int get() {
        while (flag == false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Got: " + i);
        flag = false;
        notify();
        return i;
    }
}

class Producer implements Runnable {
    SharedResource sharedResource;
    Thread t;

    Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 1;

        while (i < 1000) {
            sharedResource.put(i++);
        }
    }

    public Runnable getThread() {
        return t;
    }
}

class Consumer implements Runnable {
    SharedResource sharedResource;
    Runnable t;

    Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true) {
            sharedResource.get();
        }
    }

    public Runnable getThread() {
        return t;
    }
}
