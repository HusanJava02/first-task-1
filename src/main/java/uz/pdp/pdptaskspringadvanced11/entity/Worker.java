package uz.pdp.pdptaskspringadvanced11.entity;

//Company malumotlarini service, controller yordamida ResposeEntity
// qaytaradigan to'liq REST full API yozing. Bunda Address(street, homeNumber)
// Company(corpName, directorName, Address) Department(name, Company)
// Worker(name, phoneNumber, Address, Department) malumotlari bo'lsin.
// Proyektni git ga yuklab, javob sifatida linkni yuboring.


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @OneToOne
    private Address address;

    @ManyToOne(optional = false)
    private Department department;
}
