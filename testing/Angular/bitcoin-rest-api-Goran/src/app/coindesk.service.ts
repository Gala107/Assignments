import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BpiHolder } from './bpi-holder';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoindeskService {

  constructor( public http: HttpClient ) {};

  loadBitcoinBPI(): void{
    this.http.get("https://api.coindesk.com/v1/bpi/currentprice.json").subscribe({
      next: ( data: any ) => {
        console.log(data); 
      },
      error: ( error: any ) => {
        console.log(error);
      },
      complete: () => {
        console.log("completed!");
      }});        
    }

    load(): BpiHolder {
      return this.http.get<BpiHolder>("https://api.coindesk.com/v1/bpi/currentprice.json");
    }

  //  let obj = this.http.get("https://api.coindesk.com/v1/bpi/currentprice.json");
  //  obj.
      

}
