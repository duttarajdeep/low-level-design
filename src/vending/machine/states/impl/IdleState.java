package vending.machine.states.impl;

import vending.machine.model.Coin;
import vending.machine.model.Item;
import vending.machine.model.VendingMachine;
import vending.machine.states.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements VendingMachineState {

    public IdleState(){
        System.out.println("Vending machine state: IDLE");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Vending machine state: IDLE");
        machine.setCoins(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinBtn(VendingMachine machine) throws Exception {
        machine.setState(new HasMoneyState());
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
        throw new Exception("Not allowed");
    }

    @Override
    public List<Coin> refund(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        // code to add item
    }
}
