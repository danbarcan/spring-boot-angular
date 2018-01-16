import {Component} from "@angular/core";
import {Principal} from "../../../shared/auth/principal.service";

@Component({
    selector: 'jhi-pareris',
    templateUrl: 'parerisfaturi.component.html',

})
export class ParerisfaturiComponent {

    public type: string;
    public username: string;
    public getURL: string;


    constructor(private principal: Principal,){
        this.principal.identity().then( (x) => this.username = x.login)
        this.getURL="api/pareriG/sfaturi";
        this.type = "sfaturi";
    }

}
