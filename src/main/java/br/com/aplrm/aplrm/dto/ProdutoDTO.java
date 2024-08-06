package br.com.aplrm.aplrm.dto;

import br.com.aplrm.aplrm.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {

    private Integer id;

    @NotBlank(message = "O Campo é Obrigatorio e nao pode ser Vazio!")
    @Size(min = 3,max=80, message = "Nome Precisa ter entre 3 a 80 caracteres")
    private String nome;

    @Positive(message = "O preço deve ser positivo")
    private Double preco;

    @NotBlank(message = "O Campo é Obrigatorio e nao pode ser Vazio!")
    @Size(min = 8,max=800, message = "A descrição Precisa ter entre 8 a 800 caracteres")
    private String descricao;

    @NotBlank
    private String imgUrl;

    public ProdutoDTO(Integer id, String nome, Double preco, String descricao, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.imgUrl = produto.getImgUrl();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
