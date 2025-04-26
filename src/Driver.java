import Model.*;
import States.VendingMachineState;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("==========================");
            System.out.println("Filling up the inventory");
            System.out.println("==========================");

            loadInventory(vendingMachine);

            displayInventory(vendingMachine);

            System.out.println("==========================");
            System.out.println("Pressed Insert Coin Button");
            System.out.println("==========================");

            VendingMachineState state = vendingMachine.getState();
            state.clickOnInsertCoinBtn(vendingMachine);

            state = vendingMachine.getState();
            state.insertCoin(vendingMachine, Coin.ONE_RUPEE);
            state.insertCoin(vendingMachine, Coin.TWO_RUPEE);
            state.insertCoin(vendingMachine, Coin.TEN_RUPEE);
            state.insertCoin(vendingMachine, Coin.TWENTY_RUPEE);


            System.out.println("==========================");
            System.out.println("Pressed Select Product Button");
            System.out.println("==========================");

            state.clickOnSelectProductBtn(vendingMachine);

            state = vendingMachine.getState();
            state.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);
        } catch (Exception ex){
            System.out.println("Message: " + ex.getMessage());
            displayInventory(vendingMachine);
        }
    }

    private static void loadInventory(VendingMachine machine){
        ItemShelf[] shelves = machine.getInventory().getItemShelves();
        for (int i = 0; i < shelves.length; i++){
            Item item = new Item();
            if (i < 3){
                //1st shelf 3 juices
                item.setItemType(ItemType.JUICE);
                item.setPrice(12);
            } else if (i < 5){
                // 2nd shelf 3 coke
                item.setItemType(ItemType.COKE);
                item.setPrice(20);
            } else if(i < 7){
                // 3rd shelf 3 soda
                item.setItemType(ItemType.SODA);
                item.setPrice(25);
            }
            shelves[i].setItem(item);
            shelves[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine machine){
        System.out.println("=====Machine Details=====");
        System.out.println("=====Current Inventory Status=====");
        ItemShelf[] shelves = machine.getInventory().getItemShelves();
        for(ItemShelf shelf : shelves){
            System.out.println("Code: " + shelf.getCode() +
                                "\nItem: " + shelf.getItem().getItemType() +
                                "\nPrice: " + shelf.getItem().getPrice() +
                                "\nAvailable: " + shelf.isSoldOut());
        }

        System.out.println("=====Coins=====");
        if(!machine.getCoins().isEmpty()){
            for(Coin coin : machine.getCoins()){
                System.out.println("Value: " + coin.value);
            }
        } else System.out.println("No coins present");
    }
}
