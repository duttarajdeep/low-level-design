package vending.machine.model;

import vending.machine.states.VendingMachineState;
import vending.machine.states.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    VendingMachineState state;
    List<Coin> coins;

    Inventory inventory;

    public VendingMachine() {
        state = new IdleState();
        coins = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
