// package com.example.academia.faixa;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// public class FaixaDTO {
//     private Long id;
//     private String nome;

//     // Updated constructor to accept a Faixa object
//     public FaixaDTO(FaixaDTO faixa) {
//         this.id = faixa.getId();
//         this.nome = faixa.getNome();
//     }
// }


package com.example.academia.faixa;

import lombok.Data;

@Data
public class FaixaDTO {
    private Long id;
    private String nome;

    public static FaixaDTO from(Faixa faixa) {
        FaixaDTO faixaDTO = new FaixaDTO();
        faixaDTO.setId(faixa.getId());
        faixaDTO.setNome(faixa.getNome());
        return faixaDTO;
    }
}
