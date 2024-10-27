public class Cart {
    public static final int MAX_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_ORDERED) {
            System.out.println("Reach maximum order quantity ");
        }
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered ++;
            System.out.println("Added");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i] == disc){
                for (int j = i + 1; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("Removed");
                return;
            }

        }
        System.out.println("Cannot find the disc");
    }

    public float totalCost(){
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

}

