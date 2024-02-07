package test.task.crptapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Date;
import java.util.Objects;

public class Product {
    @Schema(example = "string", description = "Документ сертификации")
    private String certificate_document;
    @Schema(example = "2020-01-23", description = "Дата выдачи сертификата")
    private Date certificate_document_date;
    @Schema(example = "string", description = "Номер документа сертификации")
    private String certificate_document_number;
    @Schema(example = "string", description = "ИНН владельца")
    private String owner_inn;
    @Schema(example = "string", description = "ИНН производителя")
    private String producer_inn;
    @Schema(example = "2020-01-23", description = "Дата производства")
    private Date production_date;
    @Schema(example = "string", description = "Код ТН ВЭД")
    private String tnved_code;
    @Schema(example = "string", description = "Код УИТ")
    private String uit_code;
    @Schema(example = "string", description = "Код УИТУ")
    private String uitu_code;

    public Product() {
    }

    public Product(String certificate_document, Date certificate_document_date, String certificate_document_number, String owner_inn, String producer_inn, Date production_date, String tnved_code, String uit_code, String uitu_code) {
        this.certificate_document = certificate_document;
        this.certificate_document_date = certificate_document_date;
        this.certificate_document_number = certificate_document_number;
        this.owner_inn = owner_inn;
        this.producer_inn = producer_inn;
        this.production_date = production_date;
        this.tnved_code = tnved_code;
        this.uit_code = uit_code;
        this.uitu_code = uitu_code;
    }

    public String getCertificate_document() {
        return certificate_document;
    }

    public void setCertificate_document(String certificate_document) {
        this.certificate_document = certificate_document;
    }

    public Date getCertificate_document_date() {
        return certificate_document_date;
    }

    public void setCertificate_document_date(Date certificate_document_date) {
        this.certificate_document_date = certificate_document_date;
    }

    public String getCertificate_document_number() {
        return certificate_document_number;
    }

    public void setCertificate_document_number(String certificate_document_number) {
        this.certificate_document_number = certificate_document_number;
    }

    public String getOwner_inn() {
        return owner_inn;
    }

    public void setOwner_inn(String owner_inn) {
        this.owner_inn = owner_inn;
    }

    public String getProducer_inn() {
        return producer_inn;
    }

    public void setProducer_inn(String producer_inn) {
        this.producer_inn = producer_inn;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public String getTnved_code() {
        return tnved_code;
    }

    public void setTnved_code(String tnved_code) {
        this.tnved_code = tnved_code;
    }

    public String getUit_code() {
        return uit_code;
    }

    public void setUit_code(String uit_code) {
        this.uit_code = uit_code;
    }

    public String getUitu_code() {
        return uitu_code;
    }

    public void setUitu_code(String uitu_code) {
        this.uitu_code = uitu_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(certificate_document, product.certificate_document) && Objects.equals(certificate_document_date, product.certificate_document_date) && Objects.equals(certificate_document_number, product.certificate_document_number) && Objects.equals(owner_inn, product.owner_inn) && Objects.equals(producer_inn, product.producer_inn) && Objects.equals(production_date, product.production_date) && Objects.equals(tnved_code, product.tnved_code) && Objects.equals(uit_code, product.uit_code) && Objects.equals(uitu_code, product.uitu_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificate_document, certificate_document_date, certificate_document_number, owner_inn, producer_inn, production_date, tnved_code, uit_code, uitu_code);
    }

    @Override
    public String toString() {
        return "Product{" +
                "certificate_document='" + certificate_document + '\'' +
                ", certificate_document_date=" + certificate_document_date +
                ", certificate_document_number='" + certificate_document_number + '\'' +
                ", owner_inn='" + owner_inn + '\'' +
                ", producer_inn='" + producer_inn + '\'' +
                ", production_date=" + production_date +
                ", tnved_code='" + tnved_code + '\'' +
                ", uit_code='" + uit_code + '\'' +
                ", uitu_code='" + uitu_code + '\'' +
                '}';
    }
}
