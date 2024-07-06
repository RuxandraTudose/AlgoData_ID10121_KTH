public class Item {

    private ItemType type; //private; I can't access it from a different class
    private int value = 0;

	public Item(ItemType it_type, int value) {
		this.value = value;
		this.type = it_type;
	}

    public static Item Value(int value) {
        return new Item(ItemType.VALUE, value);
    }

	public static Item Mul() {
		return new Item(ItemType.MUL, 0);
	}

    public static Item Add() {
        return new Item(ItemType.ADD, 0);
    }

    public static Item Sub() {
        return new Item(ItemType.SUB, 0);
    }

    public static Item Div() {
        return new Item(ItemType.DIV, 0);
    }

    public ItemType type() {
        return this.type;
    }

    public int value () {
        return this.value;
    }

    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }
}