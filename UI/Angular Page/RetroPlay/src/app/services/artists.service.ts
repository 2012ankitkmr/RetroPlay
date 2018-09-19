import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/throw';


@Injectable()
export class ArtistsService {

  private baseURL: string = 'http://localhost:8080/artists';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private allArtistsUrl: string = '/all';

  constructor(private _http: Http) { }

  getAllArtistsForMood(mood: string) {

    if (mood == 'ALL')
      return this._http.get(this.baseURL + this.allArtistsUrl, this.options).map((response: Response) => response.json())
        .catch(this.errorHandler);
    else {
      return this._http.get(this.baseURL + "/mood/" + mood, this.options).map((response: Response) => response.json())
        .catch(this.errorHandler);
    }
  }

  getArtistDetails(artistId: string){
    
    return this._http.get(this.baseURL + "/"+ artistId, this.options).map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
  }

}
