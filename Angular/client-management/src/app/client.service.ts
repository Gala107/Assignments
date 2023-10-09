import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from './client';
import { ClientMeeting } from './client-meeting';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  baseClientUrl:string ="http://localhost:3000/clients";
  baseMeetingUrl:string ="http://localhost:3000/meetings";

  constructor(private http: HttpClient) {}

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.baseClientUrl, client);
  }

  loadClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.baseClientUrl);
  }

  deleteClient(clientId: any): Observable<Client> {
    return this.http.delete<Client>(`${this.baseClientUrl}/${clientId}`);
  }

  updateClient(client: Client): Observable<Client[]> {
    return this.http.put<Client[]>(`${this.baseClientUrl}/${client.id}`, client);
  }

  createClientMeeting(meeting: any): Observable<ClientMeeting> {
    return this.http.post<ClientMeeting>(this.baseMeetingUrl, meeting);
  }
}
