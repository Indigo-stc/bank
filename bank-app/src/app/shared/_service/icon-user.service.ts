import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { IconUser } from '../models/security';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IconUserService extends CrudService<IconUser> {

  ENROLMENT_PATH = '/isr';

  constructor() {
    super('/isr');
  }

  checkIfIconUserExists(answerUser: IconUser): Observable<boolean> {
      return this._http.post<boolean>(`${this.endPoint}/exists`, answerUser);
  }

}
