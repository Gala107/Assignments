import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Root } from './root';

@Injectable({
  providedIn: 'root'
})
export class CoindeskService {

  constructor(public http: HttpClient) {};
  
  loadCoindeskPrices():Observable<Root> {
    return this.http.get<Root>("https://api.coindesk.com/v1/bpi/currentprice.json");
  }
}
