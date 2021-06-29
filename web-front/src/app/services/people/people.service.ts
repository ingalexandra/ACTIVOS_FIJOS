import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PERSON_ENDPOINTS } from 'src/app/endpoints/person.constant';
import { Observable } from 'rxjs';
import { IResponse } from 'src/app/model/response';
import { IPerson } from 'src/app/model/person';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  private readonly ENDPOINT = PERSON_ENDPOINTS;

  constructor(private http: HttpClient) {}

  /**
   * Method to obtain the information of the people
   *
   * @author ingalexandrasarmiento
   * @returns Observable<IResponse<IPerson[]>>
   */
   public getPeople(): Observable<IResponse<IPerson[]>> {
    return this.http.get<IResponse<IPerson[]>>(this.ENDPOINT.listPeople);
  }
}
