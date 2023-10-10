package tech.ada.ecommerce.model.enums;

public enum StatusType {
    EM_ABERTO("em aberto"),
    PAGAMENTO_APROVADO("pagamento aprovado"),
    AGUARDANDO_PAGAMENTO("aguardando pagamento"),
    PAGAMENTO_REJEITADO("pagamento rejeitado"),
    CANCELADA("cancelada"),
    EM_TRANSPORTE("em transporte"),
    FINALIZADA("finalizada");

    public final String nome;

    StatusType(String s) {
        this.nome = s;
    }
}