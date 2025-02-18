package br.com.ydcns.AppPessoas.enums;

import br.com.ydcns.AppPessoas.exceptions.TypeEnumNotFoundException;

public enum TipoContato {
    TELEFONE, 
    CELULAR, 
    EMAIL,
	LINKEDIN,
	GITHUB;
	
    public static TipoContato fromString(String tipoContatoStr) {
        String tipoContatoFormatado = tipoContatoStr != null ? tipoContatoStr.trim().toUpperCase() : "";

        if (tipoContatoFormatado.isEmpty()) {
            throw new TypeEnumNotFoundException("Tipo de contato não pode ser vazio.");
        }

        try {
            return TipoContato.valueOf(tipoContatoFormatado);
        } catch (Exception e) {
            throw new TypeEnumNotFoundException();
        }
    }
}
