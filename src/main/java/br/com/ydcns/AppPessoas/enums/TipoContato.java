package br.com.ydcns.AppPessoas.enums;

import br.com.ydcns.AppPessoas.exceptions.TypeEnumNotFoundException;

public enum TipoContato {
    TELEFONE(0),
    CELULAR(1),
    EMAIL(2); 

    private final int codigo;

    TipoContato(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoContato fromString(String text) {
        switch (text.toUpperCase()) {
            case "TELEFONE":
                return TELEFONE;
            case "CELULAR":
                return CELULAR;
            case "EMAIL":
                return EMAIL;
            default:
                throw new TypeEnumNotFoundException();
        }
    }
}