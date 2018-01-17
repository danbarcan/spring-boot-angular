import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'jhi-matlaboratoare',
    templateUrl: 'labs.component.html',

})
export class LabsComponent {

    public cid: string;
    public course: String;
    public file : any;
    public files: any[];
    public years: any[];

    constructor( private courseService: CoursesService,
                 private route: ActivatedRoute){
        this.years = [{year: '2015'},{year: '2016'},{year: '2017'},{year: '2018'}];
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.courseService.find(this.cid).subscribe((x) => this.course = x);
            this.courseService.getMLabs(this.cid).subscribe((x) => this.files = x);
        });
    }

    public changeFile(evt: any): void{
        this.file = evt.target.files[0];
    }

    public getFileName(file): string{
        let name = file.path.split('/');
        return name[name.length-1];
    }

    public uploadFile(year): void {
        this.courseService.makeFileRequest('/api/upload/lab/'+this.cid +'/'+year, this.file).subscribe();
        this.file = null;
    }

    public show(year): void{
        year.show = year.show?false:true;
    }


}
