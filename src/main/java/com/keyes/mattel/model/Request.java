package com.keyes.mattel.model;

import com.keyes.mattel.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String contactNumber;
    @Email
    private String email;
    @NotBlank
    private String address;
    @Size(min = 5)
    private String businessJustification;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    private Instant createdAt;
}
