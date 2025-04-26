package vending.machine.model;

public class Inventory {
    ItemShelf[] itemShelves;

    public Inventory(int itemCount){
        itemShelves = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getItemShelves() {
        return itemShelves;
    }

    public void setItemShelves(ItemShelf[] itemShelves) {
        this.itemShelves = itemShelves;
    }

    public void initialEmptyInventory(){
        int code = 101;
        for(int i = 0; i < itemShelves.length; i++){
            ItemShelf itemShelf = new ItemShelf(code, true);
            itemShelves[i] = itemShelf;
            code++;
        }
    }

    // add item to inventory
    public void addItem(Item item, int code) throws Exception{
        for (ItemShelf shelf : itemShelves){
            if (shelf.getCode() == code){
                if (!shelf.isSoldOut()){
                    shelf.setItem(item);
                } else throw new Exception("Shelf is full. Cant add a new item");
            }
        }
        throw new Exception("Invalid item code");
    }

    // get item
    public Item getItem(int code) throws Exception{
        for (ItemShelf shelf : itemShelves){
            if (shelf.isSoldOut()){
                throw new Exception("Item is sold out");
            } else {
                return shelf.getItem();
            }
        }
        throw new Exception("Invalid item code");
    }

    // update item
    public void updateSoldOutItem(int code){
        for (ItemShelf shelf: itemShelves){
            if(shelf.getCode() == code){
                shelf.setSoldOut(true);
            }
        }
    }



}
