import { Component } from '@angular/core';
import { BpiHolder } from '../bpi-holder';
import { CoindeskService } from '../coindesk.service';

@Component({
  selector: 'app-coindesk',
  templateUrl: './coindesk.component.html',
  styleUrls: ['./coindesk.component.css']
})
export class CoindeskComponent {
  constructor(public service: CoindeskService) {};
  // bitcoin: BpiHolder;

  // loadBitcoinUpdate(): void {
  //   this.service.loadBitcoinBPI();
  //   let bpiHolder: BpiHolder = this.service.load();
  //   console.log(bpiHolder);
  // };
  
  load(): void {
  this.service.load().subscribe({
    next:(data:any)=> {
        let bitcoin: BpiHolder=data;
        console.log(bitcoin.bpi.USD.rate);
  },
  error:(error:any)=>{
        console.log(error)
  },
  complete:()=> {
      console.log("completed!")
  }

  });

}
}