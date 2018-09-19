import { Component, OnInit } from '@angular/core';
import { MoodsService } from '../../services/moods.service';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private moodsService: MoodsService,private data: DataService) { }

  Moods: any;
  selectedMood: string;
  allMoods: string = 'ALL'; // Only for HTML

  ngOnInit() {
    this.selectedMood = 'ALL';
    this.moodsService.getAllMoods().subscribe((moods) => {
      this.Moods = moods;
    });
  }

  selectAll() {
    this.selectedMood = 'ALL';
    this.data.changeMood(this.selectedMood);
  }

  selectMood(mood: string) {
    this.selectedMood = mood;
    this.data.changeMood(this.selectedMood);
  }

}
