package test.task.crptapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class DocumentRequest {
    @Schema(description = "Описание документа")
    private Description description;
    @Schema(example = "string", description = "ID документа")
    private String doc_id;
    @Schema(example = "string", description = "Статус документа")
    private String doc_status;
    @Schema(example = "LP_INTRODUCE_GOODS", description = "Тип документа")
    private DocType doc_type;
    @Schema(example = "true", description = "Импорт запроса")
    private boolean importRequest;
    @Schema(example = "string", description = "ИНН владельца")
    private String owner_inn;
    @Schema(example = "string", description = "ИНН поставщика")
    private String participant_inn;
    @Schema(example = "string", description = "ИНН производителя")
    private String producer_inn;
    @Schema(example = "2020-01-23", description = "Дата производства")
    private Date production_date;
    @Schema(example = "string", description = "Тип продукции")
    private String production_type;
    @Schema(description = "Список продуктов")
    private List<Product> products;
    @Schema(example = "2020-01-23", description = "Дата регистрации")
    private Date reg_date;
    @Schema(example = "string", description = "Регистрационный номер")
    private String reg_number;

    public DocumentRequest() {
    }

    public DocumentRequest(Description description, String doc_id, String doc_status, DocType doc_type, boolean importRequest, String owner_inn, String participant_inn, String producer_inn, Date production_date, String production_type, List<Product> products, Date reg_date, String reg_number) {
        this.description = description;
        this.doc_id = doc_id;
        this.doc_status = doc_status;
        this.doc_type = doc_type;
        this.importRequest = importRequest;
        this.owner_inn = owner_inn;
        this.participant_inn = participant_inn;
        this.producer_inn = producer_inn;
        this.production_date = production_date;
        this.production_type = production_type;
        this.products = products;
        this.reg_date = reg_date;
        this.reg_number = reg_number;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_status() {
        return doc_status;
    }

    public void setDoc_status(String doc_status) {
        this.doc_status = doc_status;
    }

    public DocType getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(DocType doc_type) {
        this.doc_type = doc_type;
    }

    public boolean isImportRequest() {
        return importRequest;
    }

    public void setImportRequest(boolean importRequest) {
        this.importRequest = importRequest;
    }

    public String getOwner_inn() {
        return owner_inn;
    }

    public void setOwner_inn(String owner_inn) {
        this.owner_inn = owner_inn;
    }

    public String getParticipant_inn() {
        return participant_inn;
    }

    public void setParticipant_inn(String participant_inn) {
        this.participant_inn = participant_inn;
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

    public String getProduction_type() {
        return production_type;
    }

    public void setProduction_type(String production_type) {
        this.production_type = production_type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentRequest that = (DocumentRequest) o;
        return importRequest == that.importRequest && Objects.equals(description, that.description) && Objects.equals(doc_id, that.doc_id) && Objects.equals(doc_status, that.doc_status) && doc_type == that.doc_type && Objects.equals(owner_inn, that.owner_inn) && Objects.equals(participant_inn, that.participant_inn) && Objects.equals(producer_inn, that.producer_inn) && Objects.equals(production_date, that.production_date) && Objects.equals(production_type, that.production_type) && Objects.equals(products, that.products) && Objects.equals(reg_date, that.reg_date) && Objects.equals(reg_number, that.reg_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, doc_id, doc_status, doc_type, importRequest, owner_inn, participant_inn, producer_inn, production_date, production_type, products, reg_date, reg_number);
    }

    @Override
    public String toString() {
        return "DocumentRequest{" +
                "description=" + description +
                ", doc_id='" + doc_id + '\'' +
                ", doc_status='" + doc_status + '\'' +
                ", doc_type=" + doc_type +
                ", importRequest=" + importRequest +
                ", owner_inn='" + owner_inn + '\'' +
                ", participant_inn='" + participant_inn + '\'' +
                ", producer_inn='" + producer_inn + '\'' +
                ", production_date=" + production_date +
                ", production_type='" + production_type + '\'' +
                ", products=" + products +
                ", reg_date=" + reg_date +
                ", reg_number='" + reg_number + '\'' +
                '}';
    }
}
