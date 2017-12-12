
import {
    AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, Input, OnChanges,
    OnInit
} from "@angular/core";
import {CoursesService} from "../courses.service";

@Component({
    selector: 'jhi-rank',
    templateUrl: 'ranking.component.html',

})
export class RankingComponent implements OnChanges {

    @Input() public rankingURL: string;
    @Input() public hasVoted: boolean;
    @Input() public voteURL: string;
    @Input() public title: string;
    elements: any[];
    voted: boolean;
    votedEl: any;
    votes: number;
    showResults: boolean;

    constructor(
        private courseService: CoursesService
    ) {
        this.voted=false;
    }

    ngOnChanges() {
        let i = 0;
        let sum = 0;
        this.courseService.getFromURL(this.rankingURL).subscribe( (x) => {this.elements = x;
            for(i =0; i<x.length; i++){
                sum += x[i].first;
            }
            this.votes = sum;
            });
    }

    select(ind){
        this.votedEl = ind;
    }

    vote(){
        this.voted = true;
        this.votes += 1;
        this.courseService.vote(this.voteURL + "/" + this.elements[this.votedEl].second.id);
        this.elements[this.votedEl].first += 1;
    }

    showR(){
        this.showResults = true;
    }

    return(){
        this.showResults = false;
    }
}
