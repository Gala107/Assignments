import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  constructor(private router: Router, private service: ClientService) { };

  clients: Array<Client> = [];

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.service.loadClients().subscribe ({
      next: result => this.clients = result,
      error: error => console.log(`Error loading clients: ${error}`),
      complete: () => console.log("Loaded clients successfully.")      
    });
  }

  deleteClient(id: any): any {

  }

  updateClient(client: Client): any {

  }
}
