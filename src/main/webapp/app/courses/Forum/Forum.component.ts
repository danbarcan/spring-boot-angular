import {Component, Input, OnChanges} from "@angular/core";
import {CoursesService} from "../courses.service";
@Component({
    selector: 'jhi-forum',
    templateUrl: 'Forum.component.html',

})
export class ForumComponent implements OnChanges{

    @Input() public getURL: string;
    @Input() public cid: string;
    @Input() public pid: string;
    @Input() public type: string;
    @Input() public username: string;
    public pareri: any[];
    public newP: any;

    constructor( private courseService: CoursesService){
        this.newP = {};
        this.newP['text'] = "";
    }

    ngOnChanges() {
        this.courseService.getFromURL(this.getURL).subscribe( (x) => {
            this.pareri = x;
        });
    }

    del(p){
        this.courseService.delP(p);
        location.reload();
    }

    enableEditing(p){
        p.enable = true;
    }

    save(p : any, n:boolean){
        let pr = {};
        if(!n) {
            pr['id'] = p.id;
            pr['text'] = p.text;
            pr['idType'] = p.idType;
            pr['idMaterie'] = p.idMaterie;
            pr['type'] = p.type;
            pr['username'] = p.username;
        }
        else{
            pr['id'] = null;
            pr['text'] = this.newP.text;
            pr['idType'] = this.pid == null? null:this.pid;
            pr['idMaterie'] = this.cid == null? null:this.cid;
            pr['type'] = this.type;
            pr['username'] = this.username;
        }
        if(pr['text'] != "" && pr['text'])
            this.courseService.saveParere(pr);

        if (n) location.reload();

        p.enable = false;
        this.newP['text'] = "";
    }


}
