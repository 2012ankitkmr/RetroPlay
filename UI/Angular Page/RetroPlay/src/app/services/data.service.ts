import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class DataService {

  private moodSource = new BehaviorSubject<string>("ALL");
  currentMood = this.moodSource.asObservable();

  private artistIdSource = new BehaviorSubject<string>("");
  currentArtistId = this.artistIdSource.asObservable();

  private songIdSource = new BehaviorSubject<string>("");
  currentSongId = this.songIdSource.asObservable();

  private artistNameSource = new BehaviorSubject<string>("Select an Artist/Song");
  currentArtistName = this.artistNameSource.asObservable();

  private playSongSource = new BehaviorSubject<boolean>(false);
  statusPlaySong = this.playSongSource.asObservable();

  constructor() { }

  changeMood(mood: string) {
    this.moodSource.next(mood);
  }

  changeArtistId(artistId: string) {
    this.artistIdSource.next(artistId);
  }

  changeSongId(songId: string) {
    this.songIdSource.next(songId);
  }
  changeArtistName(artistName: string){
    this.artistNameSource.next(artistName);
  }

  playSong(status: boolean) {
    this.playSongSource.next(status);
  }

}
