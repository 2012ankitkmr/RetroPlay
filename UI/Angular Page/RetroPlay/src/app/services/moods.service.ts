import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/throw';

@Injectable()
export class MoodsService {

  private baseURL: string = 'http://localhost:8080/moods';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private allMoodsUrl :string = '/all';

    constructor(private _http: Http) { }

    getAllMoods() {
        return this._http.get(this.baseURL + this.allMoodsUrl, this.options).map((response: Response) => response.json())
            .catch(this.errorHandler);
    }

    errorHandler(error: Response) {
        return Observable.throw(error||"SERVER ERROR");
    }


}
