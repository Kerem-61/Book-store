package com.example.publishermicroservice.config;


import com.bookstore.domain.Publisher;
import com.example.publishermicroservice.document.PublisherDocument;
import com.example.publishermicroservice.dto.request.AddPublisherRequest;
import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    private static final Converter<Publisher, PublisherResponse>
            PUBLISHER_PUBLISHER_RESPONSE_CONVERTER =
            (context) -> {
                var publisher = context.getSource();
                var response = new PublisherResponse();
                response.setPublisherId(publisher.getPublisherId().getValue());
                response.setLogo(publisher.getLogo());
                response.setName(publisher.getName());
                response.setPublisherId(publisher.getPublisherId().getValue());
                response.setLogo(publisher.getLogo());
                response.setRequistion(publisher.getRequistion().getValue());

                System.err.println("PUBLISHER_PUBLISHER_RESPONSE_CONVERTER: " + response);
                return response;
            };

    private static final Converter<Publisher, AddPublisherResponse>
            BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER =
            (context) -> {
                var publisher = context.getSource();
                var response = new AddPublisherResponse();
                response.setPublisherId(publisher.getPublisherId().getValue());
                response.setLogo(publisher.getLogo());
                response.setName(publisher.getName());
                response.setPublisherId(publisher.getPublisherId().getValue());
                response.setLogo(publisher.getLogo().getBase64Values());
                response.setRequistion(publisher.getRequistion().getValue());
                return response;
            };

    private static final Converter<AddPublisherRequest, Publisher>
            ADD_BOOK_REQUEST_TO_BOOK_CONVERTER =
            (context) -> {
                var request = context.getSource();
                return new Publisher.Builder()
                        .publisherId(request.getPublisherId())
                        .publisherId(request.getPublisherId())
                        .publisher(request.getPublisher())
                        .isbn(request.getIsbn())
                        .requistion(request.getRequistion())
                        .name(request.getName())
                        .logo(request.getLogo().getBytes())
                        .build();
            };

    private static final Converter<PublisherDocument, Publisher>
            BOOK_DOCUMENT_TO_BOOK_CONVERTER =
            (context) -> {
                var document = context.getSource();
                return new Publisher.Builder()
                        .publisherId(document.getPublisherId())
                        .logo(document.getLogo())
                        .requistion(document.getRequistion())
                        .build();

            };


    private static final Converter<Publisher, PublisherResponse>
            BOOK_TO_BOOK_DOCUMENT_CONVERTER =
            (context) -> {
                var publisher = context.getSource();
                var pubDoc = new PublisherDocument();
                pubDoc.setPublisherId(publisher.getPublisherId());
                pubDoc.setName(String.format("%s %s",
                        publisher.getName()));
                pubDoc.setLogo(publisher.getLogo());
                pubDoc.setRequistion(publisher.getRequistion());
                return pubDoc;
            };

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.addConverter(PUBLISHER_PUBLISHER_RESPONSE_CONVERTER,
                Publisher.class, PublisherDocument.class);
        mapper.addConverter(PUBLISHER_PUBLISHER_RESPONSE_CONVERTER,
                PublisherDocument.class, Publisher.class);
        mapper.addConverter(PUBLISHER_PUBLISHER_RESPONSE_CONVERTER,
                Publisher.class, PublisherResponse.class);
        return mapper;
    }
}