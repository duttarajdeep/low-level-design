package vending.machine.states;

import vending.machine.model.Coin;
import vending.machine.model.Item;
import vending.machine.model.VendingMachine;

import java.util.List;

public interface VendingMachineState {
    public void clickOnInsertCoinBtn(VendingMachine machine) throws Exception;

    public void clickOnSelectProductBtn(VendingMachine machine) throws Exception;

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    public void chooseProduct(VendingMachine machine, int productCode) throws Exception;

    public int getChange(int extraMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception;

    public List<Coin> refund(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception;


}
