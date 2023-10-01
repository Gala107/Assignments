import { Component } from '@angular/core';
import { BpiHolder } from '../bpi-holder';
import { CoindeskService } from '../coindesk.service';

@Component({
  selector: 'app-coindesk',
  templateUrl: './coindesk.component.html',
  styleUrls: ['./coindesk.component.css']
})
export class CoindeskComponent {
  constructor(public coindeskService: CoindeskService) {};

  loadBitcoinUpdate(): void {
    this.coindeskService.loadBitcoinBPI();
    let bpiHolder: BpiHolder = this.coindeskService.load();
    console.log(bpiHolder);
  };
}
