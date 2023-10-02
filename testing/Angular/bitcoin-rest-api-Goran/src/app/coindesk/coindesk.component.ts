import { Component } from '@angular/core';
import { Bpi } from '../bpi';
import { CoindeskService } from '../coindesk.service';

@Component({
  selector: 'app-coindesk',
  templateUrl: './coindesk.component.html',
  styleUrls: ['./coindesk.component.css']
})
export class CoindeskComponent {
  constructor(public service: CoindeskService) { };

  bpiArray: Array<Bpi> = [];
  msg = "";
  
  load(): void {
    this.service.load().subscribe({
      next: (data: any) => {
        this.bpiArray[0] = data["bpi"]["USD"];
        this.bpiArray[1] = data["bpi"]["EUR"];
        this.bpiArray[2] = data["bpi"]["GBP"];

        let price = parseFloat(this.bpiArray[0].rate.replace(",", ""));
        console.log("price " + price );

        if (price < 27000) {
          this.msg = "Buy now!";
        }else if (+price > 50000) {
          this.msg = "Sell now!";
        }

        console.log(this.bpiArray);
      },
      error: (error: any) => {
        console.log(error)
      },
      complete: () => {
        console.log("completed!")
      }
    });
  }
}