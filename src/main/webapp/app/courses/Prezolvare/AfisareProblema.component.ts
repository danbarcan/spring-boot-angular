import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {Principal} from "../../shared/auth/principal.service";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'jhi-afisarep',
    templateUrl: 'AfisareProblema.component.html',

})
export class AfisareProblemaComponent {
    public problema : any;
    public cid: string;
    public type: string;
    public username: string;
    public getURL: string;
    public pid : number;
    public file : any;
    public files: any[];

    constructor( private courseService: CoursesService,
                 private principal: Principal,
                 private route: ActivatedRoute){
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.pid = params['id'];
            this.type = "probleme";
            this.getURL = 'api/pareri/' + this.type + '/' + this.cid;
            this.courseService.getFromURL('api/problema/' + this.pid).subscribe((x) => {
                this.problema = x;
            });
            this.courseService.getFromURL('api/problema/getfiles' + this.pid).subscribe((x) => this.files = x);
            this.principal.identity().then( (x) => this.username = x.login)

        });
    }

    public changeFile(evt: any): void{
        this.file = evt.target.files[0];
    }

    public uploadFile(): void {
        this.courseService.makeFileRequest('api/upload/probFile/'+this.pid , this.file).subscribe();
        this.file = null;
    }

    public show(f){
        f.show = !f.show;
    }

    public getFileName(file): string{
        let name = file.path.split('/');
        return name[name.length-1];
    }
}
