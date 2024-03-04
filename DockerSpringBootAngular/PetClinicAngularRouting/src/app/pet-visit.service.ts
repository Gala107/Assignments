import { Injectable } from '@angular/core';
import { Visit } from './visit';
import { Pet } from './pet';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PetVisitService {
  baseUrl = "http://localhost:8282/petclinic/";

  constructor(private http: HttpClient) {}

  addVisit(visit: Visit): Observable<Pet> {
    let endPoint = "addVisit";
    return this.http.post<Pet>(this.baseUrl + endPoint, visit);
  }

  findPetById(id: any): Observable<Pet> {
    let endPoint = "getPetById/"
    return this.http.get<Pet>(this.baseUrl + endPoint + id);
  }
}
