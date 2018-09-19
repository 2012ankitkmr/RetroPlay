import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/throw';
import { Artists } from '../domain/Artists';
import { Songs } from '../domain/Songs';

@Injectable()
export class SongsService {

  private baseURL: string = 'http://localhost:8080/songs';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private allSongsUrl: string = '/all';

  constructor(private _http: Http) { }

  getAllSongsForMoodForArtist(mood: string, artistId: string) {

      return this._http.get(this.baseURL + "/" + mood + "/" + artistId, this.options).map((response: Response) => response.json())
        .catch(this.errorHandler);
  }

  getAllSongsForMood(mood: string) {

      return this._http.get(this.baseURL + "/mood/" + mood , this.options).map((response: Response) => response.json())
        .catch(this.errorHandler);
  }

  getSongDetails(songId: string) {

    return this._http.get(this.baseURL + "/getDetails/" + songId, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
  }

}
