import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  constructor(private http: HttpClient) { }

  listAvailableItems(): Observable<Item[]> {
    return this.http.get<Item[]>('http://localhost:8080/shopping-cart/items');
  }

}
