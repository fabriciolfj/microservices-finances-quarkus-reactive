package com.github.fabriciolfj.entities;

public interface CommandEntity {

    StatusEntity findStatus();
    CommandEntity updateStatus(final StatusEntity statusEntity);
}
