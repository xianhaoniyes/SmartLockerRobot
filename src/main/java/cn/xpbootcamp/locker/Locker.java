package cn.xpbootcamp.locker;

import java.util.HashMap;

public class Locker implements BagSaver{
    private int availableCapacity;
    private int initCapacity;
    private final HashMap<Ticket,Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.availableCapacity = capacity;
        this.initCapacity = capacity;
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

    public int totalCapacity() {return initCapacity;}

    public String report(String empty) {
        String str= "L ";
        str = empty+str+currentCapacity()+" "+totalCapacity()+"\n";
        return str;
    }



}
