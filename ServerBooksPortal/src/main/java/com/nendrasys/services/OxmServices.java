package com.nendrasys.services;

import com.nendrasys.dao.ServerBooksDaoImpl;
import com.nendrasys.model.BooksInfo;
import com.nendrasys.model.BooksList;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class OxmServices {

    private Marshaller marshaller;
    ServerBooksDaoImpl stdDaoimpl;
    private Unmarshaller unmarshaller;
    public ServerBooksDaoImpl getStdDaoimpl() {
        return stdDaoimpl;
    }

    public void setStdDaoimpl(ServerBooksDaoImpl stdDaoimpl) {
        this.stdDaoimpl = stdDaoimpl;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }


    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public String convertObjectToxml(BooksInfo booksInfo) throws IOException {
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult=new StreamResult(stringWriter);
        getMarshaller().marshal(booksInfo,streamResult );
        return stringWriter.toString();
    }

    public BooksInfo convertXmlToObject(String xml) throws IOException {
        StringReader stringReader=new StringReader(xml);
        BooksInfo unmarsh= (BooksInfo) getUnmarshaller().unmarshal(new StreamSource(stringReader));
        return unmarsh;
    }
    public String BooksListInXml(BooksList booksInfo) throws IOException {
        StringWriter stringWriter=new StringWriter();
        getMarshaller().marshal(booksInfo,new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public BooksList booksListInObj(String xml) throws IOException {
        StringReader stringReader = new StringReader(xml);
        BooksList unmarshal = (BooksList) getUnmarshaller().unmarshal(new StreamSource(stringReader));
        return unmarshal;
    }


}
