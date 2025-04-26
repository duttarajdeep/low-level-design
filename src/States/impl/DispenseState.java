package States.impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import States.VendingMachineState;

import java.util.List;

public class DispenseState implements VendingMachineState {
    public DispenseState(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Vending machine state: DISPENSE");
        dispenseProduct(machine, productCode);
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
        throw new Exception("Not allowed");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Please collect product from the tray");
        // go to machine inventory
        Item item = machine.getInventory().getItem(productCode);
        // remove the product from machine inventory - update status
        machine.getInventory().updateSoldOutItem(productCode);
        // state state to idle
        machine.setState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refund(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("Not allowed");
    }
}
