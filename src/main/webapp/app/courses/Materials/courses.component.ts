import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {ActivatedRoute} from "@angular/router";
import {Principal} from "../../shared/auth/principal.service";

@Component({
    selector: 'jhi-matcursuri',
    templateUrl: 'courses.component.html',

})
export class CoursesComponent {

    public cid: string;
    public type: string;
    public course: String;
    public file : any;
    public files: any[];
    public years: string[];

    constructor( private courseService: CoursesService,
                 private route: ActivatedRoute){
        this.years = ['2015','2016','2017','2018'];
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.courseService.find(this.cid).subscribe((x) => this.course = x);
            this.courseService.getMCourses(this.cid).subscribe((x) => this.files = x);
        });
    }

    public changeFile(evt: any): void{
        this.file = evt.target.files[0];
        console.log("sada");
    }

    public getFileName(file): string{
        let name = file.path.split('/');
        return name[name.length-1];
    }

    public uploadFile(): void {
        console.log("sasda");
        this.courseService.makeFileRequest('/api/upload/curs/'+this.cid, this.file).subscribe();
    }

}
