import { Component, ɵclearResolutionOfComponentResourcesQueue } from '@angular/core';
import { CoindeskService } from '../coindesk.service';
import { Root } from '../root';

@Component({
  selector: 'app-bitcoin-display',
  templateUrl: './bitcoin-display.component.html',
  styleUrls: ['./bitcoin-display.component.css']
})
export class BitcoinDisplayComponent {
  msg = "";
  usdPrice = "";
  eurPrice = "";
  gbpPrice = "";

  constructor(public service: CoindeskService) { };

  loadBitcoinPrices(): void {
    this.service.loadCoindeskPrices().subscribe({
      next: response => {
        this.usdPrice = response.bpi.USD.rate;
        this.eurPrice = response.bpi.EUR.rate;
        this.gbpPrice = response.bpi.GBP.rate;

        if (response.bpi.USD.rate_float < 28000) {
          this.msg = "Buy now!";
        } else if (response.bpi.USD.rate_float > 50000) {
          this.msg = "Sell now!";
        }
      }
    });
  }
}
