import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import { ProfileService } from '../profiles/profile.service';
import { Principal, LoginModalService, LoginService } from '../../shared';

import { VERSION, DEBUG_INFO_ENABLED } from '../../app.constants';

@Component({
    selector: 'jhi-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        'navbar.css'
    ]
})
export class NavbarComponent implements OnInit {

    inProduction: boolean;
    isNavbarCollapsed: boolean;
    languages: any[];
    swaggerEnabled: boolean;
    modalRef: NgbModalRef;
    version: string;
    headers: any[];

    constructor(
        private loginService: LoginService,
        private principal: Principal,
        private loginModalService: LoginModalService,
        private profileService: ProfileService,
        private router: Router
    ) {
        this.version = VERSION ? 'v' + VERSION : '';
        this.isNavbarCollapsed = true;

        this.headers = [{
                        'name': 'ANUL I',
                        'content': [
                                    {
                                        'name': 'Semestrul I',
                                        'show': false,
                                        'content': [
                                            {'name': 'APD'},
                                            {'name': 'APP'}
                                        ]
                                    },
                                    {
                                        'name': 'Semestrul II',
                                        'show': false,
                                        'content': []
                                    }
                                    ]
                        },
                        {
                            'name': 'ANUL II',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'ANUL III',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'ANUL IV',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'Master',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'Diverse',
                            'content': [
                                {
                                    'name': 'Orar',
                                    'show': false,
                                    'content': []
                                },
                                {
                                    'name': 'Admitere',
                                    'show': false,
                                    'content': []
                                }
                            ]
                        }
                        ];
    }

    ngOnInit() {
        this.profileService.getProfileInfo().subscribe((profileInfo) => {
            this.inProduction = profileInfo.inProduction;
            this.swaggerEnabled = profileInfo.swaggerEnabled;
        });
    }

    collapseNavbar() {
        this.isNavbarCollapsed = true;
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    logout() {
        this.collapseNavbar();
        this.loginService.logout();
        this.router.navigate(['']);
    }

    toggleNavbar() {
        this.isNavbarCollapsed = !this.isNavbarCollapsed;
    }

    showSubMenu(ct: any) {
        ct.show = true;
    }

    hideSubMenu(ct: any) {
        ct.show = false;
    }

    getImageUrl() {
        return this.isAuthenticated() ? this.principal.getImageUrl() : null;
    }
}
