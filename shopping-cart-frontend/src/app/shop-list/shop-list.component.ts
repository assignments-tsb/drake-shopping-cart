import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../service/shopping-cart.service';
import { Observable } from 'rxjs';
import { Item } from '../model/item';

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.scss']
})
export class ShopListComponent implements OnInit {

  items: Observable<Item[]>;

  constructor(private shoppingCart: ShoppingCartService) { }

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.items = this.shoppingCart.listAvailableItems();
  }

}
