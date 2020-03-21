package mConcurrencyInJava.jFairLocksAndLiveLocks.bLiveLock;

public class SharedResource {

    private Worker owner;

    public SharedResource(Worker ownder) {
        this.owner = ownder;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }



}
