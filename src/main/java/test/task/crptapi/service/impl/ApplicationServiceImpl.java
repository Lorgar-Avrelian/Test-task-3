package test.task.crptapi.service.impl;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import test.task.crptapi.model.DocumentRequest;
import test.task.crptapi.model.Product;
import test.task.crptapi.service.ApplicationService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    public boolean create(DocumentRequest documentRequest, HttpRequest httpRequest) {
        return createXMLFile(documentRequest);
    }
    public boolean createXMLFile(DocumentRequest documentRequest) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            return false;
        }
        Document document = builder.newDocument();
        Element document_text = document.createElement("document_text");
        Element description = document.createElement("description");
        Element participantInn = document.createElement("participantInn");
        Text text = document.createTextNode(documentRequest.getDescription().getParticipantInn());
        document.appendChild(document_text);
        document_text.appendChild(description);
        description.appendChild(participantInn);
        participantInn.appendChild(text);
        Element doc_id = document.createElement("doc_id");
        text = document.createTextNode(documentRequest.getDoc_id());
        document_text.appendChild(doc_id);
        doc_id.appendChild(text);
        Element doc_status = document.createElement("doc_status");
        text = document.createTextNode(documentRequest.getDoc_status());
        document_text.appendChild(doc_status);
        doc_status.appendChild(text);
        Element doc_type = document.createElement("doc_type");
        text = document.createTextNode(documentRequest.getDoc_type().toString());
        document_text.appendChild(doc_type);
        doc_type.appendChild(text);
        Element importRequest = document.createElement("importRequest");
        text = document.createTextNode(String.valueOf(documentRequest.isImportRequest()));
        document_text.appendChild(importRequest);
        importRequest.appendChild(text);
        Element owner_inn = document.createElement("owner_inn");
        text = document.createTextNode(documentRequest.getOwner_inn());
        document_text.appendChild(owner_inn);
        owner_inn.appendChild(text);
        Element participant_inn = document.createElement("participant_inn");
        text = document.createTextNode(documentRequest.getParticipant_inn());
        document_text.appendChild(participant_inn);
        participant_inn.appendChild(text);
        Element producer_inn = document.createElement("producer_inn");
        text = document.createTextNode(documentRequest.getProducer_inn());
        document_text.appendChild(producer_inn);
        producer_inn.appendChild(text);
        Element production_date = document.createElement("production_date");
        text = document.createTextNode(String.valueOf(documentRequest.getProduction_date()));
        document_text.appendChild(production_date);
        doc_id.appendChild(text);
        Element production_type = document.createElement("production_type");
        text = document.createTextNode(documentRequest.getProduction_type());
        document_text.appendChild(production_type);
        production_type.appendChild(text);
        Element products = document.createElement("products");
        document_text.appendChild(products);
        List<Product> productsList = documentRequest.getProducts();
        for (int i = 0; i < productsList.size(); i++) {
            Element certificate_document = document.createElement("certificate_document");
            text = document.createTextNode(productsList.get(i).getCertificate_document());
            products.appendChild(certificate_document);
            certificate_document.appendChild(text);
            Element certificate_document_date = document.createElement("certificate_document_date");
            text = document.createTextNode(String.valueOf(productsList.get(i).getCertificate_document_date()));
            products.appendChild(certificate_document_date);
            certificate_document_date.appendChild(text);
            Element certificate_document_number = document.createElement("certificate_document_number");
            text = document.createTextNode(productsList.get(i).getCertificate_document_number());
            products.appendChild(certificate_document_number);
            certificate_document_number.appendChild(text);
            Element product_owner_inn = document.createElement("owner_inn");
            text = document.createTextNode(productsList.get(i).getOwner_inn());
            products.appendChild(product_owner_inn);
            product_owner_inn.appendChild(text);
            Element product_producer_inn = document.createElement("producer_inn");
            text = document.createTextNode(productsList.get(i).getProducer_inn());
            products.appendChild(product_producer_inn);
            product_producer_inn.appendChild(text);
            Element product_production_date = document.createElement("production_date");
            text = document.createTextNode(String.valueOf(productsList.get(i).getProduction_date()));
            products.appendChild(product_production_date);
            product_production_date.appendChild(text);
            Element tnved_code = document.createElement("tnved_code");
            text = document.createTextNode(productsList.get(i).getTnved_code());
            products.appendChild(tnved_code);
            tnved_code.appendChild(text);
            Element uit_code = document.createElement("uit_code");
            text = document.createTextNode(productsList.get(i).getUit_code());
            products.appendChild(uit_code);
            uit_code.appendChild(text);
            Element uitu_code = document.createElement("uitu_code");
            text = document.createTextNode(productsList.get(i).getUitu_code());
            products.appendChild(uitu_code);
            uitu_code.appendChild(text);
        }
        Element reg_date = document.createElement("reg_date");
        text = document.createTextNode(String.valueOf(documentRequest.getReg_date()));
        document_text.appendChild(reg_date);
        reg_date.appendChild(text);
        Element reg_number = document.createElement("reg_number");
        text = document.createTextNode(documentRequest.getReg_number());
        document_text.appendChild(reg_number);
        reg_number.appendChild(text);
        //
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("example.xml")));
        } catch (TransformerException e) {
            return false;
        }
        return true;
    }
}
