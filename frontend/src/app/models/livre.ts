export interface Livre {
    id: number;
    isbn: string;
    titre: string;
    auteur: string;
    date: Date;
    nombreExamplaires: number |any;
    nombreExamplairesRestants: number | any;
  }
