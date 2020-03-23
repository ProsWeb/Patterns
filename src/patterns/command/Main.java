//Write two classes which represent the Command pattern, CommandMove and CommandPickItem.
//
//        These classes should also support undo.
//        They should implement the entity movement on the 2D and item picking.
//        The x-axis on the map goes from left to right, the y-axis goes from bottom to top.
//
//        The inventory of the entity has getInventoryLength() slots starting from 0,
//        and each slot can contain only one item.
//        The entity should pick an item into a slot with least possible index
//        (slots with nothing inside is null).
//        If all slots of an entity are filled with some item,
//        then entity should not place this item in its inventory.
//
//        To undo, you should revert the changes made to the entity,
//        so the coordinates and the inventory of the entity before execute()
//        and after undo() should be the same.

package patterns.command;

interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    Integer previousX = null;
    Integer previousY = null;

    @Override
    public void execute() {
        previousX = entity.getX();
        previousY = entity.getY();

        entity.setX(xMovement);
        entity.setY(yMovement);
    }

    @Override
    public void undo() {
        entity.setX(previousX);
        entity.setY(previousY);
    }
}

class CommandPickItem implements Command {
    Storable entity;
    String item;
    Integer usedSlot = null;

    @Override
    public void execute() {
        int inventoryLength = entity.getInventoryLength();
        for (int i = 0; i < inventoryLength; i++) {

            String currentItem = entity.getInventoryItem(i);
            if (currentItem == null) {
                entity.setInventoryItem(i, item);
                usedSlot = i;

                return;
            }
        }
    }

    @Override
    public void undo() {
        if (usedSlot != null) {
            entity.setInventoryItem(usedSlot, null);
            usedSlot = null;
        }
    }
}

