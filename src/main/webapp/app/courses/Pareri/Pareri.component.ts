import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {Principal} from "../../shared/auth/principal.service";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'jhi-pareri',
    templateUrl: 'Pareri.component.html',

})
export class PareriComponent{

    public cid: string;
    public type: string;
    public course: String;
    public username: string;
    public getURL: string;

    constructor( private courseService: CoursesService,
            private principal: Principal,
            private route: ActivatedRoute){
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.type = params['type'];
            this.getURL = 'api/pareri/' + this.type + '/' + this.cid;
            this.courseService.find(this.cid).subscribe((x) => this.course = x);
            this.principal.identity().then( (x) => this.username = x.login)

        });
    }

}
