import { Component, OnInit } from '@angular/core';
import { Purchase } from '../model/purchase';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ShoppingCartService } from '../service/shopping-cart.service';
import { Item } from '../model/item';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrls: ['./shop-cart.component.scss']
})
export class ShopCartComponent implements OnInit {

  purchases: Purchase[] = [];

  constructor(private shoppingCart: ShoppingCartService) { }

  ngOnInit() {
    this.loadItems();
  }

  async loadItems() {
    let purchases: Purchase[] = await (this.shoppingCart.listAvailableItems().pipe(
      map((items) => Purchase.fromList(items))
    ).toPromise());

    this.purchases = purchases;
  }

  async buy() {
    console.log('buy!');
    let purchases = await this.shoppingCart.purchase(this.purchases).toPromise();
    console.log('Purchased: ' + purchases);
  }

}
