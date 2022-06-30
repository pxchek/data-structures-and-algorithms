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
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.i = i;
        flag = true;
        System.out.println("Put: " + i);
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
