import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {Principal} from "../../shared/auth/principal.service";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'jhi-prez',
    templateUrl: 'Prezolvare.component.html',

})
export class PrezolvareComponent {
    public cid: string;
    public type: string;
    public course: String;
    public listaP: any[];
    public problema: any;
    public username : String;

    constructor( private courseService: CoursesService,
                 private principal: Principal,
                 private route: ActivatedRoute){
        this.problema = {'title' : '',
                         'text' : ''};
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.type = params['type'];
            this.courseService.find(this.cid).subscribe((x) => this.course = x);
            this.principal.identity().then( (x) => this.username = x.login)
            if(this.type === 'deschise') {
                this.courseService.getFromURL('api/probleme/'+this.cid).subscribe((x)=>this.listaP=x);
            }
            else{
                this.courseService.getFromURL('api/problemeR/'+this.cid).subscribe((x)=>this.listaP=x);
            }

        });
    }

    save(){
        this.problema['id'] = null;
        this.problema['username'] = this.username;
        this.problema['resolved'] = false;
        this.problema['idMaterie'] = this.cid;
        this.problema['id'] = null
        this.courseService.saveProblema(this.problema);
        location.reload();

    }

}


















