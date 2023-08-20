package com.example.kafkaconsumer.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public final class NestedUserInfo implements Serializable {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    public String toString() {
        return String.format("User id %s username : %s; firstname : %s; lastname : %s ",
                id, username, firstName, lastName);
    }
}
