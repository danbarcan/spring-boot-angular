
import {AfterContentInit, AfterViewChecked, Component, Input, OnInit} from "@angular/core";
import {CoursesService} from "../courses.service";

@Component({
    selector: 'jhi-rank',
    templateUrl: 'ranking.component.html',

})
export class RankingComponent implements AfterContentInit {

    @Input() public rankingURL: string;
    @Input() public hasVoted: boolean;
    @Input() public voteURL: string;
    elements: any[];
    voted: boolean;

    constructor(
        private courseService: CoursesService
    ) {
        this.voted=false;
    }

    ngAfterContentInit() {
        this.courseService.getFromURL(this.rankingURL).subscribe( (x) => {this.elements = x;
        console.log(x)});
    }

    vote(element: any){
        this.voted = true;
        this.courseService.vote(this.voteURL + "/" + element.second.id);
    }
}
