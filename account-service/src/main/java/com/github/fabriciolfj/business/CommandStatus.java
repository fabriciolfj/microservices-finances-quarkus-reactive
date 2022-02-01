package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.CommandEntity;
import com.github.fabriciolfj.entities.StatusEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommandStatus {

    public CommandEntity inative(final CommandEntity command) {
        if (command.findStatus().name().equals(StatusEntity.ATIVE.name())) {
            return command.updateStatus(StatusEntity.INATIVE);
        }

        throw new RuntimeException("Status invalid: " + command.findStatus().name());
    }

    public CommandEntity ative(final CommandEntity command) {
        if (command.findStatus().name().equals(StatusEntity.NONE.name())) {
            return command.updateStatus(StatusEntity.ATIVE);
        }

        throw new RuntimeException("Status invalid: " + command.findStatus().name());
    }
}
