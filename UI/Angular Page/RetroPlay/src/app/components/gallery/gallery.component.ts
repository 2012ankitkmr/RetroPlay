import { Component, OnInit, AfterViewInit, ElementRef } from '@angular/core';
import { ArtistsService } from '../../services/artists.service'
import { DataService } from '../../services/data.service';
import { Artists } from '../../domain/Artists';
import { Songs } from '../../domain/Songs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit, AfterViewInit {

  constructor(private artistsService: ArtistsService, private data: DataService, private router: Router, private elementRef:ElementRef) { }

  artists: Artists[];
  selectedMood: string;
  Songs: Songs[];
  selectedArtistId: string;
  artist_name:string;

  ngAfterViewInit() {
    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "assets/js/jquery.waterwheelCarousel.js"; //external script
    this.elementRef.nativeElement.appendChild(s);
  }

  ngOnInit() {

    this.data.currentMood.subscribe((mood) => {
      this.selectedMood = mood;
      console.log(this.selectedMood);
      this.updateArtists();
    });

  }

  changeArtist(artistId: string) {
    this.selectedArtistId = artistId;
    this.data.changeArtistId(this.selectedArtistId);
    this.router.navigate(['/song']);

  }

  updateArtists() {

    this.artistsService.getAllArtistsForMood(this.selectedMood).subscribe((artists) => {
      this.artists = artists;
      console.log(this.artists);
      //      this.isHidden = false;
    });

  }

}