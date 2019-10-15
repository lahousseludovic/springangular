import { NiveauEtude } from './niveauEtude';

export class Personne{
    public id: number;
    
    constructor(
       
        public nom: string,
        public prenom: string,
        public age: number,
        public niveauEtude: NiveauEtude

    ){}
}