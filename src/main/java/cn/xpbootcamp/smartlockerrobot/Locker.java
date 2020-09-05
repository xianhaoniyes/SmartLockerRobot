package cn.xpbootcamp.smartlockerrobot;

import java.util.HashMap;

public class Locker {
    private int availableCapacity;
    private HashMap<Ticket,Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.availableCapacity = capacity;
    }

    public Ticket save(Bag bag) {
        if(availableCapacity == 0)
            throw new LockerIsFullException();
        Ticket ticket = new Ticket();
        bags.put(ticket,bag);
        availableCapacity -- ;
        return ticket;
    }

    public Bag pickupBy(Ticket ticket) {

        Bag bag =  bags.remove(ticket);

        if(bag == null){
            throw new InvalidTicketException();
        }

        return bag;

    }

    public int currentCapacity(){
        return availableCapacity;
    }
}
