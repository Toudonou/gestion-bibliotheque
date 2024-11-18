export interface Livre {
    id: number;
    isbn: string;
    titre: string;
    auteur: string;
    date: Date;
    nombreExamplaires: string |any;
    nombreExamplairesRestants: string | any;
  }
