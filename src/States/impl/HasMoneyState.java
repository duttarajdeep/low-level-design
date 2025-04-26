package States.impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import States.VendingMachineState;

import java.util.List;

public class HasMoneyState implements VendingMachineState {
    public HasMoneyState(){
        System.out.println("Vending machine state: HAS_MONEY");
    }
    @Override
    public void clickOnInsertCoinBtn(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void clickOnSelectProductBtn(VendingMachine machine) throws Exception {
        // change state to selection state
        machine.setState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        // add coin to the machine
        System.out.println("Coin of value: " + coin.value + " accepted.");
        machine.getCoins().add(coin);
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
        throw new Exception("Not allowed");
    }

    @Override
    public List<Coin> refund(VendingMachine machine) throws Exception {
        System.out.println("Please collect the cash from the tray");
        // clear out the coins in machine
        machine.getCoins().clear();
        // update state to idle
        machine.setState(new IdleState());
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("Not allowed");
    }
}
