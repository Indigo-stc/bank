import { Inject, Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CrudService<T> {

  protected _http = inject(HttpClient);
  private apiUrl = environment.apiUrl;
  protected endPoint: string;

  constructor(@Inject('PATH_URL') private pathUrl: string) {
    this.endPoint = `${this.apiUrl}${this.pathUrl}`;
  }

  getAll() {
    return this._http.get<T[]>(this.endPoint);
  }

  getById(id: number): Observable<T> {
    return this._http.get<T>(`${this.endPoint}/${id}`);
  }

  create(item: T): Observable<T> {
    return this._http.post<T>(this.endPoint, item);
  }

  update(id: number, item: T): Observable<T> {
    return this._http.put<T>(`${this.endPoint}/${id}`, item);
  }

  delete(id: number): Observable<void> {
    return this._http.delete<void>(`${this.endPoint}/${id}`);
  }

}

