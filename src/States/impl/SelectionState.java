package States.impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import States.VendingMachineState;

import java.util.List;

public class SelectionState implements VendingMachineState {

    public SelectionState(){
        System.out.println("Vending machine state: SELECTION");
    }
    @Override
    public void clickOnInsertCoinBtn(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void clickOnSelectProductBtn(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        // get item by code
        Item item = machine.getInventory().getItem(productCode);
        // get cash submiited in machine
        int totalAmountSubmitted = 0;
        for (Coin coin : machine.getCoins()){
            totalAmountSubmitted += coin.value;
        }

        // if price == cash -> move to dispense state
        if (totalAmountSubmitted >= item.getPrice()){
            // if price < cash -> getChange() -> move to dispense state
            if (totalAmountSubmitted > item.getPrice()){
                getChange(totalAmountSubmitted - item.getPrice());
            }
            machine.setState(new DispenseState(machine, productCode));
        } else {
            // if price > cash -> refund() -> show error message
            System.out.println("Insufficient amount submitted");
            refund(machine);
            throw new Exception("Insufficient amount submitted");
        }
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        System.out.println("Chagne Refund amount: " + extraMoney);
        return extraMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public List<Coin> refund(VendingMachine machine) throws Exception {
        System.out.println("Please collect the cash from the tray");
        // set state to idle
        machine.setState(new IdleState());
        return machine.getCoins();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("Not allowed");
    }
}
