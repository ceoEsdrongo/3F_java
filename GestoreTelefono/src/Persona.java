

enum Tipologia {
    cellulare,
    abitazione,
    azienda
}

class Persona {
    String nome;
    String cognome;
    String numDiTelefono;
    Tipologia tipo;

    public String anagrafica() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Numero di telefono: " + numDiTelefono + ", Tipo di abbonamento: " + tipo;
    }

    public String ricercaSingola() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Numero di telefono: " + numDiTelefono + ", Tipo di abbonamento: " + tipo;
    }
}