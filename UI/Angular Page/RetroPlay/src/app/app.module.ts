import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { HttpModule } from '@angular/http';
import { RouterModule,Routes } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import { PlayerComponent } from './components/player/player.component';
import { MoodsService } from './services/moods.service';
import { ArtistsService } from './services/artists.service';
import { DataService } from './services/data.service';
import { SongGalleryComponent } from './components/song-gallery/song-gallery.component';
import { SongsService } from './services/songs.service';

const appRoutes:Routes = [
    { path: '', redirectTo: 'artist', pathMatch: 'full' },
    { path: 'artist', component: GalleryComponent },
    { path: 'song', component: SongGalleryComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    GalleryComponent,
    PlayerComponent,
    SongGalleryComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpModule
  ],
  providers: [MoodsService, ArtistsService, DataService, SongsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
