import { Item } from "./item";

export class Purchase {

    id: number = null;
    itemId: number;
    quantity: number;
    item: Item;

    static fromList(items: Item[]): Purchase[] {
        return items.map(i => Purchase.from(i));
    }

    static from(item: Item): Purchase {
        let purchase = new Purchase();
        purchase.itemId = item.id;
        purchase.quantity = item.quantity;
        purchase.item = item;

        return purchase;
    }
}
