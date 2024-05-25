package com.inclusivamenteaba.api.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String cep;

    private String street;

    @Column(name = "address_number")
    private Integer addressNumber;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    public void updateData(Address updatedAddress) {
        if(updatedAddress.getCep() != null) {
            this.setCep(updatedAddress.getCep());
        }
        if(updatedAddress.getStreet() != null) {
            this.setStreet(updatedAddress.getStreet());
        }
        if(updatedAddress.getAddressNumber() != null) {
            this.setAddressNumber(updatedAddress.getAddressNumber());
        }
        if(updatedAddress.getComplement() != null) {
            this.setComplement(updatedAddress.getComplement());
        }
        if(updatedAddress.getNeighborhood() != null) {
            this.setNeighborhood(updatedAddress.getNeighborhood());
        }
        if(updatedAddress.getCity() != null) {
            this.setCity(updatedAddress.getCity());
        }
        if(updatedAddress.getState() != null) {
            this.setState(updatedAddress.getState());
        }
    }
}
