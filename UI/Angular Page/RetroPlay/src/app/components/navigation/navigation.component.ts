import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { ArtistsService } from '../../services/artists.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private data: DataService, private artistService: ArtistsService, private router: Router) { }
  currentArtist: string;
  currentPage: string;

  ngOnInit() {
    this.resetCurrentArtist();
    this.router.events.subscribe((res) => {
      this.currentPage = this.router.url;
    });

    this.data.currentArtistName.subscribe((artistId)=>{
      this.currentArtist = artistId;
    });

  }
  routeToArtist() {
    this.router.navigate(['/artist']);
  }

  routeToSong() {
    this.router.navigate(['/song']);
  }

  resetCurrentArtist() {
    this.currentArtist = "Select an Artist/Song";
  }
  removeArtist() {
    this.resetCurrentArtist();
    this.data.changeArtistId("");
    this.routeToArtist();
  }

}
