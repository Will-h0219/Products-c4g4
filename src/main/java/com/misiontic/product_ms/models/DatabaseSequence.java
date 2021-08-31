package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

public class DatabaseSequence {
    @Id
    private String id;

    private Long seq;

    public DatabaseSequence() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }
}
