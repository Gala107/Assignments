import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoindeskService {

  constructor( public http: HttpClient ) {};

    load(): Observable<any> {
      return this.http.get<any>("https://api.coindesk.com/v1/bpi/currentprice.json");
    }
}
