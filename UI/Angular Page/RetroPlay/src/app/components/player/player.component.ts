import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { SongsService } from '../../services/songs.service';
import { Songs } from '../../domain/Songs';
import { ArtistsService } from '../../services/artists.service';

declare var startplayer: any;
declare var App: any;

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})

export class PlayerComponent implements OnInit {

  constructor(private data: DataService, private songService: SongsService, private artistService: ArtistsService) { }

  selectedSongId: string;
  currentSong: Songs;
  player: any;
  playSong: boolean;

  ngOnInit() {
    this.player = new App();
    this.data.currentSongId.subscribe((songId) => {
      this.selectedSongId = songId;
      if (songId != "") {
        console.log(this.selectedSongId);
        this.setSongDetails();
        this.playAudio();
      }
    });
  }

  setSongDetails() {
    this.songService.getSongDetails(this.selectedSongId).subscribe((songDetails) => {
      this.currentSong = songDetails;

      this.setArtistName(songDetails.artist_ids);

      this.setPlayerInformation();
    });
  }

  setArtistName(artist_ids: string) {

    this.artistService.getArtistDetails(artist_ids).subscribe((artistDetails) => {
      this.data.changeArtistName(artistDetails.artist_name);
    });
  }

  setPlayerInformation() {
    let songBaseURL = this.currentSong.song_link;
    let fileNames: Array<string> = [this.currentSong.song_id + ".mp3"];
    let songTitles: Array<string> = [this.currentSong.song_name];
    this.player.setAudioURL(songBaseURL, fileNames, songTitles);
    this.checkPlayStatus();
  }

  checkPlayStatus() {
    this.data.statusPlaySong.subscribe((status) => {
      this.playSong = status;
      if (status == true)
        this.playAudio();
    });
  }

  playAudio() {

    if (this.playSong == true) {
      console.log("playing audio");
      this.player.loadAudio();
    }
  }

}
