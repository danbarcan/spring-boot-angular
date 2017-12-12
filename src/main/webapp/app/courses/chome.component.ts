import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CoursesService} from './courses.service';
import {Principal} from '../shared/auth/principal.service';

@Component({
    selector: 'jhi-chome',
    templateUrl: 'chome.component.html',

})
export class ChomeComponent implements OnInit {

    course: String;
    hasVotedA: boolean;
    hasVotedP: boolean;
    rankingPURL: string;
    rankingAURL: string;
    voteAURL: string;
    votePURL: string;

    constructor(
        private route: ActivatedRoute,
        private courseService: CoursesService,
        private principal: Principal
    ) {
        this.route.params.subscribe((params) => {
            let cid = params['cid'];
            this.courseService.find(cid).subscribe((x) => this.course = x);
            this.principal.identity().then( (x) => {
                this.courseService.hasVotedA(cid,x.id).subscribe( (z) => this.hasVotedA=z);
                this.courseService.hasVotedP(cid,x.id).subscribe( (z) => this.hasVotedP=z);
            });
            this.rankingPURL = this.courseService.getRProfURL(cid);
            this.rankingAURL = this.courseService.getRAsisURL(cid);
            this.voteAURL = this.courseService.getVoteAURL(cid);
            this.votePURL = this.courseService.getVotePURL(cid);
        });
    }

    ngOnInit() {


    }

}
