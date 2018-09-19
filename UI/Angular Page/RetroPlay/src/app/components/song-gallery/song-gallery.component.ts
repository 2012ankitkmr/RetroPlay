import { Component, OnInit, AfterViewInit, ElementRef } from '@angular/core';
import { ArtistsService } from '../../services/artists.service'
import { DataService } from '../../services/data.service';
import { Artists } from '../../domain/Artists';
import { Songs } from '../../domain/Songs';
import { SongsService } from '../../services/songs.service';

@Component({
  selector: 'app-song-gallery',
  templateUrl: './song-gallery.component.html',
  styleUrls: ['./song-gallery.component.css']
})
export class SongGalleryComponent implements OnInit {

  constructor(private data: DataService, private songsService: SongsService, private elementRef: ElementRef, private artistService: ArtistsService) { }

  artists: Artists[];
  selectedMood: string;
  songs: Songs[];
  selectedArtistId: string;
  selectedSong: string;
  msgDisplay: boolean;

  ngAfterViewInit() {
    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "assets/js/jquery.waterwheelCarousel.js"; //external script
    this.elementRef.nativeElement.appendChild(s);
  }

  ngOnInit() {

    this.msgDisplay = false;
    this.data.currentMood.subscribe((mood) => {
      this.selectedMood = mood;
      this.updateSongs();
    });

    this.data.currentArtistId.subscribe((artistId) => {
      this.selectedArtistId = artistId;
      this.updateSongs();
    });

  }

  updateSongs() {
    if (this.selectedArtistId == "") {
      this.songsService.getAllSongsForMood(this.selectedMood).subscribe((songs) => {
        this.songs = songs;
        this.setMsg();
      });
    }
    else {
      this.songsService.getAllSongsForMoodForArtist(this.selectedMood, this.selectedArtistId).subscribe((songs) => {
        this.songs = songs;
        this.setMsg();
      });
    }
  }

  setMsg() {
    if (this.songs.length == 0)
      this.msgDisplay = true;
    else
      this.msgDisplay = false;
  }

  sendSongRequestToPlayer(songId: string) {
    this.selectedSong = songId;
    this.data.changeSongId(this.selectedSong);
    this.data.playSong(true);
  }

}
